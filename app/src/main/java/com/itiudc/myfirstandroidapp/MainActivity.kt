package com.itiudc.myfirstandroidapp

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.makeText as makeText1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val res: Resources = resources

        val buttonGetNumber = findViewById<Button>(R.id.button_getNumber)
        val inputAge        = findViewById<EditText>(R.id.input_age)
        val inputName       = findViewById<EditText>(R.id.input_name)
        val showNumber      = findViewById<TextView>(R.id.show_number)
        val showPhrase      = findViewById<TextView>(R.id.subtitle)

        var numberToShow = 0

        buttonGetNumber.setOnClickListener(){
            var numberAge:String = inputAge.text.toString()

            if (inputAge.text.isEmpty() || inputName.text.isEmpty()){
                Toast.makeText(this, "Please write something...", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(numberAge.toInt() < 10){
                numberAge = (numberAge.toInt() * 7).toString()
                if(numberAge.toInt() > 9){
                    numberToShow = operation(numberAge.toInt())
                }else{
                    numberToShow = numberAge.toInt()
                }
            }else{
                numberToShow = operation(numberAge.toInt())
            }

            showPhrase.text = res.getString(R.string.main_subtitle, inputName.text.toString())
            showNumber.text = res.getString(R.string.main_lucky_number, numberToShow.toString())

            showPhrase.visibility = View.VISIBLE
            showNumber.visibility = View.VISIBLE

            numberToShow = 0
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