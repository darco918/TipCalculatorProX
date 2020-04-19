package com.example.tipcalculatorprox

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.country_card_item.*
import java.lang.Exception

class CountryCardAdapter(context: Context, resource: Int, list: ArrayList<Country>)
    : ArrayAdapter<Country>(context, resource, list) {

    private var mResource:Int =0
    private var mList: ArrayList<Country>
    private var mLayoutInflater: LayoutInflater
    private var mContext: Context = context

    var l = mutableListOf(R.drawable.argentina,R.drawable.australia,R.drawable.brazil,R.drawable.china,R.drawable.costa_rica,
        R.drawable.croatia,R.drawable.czech_republic,R.drawable.dubai,R.drawable.egypt,R.drawable.france,R.drawable.germany,
        R.drawable.greece,R.drawable.hungary,R.drawable.india,R.drawable.israel,R.drawable.italy,R.drawable.japan,
        R.drawable.mexico,R.drawable.romania,R.drawable.russia,R.drawable.south_africa,R.drawable.spain,
        R.drawable.sweden,R.drawable.thailand,R.drawable.turkey,R.drawable.usa)
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

        val country_image = view.findViewById<ImageView>(R.id.country_icon)
        country_image.setImageResource(l[position])
    }

}