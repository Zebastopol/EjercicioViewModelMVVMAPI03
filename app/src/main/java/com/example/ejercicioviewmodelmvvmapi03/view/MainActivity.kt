package com.example.ejercicioviewmodelmvvmapi03.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ejercicioviewmodelmvvmapi03.R
import com.example.ejercicioviewmodelmvvmapi03.databinding.ActivityMainBinding
import com.example.ejercicioviewmodelmvvmapi03.viewmodel.ViewModel
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this).get(ViewModel::class.java)
        observar()

        binding.btnBuscarNoticia.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE
            if (binding.txtKeyword != null){
                mainViewModel.onBuscarKeyword(binding.txtKeyword.text.toString())
            }else {
                mainViewModel.onBtnBuscarNoticias()
            }
        }
    }

    private fun observar() {
            mainViewModel.noticias.observe(this, Observer {
            binding.txtDescripcion.text = "Noticias: \n"
            /*binding.txtAutor.text =
            binding.txtFecha.text*/
            binding.txtDescripcion.append("${Gson().toJson(it)}")
            binding.progressBar.visibility = View.GONE
        })
    }
}