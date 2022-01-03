package com.rasenyer.imagesapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.rasenyer.imagesapp.R
import com.rasenyer.imagesapp.databinding.ItemImageBinding
import com.rasenyer.imagesapp.datasource.remote.models.Image

class ImageAdapter : RecyclerView.Adapter<ImageAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: ItemImageBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<Image>() {

        override fun areItemsTheSame(oldImage: Image, newImage: Image): Boolean {
            return oldImage.id == newImage.id
        }

        override fun areContentsTheSame(oldImage: Image, newImage: Image): Boolean {
            return oldImage == newImage
        }

    }

    private val differ = AsyncListDiffer(this, diffCallback)

    fun submitList(imageList: List<Image>) = differ.submitList(imageList)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(myViewHolder: MyViewHolder, position: Int) {

        val image = differ.currentList[position]

        myViewHolder.binding.apply {

            val url = image.urls.regular

            mImageView.load(url) {
                placeholder(R.drawable.ic_image)
                crossfade(true)
                crossfade(1000)
            }

        }

    }

    override fun getItemCount() = differ.currentList.size

}