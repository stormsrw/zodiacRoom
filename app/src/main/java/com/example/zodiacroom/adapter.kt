package com.example.zodiacroom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adapter(private val items:ArrayList<String>): RecyclerView.Adapter<adapter.ViewHolder>() {
    private lateinit var mListener :onItemClickListener
    interface onItemClickListener{
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    class ViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val textView : TextView = itemView.findViewById(R.id.sign)
        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return ViewHolder(view,mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text=items[position]
    }

    override fun getItemCount(): Int {
        return items.size
    }


}