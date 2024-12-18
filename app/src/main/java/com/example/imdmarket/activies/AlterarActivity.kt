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
import com.example.imdmarket.databinding.ActivityCadastrarBinding
import com.example.imdmarket.model.Produto
import com.example.imdmarket.model.ProdutoGlobal

class AlterarActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAlterarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()

        binding = ActivityAlterarBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btalterar.setOnClickListener {

            val codigo = binding.edCodigo.text.toString()

                if (codigo.isEmpty()){
                    Toast.makeText(this, "Digite o código do produto para alteração!", Toast.LENGTH_SHORT).show()

                } else{
                       val produto = ProdutoGlobal.listaProdutos.find { it.codigo_produto == codigo } //procura o codigo

                    if (produto != null ) {

                        // Captura os valores
                        val novoNome = binding.edNome.text.toString()
                        if (novoNome.isNotEmpty()) {
                            produto.nome_produto = novoNome
                        }

                        val novaDescricao = binding.edDescription.text.toString()
                        if (novaDescricao.isNotEmpty()) {
                            produto.descrição_produto = novaDescricao
                        }

                        val novoEstoque = binding.edEstoque.text.toString().toIntOrNull()
                        if (novoEstoque != null && novoEstoque >= 0) {
                            produto.estoque = novoEstoque
                        }


                        // adciona produto com as alterações
                        ProdutoGlobal.salvarProdutos(this)



                        Toast.makeText(this, "Produto alterado com sucesso", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, MainActivity::class.java))
                    } else {
                        Toast.makeText(this, "Produto não encontrado.", Toast.LENGTH_SHORT).show()
                    }
                }




        }

        binding.btlimpar2.setOnClickListener {
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