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
import android.widget.ArrayAdapter
import com.example.imdmarket.databinding.ActivityCadastrarBinding
import com.example.imdmarket.model.ProdutoGlobal
import com.google.gson.Gson
import java.io.File


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

        ProdutoGlobal.carregarProdutos(this)


        //apresenta a lista
        val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                ProdutoGlobal.listaProdutos.map { it.toString()  } // Exibir todos os dados
        )
        binding.listView.adapter = adapter
    }

         override fun onDestroy() {
                super.onDestroy()
                // Salva os dados quando a Activity for destruída
                ProdutoGlobal.salvarProdutos(this)
         }

}
