package com.example.taskfox3.dto;

import android.content.Context;
import android.view.MotionEvent;

public interface MyCustomObjectListener {


    public boolean  canWeStartCalc(Boolean b); //Object... anyDataYouWantToPassToActivity
    public void error(String operation, String threads);


}
