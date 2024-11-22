package br.com.fiap.smartgreen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cadastro)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txtNomeCadastro = findViewById<EditText>(R.id.txtNomeCadastro)
        val txtConsumoCadastro = findViewById<EditText>(R.id.txtConsumoCadastro)
        val txtTempoCadastro = findViewById<EditText>(R.id.txtTempoCadastro)
        val btnSalvar = findViewById<Button>(R.id.btnSalvarMetas)
        val btnCancela = findViewById<Button>(R.id.btnCancelarCadastro)

        btnCancela.setOnClickListener {
            val i = Intent(this, InicioActivity::class.java)
            startActivity(i)
        }

        btnSalvar.setOnClickListener {
            val db = DataBaseManager(this)
            val nome = txtNomeCadastro.text.toString()
            val consumo = txtConsumoCadastro.text.toString()
            val tempo = txtTempoCadastro.text.toString()
            val i = Intent(this, InicioActivity::class.java)
        }

    }
}