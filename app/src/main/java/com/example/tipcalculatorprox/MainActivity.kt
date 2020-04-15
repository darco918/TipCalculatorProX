package com.example.tipcalculatorprox

import android.content.Intent
import android.graphics.Color.rgb
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_main.*
import android.text.TextWatcher

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val billAmount = findViewById<TextView>(R.id.bill_amount_text)

        billAmount.setOnClickListener {
            val intent= Intent(this, CountriesActivity::class.java)
            startActivity(intent)
        }

        val editTextBillAmount = findViewById<EditText>(R.id.input_amount)

        editTextBillAmount.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                if(editTextBillAmount.getText().toString() != ""){
                    computeTip(editTextBillAmount.getText().toString().toDouble(), 1,20)
    //                editTextBillAmount.highlightColor = rgb(255,255,255)
                }
                else{
                    computeTip(0.00, 1,20)
                }


            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                computeTip(editTextBillAmount.hint.toString().toDouble(), 1,20)
                editTextBillAmount.highlightColor = rgb(255,255,255)

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                computeTip(editTextBillAmount.hint.toString().toDouble(), 1,20)
                editTextBillAmount.highlightColor = rgb(255,255,255)

            }
        })


       // computeTip(120.00, 6, 20)

    }


    private fun computeTip( billAmount:Double,numberPeople: Int, tipPercentage:Int){
        val totalTip:Double = billAmount * ((tipPercentage.toDouble())/100)

        tip_amount_text.text = ("$   " +(totalTip / numberPeople).toString())
        total_tip_textview.text = ("$   " + totalTip.toString())
    }
}
