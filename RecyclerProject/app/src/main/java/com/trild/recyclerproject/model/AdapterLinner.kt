package com.trild.recyclerproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.trild.recyclerproject.LinnerFragment
import com.trild.recyclerproject.R

class AdapterLinner(private val context: Context, private val listStudent: List<Student>, private val clickItem: (Student) -> Unit)  : RecyclerView.Adapter<AdapterLinner.ViewHolder>() {

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
            btnEnter.setOnClickListener {
                Toast.makeText(context,"Name: "+ txtName.text + ", Age: " + txtAge.text, Toast.LENGTH_LONG).show()
            }
            itemView.setOnClickListener {
                clickItem(student)
            }
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
        val btnEnter = view.findViewById<Button>(R.id.btnSubLinnerEnter)

    }

}