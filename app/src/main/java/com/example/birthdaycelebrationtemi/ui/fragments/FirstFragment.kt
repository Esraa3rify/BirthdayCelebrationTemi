package com.example.birthdaycelebrationtemi.ui.fragments


import android.app.Activity
import android.content.Intent
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.birthdaycelebrationtemi.R
import com.example.birthdaycelebrationtemi.ui.activities.MainActivity
import com.example.birthdaycelebrationtemi.ui.analytics.ScreenNames
import com.example.birthdaycelebrationtemi.ui.data.model.AddNewFaceResponseModel
import com.example.birthdaycelebrationtemi.ui.data.networking.ServiceBuilder
import com.example.birthdaycelebrationtemi.ui.fragments.name.EnterNameFragment
import com.github.dhaval2404.imagepicker.ImagePicker

import kotlinx.android.synthetic.main.fragment_first.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.Call
import retrofit2.Response
import java.io.File


class FirstFragment : Fragment() {

    private val requestGallery = 2121
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
      //  val mainActivity = activity as MainActivity




        btn_start.setOnClickListener {

            ImagePicker.with(this).start(requestGallery)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == requestGallery && data != null) {
                val fileUri = data.data
                setImage(fileUri!!)
                ImagePicker.getFile(data)?.let { doRequest(it,fileUri,"") } ?: run{ Toast.makeText(activity,"Ops. Something went wrong.",
                    Toast.LENGTH_SHORT).show()}


            }
        }
    }

    private fun setImage(uri: Uri) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
            val source = ImageDecoder.createSource(requireActivity().contentResolver, uri)
            val bitmap = ImageDecoder.decodeBitmap(source)
            imageSelected.setImageBitmap(bitmap)


        } else {
            @Suppress("DEPRECATION") val bitmap =
                MediaStore.Images.Media.getBitmap(requireActivity().contentResolver, uri)
            imageSelected.setImageBitmap(bitmap)

        }
    }
    private  fun doRequest(file: File, uri: Uri, faceName:String) {
        val requestFile = file.asRequestBody(requireActivity().contentResolver?.getType(uri)?.toMediaTypeOrNull())
        val body = MultipartBody.Part.createFormData("image", file.name, requestFile)
        val serviceBuilder = ServiceBuilder.myApi


        serviceBuilder.addFace(faceName,body).enqueue(object : retrofit2.Callback<AddNewFaceResponseModel>

        {

            override fun onResponse(
                call: Call<AddNewFaceResponseModel>,
                response: Response<AddNewFaceResponseModel>
            ) {
                val responseCode = response.code()
                if (responseCode == 200) {
                   // Toast.makeText(activity, "Uploaded !", Toast.LENGTH_SHORT).show()
                    val mainActivity = activity as MainActivity
                    mainActivity.navigateToSpecificFragment(EnterNameFragment(), ScreenNames.EnterNameFragment)
                   // mainActivity.changeFragment(EnterNameFragment())

                }
            }


            override fun onFailure(call: Call<AddNewFaceResponseModel>, t: Throwable) {
              //  Toast.makeText(activity, "Failed due ${t.message}", Toast.LENGTH_SHORT)
                //    .show()
                val mainActivity = activity as MainActivity
                mainActivity.navigateToSpecificFragment(EnterNameFragment(), ScreenNames.EnterNameFragment)
            }
        })

    }


}