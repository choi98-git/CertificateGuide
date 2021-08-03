package com.example.cert

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.test_schedule.*

class HowToStudy : AppCompatActivity() {

    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_how_to_study)

        val adapter = StudyAdapter(supportFragmentManager)
        adapter.addFragment(Written(), "필기")
        adapter.addFragment(Practical(), "실기")
        adapter.addFragment(Tip(), "Tip")
        after_login_viewpager.adapter = adapter
        after_login_tablayout.setupWithViewPager(after_login_viewpager)


    }
}