package com.example.cert

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.written_test.*
import javax.security.auth.Subject

class WrittenTest: AppCompatActivity() {

    private val startButton: Button by lazy {
        findViewById<Button>(R.id.startTestBtn)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.written_test)

        val subjectSpinner = findViewById<Spinner>(R.id.subjectSpinner)
        val testDateSpinner = findViewById<Spinner>(R.id.testDate)

    // arrayAdapter를 통해 생성한 array를 Spinner에 적용
        subjectSpinner.adapter = ArrayAdapter.createFromResource(this,R.array.Subject,
            android.R.layout.simple_spinner_item)

        testDateSpinner.adapter = ArrayAdapter.createFromResource(this, R.array.Date,
            android.R.layout.simple_spinner_item)


        startButton.setOnClickListener {
            val selectedYear: String = subjectSpinner.selectedItem.toString()
            val selectedCount: String = testDate.selectedItem.toString()

            // 시험 년도와 회차를 선택 안했을 경우 예외 처리
            if(selectedCount != "시험 회차" && selectedYear != "년도") {
                val intent = Intent(this,StartTest::class.java)
                intent.putExtra("selectedYear","$selectedYear" )
                intent.putExtra("selectedCount","$selectedCount" )
                startActivity(intent)
            } else if(selectedCount == "시험 회차" || selectedYear == "년도") {
                Toast.makeText(this, "년도와 회차를 모두 선택해주세요.",Toast.LENGTH_SHORT).show()
            }
        }
    }
}