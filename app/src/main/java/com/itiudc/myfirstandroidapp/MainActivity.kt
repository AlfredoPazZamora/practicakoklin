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
        var temp = 0
        var i = 0


        buttonGetNumber.setOnClickListener(){
            var numberAge:String = inputAge.text.toString()


            if (inputAge.text.isEmpty()){
                Toast.makeText(this, "Please write something...", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(numberAge.toInt() < 10){
                numberAge = (numberAge.toInt() * 7).toString()

                if(numberAge.toInt() > 9){
                    temp = operation(numberAge.toInt())
                    showNumber.text = temp.toString()
                }else{
                    showNumber.text = numberAge
                }
            }else{
                temp = operation(numberAge.toInt())
                showNumber.text = temp.toString()
            }

            temp = 0

        }
    }

    fun operation(numberAge:Int): Int {
        var age = numberAge
        var temp = 0

        while (age > 0){
            temp += age % 10
            age /= 10

            if(temp > 9){
                temp = operation(temp);
            }
        }


        return temp
    }
}