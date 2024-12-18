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
import com.example.imdmarket.databinding.ActivityDeletarBinding
import com.example.imdmarket.model.ProdutoGlobal

class DeletarActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDeletarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()

        binding = ActivityDeletarBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btdeletar.setOnClickListener {

            val codigo = binding.edCodigo.text.toString()
            val remover_produto = ProdutoGlobal.listaProdutos.removeIf { it.codigo_produto == codigo }

                if (remover_produto) {
                    ProdutoGlobal.salvarProdutos(this)
                    Toast.makeText(this, "Produto deletado com sucesso", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, MainActivity::class.java))
                } else {
                    Toast.makeText(this, "Produto não encontrado.", Toast.LENGTH_SHORT).show()
                }


        }


        binding.btlimpar3.setOnClickListener {

            limparCampos()
            Toast.makeText(this, "Campos limpos!", Toast.LENGTH_SHORT).show()

        }



    }

        private fun limparCampos(){
            binding.edCodigo.text.clear()

        }
}