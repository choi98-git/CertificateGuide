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

class WordsTestAdapter (
    private val words: List<Words>
): RecyclerView.Adapter<WordsTestAdapter.WordTestViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        WordTestViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_word_test,parent,false)
        )

    override fun onBindViewHolder(holder: WordTestViewHolder, position: Int) {
        holder.bind(words[position])
    }

    override fun getItemCount() = words.size

    class WordTestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val wordTestView: TextView = itemView.findViewById(R.id.wordTestView)
        private val expTestView: TextView = itemView.findViewById(R.id.expTestView)

        private val gradingBtn: Button = itemView.findViewById(R.id.gradingBtn)
        private val submissionBtn: Button = itemView.findViewById(R.id.submissionBtn)
        private val answerWordEdt: EditText = itemView.findViewById(R.id.wordAnswerEdt)

        fun bind(words: Words) {
            wordTestView.text = words.word
            expTestView.text = words.exp

            wordTestView.visibility = View.GONE

            submissionBtn.setOnClickListener {
                wordTestView.visibility = View.VISIBLE
                when {
                    words.word.indexOf(answerWordEdt.text.toString()) > -1 -> {
                        when {
                            answerWordEdt.text.toString().equals("") -> {
                                Toast.makeText(itemView.context,"정답을 입력해 주세요!!", Toast.LENGTH_LONG).show()
                                wordTestView.visibility = View.GONE
                            }
                            else -> AlertDialog.Builder(itemView.context)
                                .setTitle("정답 확인")
                                .setMessage("정답입니다!!\n 정답: ${words.word}")
                                .setPositiveButton("확인") { _, _ -> }
                                .create()
                                .show()
                        }
                    }
                    else -> {
                        AlertDialog.Builder(itemView.context)
                            .setTitle("정답 확인")
                            .setMessage("오답입니다!!\n 정답: ${words.word}")
                            .setPositiveButton("확인") { _, _ -> }
                            .create()
                            .show()
                    }
                }
            }

            gradingBtn.setOnClickListener {
                wordTestView.visibility = View.VISIBLE
            }
        }

    }

}