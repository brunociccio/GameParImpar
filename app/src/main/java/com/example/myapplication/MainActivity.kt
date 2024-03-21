package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.myapplication.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    private var isPar: Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        capturarClicks()

    }

    private fun capturarClicks() {
        binding.textView1.setOnClickListener{
            checarResultado(1, escolherPeloApp(isPar))
        }
        binding.textView2.setOnClickListener{
            checarResultado(2, escolherPeloApp(isPar))
        }
        binding.textView3.setOnClickListener{
            checarResultado(3, escolherPeloApp(isPar))
        }
        binding.textView4.setOnClickListener{
            checarResultado(4, escolherPeloApp(isPar))
        }
        binding.textView5.setOnClickListener {
            checarResultado(5, escolherPeloApp(isPar))
        }
        binding.buttonPar.setOnClickListener {
            isPar = true
        }
        binding.buttonImpar.setOnClickListener {
            isPar = false
        }
    }

    private fun checarResultado(escolhaUsuario: Int, escolhaApp: Int?) {
        if(escolhaApp == null) binding.textViewResultado.text = "Escolha entre Par e Ímpar"
        else {
            val resultadoPar = (escolhaUsuario + escolhaApp) % 2 == 0
            if(isPar == true && resultadoPar) {
                binding.textViewResultado.text = "Você ganhou!"
        } else {
                binding.textViewResultado.text = "Você perdeu!"
            }
        }
    }

    private fun escolherPeloApp(isPar: Boolean?): Int? {
        if (isPar == null) return null
        val escolhaApp = Random.nextInt(5)
        binding.textViewAppChoice.text = escolhaApp.toString()
        return escolhaApp
    }
}