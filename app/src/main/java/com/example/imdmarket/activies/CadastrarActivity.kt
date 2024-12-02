package com.example.imdmarket.activies

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imdmarket.MainActivity
import com.example.imdmarket.R
import com.example.imdmarket.databinding.ActivityCadastrarBinding
import com.example.imdmarket.databinding.ActivityLoginBinding

class CadastrarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastrarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()

        binding = ActivityCadastrarBinding.inflate(layoutInflater)
        setContentView(binding.root)



    binding.btsalvar.setOnClickListener {

        Toast.makeText(this, "Produto salvo com sucesso", Toast.LENGTH_SHORT).show()
        startActivity(Intent(this, MainActivity::class.java))
     }

    }
}