package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizapp.databinding.ActivityQuizBinding
import com.example.quizapp.fragment.withdrawal
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class quizActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityQuizBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var img = intent.getIntExtra("categoryimg", 0)
        binding.categoryimg.setImageResource(img)

        binding.dollerwithdrawal.setOnClickListener {
            var bottomSheetDialog : BottomSheetDialogFragment =  withdrawal()
            bottomSheetDialog.show(this@quizActivity.supportFragmentManager,"TEST")
            bottomSheetDialog.enterTransition
        }
        binding.coinwithdrawal.setOnClickListener {
            var bottomSheetDialog : BottomSheetDialogFragment =  withdrawal()
            bottomSheetDialog.show(this@quizActivity.supportFragmentManager,"TEST")
            bottomSheetDialog.enterTransition
        }
    }
}