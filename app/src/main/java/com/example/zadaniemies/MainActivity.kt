package com.example.zadaniemies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide() // ukrycie toolbara


        // przejscie do nowego activity
        findViewById<Button>(R.id.button).setOnClickListener {
            val intent = Intent(this, info_uzytk::class.java)
            startActivity(intent)
        }
    }
}