package com.saotome.vmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// Aqui é onde ficam as regras de negócio
class MainViewModel: ViewModel() {
    var mContador = MutableLiveData<String>().apply {
        value = contador.toString()
    }
    private var contador: Int = 0

    private fun setmContador () {
        mContador.value = contador.toString()
    }

    private fun validarContador() {
        contador++
        if (contador > 5) {
            contador = 0
        }
        setmContador ()
    }

    fun contador(){
        validarContador()
    }
}