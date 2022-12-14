package com.example.businesscard.ui.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.businesscard.databinding.ItemBusinessCardBinding
import com.example.businesscard.domain.BusinessCard

class BusinessCardAdapter : ListAdapter<BusinessCard, BusinessCardAdapter.ViewHolder>(DiffCallback()) {

    var listenerShare: (View) -> Unit = {}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBusinessCardBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }



    inner class ViewHolder (private val binding: ItemBusinessCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind (item: BusinessCard) {
            binding.tvName.text = item.name
            binding.tvPhone.text = item.phone
            binding.tvCompany.text = item.company
            binding.tvEmail.text = item.email
            binding.cvContent.setCardBackgroundColor(Color.parseColor(item.backgroundColor))
            binding.cvContent.setOnClickListener{
                listenerShare(it)
            }
        }
    }

}

class DiffCallback: DiffUtil.ItemCallback<BusinessCard>() {
    override fun areItemsTheSame(oldItem: BusinessCard, newItem: BusinessCard) = oldItem == newItem
    override fun areContentsTheSame(oldItem: BusinessCard, newItem: BusinessCard) = oldItem.id == newItem.id

}
