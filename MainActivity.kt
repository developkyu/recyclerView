package com.example.recyclerviewkt

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //뷰 바인딩 초기화
        binding = ActivityMainBinding.inflate(layoutInflater)
        //메인 액티비티를 보는
        setContentView(binding.root)

        val profileList = arrayListOf(
            Profiles(R.drawable.profile_man, "홈드로이드", 27, "안드로이드 앱 개발자"),
            Profiles(R.drawable.profile_women, "안드로이드", 15, "아이폰 앱 개발자"),
            Profiles(R.drawable.profile_man, "김드로이드", 10, "리액트 앱 개발자"),
            Profiles(R.drawable.profile_women, "신드로이드", 40, "플러터 앱 개발자"),
            Profiles(R.drawable.profile_man, "이드로이드", 20, "유니티 앱 개발자"),
            Profiles(R.drawable.profile_women, "윤드로이드", 24, "알고리즘 앱 개발자"),
            Profiles(R.drawable.profile_women, "민드로이드", 69, "웹 앱 개발자"),
            Profiles(R.drawable.profile_man, "공드로이드", 42, "하이브리드 앱 개발자"),
            Profiles(R.drawable.profile_women, "참드로이드", 23, "그냥 앱 개발자"),
            Profiles(R.drawable.profile_women, "점드로이드", 19, "배고픈 앱 개발자"),
            Profiles(R.drawable.profile_man, "고드로이드", 32, "졸린 앱 개발자")
        )

        binding.rvProfile.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvProfile.setHasFixedSize(true)

        binding.rvProfile.adapter = ProfileAdapter(profileList)

    }
}