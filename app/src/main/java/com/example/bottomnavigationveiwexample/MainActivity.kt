package com.example.bottomnavigationveiwexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private var frame : FrameLayout? = null;

    private val monNavigationItemSelectedListener = object  : BottomNavigationView.OnNavigationItemSelectedListener{

        override fun onNavigationItemSelected(p0: MenuItem): Boolean { // BottomNavigationView 안에 아이템 클릭 시
            when(p0.itemId){
                R.id.action_home -> {       // Home 아이콘을 클릭
                    var main = Main.Companion.newInstance()   //newInstance 메소드로 fragment 객체생성
                    addFrag(main)

                    return true


                }
                R.id.action_account -> {     //MY 아이콘 클릭
                    val my = MY()          //fragment 객체 생성
                    addFrag(my)
                    return true
                }
            }
            return false
        }
    }

    private fun addFrag(fragment: Fragment){  //FragmentManager를 이용해서 Framelayout에 넣을 fragment를 동적으로 교체
        supportFragmentManager.beginTransaction().replace(R.id.frame,fragment).commit()


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        frame = findViewById(R.id.frame) as FrameLayout
        val navigationView = findViewById(R.id.bottom_navigation) as BottomNavigationView
        navigationView.setOnNavigationItemSelectedListener (monNavigationItemSelectedListener )

        val fragment = Main.Companion.newInstance()
        addFrag(fragment)             //첫 화면은 Main 화면으로


    }
}
