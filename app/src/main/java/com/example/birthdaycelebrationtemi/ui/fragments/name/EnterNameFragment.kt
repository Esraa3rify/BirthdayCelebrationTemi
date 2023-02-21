package com.example.birthdaycelebrationtemi.ui.fragments.name

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.birthdaycelebrationtemi.R
import com.example.birthdaycelebrationtemi.ui.activities.MainActivity
import com.example.birthdaycelebrationtemi.ui.analytics.ScreenNames
import com.example.birthdaycelebrationtemi.ui.fragments.ThankUouFragment
import com.robotemi.sdk.Robot
import com.robotemi.sdk.TtsRequest
import com.robotemi.sdk.listeners.OnRobotReadyListener
import kotlinx.android.synthetic.main.fragment_blow_out_candles.*

import kotlinx.android.synthetic.main.fragment_enter_name.*

class EnterNameFragment : Fragment() {
  //  private lateinit var sRobot: Robot

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
        val text = etVisitorName.text.toString()

        val bundle=Bundle()
        bundle.putString("data",text)

        val fragment=Validate_NameFragment()
        fragment.arguments=bundle




        fragmentManager?.beginTransaction()?.replace(R.id.nav_host_fragment,fragment)?.commit()


    }


    }


}