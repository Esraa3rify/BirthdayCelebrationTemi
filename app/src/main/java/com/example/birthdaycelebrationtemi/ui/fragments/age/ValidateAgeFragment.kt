package com.example.birthdaycelebrationtemi.ui.fragments.age

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.birthdaycelebrationtemi.R
import com.example.birthdaycelebrationtemi.ui.activities.MainActivity
import com.example.birthdaycelebrationtemi.ui.analytics.ScreenNames
import com.example.birthdaycelebrationtemi.ui.fragments.StartFragment
import com.robotemi.sdk.Robot
import com.robotemi.sdk.TtsRequest
import kotlinx.android.synthetic.main.fragment_validate_age.yes_btn


class ValidateAgeFragment : Fragment() {

    private lateinit var sRobot: Robot
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

        // Setting On Click Listener
        val textargs2: TextView =view.findViewById(R.id.textAge)
        val args=this.arguments
        val inputData=args?.get("data")
        textargs2.text=inputData.toString()


//        // When robot is ready
//        val ttsRequest = TtsRequest.create("$textargs2  Did I hear you right? ", false)
//        sRobot.speak(ttsRequest)


        yes_btn.setOnClickListener{

            val mainActivity = activity as MainActivity
            mainActivity.navigateToSpecificFragment(StartFragment(), ScreenNames.StartFragment)

        }
    }

}