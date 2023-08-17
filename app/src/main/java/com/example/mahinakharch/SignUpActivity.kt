package com.example.mahinakharch

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.example.mahinakharch.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySignUpBinding
    private lateinit var firebaseauth:FirebaseAuth
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseauth=FirebaseAuth.getInstance()

        binding.textView.setOnClickListener{
            val intent=Intent(this,SignInActivity::class.java)
            startActivity(intent)
        }

        binding.button.setOnClickListener{
        val email=binding.emailEt.text.toString()
            val pass=binding.passET.text.toString()
            val confirmpass=binding.confirmPassEt.text.toString()
         if(email.isNotEmpty()&&pass.isNotEmpty()&&confirmpass.isNotEmpty())   {
             if(pass.equals(confirmpass)){
             firebaseauth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener{
                 if(it.isSuccessful){
                   val intent=Intent(this,SignInActivity::class.java)
                     startActivity(intent)
                 }
                 else{
                     Toast.makeText(this,it.exception.toString(),Toast.LENGTH_SHORT).show()

                 }
             }
             }
             else{
                 Toast.makeText(this,"Password is not matching",Toast.LENGTH_SHORT).show()
             }
         }
         else{
             Toast.makeText(this,"Please enter a valid input!",Toast.LENGTH_SHORT).show()

         }
        }
    }
}