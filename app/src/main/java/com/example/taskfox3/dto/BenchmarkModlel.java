
package com.example.taskfox3.dto;
import android.widget.ProgressBar;

import com.example.taskfox3.R;

import java.util.ArrayList;
import java.util.List;


//3. Создай интерфейс BenchmarkModlel.
// Он будет создавать тебе список айтемов для отображения и мерять время. Сделай 2 реализации: для коллекций и для мап.
//Создай нужную модель в кастомной фабрике из п.2 и передай ее в конструктор вьюМодели

public interface BenchmarkModlel {


    List<BenchmarkItem> dataListCollections = new ArrayList<>();
    List<BenchmarkItem> dataListMaps = new ArrayList<>();
    long timeForCollections=0L;
    long timeForMaps=0L;



     static List<BenchmarkItem> addItemForCollection(){
         dataListCollections.add(new BenchmarkItem(R.string.name_oper_1));
         dataListCollections.add(new BenchmarkItem(R.string.name_oper_2));
         dataListCollections.add(new BenchmarkItem(R.string.name_oper_3));
         dataListCollections.add(new BenchmarkItem(R.string.name_oper_4));
         dataListCollections.add(new BenchmarkItem(R.string.name_oper_5));
         dataListCollections.add(new BenchmarkItem(R.string.name_oper_6));
         dataListCollections.add(new BenchmarkItem(R.string.name_oper_7));
        return dataListCollections;
    }

    static List<BenchmarkItem> addItemForMaps(){
        dataListMaps.add(new BenchmarkItem(R.string.name_oper_map_1));
        dataListMaps.add(new BenchmarkItem(R.string.name_oper_map_2));
        dataListMaps.add(new BenchmarkItem(R.string.name_oper_map_3));
        return dataListMaps;
    }


}

