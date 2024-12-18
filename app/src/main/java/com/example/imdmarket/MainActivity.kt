package com.example.imdmarket

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imdmarket.activies.AlterarActivity
import com.example.imdmarket.activies.CadastrarActivity
import com.example.imdmarket.activies.DeletarActivity
import com.example.imdmarket.activies.ListaActivity
import com.example.imdmarket.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // val textoRecuperado1 = recuperarDados(this, "campo1")
        // val textoRecuperado2 = recuperarDados(this, "campo2")

       binding.btcadastro.setOnClickListener {

           startActivity(Intent(this, CadastrarActivity::class.java))
       }

        binding.btlistar.setOnClickListener {

            startActivity(Intent(this, ListaActivity::class.java))
        }


        binding.btalterar.setOnClickListener {

            startActivity(Intent(this, AlterarActivity::class.java))
        }

        binding.btdeletar.setOnClickListener {

            startActivity(Intent(this, DeletarActivity::class.java))
        }
    }

    fun recuperarDados(context: Context, key: String): String {
        val sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val texto = sharedPreferences.getString(key, null)
        return texto ?: ""
    }
}