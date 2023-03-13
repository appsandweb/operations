package com.dam.operations

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun doOperation(view: View) {
        val number1txt = findViewById<EditText>(R.id.number1_txt)
        val number2txt = findViewById<EditText>(R.id.number2_txt)
        var op = ""

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)

        val selectedId = radioGroup.checkedRadioButtonId
        val radioButton = findViewById<RadioButton>(selectedId)
        op = radioButton.text.toString()

        val number1 = number1txt.text.toString().toFloat()
        val number2 = number2txt.text.toString().toFloat()

        val intent = Intent(this, Activity2::class.java)

        val bundle = Bundle()
        bundle.putFloat("number1", number1)
        bundle.putFloat("number2", number2)
        bundle.putString("op", op)

        intent.putExtras(bundle)

        startActivity(intent)

    }

}