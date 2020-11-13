package com.example.taskfox3;


import androidx.lifecycle.ViewModel;

import java.util.ArrayList;


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

public class MyViewModel extends ViewModel {
    ArrayList<Integer> integerArrayList;
    Boolean btnSwitch = false;

    public Boolean getBtnSwitch() {
        return btnSwitch;
    }

    public void setBtnSwitch(Boolean btnSwitch) {
        this.btnSwitch = btnSwitch;
    }

    public MyViewModel() {
    }

    public String getSizeOfColl() {
        return sizeOfColl;
    }

    String sizeOfColl;

    public void setSizeOfCollAndMaps(String sizeOfColl) {
        this.sizeOfColl = sizeOfColl;
    }

    public MyViewModel(String sizeOfColl) {
        this.sizeOfColl = sizeOfColl;
    }

    private ArrayList addingInTheBeginning(){
        integerArrayList = new ArrayList<>();
        //zapolnit arraylist
        //sozdat potok dla dobawlenia w naczalo
        return integerArrayList;
    };

    /*addingInTheMiddle;
     addingInTheEnd;
     searchByValue;
     removingInTheBeginning;
     removingInTheMiddle;
     removingInTheEnd;*/








}
















