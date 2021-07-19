package com.example.cert

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton


public class FourthFragment : Fragment()
{

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View?
    {
        return inflater.inflate(R.layout.fourthfragment, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val examApplyBtn = view.findViewById<Button>(R.id.examGo)
        val enrollQnetBtn = view.findViewById<Button>(R.id.enroll)
        val appInstallBtn = view.findViewById<Button>(R.id.appInstall)

        examApplyBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.q-net.or.kr/rcv001.do?id=rcv00103&gSite=Q&gId="))
            startActivity(intent)
        }

        enrollQnetBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.q-net.or.kr/man003.do?id=man00301&gSite=Q&gId="))
            startActivity(intent)
        }

        appInstallBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.mcnc.parecis.hrdkorea.qnet"))
            startActivity(intent)
        }
    }
}