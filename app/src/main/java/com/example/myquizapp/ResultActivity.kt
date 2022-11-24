package com.example.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val tvName : TextView = findViewById(R.id.res_name)
        val btn: Button = findViewById(R.id.finish)
        val score : TextView = findViewById(R.id.score)
        tvName.text = intent.getStringExtra(Constants.USER_NAME)
        val total = intent.getIntExtra(Constants.TOTAL_QUESTION,0)
        val cr = intent.getIntExtra(Constants.CORRECT_ANSWER,0)

        score.text = "Your score is $cr / $total"

        btn.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }



    }
}