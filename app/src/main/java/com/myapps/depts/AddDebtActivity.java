package com.myapps.depts;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.github.brnunes.swipeablerecyclerview.SwipeableRecyclerViewTouchListener;
import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class AddDebtActivity extends Activity implements TextWatcher {

    private List<Quota> quotaList;
    private RecyclerView.Adapter recyclerViewAdapter;
    private Spinner spinner;
    private ArrayAdapter<Quota> spinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_debt);

        quotaList = new ArrayList<>();

        spinner = (Spinner) findViewById(R.id.who_paid_spinner);

        spinnerAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, quotaList);

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.add_persons_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerViewAdapter = new AddPersonsAdapter(quotaList);
        recyclerView.setAdapter(recyclerViewAdapter);

        SwipeableRecyclerViewTouchListener swipeTouchListener =
                new SwipeableRecyclerViewTouchListener(recyclerView,
                        new SwipeableRecyclerViewTouchListener.SwipeListener() {
                            @Override
                            public boolean canSwipe(int position) {
                                return true;
                            }

                            @Override
                            public void onDismissedBySwipeLeft(RecyclerView recyclerView, int[] reverseSortedPositions) {
                                quotaList.remove(reverseSortedPositions[0]);
                                recyclerViewAdapter.notifyItemRemoved(reverseSortedPositions[0]);
                                recyclerViewAdapter.notifyDataSetChanged();
                            }

                            @Override
                            public void onDismissedBySwipeRight(RecyclerView recyclerView, int[] reverseSortedPositions) {
                                quotaList.remove(reverseSortedPositions[0]);
                                recyclerViewAdapter.notifyItemRemoved(reverseSortedPositions[0]);
                                recyclerViewAdapter.notifyDataSetChanged();
                            }
                        });
        recyclerView.addOnItemTouchListener(swipeTouchListener);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add_person_fab);
        fab.attachToRecyclerView(recyclerView);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quotaList.add(new Quota());
                recyclerViewAdapter.notifyDataSetChanged();
            }
        });

        quotaList.add(new Quota().setPersonName(getString(R.string.me)));
        recyclerViewAdapter.notifyDataSetChanged();
        quotaList.add(new Quota());
        recyclerViewAdapter.notifyDataSetChanged();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        spinnerAdapter.notifyDataSetChanged();
    }
}
