package br.com.fiap.smartgreen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MetasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_metas)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Botão Cancelar
        val btnCancela = findViewById<Button>(R.id.btnCriar)

        btnCancela.setOnClickListener {
            val i = Intent(this, InicioActivity::class.java)
            startActivity(i)
        }

        //Menu Inferior
        val imageInicio = findViewById<ImageView>(R.id.image1)
        val imagePerfil = findViewById<ImageView>(R.id.image3)

        imageInicio.setOnClickListener {
            val i = Intent(this, InicioActivity::class.java)
            startActivity(i)
        }

        imagePerfil.setOnClickListener {
            val i4 = Intent(this, PerfilActivity::class.java)
            startActivity(i4)
        }
    }
}