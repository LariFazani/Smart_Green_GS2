package br.com.fiap.smartgreen

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.content.ContentValues
import android.database.Cursor

class DataBaseManager(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_NAME = "userTransport"
        private const val DATABASE_VERSION = 1

        private const val TABLE_NAME = "tbl_users"
        private const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
        const val COLUMN_ENERGIA = "energia"
        const val COLUMN_SALA = "sala"
        const val COLUMN_COZINHA = "cozinha"
        const val COLUMN_QUARTO = "quarto"
        const val COLUMN_BANHEIRO = "banheiro"
        const val COLUMN_OUTROS = "outros"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_TABLE_QUERY = """
            CREATE TABLE $TABLE_NAME (
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_NAME TEXT,
                $COLUMN_ENERGIA INTEGER,
                $COLUMN_SALA INTEGER,
                $COLUMN_COZINHA INTEGER,
                $COLUMN_QUARTO INTEGER,
                $COLUMN_BANHEIRO INTEGER,
                $COLUMN_OUTROS INTEGER
            )
        """.trimIndent()

        db.execSQL(CREATE_TABLE_QUERY)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addUser(name: String, energia: Int, sala: Int, cozinha: Int, quarto: Int, banheiro: Int, outros: Int) {
        val db = this.writableDatabase

        val values = ContentValues().apply {
            put(COLUMN_NAME, name)
            put(COLUMN_ENERGIA, energia)
            put(COLUMN_SALA, sala)
            put(COLUMN_COZINHA, cozinha)
            put(COLUMN_QUARTO, quarto)
            put(COLUMN_BANHEIRO, banheiro)
            put(COLUMN_OUTROS, outros)
        }

        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun updateUser(id: Int, name: String, energia: Int, sala: Int, cozinha: Int, quarto: Int, banheiro: Int, outros: Int) {
        val db = this.writableDatabase

        val values = ContentValues().apply {
            put(COLUMN_NAME, name)
            put(COLUMN_ENERGIA, energia)
            put(COLUMN_SALA, sala)
            put(COLUMN_COZINHA, cozinha)
            put(COLUMN_QUARTO, quarto)
            put(COLUMN_BANHEIRO, banheiro)
            put(COLUMN_OUTROS, outros)
        }

        db.update(TABLE_NAME, values, "$COLUMN_ID = ?", arrayOf(id.toString()))
        db.close()
    }

    fun deleteUser(id: Int) {
        val db = this.writableDatabase
        db.delete(TABLE_NAME, "$COLUMN_ID = ?", arrayOf(id.toString()))
        db.close()
    }

    fun getAllUsers(): Cursor? {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME", null)
    }
}