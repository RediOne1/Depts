package com.myapps.depts;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.List;

/**
 * author: Adrian
 * date: 2015-05-09.
 */
public class AddPersonsAdapter extends RecyclerView.Adapter<AddPersonsAdapter.ViewHolder> {

    private List<Quota> quotaList;

    public AddPersonsAdapter(List<Quota> quotaList) {
        this.quotaList = quotaList;
    }

    @Override
    public AddPersonsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.add_person_single_person_layout, parent, false);

        final ViewHolder vh = new ViewHolder(v);
        vh.name = (EditText) v.findViewById(R.id.single_person_name);
        vh.money = (EditText) v.findViewById(R.id.single_person_money);
        vh.name.addTextChangedListener((AddDebtActivity) parent.getContext());
        vh.name.addTextChangedListener(quotaList.get(position));
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        viewHolder.name.setText(quotaList.get(position).person.name);
        float money = quotaList.get(position).money;
        if (money != 0f)
            viewHolder.money.setText(String.format("%.2f", money));


    }

    @Override
    public int getItemCount() {
        return quotaList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public EditText name;
        public EditText money;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
