package ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.geekbrains_popular_libraries_kotlin.databinding.ItemRepoBinding
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter.list.IRepoListPresenter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.view.list.RepoItemView
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.view.list.UserItemView

class ReposRVAdapter(val presenter: IRepoListPresenter) : RecyclerView.Adapter<ReposRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(ItemRepoBinding.inflate(LayoutInflater.from(parent.context), parent, false)).apply {
            itemView.setOnClickListener { presenter.itemClickListener?.invoke(this) }
        }

    override fun getItemCount() = presenter.getCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = presenter.bindView(holder.apply { pos = position })

    inner class ViewHolder(val vb: ItemRepoBinding) : RecyclerView.ViewHolder(vb.root), RepoItemView {
        override fun setRepoName(name: String) {
            vb.tvRepo.text = name
        }

        override var pos = -1
    }
}