package com.myapps.depts;

import android.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.melnykov.fab.FloatingActionButton;
import com.myapps.depts.database.DebtsDb;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private List<Debt> debtList = new ArrayList<>();
    private RecyclerView.Adapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        adapter = new DebtsRecyclerViewAdapter(debtList);
        mRecyclerView.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.add_debt_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddDebtActivity.class);
                getActivity().startActivityForResult(intent, 1);
            }
        });
        fab.attachToRecyclerView(mRecyclerView);
    }

    private class LoadDebts extends AsyncTask<Void, Void, ArrayList<Debt>>{

        private DebtsDb debtsDb;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            debtsDb = new DebtsDb(getActivity());
            debtsDb.open();
        }

        @Override
        protected ArrayList<Debt> doInBackground(Void... params) {
            List<Debt> debts = new ArrayList<>();
            Cursor cursor = debtsDb.getAllDebts();
            if(cursor != null && cursor.moveToFirst())
                while(!cursor.isAfterLast()){

                }
            return null;
        }

        @Override
        protected void onPostExecute(ArrayList<Debt> debts) {
            super.onPostExecute(debts);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            debtsDb.close();
        }
    }
}
