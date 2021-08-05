package com.example.cert

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.os.persistableBundleOf
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
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
            .load(itemList[position].img)
            .into(holder.img)

        holder.bind(itemList[position])
    }

    class TestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val solve: TextView = itemView.findViewById(R.id.question)
        private val res1: RadioButton = itemView.findViewById(R.id.firstAnswer)
        private val res2: RadioButton = itemView.findViewById(R.id.secondAnswer)
        private val res3: RadioButton = itemView.findViewById(R.id.thirdAnswer)
        private val res4: RadioButton = itemView.findViewById(R.id.fourthAnswer)
        private val dap: TextView = itemView.findViewById(R.id.correctAnswer)
        private val radioGroup: RadioGroup = itemView.findViewById(R.id.radioGroup)
        private val correctBtn: Button = itemView.findViewById(R.id.correctButton)
        val img: ImageView = itemView.findViewById(R.id.testImage)



        fun bind(test: Test) {
            solve.text = test.solve
            res1.text = test.res1
            res2.text = test.res2
            res3.text = test.res3
            res4.text = test.res4
            dap.text = test.dap


            correctBtn.setOnClickListener {
                try {
                    val radioButton: RadioButton = itemView.findViewById(radioGroup.checkedRadioButtonId)
                        if (dap.text.toString().equals(radioButton.text.toString())) {
                            androidx.appcompat.app.AlertDialog.Builder(itemView.context)
                                .setTitle("정답")
                                .setMessage("정답입니다!!")
                                .setPositiveButton("확인",null)
                                .create()
                                .show()
                        } else {
                            androidx.appcompat.app.AlertDialog.Builder(itemView.context)
                                .setTitle("오답")
                                .setMessage("오답입니다!!")
                                .setPositiveButton("확인",null)
                                .create()
                                .show()
                        }
                    }catch(e: NullPointerException){
                        Toast.makeText(itemView.context, "정답을 선택해 주세요!!", Toast.LENGTH_SHORT).show()
                }
            }

        }

    }
}