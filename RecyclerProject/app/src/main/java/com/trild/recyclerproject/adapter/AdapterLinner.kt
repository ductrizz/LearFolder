package com.trild.recyclerproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.trild.recyclerproject.LinnerFragment
import com.trild.recyclerproject.R

class AdapterLinner(private val listStudent: List<Student>)  : RecyclerView.Adapter<AdapterLinner.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_linner, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = listStudent.get(position)
        holder.apply {
            txtName.text = student.name
            txtBirthday.text = student.birthYear.toString()
            txtAge.text = student.age.toString()
        }
    }

    override fun getItemCount(): Int {
        return listStudent.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgAvatar = view.findViewById<ImageView>(R.id.imgSubLinnerAvarta)
        val txtName = view.findViewById<TextView>(R.id.txtSubLinnerName)
        val txtBirthday = view.findViewById<TextView>(R.id.txtSubLinnerBirthYear)
        val txtAge = view.findViewById<TextView>(R.id.txtSubLinnerAge)
    }

}