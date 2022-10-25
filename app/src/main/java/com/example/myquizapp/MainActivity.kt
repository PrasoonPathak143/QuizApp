package com.example.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnStart : Button = findViewById(R.id.start)
        val name : EditText = findViewById(R.id.uname)
        btnStart.setOnClickListener {
            if(name.text.isEmpty()){
                Toast.makeText(this,"Please Enter the Name",Toast.LENGTH_LONG).show()
            }
            else{
                val intent = Intent(this,QuestionActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}