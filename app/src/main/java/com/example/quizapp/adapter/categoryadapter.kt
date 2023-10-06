package com.example.quizapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.databinding.CategoryitemBinding
import com.example.quizapp.modle.categorymodle
import com.example.quizapp.quizActivity

class categoryadapter(var categoryList: ArrayList<categorymodle>, var requireActivity: FragmentActivity) : RecyclerView.Adapter<categoryadapter.MyCategoryViewHolder>() {
    class MyCategoryViewHolder(var binding: CategoryitemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCategoryViewHolder {
        return MyCategoryViewHolder(CategoryitemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount() = categoryList.size

    override fun onBindViewHolder(holder: MyCategoryViewHolder, position: Int) {
        var dataList = categoryList[position]
        holder.binding.categoryimage.setImageResource(dataList.catImg)
        holder.binding.category.text=dataList.catText

        holder.binding.categorybtn.setOnClickListener {
            var intent = Intent(requireActivity, quizActivity::class.java)
            intent.putExtra("categoryimg", dataList.catImg)
            requireActivity.startActivity(intent)
        }
    }
}