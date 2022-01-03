package com.rasenyer.imagesapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rasenyer.imagesapp.datasource.remote.models.Image
import com.rasenyer.imagesapp.repository.ImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImageViewModel @Inject constructor(private val imageRepository: ImageRepository) : ViewModel() {

    private val _imageList = MutableLiveData<List<Image>>()
    val imageList: LiveData<List<Image>>
        get() = _imageList

    init { getResponse() }

    private fun getResponse() = viewModelScope.launch {

        imageRepository.getResponse().let { response ->

            if (response.isSuccessful) { _imageList.postValue(response.body()) }
            else { Log.d("Tag", "Error: ${response.errorBody()}") }

        }

    }

}