package com.dam.operations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
        doMath()
    }

    fun doMath() {
        val bundle = intent.extras

        val number1 = bundle?.getFloat("number1") ?: 0f
        val number2 = bundle?.getFloat("number2") ?: 0f

        val sOp = bundle?.getString("op", "") ?: ""

        var result = 0f
        var sResponse = ""

        when (sOp) {
            "+" -> result = number1 + number2
            "-" -> result = number1 - number2
            "*" -> result = number1 * number2
            "/" -> if (number2 == 0f) {
                result = 0f
            } else {
                result = number1 / number2
            }
        }

        sResponse = when {
            number2 == 0f && sOp == "/" -> "Erro: segundo numero nao pode ser 0 na divisao"
            sOp == "" -> "Erro: não definiu operação"
            else -> String.format("O resultado de %s entre %.2f e %.2f é %.2f", sOp, number1, number2, result)
        }

        //sResponse = number1.toString() + number2.toString()

        val result_tv = findViewById<TextView>(R.id.result_tv)
        result_tv.text = sResponse
    }


    fun voltar(view: View) {
        finish()
    }


}