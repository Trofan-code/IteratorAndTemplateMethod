package com.example.taskfox3.dto;


import java.util.List;


//3. Создай интерфейс BenchmarkModel.
// Он будет создавать тебе список айтемов для отображения и мерять время.
// Сделай 2 реализации: для коллекций и для мап.
//Создай нужную модель в кастомной фабрике из п.2 и передай ее в конструктор вьюМодели

public interface BenchmarkModel {

    List<BenchmarkItem> returnNewData(String elements, String threads);

    List<BenchmarkItem> setupItems();

}

