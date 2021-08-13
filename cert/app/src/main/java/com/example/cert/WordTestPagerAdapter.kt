package com.example.cert

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class WordTestPagerAdapter (
    private val words: List<Word>
): RecyclerView.Adapter<WordTestPagerAdapter.WordViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
    WordViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_word_test, parent, false)
    )

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.bind(words[position])
    }

    override fun getItemCount() = words.size

    class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val explanationTextView: TextView = itemView.findViewById(R.id.expTextView)
        private val wordTextView: TextView = itemView.findViewById(R.id.wordTextView)
        private val wordAnswerEdt: EditText = itemView.findViewById(R.id.wordAnswerEdt)

        private val submissionBtn: Button by lazy {
            itemView.findViewById(R.id.submissionBtn)
        }
        private val gradingBtn: Button by lazy {
            itemView.findViewById(R.id.gradingBtn)
        }


        fun bind(word: Word) {
            explanationTextView.text = word.explanation
            wordTextView.text = "정답: ${word.word}"
            submissionBtn.setOnClickListener {
                wordTextView.visibility = View.VISIBLE
                when {
                    word.word.indexOf(wordAnswerEdt.text.toString()) > -1 -> {
                        when { // 정답을 입력 안했을 때 예외 처리
                            wordAnswerEdt.text.toString().equals("") -> {
                                Toast.makeText(itemView.context,"정답을 입력해 주세요!!", Toast.LENGTH_LONG).show()
                                wordTextView.visibility = View.GONE
                            } //입력한 답이 정답일 경우
                            else -> AlertDialog.Builder(itemView.context)
                                .setTitle("정답 확인")
                                .setMessage("정답입니다!!\n 정답: ${word.word}")
                                .setPositiveButton("확인") { _, _ -> }
                                .create()
                                .show()
                        }
                    }
                    else -> { //입력한 답이 오답일 경우
                        AlertDialog.Builder(itemView.context)
                            .setTitle("정답 확인")
                            .setMessage("오답입니다!!\n 정답: ${word.word}")
                            .setPositiveButton("확인") { _, _ -> }
                            .create()
                            .show()
                    }
                }
            }

            gradingBtn.setOnClickListener {
                wordTextView.visibility = View.VISIBLE
            }

        }

    }

}

