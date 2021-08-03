package com.example.cert

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class WhereUsing : AppCompatActivity() {
    private val infoBtn: Button by lazy {
        findViewById(R.id.infoBtn)
    }

    private val exam2: Button by lazy {
        findViewById(R.id.exam2)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.usecerti)

        infoBtn.setOnClickListener {
            val intent = Intent(this,TestInfo::class.java)
            startActivity(intent)
        }

        exam2.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.q-net.or.kr/man001.do?gSite=Q"))
            startActivity(intent)
        }

    }

    override fun onBackPressed() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

}