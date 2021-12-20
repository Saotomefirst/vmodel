package com.saotome.vmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.saotome.vmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var txtContador: EditText
    lateinit var btnDados: Button
    lateinit var btnMostrar: Button

    var contador = 0

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        val activityMainview = activityMainBinding.root
        setContentView(activityMainview)
        //setContentView(R.layout.activity_main)

        inicializarDados()
        inicializarContador()
        inicializarCliques()

    }

    private fun validarContador() {
        if (contador > 5) {
            contador = 0
        }
    }

    private fun inicializarDados() {
        txtContador = activityMainBinding.txtContador
        btnDados = activityMainBinding.btnDados
        btnMostrar = activityMainBinding.btnMostrar
    }

    private fun inicializarContador() {
        txtContador.setText(contador.toString())
    }

    private fun inicializarCliques() {
        btnDados.setOnClickListener {
            contador++
            validarContador()
            inicializarContador()
        }

        btnMostrar.setOnClickListener {
            Toast.makeText(this, "Valor do Contador: ${contador.toString()}", Toast.LENGTH_SHORT).show()
        }
    }

}