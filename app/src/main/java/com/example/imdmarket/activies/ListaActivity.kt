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
import com.example.imdmarket.databinding.ActivityAlterarBinding
import com.example.imdmarket.databinding.ActivityListaBinding

class ListaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()

        binding = ActivityListaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btvoltar.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }



    }
}