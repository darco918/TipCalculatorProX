package com.example.tipcalculatorprox

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val billAmount = findViewById<TextView>(R.id.bill_amount_text)

        billAmount.setOnClickListener {
            val intent= Intent(this, CountriesActivity::class.java)
            startActivity(intent)
        }
    }
}
