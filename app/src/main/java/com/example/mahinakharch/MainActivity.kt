package com.example.mahinakharch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn: FloatingActionButton =findViewById(R.id.addbtn)

        btn.setOnClickListener {
            //  Toast.makeText(applicationContext, "This a toast message", Toast.LENGTH_LONG).show()
            val i = Intent(this, TransactionType::class.java)
            startActivity(i)
        }
    }
}