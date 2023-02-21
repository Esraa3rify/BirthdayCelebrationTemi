package com.example.birthdaycelebrationtemi.ui.fragments.age

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.birthdaycelebrationtemi.R
import com.example.birthdaycelebrationtemi.ui.activities.MainActivity
import kotlinx.android.synthetic.main.fragment_age.*



class AgeFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_age, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainActivity = activity as MainActivity


        // Setting On Click Listener
        ageProceedBtn.setOnClickListener {

            // Getting the user input
            val text = etVisitorAge.text.toString()

            val bundle=Bundle()
            bundle.putString("data",text)

            val fragment= ValidateAgeFragment()
            fragment.arguments=bundle


            fragmentManager?.beginTransaction()?.replace(R.id.nav_host_fragment,fragment)?.commit()




        }

    }

}