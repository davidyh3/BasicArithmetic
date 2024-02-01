/*
 * AI USE ACKNOWLEDGEMENT
 *
 * For this assignment, I wrote most of my code, including the activity_main.xml.
 * However, since I changed my code from CheckBoxes to RadioGroups (I did not use
 * RadioGroup but only RadioButtons in my first try so I though it is not useful
 * for this assignment until I am packing everything up in the last minute), I
 * have to rewrite everything. To have a quicker debugging, I asked ChatGPT for
 * the way to change from CheckBox to RadioGroup.
 */


package com.example.basicarithmetic

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var number1: EditText
    private lateinit var number2: EditText
    private lateinit var resultTextView: TextView
    private lateinit var operationGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize EditText and TextView
        number1 = findViewById(R.id.number1)
        number2 = findViewById(R.id.number2)
        resultTextView = findViewById(R.id.resultTextView)

        // Initialize RadioGroup for operations
        operationGroup = findViewById(R.id.operationGroup)

        // Initialize and set up the calculate button
        val btnCalculate = findViewById<Button>(R.id.calculateButton)
        btnCalculate.setOnClickListener {
            calculateResult()
        }
    }

    private fun calculateResult() {
        if (number1.text.isEmpty() || number2.text.isEmpty()) {
            resultTextView.text = "Please enter both numbers"
            return
        }

        val a = number1.text.toString().toDouble()
        val b = number2.text.toString().toDouble()
        var output: Double? = null

        when (operationGroup.checkedRadioButtonId) {
            R.id.btn_addition -> output = a + b
            R.id.btn_subtraction -> output = a - b
            R.id.btn_multiplication -> output = a * b
            R.id.btn_division -> {
                if (b != 0.0) {
                    output = a / b
                } else {
                    resultTextView.text = "Cannot divide by zero"
                    return
                }
            }
            R.id.btn_modulus -> output = a % b
        }

        output?.let {
            resultTextView.text = "Result: $it"
        } ?: run {
            resultTextView.text = "Please select an operation"
        }
    }
}