package com.example.cert

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import com.example.cert.R

class StudyActivity : AppCompatActivity() {

    private val selectButton: Button by lazy {
        findViewById(R.id.selectButton)
    }

    private val cancelButton: Button by lazy {
        findViewById(R.id.cancelButton)
    }

    private val writtenTest: CheckBox by lazy {
        findViewById(R.id.writtenTest)
    }
    private val wordStudy: CheckBox by lazy {
        findViewById(R.id.wordStudy)
    }
    private val wordTest: CheckBox by lazy {
        findViewById(R.id.wordTest)
    }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.study_filter)

            // 하나의 체크박스가 테크되면 다른 체크박스는 체크 -> false
            writtenTest.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    wordStudy.isChecked = false
                    wordTest.isChecked = false
                }
            }

            wordStudy.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    writtenTest.isChecked = false
                    wordTest.isChecked = false
                }
            }

            wordTest.setOnCheckedChangeListener{ buttonView, isChecked ->
                if (isChecked) {
                    writtenTest.isChecked = false
                    wordStudy.isChecked = false
                }
            }

            selectButton.setOnClickListener {

                if (writtenTest.isChecked) {
                    val intent = Intent(this, WrittenTest::class.java)
                    startActivity(intent)
                }

                if (wordStudy.isChecked) {
                    val intent = Intent(this, Memorization::class.java)
                    startActivity(intent)
                }

                if (wordTest.isChecked) {
                    val intent = Intent(this, WordTest::class.java)
                    startActivity(intent)
                }

            }

            // 취소 버튼
            cancelButton.setOnClickListener {
                writtenTest.isChecked = false
                wordStudy.isChecked = false
                wordTest.isChecked = false
            }

        }

}
