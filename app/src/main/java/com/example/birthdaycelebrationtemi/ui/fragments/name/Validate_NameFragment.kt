package com.example.birthdaycelebrationtemi.ui.fragments.name

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.birthdaycelebrationtemi.R
import com.example.birthdaycelebrationtemi.ui.analytics.ScreenNames
import com.example.birthdaycelebrationtemi.ui.activities.MainActivity
import com.example.birthdaycelebrationtemi.ui.fragments.StartFragment
import com.example.birthdaycelebrationtemi.ui.fragments.age.AgeFragment
import com.robotemi.sdk.TtsRequest
import kotlinx.android.synthetic.main.fragment_enter_name.*
import kotlinx.android.synthetic.main.fragment_validate__name.*
import kotlinx.android.synthetic.main.fragment_validate__name.yes_btn
import kotlinx.android.synthetic.main.fragment_validate_age.*


class Validate_NameFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_validate__name, container, false)
//    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_validate__name, container, false)


        return view
    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //val mainActivity = activity as MainActivity
        // Setting On Click Listener
        val textargs2: TextView =view.findViewById(R.id.text)
        val args=this.arguments
        val inputData=args?.get("data")
        textargs2.text=inputData.toString()

//
//        // When robot is ready
//        val ttsRequest = TtsRequest.create("$textargs2  Did I hear you right? ", false)
//        sRobot.speak(ttsRequest)


        yes_btn.setOnClickListener{

            val mainActivity = activity as MainActivity
            mainActivity.navigateToSpecificFragment(AgeFragment(), ScreenNames.AgeFragment)

        }
    }


}