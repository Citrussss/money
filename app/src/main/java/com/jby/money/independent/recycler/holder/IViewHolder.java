package com.jby.money.independent.recycler.holder;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.jby.money.independent.ui.IndependentEntity;

/**
 * @name money
 * @class name：com.jby.money.independent.recycler.adapter
 * @class describe
 * @anthor bangbang QQ:740090077
 * @time 2018/10/26 10:19 PM
 * @change
 * @chang time
 * @class describe
 */
@SuppressWarnings("unchecked")
public class IViewHolder extends RecyclerView.ViewHolder {
    private IndependentEntity entity;
    private IViewHolder(ViewGroup container, ViewDataBinding binding) {
        super(binding.getRoot());

    }
    IViewHolder(IndependentEntity entity,ViewGroup viewGroup){
        this(viewGroup,entity.attach(viewGroup));
    }
}
