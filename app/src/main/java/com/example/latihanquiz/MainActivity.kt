package com.example.latihanquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tuser: EditText = findViewById(R.id.username)
        val tpass: EditText = findViewById(R.id.password)
        val tombol: Button = findViewById(R.id.login)
        val klik: Button = findViewById(R.id.batal)

        tombol.setOnClickListener{
            val tx = tuser.text.toString()
            val use = tuser.text.toString()
            val pass = tpass.text.toString()

            if (use == "admin" && pass == "123"){
                val intent = Intent(this, form::class.java)
                intent.putExtra("usr",tx)
                startActivity(intent)
            } else {
                Toast.makeText(this,"Username atau Password Salah", Toast.LENGTH_SHORT).show()

                tuser.text.clear()
                tpass.text.clear()
            }

        }
        klik.setOnClickListener{
            tuser.text.clear()
            tpass.text.clear()
        }
    }
}