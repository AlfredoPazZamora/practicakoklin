package com.itiudc.myfirstandroidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.makeText as makeText1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonGetNumber = findViewById<Button>(R.id.button_getNumber)
        val inputAge        = findViewById<EditText>(R.id.input_age)
        val showNumber      = findViewById<TextView>(R.id.show_number)
        val temp = 0

        buttonGetNumber.setOnClickListener(){
            var numberAge:String = inputAge.text.toString()

            if (inputAge.text.isEmpty()){
                Toast.makeText(this, "Please write something...", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (numberAge.toInt() > 9){
                Toast.makeText(this, "Yes is $numberAge", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "No is $numberAge", Toast.LENGTH_SHORT).show()
            }

        }
    }
}