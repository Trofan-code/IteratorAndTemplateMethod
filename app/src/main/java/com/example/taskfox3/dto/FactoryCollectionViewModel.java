package com.example.taskfox3.dto;

import android.os.Bundle;
import android.provider.CalendarContract;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.taskfox3.ui.fragment.CollectionViewModel;

//Создай нужную модель в кастомной фабрике из п.2 и передай ее в конструктор вьюМодели



public class FactoryCollectionViewModel extends ViewModelProvider.NewInstanceFactory {


    private  Bundle bundle;
    public FactoryCollectionViewModel(Bundle bundle) {
        this.bundle = bundle;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass == CollectionViewModel.class){
            return (T) new CollectionViewModel(bundle);
        }
        return null;
    }

}
