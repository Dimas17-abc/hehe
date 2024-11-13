package com.example.latihanquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class form : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_form)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val np: EditText = findViewById(R.id.npm)
        val nam: EditText = findViewById(R.id.nama)
        val kel: EditText = findViewById(R.id.kelas)
        val laki: CheckBox = findViewById(R.id.laki)
        val cewek: CheckBox = findViewById(R.id.perempuan)
        val tom: Button = findViewById(R.id.simpan)
        val cancel: Button =findViewById(R.id.reset)

        tom.setOnClickListener{
            val nim = np.text.toString()
            val name = nam.text.toString()
            val clas = kel.text.toString()
            val cowo = laki.isChecked()
            val cewe = cewek.isChecked()

            if (nim.isEmpty() || name.isEmpty() || clas.isEmpty() || (!cowo && !cewe)) {
                Toast.makeText(this, "Harap Lengkapi Data", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, data::class.java)
                intent.putExtra("npm", nim)
                intent.putExtra("nama", name)
                intent.putExtra("kelas", clas)
                intent.putExtra("jk", if (cowo)"Laki-laki" else "Perempuan")
                startActivity(intent)
            }
        }

        laki.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                cewek.isChecked = false
            }
        }

        cewek.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                laki.isChecked = false
            }
        }

        cancel.setOnClickListener{
            np.text.clear()
            nam.text.clear()
            kel.text.clear()
            laki.isChecked = false
            cewek.isChecked = false
        }
    }
}