package com.example.taskfox3;


import android.widget.EditText;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.taskfox3.model.DataTable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


//2. При нажатии на кнопку передаешь данные
// (строки с числом потоков и элементов) во
// viewModel фрагмента. Валидируешь их и если не все ок -
// в нужном editText выводишь сообщение о косяке. Если все ок -
// создаешь список задач с пулом потоков (threadPool) и запускаешь расчет
// времени.
//3. Еще одно нажатие на кнопку - остановка расчета
//*Там возможны проблемы из-за лайв даты
//Dan: Между фрагментами ничегго шарить не нужно.
//Состояние кнопки тоже передаешь во вьюМодель,
// чтобы определить запускать потоки или останавливать

//create a model (data bus) that allow to ViewModel from activity to interact with models from fragments.
//interface:
//{
//void putParams(params);
//void addParamsListener(ParamsChangedListener listener);
//void removeParamsListener(ParamsChangedListener listener);
//}
//ParamsChangedListener {
//void onChanged(Params params)
//}

public class CollectionViewModel extends ViewModel {
    public CollectionViewModel() {
    }
    List<Integer> intList;
    Boolean btnSwitch = false;
    String sizeOfCollections;
    String sizeOfThreads;
    private MutableLiveData<List<DataTable>> listMutableLiveData = new MutableLiveData<>();

    public LiveData<List<DataTable>> getDataTable(){
        return  listMutableLiveData;
    }

//3. Заполнение коллекции происходит в потоке и каждый поток заполняет свой экземпляр коллекции.
    //Заполняй коллекцию через Colletiins nCopies
    //public static <T> List<T> nCopies(int n,T o)
ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(sizeOfThreads));

    private List addingInTheBeginning(){
        intList = new ArrayList<Integer>();
        intList =  Collections.nCopies(Integer.parseInt(sizeOfCollections), 1);
        executor.submit(() -> {
            intList.add(0, 2);
        });
        return intList;
    };
    private List addingInTheMiddle(){
        intList = new ArrayList<Integer>();
        intList =  Collections.nCopies(Integer.parseInt(sizeOfCollections), 1);
       // ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(sizeOfThreads));
        executor.submit(() -> {
            intList.add((Integer.parseInt(sizeOfCollections))/2, 2);
        });
        return intList;
    };
    private List addingInTheEnd(){
        intList = new ArrayList<Integer>();
        intList =  Collections.nCopies(Integer.parseInt(sizeOfCollections), 1);
       // ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(sizeOfThreads));
        executor.submit(() -> {
            intList.add((Integer.parseInt(sizeOfCollections)), 3);
        });
        return intList;
    };

    /*addingInTheMiddle;
     addingInTheEnd;
     searchByValue;
     removingInTheBeginning;
     removingInTheMiddle;
     removingInTheEnd;*/








}
















