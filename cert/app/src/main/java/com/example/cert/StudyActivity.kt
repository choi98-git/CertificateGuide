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

    private val writtenTest: CheckBox = findViewById(R.id.writtenTest)
    private val wordStudy: CheckBox = findViewById(R.id.wordStudy)
    private val wordTest: CheckBox = findViewById(R.id.wordTest)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.study_filter)


        NonDuplicateCheck()

        selectButton.setOnClickListener {

            if (writtenTest.isChecked) {
                val intent = Intent(this, WrittenTest::class.java)
                startActivity(intent)
            }

            if (wordStudy.isChecked) {
                val intent = Intent(this, WordStudy::class.java)
                startActivity(intent)
            }

            if (wordTest.isChecked) {
                val intent = Intent(this, WordTest::class.java)
                startActivity(intent)
            }

        }

        cancelButton.setOnClickListener {
            writtenTest.isChecked = false
            wordStudy.isChecked = false
            wordTest.isChecked = false
        }

    }

    private fun NonDuplicateCheck() {

        if (writtenTest.isChecked) {
            wordStudy.isChecked = false
            wordTest.isChecked = false
        }

        if (wordStudy.isChecked) {
            writtenTest.isChecked = false
            wordTest.isChecked = false
        }

        if (wordTest.isChecked) {
            writtenTest.isChecked = false
            wordStudy.isChecked = false
        }

    }
}