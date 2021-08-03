package com.example.cert

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class WrittenTest: AppCompatActivity() {

    private val startButton: Button by lazy {
        findViewById<Button>(R.id.startButton)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.written_test)

        val subjectSpinner = findViewById<Spinner>(R.id.subjectSpinner)
        val testDateSpinner = findViewById<Spinner>(R.id.testDate)

        subjectSpinner.adapter = ArrayAdapter.createFromResource(this,R.array.Subject,
            android.R.layout.simple_spinner_item)

        testDateSpinner.adapter = ArrayAdapter.createFromResource(this, R.array.Date,
            android.R.layout.simple_spinner_item)

        startButton.setOnClickListener {
           val intent = Intent(this,StartTest::class.java)
            startActivity(intent)
        }
    }
}