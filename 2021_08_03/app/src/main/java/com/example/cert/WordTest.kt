package com.example.cert

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import org.json.JSONArray
import org.json.JSONObject

class WordTest: AppCompatActivity() {

    private val viewPager: ViewPager2 by lazy{
        findViewById(R.id.viewPager)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.word_test)

        initData()
    }
    private  fun initData(){
        val remoteConfig = Firebase.remoteConfig
        remoteConfig.setConfigSettingsAsync(
            remoteConfigSettings {
                minimumFetchIntervalInSeconds = 0
            }
        )
        remoteConfig.fetchAndActivate().addOnCompleteListener {
            if(it.isSuccessful){
                val words = parseWordsJson(remoteConfig.getString("words")).shuffled()
                val isWordRevealed = remoteConfig.getBoolean("is_word_revealed")

                displayWordsPager(words,isWordRevealed)

            }
        }
    }

    private fun parseWordsJson(json: String): List<Word> {
        val jsonArray = JSONArray(json)
        var jsonList = emptyList<JSONObject>()
        for(index in 0 until jsonArray.length()){
            val jsonObject = jsonArray.getJSONObject(index)
            jsonObject?.let {
                jsonList = jsonList + it
            }
        }

        return jsonList.map {
            Word(
                explanation = it.getString("explanation"),
                word = it.getString("word"))
        }
    }

    private fun displayWordsPager(words:List<Word>, isWordReVealed: Boolean){
        viewPager.adapter = WordTestPagerAdapter(
            words
        )
    }
}