package br.com.fiap.smartgreen

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback

class InicioActivity : AppCompatActivity(), OnMapReadyCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inicio)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        //Menu Inferior
        val imageMetas = findViewById<ImageView>(R.id.image2)
        val imagePerfil = findViewById<ImageView>(R.id.image3)

        imageMetas.setOnClickListener{
            val i2 = Intent(this, MetasActivity::class.java)
            startActivity(i2)
        }

        imagePerfil.setOnClickListener{
            val i4 = Intent(this, PerfilActivity::class.java)
            startActivity(i4)
        }
    }

    override fun onMapReady(map: GoogleMap?) {

    }

}