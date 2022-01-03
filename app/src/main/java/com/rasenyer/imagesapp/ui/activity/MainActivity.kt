package com.rasenyer.imagesapp.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.rasenyer.imagesapp.databinding.ActivityMainBinding
import com.rasenyer.imagesapp.ui.adapter.ImageAdapter
import com.rasenyer.imagesapp.viewmodel.ImageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var imageAdapter: ImageAdapter
    private val imageViewModel: ImageViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecyclerView()

    }

    private fun setUpRecyclerView() {

        imageAdapter = ImageAdapter()

        binding.mRecyclerView.apply {
            adapter = imageAdapter
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            setHasFixedSize(true)
        }

        imageViewModel.imageList.observe(this, { imageList ->

            if (imageList != null) {
                imageAdapter.submitList(imageList)
            }

        })

    }

}