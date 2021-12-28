package com.technado.neekyu.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.technado.neekyu.R

class WallpapersAdapter(var context: Context, var list: List<String>) :
    RecyclerView.Adapter<WallpapersAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.item_wallpappers, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvSet.setOnClickListener(View.OnClickListener {
            Toast.makeText(context, "" + position, Toast.LENGTH_SHORT).show()
        })
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvSet: TextView

        init {
            tvSet = itemView.findViewById(R.id.tvSet)
        }
    }
}