package com.example.beratbadan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(private val people: List<data>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    private var onItemClickListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person = people[position]
        holder.nameTextView.text = person.name
        holder.genderTextView.text = person.gender
        holder.heightTextView.text = person.height.toString()
        holder.weightTextView.text = person.weight.toString()
        holder.itemView.setOnClickListener {
            onItemClickListener?.onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return people.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.Nama)
        val genderTextView: TextView = itemView.findViewById(R.id.jeniskelamin)
        val heightTextView: TextView = itemView.findViewById(R.id.tinngibadan)
        val weightTextView: TextView = itemView.findViewById(R.id.beratbadan)
    }
}
