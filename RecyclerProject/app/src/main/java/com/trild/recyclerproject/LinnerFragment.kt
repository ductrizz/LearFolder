package com.trild.recyclerproject

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.trild.recyclerproject.adapter.AdapterLinner
import com.trild.recyclerproject.adapter.Student
import com.trild.recyclerproject.databinding.FragmentLinnerBinding
import java.util.zip.Inflater

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class LinnerFragment : Fragment() {

    private var _binding: FragmentLinnerBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var listStudent : ArrayList<Student>
    private lateinit var adapter: AdapterLinner

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLinnerBinding.inflate(inflater, container, false)
        return binding.root
/*        listStudent = ArrayList()
        listStudent?.apply {
            add(Student("Lê Văn Minh", 1997))
            add(Student("Lê Đức Trí", 1993))
            add(Student("Bùi Đức Trí", 1990))
            add(Student("Bùi Đức Trí", 1991))
            add(Student("Nguyễn Thị Thu Minh", 2001))
        }
        adapter = AdapterLinner(listStudent)
        binding.rcvLinner.adapter = adapter*/
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
        listStudent = ArrayList()
        listStudent.apply {
            add(Student("Lê Văn Minh", 1997))
            add(Student("Lê Đức Trí", 1993))
            add(Student("Bùi Đức Trí", 1990))
            add(Student("Bùi Đức Trí", 1991))
            add(Student("Nguyễn Thị Thu Minh", 2001))
        }
        adapter = AdapterLinner(listStudent)
        view?.findViewById<RecyclerView>(R.id.rcvLinner)?.adapter = adapter
    }
}