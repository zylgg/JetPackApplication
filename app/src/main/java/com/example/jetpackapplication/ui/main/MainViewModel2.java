package com.example.jetpackapplication.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

/**
 *
 * ViewModel+LiveData+dataBinding+SavedStateHandle(ViewModel)
 * 需要继承ViewModel，并且ViewModel中一般会配合LiveData使用：
 */
public class MainViewModel2 extends ViewModel {
    public final String ASCORE = "aScore";
    public final String BSCORE = "bScore";
    public final String ADD_ASCORE = "aUndoScore";
    public final String ADD_BSCORE = "bUndoScore";

    /**
     * 构造函数的时候会接收一个 SavedStateHandle 对象，这是一个键值对映射，用户保存状态
     *
     * 注意： 状态必须是简单的轻量级状态。对于复杂或大型数据，您应该使用本地持久性存储
     */
    private SavedStateHandle handle;

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
        handle.set(ADD_ASCORE, getaScore().getValue());
        handle.set(ADD_BSCORE, getbScore().getValue());
        getaScore().setValue(getaScore().getValue() + s);
    }

    //添加B队的分数
    public void addBScore(int s) {
        //首先把A队和B队的分数保存起来
        handle.set(ADD_ASCORE, getaScore().getValue());
        handle.set(ADD_BSCORE, getbScore().getValue());
        //再计算分数
        getbScore().setValue(getbScore().getValue() + s);
    }

    /**
     * 重置
     */
    public void reset() {
        //首先把A队和B队的分数保存起来
        handle.set(ADD_ASCORE, getaScore().getValue());
        handle.set(ADD_BSCORE, getbScore().getValue());
        handle.set(ASCORE, 0);
        handle.set(BSCORE, 0);
    }

    //撤回一次
    public void undoScore() {
        handle.set(ASCORE, handle.getLiveData(ADD_ASCORE).getValue());
        handle.set(BSCORE, handle.getLiveData(ADD_BSCORE).getValue());
    }

}
