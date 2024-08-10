package com.example.test2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // 네비게이션 아이템 클릭 리스너 설정
        bottomNavigationView.setOnItemSelectedListener { item ->
            var selectedFragment: Fragment? = null
            when (item.itemId) {
                R.id.nav_home -> selectedFragment = HomeFragment()
                R.id.nav_settings -> selectedFragment = SettingsFragment()
            }
            // 선택된 프래그먼트를 교체합니다.
            selectedFragment?.let {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.content_frame, it)
                    .commit()
            }
            true
        }

        // 기본 프래그먼트로 홈 화면 설정
        if (savedInstanceState == null) {
            bottomNavigationView.selectedItemId = R.id.nav_home
            supportFragmentManager.beginTransaction()
                .replace(R.id.content_frame, HomeFragment())
                .commit()
        }
    }

