package br.com.fiap.smartgreen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PerfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_perfil)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imageInicio = findViewById<ImageView>(R.id.image1)
        val imageMetas = findViewById<ImageView>(R.id.image2)

        imageInicio.setOnClickListener {
            val i = Intent(this, InicioActivity::class.java)
            startActivity(i)
        }

        imageMetas.setOnClickListener {
            val i2 = Intent(this, MetasActivity::class.java)
            startActivity(i2)
        }

        val btnCancela = findViewById<Button>(R.id.btnCancelarPerfil)

        btnCancela.setOnClickListener {
            val i = Intent(this, InicioActivity::class.java)
            startActivity(i)
        }

        val db = DataBaseManager(this) // Assuming you've updated DataBaseManager

        val sharedPrefs = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

        val cursor = db.getAllUsers() // Assuming you've added a method to retrieve all users

        if (cursor != null && cursor.moveToFirst()) {
            val name = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseManager.COLUMN_NAME))
            val energia = cursor.getInt(cursor.getColumnIndexOrThrow(DataBaseManager.COLUMN_ENERGIA)) == 1
            val sala = cursor.getInt(cursor.getColumnIndexOrThrow(DataBaseManager.COLUMN_SALA)) == 1
            val cozinha = cursor.getInt(cursor.getColumnIndexOrThrow(DataBaseManager.COLUMN_COZINHA)) == 1
            val quarto = cursor.getInt(cursor.getColumnIndexOrThrow(DataBaseManager.COLUMN_QUARTO)) == 1
            val banheiro = cursor.getInt(cursor.getColumnIndexOrThrow(DataBaseManager.COLUMN_BANHEIRO)) == 1
            val outros = cursor.getInt(cursor.getColumnIndexOrThrow(DataBaseManager.COLUMN_OUTROS)) == 1

            findViewById<EditText>(R.id.txtNome).setText(name)
            findViewById<CheckBox>(R.id.checkbox).isChecked = energia
            findViewById<CheckBox>(R.id.sala).isChecked = sala
            findViewById<CheckBox>(R.id.cozinha).isChecked = cozinha
            findViewById<CheckBox>(R.id.quarto).isChecked = quarto
            findViewById<CheckBox>(R.id.banheiro).isChecked = banheiro
            findViewById<CheckBox>(R.id.outros).isChecked = outros

            cursor.close()
        } else {
            Toast.makeText(this, "Dados não encontrados.", Toast.LENGTH_LONG).show()
        }

        findViewById<Button>(R.id.btnSalvarPerfil).setOnClickListener {
            val name = findViewById<EditText>(R.id.txtNome).text.toString()
            val energia = findViewById<CheckBox>(R.id.checkbox).isChecked
            val sala = findViewById<CheckBox>(R.id.sala).isChecked
            val cozinha = findViewById<CheckBox>(R.id.cozinha).isChecked
            val quarto = findViewById<CheckBox>(R.id.quarto).isChecked
            val banheiro = findViewById<CheckBox>(R.id.banheiro).isChecked
            val outros = findViewById<CheckBox>(R.id.outros).isChecked

            if (name != null) {
                db.updateUser(
                    name,
                    if (energia) 1 else 0,
                    if (sala) 1 else 0,
                    if (cozinha) 1 else 0,
                    if (quarto) 1 else 0,
                    if (banheiro) 1 else 0,
                    if (outros) 1 else 0, // Add 'outros' here
                )
                Toast.makeText(this, "Perfil atualizado com sucesso!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Erro ao atualizar perfil.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}