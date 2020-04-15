package com.example.tipcalculatorprox

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.country_card_item.*
import java.lang.Exception

class CountryCardAdapter(context: Context, resource: Int, list: ArrayList<Country>)
    : ArrayAdapter<Country>(context, resource, list) {

    private var mResource:Int =0
    private var mList: ArrayList<Country>
    private var mLayoutInflater: LayoutInflater
    private var mContext: Context = context

    init{
        this.mResource = resource
        this.mList = list
        this.mLayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val returnView: View?

        if(convertView == null){
            returnView = try{
                mLayoutInflater.inflate(mResource,null)
            } catch (e: Exception){
                e.printStackTrace()
                View(context)
            }
            setUI(returnView, position)
            return returnView
        }
        setUI(convertView, position)
        return convertView
    }

    private fun setUI(view: View, position: Int){
        val country: Country? = if(count> position) getItem(position ) else null

        val countryName: TextView? = view.findViewById(R.id.country_card_name)
        countryName?.text = country?.name ?: ""

        val countryPercentage: TextView? = view.findViewById(R.id.country_card_percentage)
        countryPercentage?.text = country?.percentage ?: ""

    }

}