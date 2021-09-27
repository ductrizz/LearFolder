package com.trild.recyclerproject.view

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import com.trild.recyclerproject.R
import com.trild.recyclerproject.databinding.FragmentMainBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnMainLinnerRecycler.setOnClickListener {
                findNavController().navigate(R.id.action_main_to_Linner)
            }
            btnMainGridRecycler.setOnClickListener {
                findNavController().navigate(R.id.action_main_to_Grid)
            }
            btnMainStaggeredRecycler.setOnClickListener {
                findNavController().navigate(R.id.action_main_to_Staggered)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}