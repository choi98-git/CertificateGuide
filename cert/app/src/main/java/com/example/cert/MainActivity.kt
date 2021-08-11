package com.example.cert

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val testScheduleButton: ImageButton by lazy {
        findViewById(R.id.testSchedule)
    }

    private val testInfoButton: ImageButton by lazy {
        findViewById(R.id.testInfo)
    }

    private val studyButton: ImageButton by lazy{
        findViewById(R.id.study)
    }

    private val channelButton: ImageButton by lazy{
        findViewById(R.id.youtube)
    }

    private var endCnt = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dDayButton: ImageButton = findViewById(R.id.dDaySetting)
        val dDayText = findViewById<TextView>(R.id.dDay)

        //  intent를 통해 넘어온 문자열을 difDate 변수에 담음
        val difDate = intent.getStringExtra("difDate")

        dDayText.text = difDate

        // D-Day설정 버튼을 눌러 설정창으로 이동
        dDayButton.setOnClickListener {
            val intent = Intent(this, DdayActivity::class.java)
            startActivity(intent)
        }

        testScheduleButton.setOnClickListener {
            val intent = Intent(this, TestSchedule::class.java)
            startActivity(intent)
        }

        testInfoButton.setOnClickListener {
            val intent = Intent(this, TestInfo::class.java)
            startActivity(intent)
        }

        channelButton.setOnClickListener {
            val intent = Intent(this,HowToStudy::class.java)
            startActivity(intent)
        }

        studyButton.setOnClickListener {
            val intent = Intent(this, StudyActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        endCnt ++
        Toast.makeText(this, "'뒤로' 버튼을 한번 더 누르시면 앱이 종료됩니다.",Toast.LENGTH_SHORT).show()
        if(endCnt == 2) {
            finish()
            return
        }
    }
}