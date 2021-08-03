package com.example.cert

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.firebase.firestore.FirebaseFirestore

class StartTest: AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()    // Firestore 인스턴스 선언
    val itemList = mutableListOf<Test>()    // 리스트 아이템 배열

    private val viewPager: ViewPager2 by lazy{
        findViewById(R.id.viewPager)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_test)


        db.collection("Test")   // 작업할 컬렉션
            .get()      // 문서 가져오기
            .addOnSuccessListener { result ->
                // 성공할 경우
                itemList.clear()
                for (document in result) {  // 가져온 문서들은 result에 들어감
                    val item = Test(document["question"] as String, document["img"] as String, document["res1"] as String, document["res2"] as String,
                        document["res3"] as String, document["res4"] as String, document["correctAnswer"] as String)
                    itemList.add(item)
                }
                displayListAdapter(itemList)
            }
            .addOnFailureListener { exception ->
                // 실패할 경우
                Log.w("MainActivity", "Error getting documents: $exception")
            }

    }
    private fun displayListAdapter(itemList: List<Test>) {
        viewPager.adapter = TestPagerAdapter(
            itemList
        )
    }
}