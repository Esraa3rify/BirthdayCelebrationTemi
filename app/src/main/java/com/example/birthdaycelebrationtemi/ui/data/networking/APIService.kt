package com.example.birthdaycelebrationtemi.ui.data.networking

import com.example.birthdaycelebrationtemi.ui.data.model.AddNewFaceResponseModel
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

interface APIService {

    @Multipart
    @POST(EndPoint.addFace)
    fun addFace(
        @Query("face_name") post: String,
        @Part image:MultipartBody.Part):Call<AddNewFaceResponseModel>


}