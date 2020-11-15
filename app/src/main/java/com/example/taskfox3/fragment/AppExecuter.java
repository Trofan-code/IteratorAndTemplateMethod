package com.example.taskfox3.fragment;

import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppExecuter {

    private static final Object LOCK = new Object();
    private static AppExecuter instanceExecutor;
    private final Executor addingInTheBeginningIO;
    private final Executor addingInTheMiddleIO;
    private final Executor addingInTheEndIO;
    private final Executor searchByValueIO;
    private final Executor removingInTheBeginningIO;
    private final Executor removingInTheMiddleIO;
    private final Executor removingInTheEndIO;

    public AppExecuter(Executor addingInTheBeginningIO, Executor addingInTheMiddleIO, Executor addingInTheEndIO,
                       Executor searchByValueIO, Executor removingInTheBeginningIO, Executor removingInTheMiddleIO,
                       Executor removingInTheEndIO) {
        this.addingInTheBeginningIO = addingInTheBeginningIO;
        this.addingInTheMiddleIO = addingInTheMiddleIO;
        this.addingInTheEndIO = addingInTheEndIO;
        this.searchByValueIO = searchByValueIO;
        this.removingInTheBeginningIO = removingInTheBeginningIO;
        this.removingInTheMiddleIO = removingInTheMiddleIO;
        this.removingInTheEndIO = removingInTheEndIO;
    }

    public Executor getAddingInTheBeginningIO() {
        return addingInTheBeginningIO;
    }

    public Executor getAddingInTheMiddleIO() {
        return addingInTheMiddleIO;
    }

    public Executor getAddingInTheEndIO()  {
        return addingInTheEndIO;
    }
    public Executor getSearchByValueIO() {
        return searchByValueIO;
    }

    public Executor getRemovingInTheBeginningIO() {
        return removingInTheBeginningIO;
    }

    public Executor getRemovingInTheMiddleIO() {
        return removingInTheMiddleIO;
    }

    public Executor getRemovingInTheEndIO() {
        return removingInTheEndIO;
    }


    public static AppExecuter getInstance(){
        if(instanceExecutor==null){
            synchronized (LOCK){
                instanceExecutor = new AppExecuter//(Executors.newCachedThreadPool(),new MainThreadHandler(),  );--??
            }
        }
        return instanceExecutor;
    }

    private static class MainThreadHandler implements Executor {

        private Handler mainThreadHandler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(@NonNull Runnable command) {
            mainThreadHandler.post(command);

        }
    }

}
