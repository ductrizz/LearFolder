package com.trild.recyclerproject.model

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.trild.recyclerproject.R

class AdapterGrid(private val context: Context, private val listStudent: List<Student>, private val clickItem: (Student) -> Unit)  : RecyclerView.Adapter<AdapterGrid.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_grid, parent,false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = listStudent.get(position)
        holder.apply {
            txtName.text = student.name
            txtBirthday.text = "Birth: " + student.birthYear.toString()
            txtAge.text = "Age: " + student.age.toString()
            itemView.setOnClickListener {
                clickItem(student)
            }
        }
    }

    override fun getItemCount(): Int {
        return listStudent.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgAvatar = view.findViewById<ImageView>(R.id.imgSubGridAvatar)
        val txtName = view.findViewById<TextView>(R.id.txtSubGridName)
        val txtBirthday = view.findViewById<TextView>(R.id.txtSubGridBirthYear)
        val txtAge = view.findViewById<TextView>(R.id.txtSubGridAge)
    }

}