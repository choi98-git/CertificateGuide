package com.example.cert


import android.app.AlertDialog
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide



class TestPagerAdapter (
    private val itemList: List<Test>
): RecyclerView.Adapter<TestPagerAdapter.TestViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        TestViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_test, parent, false)
        )


    override fun getItemCount() = itemList.size


    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load(itemList[position].testImage)
            .into(holder.img)

        holder.bind(itemList[position])
    }

    class TestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val question: TextView = itemView.findViewById(R.id.question)
        private val res1: RadioButton = itemView.findViewById(R.id.firstAnswer)
        private val res2: RadioButton = itemView.findViewById(R.id.secondAnswer)
        private val res3: RadioButton = itemView.findViewById(R.id.thirdAnswer)
        private val res4: RadioButton = itemView.findViewById(R.id.fourthAnswer)
        private val correctAnswer: TextView = itemView.findViewById(R.id.correctAnswer)
        private val radioGroup: RadioGroup = itemView.findViewById(R.id.radioGroup)
        private val nextButton: Button = itemView.findViewById(R.id.nextButton)
        val img: ImageView = itemView.findViewById(R.id.testImage)


        fun bind(test: Test) {
            question.text = test.question
            res1.text = test.firstAnswer
            res2.text = test.secondAnswer
            res3.text = test.thirdAnswer
            res4.text = test.fourthAnswer
            correctAnswer.text = test.correctAnswer

            nextButton.setOnClickListener {
                val radioButton: RadioButton = itemView.findViewById(radioGroup.checkedRadioButtonId)
                if (correctAnswer.text.toString().equals(radioButton.text.toString())){
                    androidx.appcompat.app.AlertDialog.Builder(itemView.context)
                        .setTitle("정답")
                        .setMessage("정답입니다!!")
                        .create()
                        .show()
                }else{
                    androidx.appcompat.app.AlertDialog.Builder(itemView.context)
                        .setTitle("오답")
                        .setMessage("오답입니다!!")
                        .create()
                        .show()
                }
            }

        }

    }
}
