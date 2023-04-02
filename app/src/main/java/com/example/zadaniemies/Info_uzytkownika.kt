package com.example.zadaniemies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.navigation.NavigationView

class Info_uzytkownika : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_uzytkownika)

        supportActionBar?.hide() // ukrycie toolbara
        val Info_User = intent.getStringArrayExtra("In_user") // odczytanie tablicy z informacjami o uzytkowniku

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
            startActivity(Intent(this, MainActivity::class.java).putExtra("In_user", Info_User))
        }

        // przejscie do strony z tabelami
        findViewById<Button>(R.id.btn_ocena).setOnClickListener {
            startActivity(Intent(this, Tabela::class.java).putExtra("In_user", Info_User))
        }

        // przejscie do strony z informacjami o uzytkowniku
        findViewById<Button>(R.id.btn_info).setOnClickListener {
            Toast.makeText(this, "Jesteś już na stronie z informacjami", Toast.LENGTH_SHORT).show()
        }

        // Wypelnienie danymi pobranymi z formularza
        findViewById<TextView>(R.id.nick_text).text = "Nick: " + Info_User?.get(0)
        findViewById<TextView>(R.id.imie_text).text = "Imie: " + Info_User?.get(1)
        findViewById<TextView>(R.id.nazw_text).text = "Nazwisko: " + Info_User?.get(2)
        findViewById<TextView>(R.id.klasa_text).text = "Klasa: " + Info_User?.get(3)
    }
}