package com.example.jiik.models

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.jiik.R

class MarsAdapter(private val context: Context) :
    RecyclerView.Adapter<MarsAdapter.ViewHolder>() {
    private var list: List<MarsVariables> = ArrayList()
    fun setMarsData(list: List<MarsVariables>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.image_view_list,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.tvType.text = item.type
        holder.tvPrice.text = "$" + item.price.toString()

        var imageURL = item.imgSrc
        imageURL = imageURL.substring(0, 4) + "s" + imageURL.substring(4)

        Glide.with(context)
            .load(imageURL)
            .into(holder.image)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvType: TextView = view.findViewById(R.id.type)
        val tvPrice: TextView = view.findViewById(R.id.prize)
        val image: ImageView = view.findViewById(R.id.mars_image)
    }
}