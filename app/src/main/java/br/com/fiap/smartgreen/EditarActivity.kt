package br.com.fiap.smartgreen // Substitua pelo seu pacote

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class EditarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.editar_meta)

        val editTextMeta = findViewById<EditText>(R.id.txtMetas)
        val buttonSalvar = findViewById<Button>(R.id.btnSalvarMetas)
        val buttonCancelar = findViewById<Button>(R.id.btnCancelarMetas)

        buttonSalvar.setOnClickListener {
            val meta = editTextMeta.text.toString()
            // ... (salvar a meta, por exemplo, em um banco de dados)
            finish()
        }

        buttonCancelar.setOnClickListener {
            finish()
        }
    }
}