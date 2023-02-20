package com.example.birthdaycelebrationtemi.ui.fragments.age

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.birthdaycelebrationtemi.R
import com.example.birthdaycelebrationtemi.ui.activities.MainActivity
import com.example.birthdaycelebrationtemi.ui.analytics.ScreenNames
import com.example.birthdaycelebrationtemi.ui.fragments.StartFragment

import kotlinx.android.synthetic.main.fragment_validate_age.*


class ValidateAgeFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_validate_age, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainActivity = activity as MainActivity



        yes_btn.setOnClickListener {
            mainActivity.navigateToSpecificFragment(StartFragment(), ScreenNames.StartFragment)
        }
    }

}