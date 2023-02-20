package com.example.birthdaycelebrationtemi.ui.fragments.name

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.birthdaycelebrationtemi.R
import com.example.birthdaycelebrationtemi.ui.analytics.ScreenNames
import com.example.birthdaycelebrationtemi.ui.activities.MainActivity
import com.example.birthdaycelebrationtemi.ui.fragments.age.AgeFragment
import kotlinx.android.synthetic.main.fragment_enter_name.*

class EnterNameFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_enter_name, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainActivity = activity as MainActivity





        // Setting On Click Listener
        proceedBtn.setOnClickListener {

            // Getting the user input
            val text = etVisitorName.text

            // Showing the user input
            //Toast.makeText(activity, text, Toast.LENGTH_SHORT).show()
            if(!text.isBlank()) {
                mainActivity.navigateToSpecificFragment(AgeFragment(), ScreenNames.AgeFragment)

            }
        }


    }

}