package com.example.quizapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizapp.R
import com.example.quizapp.adapter.historyAdapter
import com.example.quizapp.databinding.FragmentHistoryBinding
import com.example.quizapp.modle.historymodelclass
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class HistoryFragment : Fragment() {

    val binding by lazy {
        FragmentHistoryBinding.inflate(layoutInflater)
    }
    private val ListHistory = ArrayList<historymodelclass>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ListHistory.add(historymodelclass("12:00", "100"))
        ListHistory.add(historymodelclass("12:06", "200"))
        ListHistory.add(historymodelclass("12:05", "500"))
        ListHistory.add(historymodelclass("12:09", "1000"))

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

        binding.historyrecyclerview.layoutManager = LinearLayoutManager(requireContext())
        var adapter = historyAdapter(ListHistory)
        binding.historyrecyclerview.adapter = adapter
        binding.historyrecyclerview.setHasFixedSize(true)

        // Inflate the layout for this fragment
        return binding.root

        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    companion object {
    }
}
