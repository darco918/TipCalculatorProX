package com.example.tipcalculatorprox

import android.annotation.SuppressLint
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
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val constraintLayoutFlag = findViewById<ConstraintLayout>(R.id.flags_clayout)
        constraintLayoutFlag.setOnClickListener(){
            val intent= Intent(this, CountriesActivity::class.java)
            startActivity(intent)
        }

        val constraintLayoutDashboard = findViewById<TextView>(R.id.to_dashboard)
        constraintLayoutDashboard.setOnClickListener(){
            val intent= Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }



        val editTextBillAmount = findViewById<EditText>(R.id.input_amount)
        val editTextNumberPeople = findViewById<EditText>(R.id.input_number_people)
        val editTextPercentage = findViewById<EditText>(R.id.input_tip_percentage)
        //editTextBillAmount.hint = "2"
        editTextBillAmount.setText("1")
        editTextNumberPeople.setText("1")
        editTextPercentage.setText("15") // get the country percentage

        editTextBillAmount.setTextColor(rgb(255,255,255))
        editTextNumberPeople.setTextColor(rgb(255,255,255))
        editTextPercentage.setTextColor(rgb(255,255,255))

        editTextBillAmount.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                if(editTextBillAmount.getText().toString() != ""){
                    computeTip(editTextBillAmount.getText().toString().toDouble(), editTextNumberPeople.getText().toString().toInt(),editTextPercentage.getText().toString().toInt())
                    editTextBillAmount.setTextColor(rgb(255,255,255))
                }
                else{
                    computeTip(0.00, 1,20)
                }

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                computeTip(editTextBillAmount.hint.toString().toDouble(), 1,20)
                //editTextBillAmount.highlightColor = rgb(255,255,255)

            }
        })



        //check if they are all null
        //CHECK IF NUMBER IS 0
        editTextNumberPeople.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                if(editTextNumberPeople.getText().toString() != ""){
                    computeTip(editTextBillAmount.getText().toString().toDouble(), editTextNumberPeople.getText().toString().toInt(),editTextPercentage.getText().toString().toInt())
                    //                editTextBillAmount.highlightColor = rgb(255,255,255)
                }
                else{
                    computeTip(editTextBillAmount.getText().toString().toDouble(), 1,20)
                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })


        editTextPercentage.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                if(editTextPercentage.getText().toString() != ""){
                    computeTip(editTextBillAmount.getText().toString().toDouble(), editTextNumberPeople.getText().toString().toInt(),editTextPercentage.getText().toString().toInt())
                    //                editTextBillAmount.highlightColor = rgb(255,255,255)
                }
                else{
                    computeTip(editTextBillAmount.getText().toString().toDouble(), 1,10)
                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })


    }


    private fun computeTip( billAmount:Double,numberPeople: Int, tipPercentage:Int){
        val totalTip:Double = billAmount * ((tipPercentage.toDouble())/100)

        total_tip_textview.text = ("$   " + "%.2f".format(totalTip).toDouble().toString())
        // the total tip for all people combined

        tip_amount_text.text = ("$   " +("%.2f".format(totalTip / numberPeople).toDouble()).toString())
        // for each person


    }
}
