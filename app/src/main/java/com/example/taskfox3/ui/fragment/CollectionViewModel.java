package com.example.taskfox3.ui.fragment;

import androidx.lifecycle.ViewModel;

import com.example.taskfox3.dto.BenchmarkItem;
import com.example.taskfox3.dto.BenchmarkModel;
import com.example.taskfox3.dto.MyCustomObjectListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


public class CollectionViewModel extends ViewModel {
    private final BenchmarkModel benchmarkModel;
    private MyCustomObjectListener myCustomObjectListener;

    public void setMyCustomObjectListener(MyCustomObjectListener myCustomObjectListener) {
        this.myCustomObjectListener = myCustomObjectListener;
    }


    public CollectionViewModel(BenchmarkModel benchmarkModel) {
        this.benchmarkModel = benchmarkModel;

    }

    public List<BenchmarkItem> setupItems() {
        return benchmarkModel.setupItems();
        // set list of items into ui
    }

    public void onCalculationStateChangeClicked(String elements, String threads, boolean isStart) {
        List<BenchmarkItem> copyItems = setupItems();
        for (int i=0;i<copyItems.size();i++) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(threads));
        executor.submit(() -> {
            if(copyItems!=null){
                benchmarkModel.returnNewData(elements,threads).get(i);

                //Удаляй посчитаные элементы из копии. Список пуст - все
                //Я понимаю,что тут не так,но я пока не нашла вариант,как сделать такое
            }
            copyItems.remove(i); //Variable used in lambda expression should be final or effectively final
        });
        }


        //Тебе нужно получить новый список элементов + создать его копию + пул потоков.
        //Итерируешь по списку и кидаешь задачи в пул. Копия списка нужна чтобы знать когда расчет полность завершится
        //Удаляй посчитаные элементы из копии. Список пуст - все
        // start or stop calculation?
        // validate in case of start, stop - other way
        // Use TreadPool
    }


}
















