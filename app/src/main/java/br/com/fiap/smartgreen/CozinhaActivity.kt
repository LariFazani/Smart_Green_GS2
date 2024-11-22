package br.com.fiap.smartgreen

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class CozinhaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cozinha)

        val textNome = findViewById<TextView>(R.id.txtNome)
        val textConsumoMedio = findViewById<TextView>(R.id.txtConsumoCadastro)
        val textTempoUtilizado = findViewById<TextView>(R.id.txtTempoCadastro)


        val nome = getDadosCadastroActivity("nome")
        val consumoMedio = getDadosCadastroActivity("consumoMedio")
        val tempoUtilizado = getDadosCadastroActivity("tempoUtilizado")

        textNome.text = nome
        textConsumoMedio.text = consumoMedio
        textTempoUtilizado.text = tempoUtilizado

        val imageInicio = findViewById<ImageView>(R.id.image1)
        val imageMetas = findViewById<ImageView>(R.id.image2)
        val imagePerfil = findViewById<ImageView>(R.id.image3)

        imageInicio.setOnClickListener {
            val i = Intent(this, InicioActivity::class.java)
            startActivity(i)
        }

        imageMetas.setOnClickListener{
            val i2 = Intent(this, MetasActivity::class.java)
            startActivity(i2)
        }

        imagePerfil.setOnClickListener{
            val i4 = Intent(this, PerfilActivity::class.java)
            startActivity(i4)
        }
    }

    private fun getDadosCadastroActivity(campo: String): String {
        // Implementar a lógica para obter o dado do campo especificado
        // (por exemplo, usando um banco de dados)
        return "dado_temporario" // Valor temporário para exemplificar
    }
} {
