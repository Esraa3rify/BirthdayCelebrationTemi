package com.example.birthdaycelebrationtemi.ui.activities


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.birthdaycelebrationtemi.R
import com.example.birthdaycelebrationtemi.ui.analytics.ScreenNames
import com.example.birthdaycelebrationtemi.ui.fragments.FirstFragment
import com.robotemi.sdk.Robot
import com.robotemi.sdk.TtsRequest
import com.robotemi.sdk.listeners.OnRobotReadyListener
import java.util.*


class MainActivity : AppCompatActivity(), OnRobotReadyListener
{
    private lateinit var sRobot: Robot


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize robot instance
        sRobot = Robot.getInstance();

        inflateInitialFragment()
    }

    override fun onStart() {
        super.onStart()

        // Add robot event listeners
        sRobot!!.addOnRobotReadyListener(this);
    }

    override fun onStop() {
        super.onStop()

        // Remove robot event listeners
        sRobot!!.removeOnRobotReadyListener(this);
    }

    private fun inflateInitialFragment()
    {
        navigateToSpecificFragment(FirstFragment(), ScreenNames.FirstFragment);
    }



    override fun onRobotReady(isReady: Boolean) {
        if (isReady) {

            sRobot!!.hideTopBar() // hide temi's top action bar when skill is active

            // When robot is ready
            val ttsRequest = TtsRequest.create("Hello World, that is Celebration message", false)
            sRobot.speak(ttsRequest)
        }
    }

    fun navigateToSpecificFragment(fragment:Fragment,screenName: ScreenNames)
    {


            if (!supportFragmentManager.isDestroyed) {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.nav_host_fragment, fragment).commit()
            }

    }

}