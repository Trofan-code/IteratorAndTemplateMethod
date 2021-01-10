
package com.example.taskfox3.dto;
import android.widget.ProgressBar;

import com.example.taskfox3.R;

import java.util.ArrayList;
import java.util.List;


//3. Создай интерфейс BenchmarkModlel.
// Он будет создавать тебе список айтемов для отображения и мерять время.
// Сделай 2 реализации: для коллекций и для мап.
//Создай нужную модель в кастомной фабрике из п.2 и передай ее в конструктор вьюМодели

public interface BenchmarkModlel {
    public List<BenchmarkItem> setupItemsCollection();
    public List<BenchmarkItem> setupItemsMaps();
    public long countTimeCollection();
    public long countTimeMaps();











}

