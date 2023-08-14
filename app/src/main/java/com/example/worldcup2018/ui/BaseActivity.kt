package com.example.worldcup2018.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB: ViewBinding>:AppCompatActivity(){
    abstract val LOG:String
    private var _binding:ViewBinding?=null
    abstract val bindingInflater:(LayoutInflater)->VB
     val binding get()=  _binding as VB?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding=bindingInflater(layoutInflater)
        setContentView(requireNotNull(_binding).root)
        setup()
        addCallBacks()
    }
    abstract fun addCallBacks()
    abstract fun setup()
    fun log(value:Any){
        Log.v(LOG,value.toString())
    }
}