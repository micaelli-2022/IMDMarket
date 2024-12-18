package com.example.imdmarket.model

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File

object ProdutoGlobal {

    val listaProdutos = mutableSetOf<Produto>()
    private const val nome_arquivo = "produtos.json"

    // Salvar os produtos no JSON
    fun salvarProdutos(context: Context) {
        val gson = Gson()
        val json = gson.toJson(listaProdutos)
        val file = File(context.filesDir, nome_arquivo)
        file.writeText(json)
    }

    // Carregar os produtos do JSON
    fun carregarProdutos(context: Context) {
        val file = File(context.filesDir,nome_arquivo)
        if (file.exists()) {
            val json = file.readText()
            val gson = Gson()
            val type = object : TypeToken<MutableSet<Produto>>() {}.type
            val produtos = gson.fromJson<MutableSet<Produto>>(json, type)
            listaProdutos.clear()
            listaProdutos.addAll(produtos)
        }
    }




}



