package com.example.latihanquiz

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class data : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_data)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txtnp: TextView = findViewById(R.id.txtnpm)
        val txtnam: TextView = findViewById(R.id.txtnama)
        val txtkel: TextView = findViewById(R.id.txtkelas)
        val txtjk: TextView = findViewById(R.id.txtjenis)

        val npm = intent.getStringExtra("npm")
        val nama = intent.getStringExtra("nama")
        val kelas = intent.getStringExtra("kelas")
        val jk = intent.getStringExtra("jk")

        txtnp.text = npm
        txtnam.text = nama
        txtkel.text = kelas
        txtjk.text = jk
    }
}