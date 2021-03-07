package com.example.taskfox3.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.taskfox3.R;
import com.example.taskfox3.dto.BenchmarkItem;
import com.example.taskfox3.dto.Types;
import com.example.taskfox3.model.FactoryCollectionViewModel;

import java.util.List;


public class BenchmarkFragment extends Fragment implements CompoundButton.OnCheckedChangeListener, BenchmarkView {

    public static final String TYPE = "type";
    private final BenchmarksAdapter adapter = new BenchmarksAdapter();
    private CollectionViewModel viewModel;
    private EditText editTextOperations;
    private EditText editTextThreads;
    private ToggleButton swStart;
    private static final String TAG = "MyApp";
    final Handler handler = new Handler(Looper.getMainLooper());


    public static BenchmarkFragment newInstance(int type) { //prichodit 0-coll, 1-mapy
        final BenchmarkFragment benchmarkFragment = new BenchmarkFragment();
        // use arguments to store type
        final Bundle args = new Bundle();
        args.putInt(TYPE, type);
        benchmarkFragment.setArguments(args);
        return benchmarkFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Bundle args = this.getArguments();
        final int type = args.getInt(TYPE, Types.COLLECTIONS);
        viewModel = new ViewModelProvider(this, new FactoryCollectionViewModel(type)).get(CollectionViewModel.class);
        viewModel.setBenchmarkView(this);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_benchmark, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final RecyclerView recyclerView = view.findViewById(R.id.recycler_view_for_tab);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);

        editTextOperations = view.findViewById(R.id.et_elements);
        editTextThreads = view.findViewById(R.id.et_threads);
        swStart = view.findViewById(R.id.btn_start_stop);
        swStart.setOnCheckedChangeListener(this);

    }

    @Override
    public void onStart() {
        super.onStart();
        if (adapter.isEmpty()) {
            viewModel.getNewItemsList();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        viewModel.removeMyCustomObjectListener(this);
    }

    @Override
    public void onStop() {
       // swStart.setChecked(false);

        super.onStop();
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (compoundButton.isPressed()) {
            viewModel.onCalculationStateChangeClicked(getString(editTextOperations), getString(editTextThreads), b);
            // do something related to user click/tap
        } else if(compoundButton.performClick()) {


            swStart.toggle();

            // do something related to programmatically state changes (checked/unchecked)
        }




    }

    @Override
    public void buttonPositionStopped() {

         //swStart.setChecked(false);
        swStart.toggle();
        // как вернуть обратно
    }

    @Override
    public void showProgress() {
        handler.post(() -> adapter.setProgressVisibility(true));
    }

    @Override
    public void hideProgress() {
        handler.post(() -> adapter.setProgressVisibility(false));
    }


    private String getString(EditText editText) {
        return editText.getText().toString().trim();
    }

    @Override
    public void operationError() {
        editTextOperations.setError(getText(R.string.error_1));
    }

    @Override
    public void threadsError() {
        editTextThreads.setError(getText(R.string.error_2));
    }

    @Override
    public void setTasks(List<BenchmarkItem> newTasks) {
        adapter.setItems(newTasks);
    }

    @Override
    public void updateItem(BenchmarkItem newItem, int position) {
        handler.post(() -> adapter.setNewItem(newItem, position));
    }

    @Override
    public void returnMessageCalcDone() {
        Toast.makeText(getActivity(), "Calculation is over!!!!!!!!!!!!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void returnMessageCalcIsStopped() {

        Toast.makeText(getActivity(), "Calculation is stopped!", Toast.LENGTH_SHORT).show();
    }
}
