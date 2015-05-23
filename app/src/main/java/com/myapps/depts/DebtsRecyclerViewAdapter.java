package com.myapps.depts;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * author: Adrian
 * date: 2015-05-07.
 */
public class DebtsRecyclerViewAdapter extends RecyclerView.Adapter<DebtsRecyclerViewAdapter.ViewHolder> {

    private List<Debt> debtList;

    public DebtsRecyclerViewAdapter(List<Debt> debtList) {
        this.debtList = debtList;
    }

    @Override
    public DebtsRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.debt_layout, parent, false);

        ViewHolder vh = new ViewHolder(v);
        vh.title = (TextView) v.findViewById(R.id.debt_list_item_title);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.title.setText(debtList.get(position).name);

    }

    @Override
    public int getItemCount() {
        return debtList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
