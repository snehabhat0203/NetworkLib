package com.yml.networklibpoc.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yml.networklibpoc.databinding.ItemUniversityBinding
import com.yml.networklibpoc.domain.model.University

class UniversityAdapter(private val universities: List<University>) :
    RecyclerView.Adapter<UniversityAdapter.UniversityViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniversityViewHolder {
        return UniversityViewHolder(
            ItemUniversityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: UniversityViewHolder, position: Int) {
        holder.bindData(universities[position])
    }

    override fun getItemCount(): Int = universities.size

    inner class UniversityViewHolder(private val view: ItemUniversityBinding) :
        RecyclerView.ViewHolder(view.root) {
        fun bindData(university: University) {
            view.textviewLink.text = university.webLink
            view.textviewName.text = university.name
        }
    }
}