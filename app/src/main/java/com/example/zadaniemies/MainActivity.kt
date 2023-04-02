package com.example.zadaniemies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var logged = false
        var Info_User = arrayOf("","","","")

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
            Toast.makeText(this, "Jesteś już na stronie głównej", Toast.LENGTH_SHORT).show()
        }

        // przejscie do strony z tabelami
        findViewById<Button>(R.id.btn_ocena).setOnClickListener {
            if(logged)
                startActivity(Intent(this, Tabela::class.java).putExtra("In_user", Info_User))
            else
                Toast.makeText(this, "Musisz się zalogować", Toast.LENGTH_SHORT).show()
        }

        // przejscie do strony z informacjami o uzytkowniku
        findViewById<Button>(R.id.btn_info).setOnClickListener {
            if(logged)
                startActivity(Intent(this, Info_uzytkownika::class.java).putExtra("In_user", Info_User))
            else
                Toast.makeText(this, "Musisz się zalogować", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.log_btn).setOnClickListener{
            val nick = findViewById<EditText>(R.id.nick_input).text.toString()
            val login = findViewById<EditText>(R.id.login_input).text.toString()
            val password = findViewById<EditText>(R.id.pass_input).text.toString()
            val klasa = findViewById<EditText>(R.id.class_input).text.toString()

            if(nick.isEmpty() || login.isEmpty() || password.isEmpty() || klasa.isEmpty())
                Toast.makeText(this, "Wypełnij wszystkie pola", Toast.LENGTH_SHORT).show()
            else if(login != "Olivier")
                Toast.makeText(this, "Nieprawidłowy login", Toast.LENGTH_SHORT).show()
            else if(password != "van Overveld")
                Toast.makeText(this, "Nieprawidłowe hasło", Toast.LENGTH_SHORT).show()
            else {
                logged = true
                Info_User[0] = nick
                Info_User[1] = login
                Info_User[2] = password
                Info_User[3] = klasa

                findViewById<LinearLayout>(R.id.Form_login).visibility = View.GONE
                Toast.makeText(this, "Zalogowano", Toast.LENGTH_SHORT).show()
            }
        }


    }
}