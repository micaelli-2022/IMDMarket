package com.example.imdmarket.model


data class Produto(var codigo_produto: String, var nome_produto: String, var descrição_produto: String,
                  var estoque: Int) {


        override fun toString(): String {
            return "Código do produto: $codigo_produto \nNome do produto: $nome_produto \nDescrição: $descrição_produto\nEstoque: $estoque\n"
          }
    }
//data class para sobrescerver os metodos de comparação, para que não sejam colocados produtos repetidos