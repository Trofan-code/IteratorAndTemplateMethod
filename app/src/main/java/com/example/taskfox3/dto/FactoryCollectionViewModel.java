package com.example.taskfox3.dto;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.taskfox3.ui.fragment.CollectionViewModel;
//2. Создай кастомную фабрику для вьюМодели (есть примеры в документации и на startandroid)



public class FactoryCollectionViewModel extends ViewModelProvider.NewInstanceFactory {
   private int sizeOfOperations;
   private int sizeOfThreads;

    public FactoryCollectionViewModel(int sizeOfOperations,int sizeOfThreads) {
        super();
        this.sizeOfOperations=sizeOfOperations;
        this.sizeOfThreads=sizeOfThreads;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass == CollectionViewModel.class){
            return (T) new CollectionViewModel(sizeOfOperations,sizeOfThreads);
        }
        return null;
    }

}
