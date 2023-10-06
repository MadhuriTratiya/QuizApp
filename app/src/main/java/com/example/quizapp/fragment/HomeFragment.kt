package com.example.quizapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.quizapp.R
import com.example.quizapp.adapter.categoryadapter
import com.example.quizapp.databinding.FragmentHomeBinding
import com.example.quizapp.modle.categorymodle
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlin.collections.ArrayList

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment() {

    private val binding: FragmentHomeBinding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }

    private var categoryList  = ArrayList<categorymodle>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        categoryList.add(categorymodle(R.drawable.c, "C++"))
        categoryList.add(categorymodle(R.drawable.java, "Java"))
        categoryList.add(categorymodle(R.drawable.python, "Python"))
        categoryList.add(categorymodle(R.drawable.android, "Android"))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.dollerwithdrawal.setOnClickListener {
            var bottomSheetDialog : BottomSheetDialogFragment =  withdrawal()
            bottomSheetDialog.show(requireActivity().supportFragmentManager,"TEST")
            bottomSheetDialog.enterTransition
        }
        binding.coinwithdrawal.setOnClickListener {
            var bottomSheetDialog : BottomSheetDialogFragment =  withdrawal()
            bottomSheetDialog.show(requireActivity().supportFragmentManager,"TEST")
            bottomSheetDialog.enterTransition
        }
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.categoryRecycleerview.layoutManager = GridLayoutManager(requireContext(),2)
        var adapter= categoryadapter(categoryList, requireActivity())
        binding.categoryRecycleerview.adapter = adapter
        binding.categoryRecycleerview.setHasFixedSize(true)
    }

    companion object {
    }
}