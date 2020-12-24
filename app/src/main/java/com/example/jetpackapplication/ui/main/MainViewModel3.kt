package com.example.jetpackapplication.ui.main

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlin.random.Random


class MainViewModel3(var stateH: SavedStateHandle) : ViewModel() {
    var userName = ObservableField<String>()
    var userGender = ObservableField<String>()


    fun setUser(){
        userName.set("数据更新了！！");
    }


    var addcounts_key="addCount1";
    val getCount1LiveData:MutableLiveData<Int>
        get() {
            if (!stateH.contains(addcounts_key)){
                stateH.set(addcounts_key, 0)
            }
        return stateH.getLiveData(addcounts_key);
    }


    fun addCount1(int: Int){
        getCount1LiveData.postValue(getCount1LiveData.value?.plus(int))
    }


    var setRandomStr="setRandomStr"
    val getRandomStrLiveData:MutableLiveData<String>
        get() {
        if (!stateH.contains(setRandomStr)){
            stateH.set(setRandomStr, "item0")
        }
        return stateH.getLiveData<String>(setRandomStr);
        }

    fun setRandom(){
        var ii= Random.nextInt(9)*10;
        getRandomStrLiveData.postValue("item" + ii);
    }


}