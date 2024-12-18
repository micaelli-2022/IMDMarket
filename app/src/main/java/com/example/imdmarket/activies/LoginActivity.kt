package com.example.imdmarket.activies

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.Key
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imdmarket.MainActivity
import com.example.imdmarket.R
import com.example.imdmarket.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btEntrar.setOnClickListener{
            var login = binding.edLogin.text.toString()
            var senha = binding.edSenha.text.toString()


            if(login.isNotEmpty() && senha.isNotEmpty() ){
                if (login == "admin" && senha == "admin"){
                    salvar_dados(this, "campo1", login)
                    salvar_dados(this, "campo2", senha)
                    startActivity(Intent(this, MainActivity::class.java))
                }
                else {
                    Toast.makeText(this, "Senha/login inválido", Toast.LENGTH_LONG).show()
                }
            }

            else{
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()

            }



        }

        binding.textEsquecerSenha.setOnClickListener {
            Toast.makeText(this, "Redirecionando para recuperação de senha/login", Toast.LENGTH_LONG).show()
        }


    }

    private fun salvar_dados(context: Context, key: String, text:String){
        val sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val editor= sharedPreferences.edit()
        editor.putString(key,text)
        editor.apply()
    }


}