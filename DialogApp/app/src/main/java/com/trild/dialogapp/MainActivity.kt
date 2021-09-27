package com.trild.dialogapp
/*DIALOG LESSON
* (1) Alert DiaLog
* (2)Customize Dialog*/
import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var btnAdd : Button
    private lateinit var btnUndo: Button
    private lateinit var listItemNam : ListView
    private lateinit var listName : ArrayList<String>
    private lateinit var adapter : Adapter
    private lateinit var copyName : String
    private var copyIndex : Int = 0
    private lateinit var action : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnAdd = findViewById(R.id.buttonAdd)
        btnUndo = findViewById(R.id.buttonUndo)
        listItemNam = findViewById(R.id.listItem)
        listName = ArrayList()
        addListName()
        Log.e("ListName: ", listName.toString())
        adapter = ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1, listName)
        listItemNam.adapter = adapter as ArrayAdapter<*>
        listItemNam.setOnItemLongClickListener{ adapterView: AdapterView<*>, view1: View, i: Int, l: Long ->
            deleteConfirm(i)
            return@setOnItemLongClickListener false
        }
        btnAdd.setOnClickListener {
            addDialog()
            btnUndo.isEnabled = false
        }
        btnUndo.isEnabled = false
        btnUndo.setOnClickListener {
            if (action == "delete"){
                listName.add(copyIndex, copyName)
                (adapter as ArrayAdapter<*>).notifyDataSetChanged()
                btnUndo.isEnabled = false
            }else if (action == "add"){
                listName.removeAt(listName.lastIndex)
                (adapter as ArrayAdapter<*>).notifyDataSetChanged()
            }
        }
    }
    /*(2)Customize Dialog*/
    private fun addDialog(){
        val addNameDialog = Dialog(this)
        addNameDialog.setContentView(R.layout.add_dialog)
            val etxtContex = addNameDialog.findViewById<EditText>(R.id.editTextContext)
            val btnOk = addNameDialog.findViewById<Button>(R.id.buttonOK)
            val btnCanceler = addNameDialog.findViewById<Button>(R.id.buttonCancel)
        btnOk.setOnClickListener {
            if (etxtContex.length() == 0){
                listName.add(etxtContex.toString())
                (adapter as ArrayAdapter<*>).notifyDataSetChanged()
                action = "add"
                btnUndo.isEnabled = true
                addNameDialog.cancel()
            }else{
                Toast.makeText(this,"Please Input Name!", Toast.LENGTH_SHORT).show()
            }
        }
        btnCanceler.setOnClickListener {
            addNameDialog.cancel()
        }
        addNameDialog.show()
    }
/*(1)Alert Dialog*/
    private fun deleteConfirm(postion : Int){
        val currentName = listName[postion]
        val alertDialog = AlertDialog.Builder(this) //context is MainActivity
        alertDialog.setTitle("Thông Báo")
        alertDialog.setIcon(R.mipmap.ic_launcher)
        alertDialog.setMessage("Bạn có muốn xóa "+ currentName +" không?")
        alertDialog.setPositiveButton("Yes",DialogInterface.OnClickListener { dialogInterface, i ->
            action = "delete"
            btnUndo.isEnabled = true
            copyIndex = postion
            copyName = listName[postion]
            listName.remove(listName[postion])
            Log.e("copyListName: ", listName.toString())
            (adapter as ArrayAdapter<*>).notifyDataSetChanged()
        })
        alertDialog.setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, i ->

        })
        alertDialog.show()
    }
    private fun addListName(){
        listName.apply {
            add("Nguyen Van Minh")
            add("Tran Van Hau")
            add("Bui Van Ba")
            add("Le Duc Lam")
            add("Huynh Tan Phat")
            add("Nguyen Van Minh")
            add("Huynh Thuc Duyet")
            add("Le Van Long")
            add("Nguyen Thi Thu Huong")
            add("Nguyen Tran Van Binh")
        }
    }
}