package com.example.myapplication1.BDD_Application

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.contentValuesOf
import com.example.myapplication1.dataBase.User

class bdd(mContext : Context) : SQLiteOpenHelper(
    mContext,
    db_NAME,
    null,
    db_VERSION
) {
    override fun onCreate(db: SQLiteDatabase?) {
        //creation de la table
        val tableUser = """
            CREATE Table users(
            $USER_ID integer PRIMARY KEY,
            $USERS_TABLE_NAME varchar(50),
            $NOM varchar(50),
            $PRENOM varchar(50),
            $EMAIL varchar(100),
            $PASSWORD varchar(20)
    )
    """.trimIndent()
        db?.execSQL(tableUser)
    }
    companion object{
        private val db_NAME = "application_db"
        private val db_VERSION = 1
        private val USERS_TABLE_NAME = "USERS"
        private val USER_ID = "Id"
        private val NOM = "nom"
        private val PRENOM = "prenom"
        private val EMAIL = "email"
        private val PASSWORD = "password"
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }
    fun addUser(User: User): Boolean{
        //inserer un nouveau utilisateur dans la db
        val db = this.writableDatabase
        val values = contentValuesOf()
        values.put(NOM,User.nom)
        values.put(PASSWORD,User.password)
        values.put(EMAIL,User.email)
        values.put(PRENOM,User.prenom)
        //insert into user( nom , prenom, email, password )values(user.nom, user.prenom, user.email, user.password
        val result = db.insert(USERS_TABLE_NAME,null,values).toInt()

        db.close()
        return result!= -1
    }
    fun findUSER(email:String,password:String): User? {
        var user : User? = null
        val db = this.readableDatabase
        val selectionArgs = arrayOf(email,password)
        val cursor = db.query(USERS_TABLE_NAME,null,"$EMAIL=? AND $PASSWORD=?",selectionArgs,null,null,null,null)
        if (cursor != null){
            if (cursor.moveToFirst()){
                val id = cursor.getInt(0)
                val nom = cursor.getString(1)
                val prenom = cursor.getString(2)
                val email = cursor.getString(3)
                val user = User(id,nom,prenom,email,"")
                return user
            }
        }
        db.close()
        return user
    }
}

