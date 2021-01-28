package com.example.taskfox3.dto;

import android.widget.EditText;
import android.widget.Switch;

import com.example.taskfox3.R;

//Создаешь интерфейс, твой фрагмент реализует его и ты говоришь viewModel.setViewListener(this).
// Не забудь убрать слушатель в симметричном методе
// (симметричный методу, где вызвали setViewListener. См жизненный цикл иКо)
public class MyCustomObject implements MyCustomObjectListener {
    private MyCustomObjectListener myCustomObjectListener;
    private EditText editTextOperations;
    private EditText editTextThreads;
    private Switch swStart;


    public void setCustomObjectListener(MyCustomObjectListener myCustomObjectListener) {
        this.myCustomObjectListener = myCustomObjectListener;
    }

    public MyCustomObject() {
        this.myCustomObjectListener = null;
    }

    @Override
    public boolean canWeStartCalc(Boolean b) {
        if (b) {
            return true;
        } else return false;
    }

    public void error(String operation, String threads) {
        swStart = swStart.findViewById(R.id.btn_start_stop);
        editTextOperations = editTextOperations.findViewById(R.id.et_elements);
        editTextThreads = editTextThreads.findViewById(R.id.et_threads);
        if (getString(editTextOperations).length() == 0) {
            editTextOperations.setError("Num of operation is required!");
        } else if (getString(editTextThreads).length() == 0) {
            editTextThreads.setError("Num of threads is required!");
        }
    }

    private String getString(EditText editText) {
        return editText.getText().toString();
    }
}


