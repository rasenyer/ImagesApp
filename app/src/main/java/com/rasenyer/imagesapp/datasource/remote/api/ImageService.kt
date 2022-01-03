package com.rasenyer.imagesapp.datasource.remote.api

import com.rasenyer.imagesapp.datasource.remote.models.Image
import com.rasenyer.imagesapp.utils.Constants.CLIENT_ID
import com.rasenyer.imagesapp.utils.Constants.END_POINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ImageService {

    @Headers("Accept-Version: v1", "Authorization: Client-ID $CLIENT_ID")
    @GET(END_POINT)
    suspend fun getResponse(): Response<List<Image>>

}