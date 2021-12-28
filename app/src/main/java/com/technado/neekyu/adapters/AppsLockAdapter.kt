package com.technado.neekyu.adapters

import android.content.Context
import android.content.pm.ApplicationInfo
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.technado.neekyu.R
import com.technado.neekyu.models.AppModel

class AppsLockAdapter(var context: Context, var list: List<AppModel>) :
    RecyclerView.Adapter<AppsLockAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.item_apps, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.setOnClickListener(View.OnClickListener {
            Toast.makeText(context, "" + list.get(position).getName(), Toast.LENGTH_SHORT).show()
        })
        holder.appName.text = list.get(position).getName()
        holder.image.setImageDrawable(list.get(position).getIcon())
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var appName: TextView
        var image: ImageView

        init {
            appName = itemView.findViewById(R.id.appName)
            image = itemView.findViewById(R.id.image)
        }
    }
}