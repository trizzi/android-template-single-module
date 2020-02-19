package com.kryptkode.template.app.base.recycler

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewHolder<T, D>(protected val binding: D) :
    RecyclerView.ViewHolder(binding.root) where D : ViewDataBinding {
    abstract fun performBind(item: T?)
}