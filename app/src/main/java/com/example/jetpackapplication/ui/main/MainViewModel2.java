package com.example.jetpackapplication.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class MainViewModel2 extends ViewModel {
    public final String ASCORE = "aScore";
    public final String BSCORE = "bScore";
    public final String AUNDOSCORE = "aUndoScore";
    public final String BUNDOSCORE = "bUndoScore";

    private SavedStateHandle handle;//这是一个键值对映射，用户保存状态。

    public MainViewModel2(SavedStateHandle handle) {
        this.handle = handle;
    }

    //获取A队的分数
    public MutableLiveData<Integer> getaScore() {
        if (!handle.contains(ASCORE)) {
            handle.set(ASCORE, 0);
        }
        return handle.getLiveData(ASCORE);
    }

    //获取B队的分数
    public MutableLiveData<Integer> getbScore() {
        if (!handle.contains(BSCORE)) {
            handle.set(BSCORE, 0);
        }
        return handle.getLiveData(BSCORE);
    }



    //添加A队的分数
    public void addAScore(int s) {
        //首先把A队和B队的分数保存起来
        handle.set(AUNDOSCORE, getaScore().getValue());
        handle.set(BUNDOSCORE, getbScore().getValue());
        getaScore().setValue(getaScore().getValue() + s);
    }

    //添加B队的分数
    public void addBScore(int s) {
        //首先把A队和B队的分数保存起来
        handle.set(AUNDOSCORE, getaScore().getValue());
        handle.set(BUNDOSCORE, getbScore().getValue());
        //再计算分数
        getbScore().setValue(getbScore().getValue() + s);
    }

    public void reset() {
        //首先把A队和B队的分数保存起来
        handle.set(AUNDOSCORE, getaScore().getValue());
        handle.set(BUNDOSCORE, getbScore().getValue());
        handle.set(ASCORE, 0);
        handle.set(BSCORE, 0);
    }

    //撤回一次
    public void undoScore() {
        handle.set(ASCORE, handle.getLiveData(AUNDOSCORE).getValue());
        handle.set(BSCORE, handle.getLiveData(BUNDOSCORE).getValue());
    }

}
