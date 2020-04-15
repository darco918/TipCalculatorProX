package com.example.tipcalculatorprox

import com.google.firebase.database.DataSnapshot
import java.lang.Exception

class Country (snapshot: DataSnapshot){

    lateinit var id:String
    lateinit var name:String
    lateinit var percentage:String

    init {
        try {
            val data:HashMap<String, Any> = snapshot.value as HashMap<String, Any>
            id = snapshot.key.toString()
            name = data["name"] as String
            percentage = data["percentage"] as String
        }
        catch (e: Exception){
            e.printStackTrace()
        }
    }
}