package com.example.taskfox3.dto;

import android.os.Bundle;
import android.provider.CalendarContract;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.taskfox3.ui.fragment.CollectionViewModel;

//Создай нужную модель в кастомной фабрике из п.2 и передай ее в конструктор вьюМодели



public class FactoryCollectionViewModel extends ViewModelProvider.NewInstanceFactory {


    private  int type;
    public FactoryCollectionViewModel(int type) {
        this.type = type;
    }
//В фабрике решить какую реализацию интерфейса (коллекции/мапы) передавать во вьюМодель
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(type == Types.COLLECTIONS){
            BenchmarkModlel benchmarkModlelColl = new CollectionImplementation();
           return (T) new CollectionViewModel(benchmarkModlelColl);
        }else if(type == Types.MAPS){
            BenchmarkModlel benchmarkModlelMaps = new MapsImplementation();
            return (T) new CollectionViewModel(benchmarkModlelMaps);
        }
        else{
            throw new RuntimeException();
        }

    }

}
