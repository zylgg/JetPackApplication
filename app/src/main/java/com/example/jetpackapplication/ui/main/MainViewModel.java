package com.example.jetpackapplication.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    int num=0;
    public MutableLiveData<Integer> data;
    //创建LiveData对象
    public MutableLiveData<Integer>  get_AddNum_MutableLiveData(){
        if (data==null){
            data=new MutableLiveData<>();
            data.setValue(0);
        }
        return data;
    }
    public void addNum(int a){
        data.setValue(data.getValue()+a);

    }




    //控制view显隐
    private MutableLiveData<Boolean> isVisibiliy;
    public MutableLiveData<Boolean> getIsVisibiliy() {
        if (isVisibiliy == null) {
            isVisibiliy = new MutableLiveData<>();
            isVisibiliy.setValue(true);
        }
        return isVisibiliy;
    }

    public void setIsVisibiliy() {
        isVisibiliy.setValue(!isVisibiliy.getValue());
    }


}