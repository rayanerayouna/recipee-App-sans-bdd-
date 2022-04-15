package com.example.myapplication1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication1.BDD_Application.bdd
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var db : bdd
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        db = bdd(this)
        connect.setOnClickListener {
            val txtmail = email.text.toString()
            val txtpassword = password.text. toString()
            // verifier si on a nien remplie les champs mail et password
            if (txtmail.trim().isEmpty() || txtpassword.trim().isEmpty())  {
                Toast.makeText(this,"vous devez remplir tous les champs ",Toast.LENGTH_LONG).show()
            } else {
                // appel de la foncrion findUser pour verifier si l'utilisateur existe dans notre db et nous le renvoyer  si c'est le cas on passe a l'autre activity
                val user = db.findUSER(txtmail ,txtpassword)
                if(user!= null) {
                    email.setText("")
                    password.setText("")

                    /*//enregitrer le booleean is authenficated   dans les sharedpreferences
                    var editor = Sharedpreferences.edit()
                    editor.putBoleen("is_authentificated ", true)
                    editor.putString("email", txtmail)
                    editor.apply*/

                    val intentsecondactivity = Intent(this,MainActivity2::class.java).also{
                        //it.putExtra("email", txtmail)
                        startActivity(it)
                        Toast.makeText(this,"utilisateur existe ",Toast.LENGTH_LONG).show()
                    }
                    finish()


                } else {
                    error.text="votre email ou mot de passe est incorrect "
                    error.visibility = View.VISIBLE
                }
            }
        }
        inscription.setOnClickListener {
            val  intentinscriptionactivity = Intent(this, inscriptionActivity ::class.java).also{
                startActivity(it)
            }
}
    }
}