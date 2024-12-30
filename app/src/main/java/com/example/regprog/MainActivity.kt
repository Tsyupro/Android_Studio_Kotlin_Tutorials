package com.example.regprog

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val userLogin:EditText=findViewById(R.id.user_login)
        val userEmail:EditText=findViewById(R.id.user_email)
        val userPass:EditText=findViewById(R.id.user_pass)
        val pressButton:Button = findViewById(R.id.buttonReg)
        val linkToAuth:TextView = findViewById(R.id.link_to_auth)

        pressButton.setOnClickListener{
            val login =userLogin.text.toString().trim()
            val email = userEmail.text.toString().trim()
            val pass = userPass.text.toString().trim()

            if(login == "" || email == "" || pass == ""){
                Toast.makeText(this,"Не всі поля заповнені",Toast.LENGTH_LONG).show()
            }
            else{
                val user =User(login,email,pass)

                val db=DbHelper(this,null)
                db.addUser(user)
                Toast.makeText(this,"User Add Complete",Toast.LENGTH_LONG).show()

                userLogin.text.clear()
                userEmail.text.clear()
                userPass.text.clear()
            }
        }
        linkToAuth.setOnClickListener(){
            val intent = Intent(this,AuthActivity::class.java)
            startActivity(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}