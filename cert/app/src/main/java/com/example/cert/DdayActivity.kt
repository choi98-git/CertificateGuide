package com.example.cert


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isEmpty
import java.text.SimpleDateFormat
import java.util.*

class DdayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dday)

        val settingButton = findViewById<Button>(R.id.setting)

        val calView = findViewById<CalendarView>(R.id.calendarView)
        val todayText = findViewById<TextView>(R.id.todayText)
        val dDayText  = findViewById<TextView>(R.id.dDayText)
        val difDateText =  findViewById<TextView>(R.id.difDate)

        // 오늘 날짜 값을 Calender 통해 받아옴
        val tCal = Calendar.getInstance()
        val tYear = tCal.get(Calendar.YEAR).toString()
        val tMonth = (tCal.get(Calendar.MONTH)+1).toString()
        val tDay = tCal.get(Calendar.DATE).toString()

        todayText.text = "$tYear-$tMonth-$tDay"
        dDayText.text = "$tYear-$tMonth-$tDay"

        // 날짜 형식 지정
        val sdf = SimpleDateFormat("yyyy-MM-dd")

        //CalenderView에 선택한 날짜를 D-DAY 값으로 받아옴
        calView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val dCalView = view
            val dYear = year + 0
            val dMonth = month +1
            val dDay = dayOfMonth + 0


            dDayText.text = "$dYear-$dMonth-$dDay"
        }



        // D-Day 설정 후 메인 화면으로 이동
        settingButton.setOnClickListener {

            // D-Day로 설정한 값을 지정 형식으로 변환
            val dDate = sdf.parse(dDayText.text.toString())

            // 오늘 날짜로부터 D-DAY까지의 날짜 차이를 구함
            val difDate = (dDate.time - tCal.time.time) / (60 * 60 * 24 * 1000) +1
            difDateText.text = "D-$difDate"


            // intent를 통해 날짜 차이를 나타내는 문자열을 MainActivity로 넘겨줌
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("difDate", "D-$difDate")
            startActivity(intent)
        }
    }
}