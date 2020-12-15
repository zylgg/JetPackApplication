package com.example.jetpackapplication.ui.main;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider.*;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory;

import com.example.jetpackapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import com.example.jetpackapplication.databinding.MainFragmentBinding;

public class MainFragment extends Fragment {
    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.message)
    TextView message;

    private MainViewModel mViewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    private MainFragmentBinding binding;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        mViewModel = AndroidViewModelFactory.getInstance(this.getActivity().getApplication()).create(MainViewModel.class);
        binding= DataBindingUtil.bind(view);
        binding.setVmodel(mViewModel);
        binding.setLifecycleOwner(this);
    }

    @SuppressLint("FragmentLiveDataObserve")
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // TODO: Use the ViewModel
        //观察LiveData对象
        mViewModel.get_AddNum_MutableLiveData().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                //当监听到数据发生变化时跟新界面
//                message.setText(""+mViewModel.num);
            }
        });
    }

    @OnClick({R.id.button1, R.id.button2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button1:
//                mViewModel.num++;
//                mViewModel.addNum(mViewModel.num);
                break;
            case R.id.button2:
//                mViewModel.num+=2;
//                mViewModel.addNum(mViewModel.num);
                break;
        }
    }
}