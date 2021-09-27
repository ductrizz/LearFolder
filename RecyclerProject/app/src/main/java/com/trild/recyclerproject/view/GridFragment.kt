package com.trild.recyclerproject.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.setPadding
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.trild.recyclerproject.R
import com.trild.recyclerproject.databinding.FragmentGridBinding
import com.trild.recyclerproject.model.AdapterGrid
import com.trild.recyclerproject.model.AdapterLinner
import com.trild.recyclerproject.model.Student


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class GridFragment : Fragment() {

    private var _binding: FragmentGridBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var listStudent : ArrayList<Student>
    private lateinit var adapter: AdapterGrid

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentGridBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    @SuppressLint("NewApi")
    fun getAdapter(){
        val recyclerView = view?.findViewById<RecyclerView>(R.id.rcvGrid)
        val numberofColumns: Int = 2
        recyclerView?.setPadding(10)
        recyclerView?.setLayoutManager(GridLayoutManager(requireContext(),numberofColumns))
        listStudent = ArrayList()
        listStudent.apply {
            add(Student("Lê Văn Minh", 1997))
            add(Student("Lê Đức Trí", 1993))
            add(Student("Bùi Đức Trí", 1990))
            add(Student("Bùi Đức Trí", 1991))
            add(Student("Nguyễn Thị Thu Minh", 2001))
            add(Student("Trần Văn Quang", 2005))
            add(Student("Nguyễn Thị Luyến", 1999))
        }
        adapter = AdapterGrid(requireContext(),listStudent){Itemstudent ->
            //set click item
            Toast.makeText(requireContext(), "Hello " + Itemstudent.name + "!", Toast.LENGTH_LONG).show()
        }
        recyclerView?.adapter = adapter
    }
}
