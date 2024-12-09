package com.bignerdranch.andriod.nasaapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bignerdranch.andriod.nasaapi.api.GalleryItem
import com.bignerdranch.andriod.nasaapi.api.NasaResponse
import com.bignerdranch.andriod.nasaapi.databinding.ListItemGalleryBinding


class PhotoViewHolder(
    private val binding: ListItemGalleryBinding
):RecyclerView.ViewHolder(binding.root){
    fun bind(galleryItem: GalleryItem){
        binding.itemImageView.load(galleryItem.url)
    }
}


class PhotoListAdapter(
    private val galleryItem: List<GalleryItem>,
    private val onPhotoClick: (NasaResponse) -> Unit
) : RecyclerView.Adapter<PhotoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemGalleryBinding.inflate(inflater, parent, false)
        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val item = galleryItem[position]
        holder.bind(item)

        holder.itemView.setOnClickListener {
            onPhotoClick(item)
        }
    }

    private fun onPhotoClick(item: GalleryItem) {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = galleryItem.size
}

