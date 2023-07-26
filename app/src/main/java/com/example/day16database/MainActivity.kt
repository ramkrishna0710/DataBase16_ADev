package com.example.day16database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    lateinit var dataBase : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val signButton= findViewById<Button>(R.id.btnSignup)
        val eTName = findViewById<TextInputEditText>(R.id.etName)
        val etMail = findViewById<TextInputEditText>(R.id.etMail)
        val userid = findViewById<TextInputEditText>(R.id.etUser)
        val userPassword = findViewById<TextInputEditText>(R.id.etPass)

        signButton.setOnClickListener {
            val name = eTName.text.toString()
            val mail = etMail.text.toString()
            val userId = userid.text.toString()
            val password = userPassword.text.toString()

            val useR = User(name,mail,password,userId)
            dataBase = FirebaseDatabase.getInstance().getReference("Users")
            dataBase.child(userId).setValue(useR).addOnSuccessListener {
                eTName.text?.clear()
                etMail.text?.clear()
                userid.text?.clear()

                Toast.makeText(this,"User Registered",Toast.LENGTH_SHORT).show()
            }.addOnSuccessListener {
                Toast.makeText(this,"User Registered",Toast.LENGTH_SHORT).show()
            }
        }
    }
}