package com.example.tipcalculatorprox

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.core.view.get
import java.util.*
import kotlin.collections.ArrayList

class CountriesActivity : AppCompatActivity(), Observer {

    private var mCountryListAdapter: CountryCardAdapter?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_countries)


        CountryModel

        CountryModel.addObserver(this)

        val dataList: ListView = findViewById(R.id.country_list)
        val data: ArrayList<Country> = ArrayList()

        mCountryListAdapter = CountryCardAdapter(this, R.layout.country_card_item, data)
        dataList.adapter = mCountryListAdapter

//        dataList.setOnItemClickListener { parent, view, position, id ->
//            val voluntar:Voluntar = dataList.getItemAtPosition(position) as Voluntar
//
//
//            val intent = Intent(this, ProfileUserActivity::class.java)
//            intent.putExtra("name", voluntar.name)
//            intent.putExtra("phone", voluntar.phone)
//            intent.putExtra("mail", voluntar.mail)
//            startActivity(intent)
//        }
    }

    override fun update(o: Observable?, arg: Any?) {
        mCountryListAdapter?.clear()


        val data = CountryModel.getData()
        if(data!=null){

            mCountryListAdapter?.clear()
            mCountryListAdapter?.addAll(data)
            mCountryListAdapter?.notifyDataSetChanged()

        }
    }
    override  fun onBackPressed() {

        val intent= Intent(this, MainActivity::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent)
        finish()}
//    override fun onResume() {
//        super.onResume()
//        CountryModel.addObserver(this)
//    }
//
//    override fun onPause() {
//        super.onPause()
//        CountryModel.deleteObserver(this)
//    }
//
//    override fun onStop() {
//        super.onStop()
//        CountryModel.deleteObserver(this)


}


