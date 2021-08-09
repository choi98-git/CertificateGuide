package com.example.cert

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import com.google.firebase.firestore.FirebaseFirestore
import io.grpc.InternalChannelz.id
import kotlinx.android.synthetic.main.activity_start_test.*

class StartTest : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()    // Firestore 인스턴스 선언
    val itemList = mutableListOf<Test>()    // 리스트 아이템 배열


    private val viewPager: ViewPager2 by lazy{
        findViewById(R.id.rv_list)
    }

    private val next2Button: Button by lazy {
        findViewById(R.id.nextButton)
    }

    private val pre2Button: Button by lazy {
        findViewById(R.id.preButton)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_test)

        val selectedYear = intent.getStringExtra("selectedYear")
        val selectedCOUNT = intent.getStringExtra("selectedCount")

        db.collection("$selectedYear$selectedCOUNT")   // 작업할 컬렉션
            .get()      // 문서 가져오기
            .addOnSuccessListener { result ->
                // 성공할 경우
                itemList.clear()
                for (document in result) {  // 가져온 문서들은 result에 들어감
                    val item = Test(document["img"]as String,document["solve"] as String,document["res1"] as String, document["res2"] as String,document["res3"] as String,document["res4"] as String,document["dap"] as String)
                    itemList.add(item)
                }
                displayListAdapter(itemList)
            }
            .addOnFailureListener { exception ->
                // 실패할 경우
                Log.w("StartTest", "Error getting documents: $exception")
            }
        nextButton.setOnClickListener {
            val current = rv_list.currentItem
            rv_list.setCurrentItem(current + 1, false)

        }
        preButton.setOnClickListener {
            val current = rv_list.currentItem
            rv_list.setCurrentItem(current - 1, false)
        }
    }
    private fun displayListAdapter(itemList: List<Test>){
        viewPager.adapter = TestPagerAdapter(
            itemList
        )
    }
}