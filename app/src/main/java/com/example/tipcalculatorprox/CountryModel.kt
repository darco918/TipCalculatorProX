package com.example.tipcalculatorprox

import android.util.Log
import com.google.firebase.database.*
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList

object CountryModel:Observable() {

    private var mDataValueListener :ValueEventListener? = null
    private var mCountryList: ArrayList<Country> = ArrayList()
    private fun getDatabaseRef(): DatabaseReference?{
        return FirebaseDatabase.getInstance().reference.child("country")
    }

    init {
        if(mDataValueListener != null)
        {
            getDatabaseRef()?.removeEventListener(mDataValueListener!!)
        }
        mDataValueListener = null
        Log.i("CountryModel", "date init line 24")

        mDataValueListener = object: ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                if( p0 != null)
                    Log.i("CountryModel", "Line 28, data update cancelled , err = ${p0.message}")

            }


            override fun onDataChange(dataSnapshot: DataSnapshot) {
                try {

                    Log.i("VoluntarModel","Data updatedline 33")
                    val data: ArrayList<Country> = ArrayList()
                    if(dataSnapshot!=null) {
                        for(snapshot: DataSnapshot in dataSnapshot.children){
                            try {
                                data.add(Country(snapshot))
                            }catch (e:Exception){
                                e.printStackTrace()
                            }
                            mCountryList = data
                            Log.i("CountryModel", "Data updated, there are "+ mCountryList!!.size + " entrees in the cache")
                            setChanged()
                            notifyObservers()
                        }
                    }
                }
                catch (e:Exception){
                    e.printStackTrace()

                }
            }

        }
        getDatabaseRef()?.addValueEventListener(mDataValueListener as ValueEventListener)
    }

    fun getData(): ArrayList<Country>?{
        return mCountryList
    }

}