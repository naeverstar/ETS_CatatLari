package com.example.catatanlari

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.catatanlari.databinding.ItemCatatLariBinding

class CatatLariAdapter(
    private val list: MutableList<catatLari>,
    private val onItemClick: (catatLari) -> Unit
) : RecyclerView.Adapter<CatatLariAdapter.CatatLariViewHolder>() {

    class CatatLariViewHolder(val binding: ItemCatatLariBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatatLariViewHolder {
        val binding = ItemCatatLariBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CatatLariViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CatatLariViewHolder, position: Int) {
        val item = list[position]
        holder.binding.apply {
            tvItemJadwal.text = "Tanggal: ${item.jadwal}"
            tvItemLocation.text = "Tempat: ${item.tempat}"
            
            root.setOnClickListener {
                onItemClick(item)
            }
        }
    }

    override fun getItemCount(): Int = list.size

    fun addData(item: catatLari) {
        list.add(0, item)
        notifyItemInserted(0)
    }
}