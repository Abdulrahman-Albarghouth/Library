package com.bnaeirtlibrary.ui.mybook;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MybookViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<String> mText;

    public MybookViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is My Books fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

}