package com.example.quizapp.fragment

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.quizapp.databinding.FragmentSpinBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlin.random.Random


class spinFragment : Fragment() {
  private lateinit var binding: FragmentSpinBinding
  private lateinit var timer: CountDownTimer
  private val itemTitles = arrayOf("100", "try Again", "500", "Try Again", "200", "Try Again" )


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment

        binding = FragmentSpinBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun showResult(itemTitle:String){
        Toast.makeText(requireContext(),itemTitle, Toast.LENGTH_LONG).show()
        binding.spin.isEnabled = true // Enable the button again
    }

    override fun onViewCreated(view : View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

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
            binding.spin.setOnClickListener {
            binding.spin.isEnabled = false // disable the btn while wheel is spinning

                val spin = Random.nextInt(6)
                // generate random vale button between 0 to 5
                val degress  = 60f * spin // calculate the rotation degrees based on the random value

                timer = object : CountDownTimer(5000, 50){
                    var rotation = 0f
                    override fun onTick(millisUntilFinished: Long) {
                        rotation +=5f  // Rotate the wheel

                        if(rotation >= degress){
                            rotation = degress
                            timer.cancel()
                            showResult(itemTitles[spin])
                        }
                        binding.wheel.rotation = rotation
                    }

                    override fun onFinish() {
                    }
                }.start()


        }

    }

    companion object {
    }
}