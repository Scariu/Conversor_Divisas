package com.example.conversor_divissas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import com.example.conversor_divissas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private  val divisas = listOf<String>("USD", "CLP", "EUR") //Se crea lista
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

        initListeners()
    }

    private fun initListeners() {
        binding.buttonConvert.setOnClickListener{
            val monto = binding.editTextNumero.text.toString().toDouble()
            val divisaActual = binding.spinnerMoneda1.selectedItem.toString()
            val divisaResultado = binding.spinnerMoneda2.selectedItem.toString()
            Log.d("Captura divisa", "$monto $divisaActual $divisaResultado")
            val resultado = conversorDivisa(monto, divisaActual, divisaResultado)
            binding.textViewResultado.text = resultado.toString()
            binding.textViewNumeroResultado.text = " $monto $divisaActual equivale a $resultado $divisaResultado."
        }
        binding.buttonReset.setOnClickListener(){
            reset()
        }
    }
    fun conversorDivisa(monto: Double, divisaActual: String, divisaCambio: String): Double {
        var resultadoConversion = monto
        when (divisaActual) {
            "USD" -> if (divisaCambio == "CLP") {
                resultadoConversion = monto * 817.00
            } else if (divisaCambio == "USD") {
                resultadoConversion = monto * 1
            } else if (divisaCambio == "EUR") {
                resultadoConversion = monto * 0.89
            }

            "CLP" -> if (divisaCambio == "CLP") {
                resultadoConversion = monto * 1
            } else if (divisaCambio == "USD") {
                resultadoConversion = monto * 0.0012
            } else if (divisaCambio == "EUR") {
                resultadoConversion = monto * 0.0011
            }

            "EUR" -> if (divisaCambio == "CLP") {
                resultadoConversion = monto * 910.10
            } else if (divisaCambio == "USD") {
                resultadoConversion = monto * 1.11
            } else if (divisaCambio == "EUR") {
                resultadoConversion = monto * 1
            }
            else -> {
                monto
            }
        }
        return resultadoConversion
    }

    fun reset(){
        binding.editTextNumero.setText("")
        binding.textViewResultado.text = ""
        binding.textViewNumeroResultado.text = ""
    }
}
