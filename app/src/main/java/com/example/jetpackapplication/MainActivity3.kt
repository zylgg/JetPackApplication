package com.example.jetpackapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.databinding.Observable.OnPropertyChangedCallback
import androidx.lifecycle.Observer
import com.example.jetpackapplication.databinding.ActivityMain3Binding
import com.example.jetpackapplication.ui.main.MainViewModel3


class MainActivity3 : AppCompatActivity() {
    companion object{
        private val TAG:String=this.javaClass.simpleName;
    }
    lateinit var mainBinding:ActivityMain3Binding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main3)
        mainBinding= DataBindingUtil.setContentView(this, R.layout.activity_main3);
//        var viewmodel3 : MainViewModel3=ViewModelProvider(this,SavedStateViewModelFactory(this.application,this)).get(MainViewModel3::class.java);
        val viewModel3s : MainViewModel3  by viewModels();//依赖库fragment-ktx

        mainBinding.model3=viewModel3s;//讲mode与view中指定的别名-->绑定
        mainBinding.lifecycleOwner=this;



        //用viewModel3s去监听数据变化，
        viewModel3s.getCount1LiveData.observe(this, Observer() {
            Log.i(TAG, "onchanged: " + it)
        })
        viewModel3s.getRandomStrLiveData.observe(this, {
            Log.i(TAG, "onchanged: random-->" + it)
        })

        val callback: OnPropertyChangedCallback = object : OnPropertyChangedCallback() {
            override fun onPropertyChanged(observable: Observable?, i: Int) {
            }

        }
        viewModel3s.userName.addOnPropertyChangedCallback(callback)

    }
}

