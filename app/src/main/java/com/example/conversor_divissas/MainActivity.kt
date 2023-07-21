package com.example.conversor_divissas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.conversor_divissas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private  val divisas = listOf<String>("USD", "CLP", "EURO") //Se crea lista
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, divisas)//Se crea adapter
        binding.spinnerMoneda1.adapter = adapter
        binding.spinnerMoneda2.adapter = adapter
        /*
        *Tambien se puede declarar así
        * binding.spinnerMoneda1.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, divisas)
        * binding.spinnerMoneda1.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, divisas)
        */
    }
}