package com.example.taskfox3.dto;


import java.util.List;


//3. Создай интерфейс BenchmarkModel.
// Он будет создавать тебе список айтемов для отображения и мерять время.
// Сделай 2 реализации: для коллекций и для мап.
//Создай нужную модель в кастомной фабрике из п.2 и передай ее в конструктор вьюМодели

public interface BenchmarkModel {
    String putElements(String elements);

    List<BenchmarkItem> returnNewData();

    List<BenchmarkItem> setupItems();

}

