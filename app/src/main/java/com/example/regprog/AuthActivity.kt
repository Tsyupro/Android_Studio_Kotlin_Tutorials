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

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_auth)

        val userLogin: EditText =findViewById(R.id.user_login_auth)
        val userPass: EditText =findViewById(R.id.user_pass_auth)
        val pressButton: Button = findViewById(R.id.button_auth)

        val linkToReg:TextView= findViewById(R.id.link_to_reg)

        linkToReg.setOnClickListener(){
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        pressButton.setOnClickListener{
            val login =userLogin.text.toString().trim()
            val pass = userPass.text.toString().trim()

            if(login == "" ||  pass == ""){
                Toast.makeText(this,"Не всі поля заповнені", Toast.LENGTH_LONG).show()
            }
            else{
                val db=DbHelper(this,null)
                val isAuth=db.getUser(login,pass)

                if(isAuth){
                    Toast.makeText(this,"User login Complete", Toast.LENGTH_LONG).show()
                    userLogin.text.clear()
                    userPass.text.clear()
                }
                else{
                    Toast.makeText(this,"User login Fail", Toast.LENGTH_LONG).show()

                }


            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}