package com.example.test2eval_pmm_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var empezarbtn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        empezarbtn = findViewById(R.id.EmpezarBtn)
        empezarbtn.setOnClickListener{
            intent = Intent(this@MainActivity, BookTitleActivity::class.java)
            startActivity(intent)
        }
    }
}