package com.example.basicarithmetic

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // These are for the FIRST and SECOND number input
    lateinit var number1 : EditText
    lateinit var number2 : EditText

    // This is for the RESULT textview
    lateinit var resultTextView : TextView

    // We need to create 2 doubles for inputs and 1 double for output.
    val a = number1.text.toString().toDouble()
    val b = number2.text.toString().toDouble()
    var output = 0.0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // These are for the FIRST and SECOND number input
        number1 = findViewById(R.id.number1)
        number2 = findViewById(R.id.number2)

        // This is for the RESULT textview
        resultTextView = findViewById(R.id.resultTextView)

        val add = findViewById<CheckBox>(R.id.btn_addition) as CheckBox
        val sub = findViewById<CheckBox>(R.id.btn_subtraction) as CheckBox
        val mul = findViewById<CheckBox>(R.id.btn_multiplication) as CheckBox
        val div = findViewById<CheckBox>(R.id.btn_division) as CheckBox
        val mod = findViewById<CheckBox>(R.id.btn_modulus) as CheckBox
        val btnCalculate = findViewById<Button>(R.id.calculateButton) as Button

        // If we click the bottom
        btnCalculate.setOnClickListener {
            if (add.isChecked && !sub.isChecked && !mul.isChecked &&
                !div.isChecked && !mod.isChecked) {
                output = a + b

                // We send the result to the resultTextView
                resultTextView.text = "Result is $output"
            } else if (!add.isChecked && sub.isChecked && !mul.isChecked &&
                !div.isChecked && !mod.isChecked) {
                output = a - b

                // We send the result to the result textview
                resultTextView.text = "Result is $output"
            } else if (!add.isChecked && !sub.isChecked && mul.isChecked &&
                !div.isChecked && !mod.isChecked) {
                output = a * b

                // We send the result to the result textview
                resultTextView.text = "Result is $output"
            } else if (!add.isChecked && !sub.isChecked && !mul.isChecked &&
                div.isChecked && !mod.isChecked) {
                output = a / b

                // We send the result to the result textview
                resultTextView.text = "Result is $output"
            } else if (!add.isChecked && !sub.isChecked && !mul.isChecked &&
                !div.isChecked && mod.isChecked) {
                output = a % b

                // We send the result to the result textview
                resultTextView.text = "Result is $output"
            } else {
                resultTextView.text = "Error"
            }
        }
    }
}