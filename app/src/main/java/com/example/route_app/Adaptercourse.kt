package com.example.route_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adaptercourse (val courses:List<Courses>) : RecyclerView.Adapter<Adaptercourse.viewHolder> (){

    fun setItemOnClickListener(listener: OnItemClickListener) {
       onItemClickListener = listener
    }

    // onClickListener Interface
    interface OnItemClickListener {
        fun onClick(position: Int)
    }


    private lateinit var onItemClickListener: OnItemClickListener








    class viewHolder(itemView: View,listener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        val imageid:ImageView=itemView.findViewById(R.id.courseImage)
        val text:TextView=itemView.findViewById(R.id.squareButton)

        init{
            itemView.setOnClickListener {

                listener.onClick(adapterPosition)

            }


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
val view= LayoutInflater.from(parent.context)
    .inflate(R.layout.activity_course,parent,false)

        return viewHolder(view,onItemClickListener)
    }

    override fun getItemCount(): Int = courses.size



    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val item=courses[position]
        holder.imageid.setImageResource(item.imageId)
        holder.text.text=item.courseName
    }


}