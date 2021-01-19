package com.example.taskfox3.dto;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.taskfox3.ui.fragment.CollectionViewModel;


public class FactoryCollectionViewModel extends ViewModelProvider.NewInstanceFactory {


    private final int type;
    private final int coll = 1;
    private final int map = 2;

    public FactoryCollectionViewModel(int type) {
        super();
        this.type = type;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (type == Types.COLLECTIONS) {
            return (T) new CollectionViewModel(new CollectionImplementation(),coll);
        } else if (type == Types.MAPS) {
            return (T) new CollectionViewModel(new MapsImplementation(),map);
        } else {
            throw new RuntimeException("Type is empty");
        }
    }
}
