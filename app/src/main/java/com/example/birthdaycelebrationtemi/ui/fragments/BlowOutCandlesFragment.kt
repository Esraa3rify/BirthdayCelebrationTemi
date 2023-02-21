package com.example.birthdaycelebrationtemi.ui.fragments

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.birthdaycelebrationtemi.R
import com.example.birthdaycelebrationtemi.ui.activities.MainActivity
import com.example.birthdaycelebrationtemi.ui.analytics.ScreenNames
import kotlinx.android.synthetic.main.fragment_blow_out_candles.*


class BlowOutCandlesFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blow_out_candles, container, false)
    }




    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val mainActivity = activity as MainActivity

        val music: MediaPlayer = MediaPlayer.create(activity, R.raw.birth)



        music.start()

        btn_blow_out.setOnClickListener {
            mainActivity.navigateToSpecificFragment(ThankUouFragment(), ScreenNames.ThankUouFragment)
        }




    }
}