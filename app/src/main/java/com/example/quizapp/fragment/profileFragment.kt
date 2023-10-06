
package com.example.quizapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.quizapp.databinding.FragmentProfileBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.firestore.auth.User
import com.google.firebase.ktx.Firebase


class profileFragment : Fragment() {

    val binding by lazy {
        FragmentProfileBinding.inflate(layoutInflater)
    }

    var isExapand  = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        Firebase.database.reference.child("Users")
            .child(Firebase.auth.currentUser!!.uid)
            .addValueEventListener(
            object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    //get data
                   //var snapshot1 = snapshot.value
                   //Log.d("MYTAG","$snapshot")

                    for (datasnap in snapshot.children){
                        var user= datasnap.getValue(User::class.java)

                       // binding.name.text = user.name
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                  //  TODO("Not yet implemented")
                }

            })

        // Inflate the layout for this fragment
        return binding.root
    }


    companion object
}


