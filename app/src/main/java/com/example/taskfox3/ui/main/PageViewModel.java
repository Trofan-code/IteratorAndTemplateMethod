package com.example.taskfox3.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PageViewModel extends ViewModel {
    private MutableLiveData<String> lengthArrayList = new MutableLiveData<>();

    public void setLengthArrayList(MutableLiveData<String> lengthArrayList) {
        this.lengthArrayList = lengthArrayList;
    }

    public void setLengthArrayList(String length) {
        lengthArrayList.setValue(length);
    }

    public LiveData<String> getLengthArrayList() {
        return lengthArrayList;
    }
}
