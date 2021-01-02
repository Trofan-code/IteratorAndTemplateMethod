package com.example.taskfox3.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Switch;

import com.example.taskfox3.CollectionViewModel;
import com.example.taskfox3.R;
//import com.example.taskfox3.databinding.FragmentBlankCollectionBinding;


public class BlankFragmentCollection extends Fragment {
    private RecyclerView recyclerView;
    private CollectionViewModel model;
    private EditText editTextOperations;
    private EditText editTextThreads;
    private BenchmarksRecyclerViewAdapter adapter; //когда делаю final - ошибка
    private Switch swStart;
    public static BlankFragmentCollection newInstance() {
        return new BlankFragmentCollection();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        model = new ViewModelProvider(this).get(CollectionViewModel.class);
        //ViewModelProviders.of(<Your UI controller>).get(<Your ViewModel>.class)
        /*model.getDataTable().observe(this, new Observer<List<DataTable>>() {
            @Override
            public void onChanged(List<DataTable> dataTables) {
                adapter.notifyDataSetChanged();
            }
        });*/
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {   //find all views in onViewCreated
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view_for_tab);
        adapter = new BenchmarksRecyclerViewAdapter(model.initialDataTableCollection());
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
        swStart = view.findViewById(R.id.switchButton2Collection);
        editTextOperations = view.findViewById(R.id.editTextLen2Collection);
        editTextThreads = view.findViewById(R.id.editTextTreadsCollection);
        // addDataToViewModel();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //simply create a view for fragment without switches etc
        View view = inflater.inflate(R.layout.fragment_blank_collection, container, false);
        return view;
    }


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
   /* private void observeChange(){}
    public void addDataToViewModel(){


        swStart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (!isEmpty(editTextOperations)) {
                        model.setSizeOfCollections(editTextOperations.getText().toString());
                        model.setSizeOfThreads(editTextThreads.getText().toString());
                        //collectionViewModel.setBtnSwitch(true);
                        // The toggle is enabled
                    } else {
                        Toast toast = Toast.makeText(getActivity(),
                                "Введи размер Коллекции и Мапа", Toast.LENGTH_SHORT);
                        toast.show();
                        String userSizeString = editTextOperations.getText().toString();
                        if (TextUtils.isEmpty(userSizeString)) {
                            editTextOperations.setError("The item cannot be empty"); //potom narisowat textinputlayout
                            return;
                        }
                        // The toggle is disabled
                    }
                    editTextOperations.setError(null);
                }
            }
            private boolean isEmpty(EditText sizeColl) {
                return sizeColl.getText().toString().trim().isEmpty(); }

        });
}*/
    }







