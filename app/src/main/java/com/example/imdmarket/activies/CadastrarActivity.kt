package com.example.imdmarket.activies

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imdmarket.MainActivity
import com.example.imdmarket.R
import com.example.imdmarket.databinding.ActivityCadastrarBinding
import com.example.imdmarket.databinding.ActivityLoginBinding
import com.example.imdmarket.model.Produto
import com.example.imdmarket.model.ProdutoGlobal
import java.io.File
import com.google.gson.Gson

class CadastrarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastrarBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()

        binding = ActivityCadastrarBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.btsalvar.setOnClickListener {
            // Captura os valores
            val codigo = binding.edCodigo.text.toString()
            val nome = binding.edNome.text.toString()
            val descricao = binding.edDescription.text.toString()
            val estoque = binding.edEstoque.text.toString().toIntOrNull()

            // Valida os campos
            if (codigo.isNotEmpty() && nome.isNotEmpty() && descricao.isNotEmpty() && estoque != null) {
                // Cria o produto
                val produto = Produto(codigo, nome, descricao, estoque)

                // Adiciona o produto à lista de produtos
                ProdutoGlobal.listaProdutos.add(produto)
                ProdutoGlobal.salvarProdutos(this)


                // Alerta usuário
                Toast.makeText(this, "Produto adicionado: $nome", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))


            } else {
                Toast.makeText(this, "Preencha todos os campos corretamente.", Toast.LENGTH_SHORT).show()
            }
        }


        binding.btlimpar.setOnClickListener {

            limparCampos()
            Toast.makeText(this, "Campos limpos!", Toast.LENGTH_SHORT).show()
        }


    }


    private fun limparCampos() {
        binding.edCodigo.text.clear()
        binding.edNome.text.clear()
        binding.edDescription.text.clear()
        binding.edEstoque.text.clear()
    }


}