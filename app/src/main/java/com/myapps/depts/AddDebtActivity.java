package com.myapps.depts;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class AddDebtActivity extends Activity {

    private List<Quota> quotaList;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_debt);

        quotaList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.add_persons_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        adapter = new AddPersonsAdapter(quotaList);
        recyclerView.setAdapter(adapter);

        fab = (FloatingActionButton) findViewById(R.id.add_person_fab);
        fab.attachToRecyclerView(recyclerView);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quotaList.add(new Quota());
                adapter.notifyDataSetChanged();
            }
        });

        quotaList.add(new Quota());
        adapter.notifyDataSetChanged();
    }

}
