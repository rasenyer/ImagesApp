package com.rasenyer.imagesapp.repository

import com.rasenyer.imagesapp.datasource.remote.api.ImageService
import javax.inject.Inject

class ImageRepository @Inject constructor(private val imageService: ImageService) {

    suspend fun getResponse() = imageService.getResponse()

}