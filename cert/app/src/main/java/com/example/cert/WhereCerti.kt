package com.example.cert

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class WhereCerti : AppCompatActivity() {

    private val infoBtn: Button by lazy {
        findViewById(R.id.infoBtn)
    }

    private val exam2: Button by lazy {
        findViewById(R.id.exam2)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_where_certi)

        infoBtn.setOnClickListener {
            val intent = Intent(this,WhatCerti::class.java)
            startActivity(intent)
        }

        exam2.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.q-net.or.kr/man001.do?gSite=Q"))
            startActivity(intent)
        }

    }

    override fun onBackPressed() {
        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }
    //뒤로 가기 버튼 누르면 메인화면으로 복귀
}