package com.jby.money.independent.recycler.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.jby.money.independent.recycler.holder.IViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * @name money
 * @class name：com.jby.money.independent.recycler.adapter
 * @class describe
 * @anthor bangbang QQ:740090077
 * @time 2018/10/26 10:16 PM
 * @change
 * @chang time
 * @class describe
 */
public class IAdapter extends RecyclerView.Adapter<IViewHolder> {
    private final List<IViewHolder> holderList=new ArrayList<>();
    @NonNull
    @Override
    public IViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull IViewHolder iViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
