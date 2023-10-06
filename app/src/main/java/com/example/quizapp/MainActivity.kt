package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp.databinding.ActivityMainBinding
import com.example.quizapp.modle.usermodel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private val binding  by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.signup.setOnClickListener {
            if(binding.yourname.text.toString() == " " ||
                binding.yourage.text.toString() == " " ||
                binding.youremail.text.toString() == " " ||
                binding.yourpassword.text.toString() == " "
            ) {

                Toast.makeText(this, "Please fill all the details", Toast.LENGTH_SHORT).show()
            }
                else{
                    Firebase.auth.createUserWithEmailAndPassword(binding.youremail.text.toString(),
                        binding.yourpassword.text.toString()).addOnCompleteListener {
                            if(it.isSuccessful){
                                //write data in database

                                val user = usermodel(binding.yourname.text.toString(),
                                    binding.yourage.text.toString().toInt(),
                                    binding.youremail.text.toString(),
                                    binding.yourpassword.text.toString())

                                Firebase.database.reference.child("Users")
                                    .child(Firebase.auth.currentUser!!.uid).setValue(user).addOnSuccessListener {

                                        startActivity(Intent(this, HomeActivity::class.java))
                                        finish()
                                    }


                            }
                        else{
                            Toast.makeText(this, "Intent not changed",Toast.LENGTH_LONG).show()
                            }
                    }
        }
        }

    }

    // if user allready login
    override fun onStart() {
        super.onStart()
        if(Firebase.auth.currentUser != null){

            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
    }

}