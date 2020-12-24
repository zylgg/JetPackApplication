package com.example.jetpackapplication.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.jetpackapplication.R
import com.example.jetpackapplication.databinding.ActivityMain4Binding

class MainActivity4 : AppCompatActivity() {//viewbinding使用

    lateinit var viewbinding4 :ActivityMain4Binding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        viewbinding4= ActivityMain4Binding.inflate(layoutInflater)
        setContentView(viewbinding4.root)

        //打印一下id为textView2的文本
        var toastStr:String="onCreate: "+viewbinding4.textView2.text;
        Toast.makeText(this,toastStr,Toast.LENGTH_LONG).show()

    }
}