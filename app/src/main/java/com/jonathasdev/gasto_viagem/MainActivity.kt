package com.jonathasdev.gasto_viagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.jonathasdev.gasto_viagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener { //Traz click pra view

    /**
     * Criação da Activity e chamada do Binding
     */
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCalcular.setOnClickListener(this) //Chama o item do layout (aqui button)
    }

    /**
     * Trata o Evento de Click dos elementos
     */
    override fun onClick(view: View) {
        if (view.id == R.id.btn_calcular) {
            calculate()
        }
    }

    /**
     * Traz as validações de valores dos campos
     */
    private fun validar(): Boolean {
        return (binding.editDistancia.text.toString() != ""
                && binding.editPreco.text.toString() != ""
                && binding.editAutonomia.text.toString() != ""
                && binding.editAutonomia.text.toString().toFloat() != 0f)
    }

    /**
     * Realiza o cálculo dos valores inseridos
     */
    private fun calculate() {

        if (validar()) {
            val distancia = binding.editDistancia.text.toString().toFloat()
            val preco = binding.editPreco.text.toString().toFloat()
            val autonomia = binding.editAutonomia.text.toString().toFloat()

            val valorTotal = (distancia * preco / autonomia)
            binding.textResultado.text = "R$ ${"%.2f".format(valorTotal)}"
        } else {
            Toast.makeText(this, R.string.aviso_preencher_campos, Toast.LENGTH_LONG).show()
            //Toast caso haja campos sem preenchimento!
        }
    }
}