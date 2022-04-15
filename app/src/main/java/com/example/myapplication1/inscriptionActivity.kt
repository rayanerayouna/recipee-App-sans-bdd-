package com.example.myapplication1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication1.BDD_Application.bdd
import com.example.myapplication1.dataBase.User

class inscriptionActivity  : AppCompatActivity() {
    lateinit var db: bdd
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.inscriprion)

        db = bdd(this)
        val nom = findViewById<EditText>(R.id.nom)
        val prenom = findViewById<EditText>(R.id.prenom)
        val email = findViewById<EditText>(R.id.email)
        val password  = findViewById<EditText>(R.id.password)
        val insciption = findViewById<Button>(R.id.inscription)
        val erreur = findViewById<TextView>(R.id.error2)
        val confirmerpassword = findViewById<EditText>(R.id.confirmerpassword)

        insciption.setOnClickListener {
            erreur.visibility= View.INVISIBLE
            erreur.text=""

            val name = nom.text.toString()
            val email = email.text.toString()
            val prenom = prenom.text.toString()
            val password = password.text.toString()
            val inscription = insciption.text.toString()
            val confirmationpassword = confirmerpassword.text.toString()

            // verifier si les champs sont remplie

            if(name.isEmpty() ||prenom.isEmpty() || email.isEmpty() || password.isEmpty() || confirmationpassword.isEmpty()){
                erreur.text="tous les champs sont obligatoires"
                erreur.visibility= View.VISIBLE
            }else {
                // verifier si les password sont egaux
                if(password != confirmationpassword){
                    erreur.text="passwords differents "
                    erreur.visibility= View.VISIBLE
                } else {
                    val user = User(id = 0,prenom,name,email,password)
                    val isInserted = db.addUser(user)
                    if(isInserted){
                        Toast.makeText(this,"votre compte a été crée avec succeés",Toast.LENGTH_LONG).show()
                        Intent(this,MainActivity2::class.java).also{
                            it.putExtra("email",email)
                            startActivity(it)
                        }
                    }
                }

            }
        }

    }
}