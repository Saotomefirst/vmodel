package com.saotome.vmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.saotome.vmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var txtContador: EditText
    lateinit var btnDados: Button
    lateinit var btnMostrar: Button

    lateinit var mainViewModel: MainViewModel


    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        val activityMainview = activityMainBinding.root
        setContentView(activityMainview)

        inicializarDados()
        inicializarCliques()

    }



    private fun inicializarDados() {
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        txtContador = activityMainBinding.txtContador
        btnDados = activityMainBinding.btnDados
        btnMostrar = activityMainBinding.btnMostrar

        // sempre que mContador for alterado, isto será executado!
        mainViewModel.mContador.observe(this, Observer { valor ->
            txtContador.setText(valor)
        })
    }

    private fun inicializarCliques() {
        btnDados.setOnClickListener {
            mainViewModel.contador()
        }

        btnMostrar.setOnClickListener {
            Toast.makeText(applicationContext, "Valor do Contador: ${mainViewModel.mContador.value}", Toast.LENGTH_SHORT).show()
        }
    }

}