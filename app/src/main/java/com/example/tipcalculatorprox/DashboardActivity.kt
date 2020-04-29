package com.example.tipcalculatorprox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val constraintLayoutHotel = findViewById<ConstraintLayout>(R.id.hotel_fragment)
        constraintLayoutHotel.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val constraintLayoutTaxi = findViewById<ConstraintLayout>(R.id.taxi_fragment)
        constraintLayoutTaxi.setOnClickListener(){
            val intent = Intent(this,  MainActivity::class.java)
            startActivity(intent)
        }

        val constraintLayoutPub = findViewById<ConstraintLayout>(R.id.pub_fragment)
        constraintLayoutPub.setOnClickListener(){
            val intent = Intent(this,  MainActivity::class.java)
            startActivity(intent)
        }
        val constraintLayoutRestaurant = findViewById<ConstraintLayout>(R.id.restaurant_fragment)
        constraintLayoutRestaurant.setOnClickListener(){
            val intent = Intent(this,  MainActivity::class.java)
            startActivity(intent)
        }
    }
}
