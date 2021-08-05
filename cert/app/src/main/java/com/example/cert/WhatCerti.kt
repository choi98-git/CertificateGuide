package com.example.cert

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class WhatCerti : AppCompatActivity() {

    private val useBtn: Button by lazy {
        findViewById(R.id.whereUse)
    }

    private val exam1: Button by lazy {
        findViewById(R.id.exam1)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_what_certi)

        useBtn.setOnClickListener {
            val intent = Intent(this,WhereCerti::class.java)
            startActivity(intent)
        }

        exam1.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.q-net.or.kr/man001.do?gSite=Q"))
            startActivity(intent)
        }

    }
}