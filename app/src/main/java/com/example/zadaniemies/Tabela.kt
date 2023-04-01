package com.example.zadaniemies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import com.google.android.material.navigation.NavigationView

class Tabela : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabela)

        supportActionBar?.hide() // ukrycie toolbara

        // zamknięcie toolbara
        findViewById<Button>(R.id.btn_quit).setOnClickListener {
            val navigationView = findViewById<NavigationView>(R.id.nav_view)
            navigationView.visibility = View.GONE
        }

        // pojawienie toolbara
        findViewById<ImageView>(R.id.btn_menu_icon).setOnClickListener {
            val navigationView = findViewById<NavigationView>(R.id.nav_view)
            navigationView.visibility = View.VISIBLE
        }



        // przejscie do strony głównej
        findViewById<Button>(R.id.btn_main_page).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            Toast.makeText(this, "Przeniesiono do strony głównej", Toast.LENGTH_SHORT).show()
        }

        // przejscie do strony z tabelami
        findViewById<Button>(R.id.btn_ocena).setOnClickListener {
            Toast.makeText(this, "Jesteś już w tabeli z ocenami", Toast.LENGTH_SHORT).show()
        }

        // przejscie do strony z informacjami o uzytkowniku
        findViewById<Button>(R.id.btn_info).setOnClickListener {
            startActivity(Intent(this, Info_uzytkownika::class.java))
            Toast.makeText(this, "Przeniesiono do strony z informacjami", Toast.LENGTH_SHORT).show()
        }
    }
}