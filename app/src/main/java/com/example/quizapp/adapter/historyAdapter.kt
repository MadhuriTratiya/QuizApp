package com.example.quizapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.databinding.HistoryitemBinding
import com.example.quizapp.modle.historymodelclass

class historyAdapter(var listhistory : ArrayList<historymodelclass>) : RecyclerView.Adapter<historyAdapter.HistoryCoinViewHolder>() {
    class HistoryCoinViewHolder(var binding: HistoryitemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryCoinViewHolder {
        return HistoryCoinViewHolder(HistoryitemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount() = listhistory.size

    override fun onBindViewHolder(holder: HistoryCoinViewHolder, position: Int) {
       holder.binding.time.text = listhistory[position].timeAnddate
        holder.binding.coin.text = listhistory[position].coin


    }
}