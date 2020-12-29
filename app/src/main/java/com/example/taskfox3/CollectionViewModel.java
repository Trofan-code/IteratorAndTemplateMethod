package com.example.taskfox3;


import android.app.PendingIntent;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.taskfox3.model.DataTable;
import com.example.taskfox3.ui.main.SectionsPagerAdapter;

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
    //private boolean isSwitched;


    private SectionsPagerAdapter adapter;
    private List<DataTable> dataList ;
    private ProgressBar progressBar;
    private List<Integer> intList;

    public Boolean getBtnSwitch() {
        return btnSwitch;
    }

    public void setBtnSwitch(Boolean btnSwitch) {
        this.btnSwitch = btnSwitch;
    }

    private Boolean btnSwitch = false;



    private Switch isSwitched;

    private String sizeOfCollections;
    private String sizeOfThreads;


    public CollectionViewModel(Switch isSwitched) {
        this.isSwitched = isSwitched;
    }

    public Switch getIsSwitched() {
        return isSwitched;
    }
    public void setIsSwitched(Switch isSwitched) {
        this.isSwitched = isSwitched;
    }

    public void exampleCheckSwitch(boolean isSwitched) {
        btnSwitch = isSwitched;
        exampleChange();
    }


    public List<DataTable> exampleChange() {
        dataList = new ArrayList<DataTable>();
        dataList.add(new DataTable(R.string.name_oper_1,"333",progressBar));
        dataList.add(new DataTable(R.string.name_oper_2,"333",progressBar));
        dataList.add(new DataTable(R.string.name_oper_3,"333",progressBar));
        dataList.add(new DataTable(R.string.name_oper_4,"333",progressBar));
        dataList.add(new DataTable(R.string.name_oper_5,"333",progressBar));
        dataList.add(new DataTable(R.string.name_oper_6,"333",progressBar));
        dataList.add(new DataTable(R.string.name_oper_7,"333",progressBar));
        return dataList;
    }

    /*public boolean getIsSwitched() {
        return isSwitched;
    }

    public void setSwitched(boolean switched) {
        isSwitched = switched;
    }*/

    public String getSizeOfCollections() {
        return sizeOfCollections;
    }

    public void setSizeOfCollections(String sizeOfCollections) {
        this.sizeOfCollections = sizeOfCollections;
    }

    public String getSizeOfThreads() {
        return sizeOfThreads;
    }

    public void setSizeOfThreads(String sizeOfThreads) {
        this.sizeOfThreads = sizeOfThreads;
    }

    private MutableLiveData<List<DataTable>> myDataTable;

    public LiveData<List<DataTable>> getDataTable(){
        return  myDataTable;
    }
    public void init(){

    }
//3. Заполнение коллекции происходит в потоке и каждый поток заполняет свой экземпляр коллекции.
    //Заполняй коллекцию через Colletiins nCopies
    //public static <T> List<T> nCopies(int n,T o)
//ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(sizeOfThreads));

    private List addingInTheBeginning(){
        intList = new ArrayList<Integer>();
        intList =  Collections.nCopies(Integer.parseInt(sizeOfCollections), 1);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(sizeOfThreads));
        executor.submit(() -> {
            intList.add(0, 2);
        });
        return intList;
    };
    private List addingInTheMiddle(){
        intList = new ArrayList<Integer>();
        intList =  Collections.nCopies(Integer.parseInt(sizeOfCollections), 1);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(sizeOfThreads));
        executor.submit(() -> {
            intList.add((Integer.parseInt(sizeOfCollections))/2, 2);
        });
        return intList;
    };
    private List addingInTheEnd(){
        intList = new ArrayList<Integer>();
        intList =  Collections.nCopies(Integer.parseInt(sizeOfCollections), 1);
       ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(sizeOfThreads));
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





    public List<DataTable> initialDataTable(){ //move to ViewModel
        dataList = new ArrayList<DataTable>();
        dataList.add(new DataTable(R.string.name_oper_1,"0",progressBar));
        dataList.add(new DataTable(R.string.name_oper_2,"0",progressBar));
        dataList.add(new DataTable(R.string.name_oper_3,"0",progressBar));
        dataList.add(new DataTable(R.string.name_oper_4,"0",progressBar));
        dataList.add(new DataTable(R.string.name_oper_5,"0",progressBar));
        dataList.add(new DataTable(R.string.name_oper_6,"0",progressBar));
        dataList.add(new DataTable(R.string.name_oper_7,"0",progressBar));
        return dataList;
    }







}
















