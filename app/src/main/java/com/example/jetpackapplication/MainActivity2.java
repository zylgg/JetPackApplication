package com.example.jetpackapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.jetpackapplication.databinding.ActivityMainBinding;
import com.example.jetpackapplication.ui.main.MainViewModel2;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        MainViewModel2 vmodel = new ViewModelProvider(this, new SavedStateViewModelFactory(getApplication(), this)).get(MainViewModel2.class);
        ActivityMainBinding mainBinding=DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.setModel(vmodel);
        /**
         * 这句话时必须要加上的，这个方法的注释如下
         *   Sets the {@link LifecycleOwner} that should be used for observing changes of
         *   LiveData in this binding. If a {@link LiveData} is in one of the binding expressions
         *   and no LifecycleOwner is set, the LiveData will not be observed and updates to it
         *   will not be propagated to the UI.
         * 我理解的大概意思就是 这个方法就是把 LifecycleOwner 和 LiveData 绑定到一块，只有绑定到一块。当
         * 数据发生变化的时候 才会更新UI界面
         */
        mainBinding.setLifecycleOwner(this);
    }
}