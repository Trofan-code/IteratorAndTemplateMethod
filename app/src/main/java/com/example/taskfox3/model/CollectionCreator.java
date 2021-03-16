package com.example.taskfox3.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

public interface CollectionCreator {

    ArrayList arrayListCreate(int amount);

    LinkedList linkedListCreate(int amount);

    CopyOnWriteArrayList copyOnWriteArrayListCreate(int amount);

}
