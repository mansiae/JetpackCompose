package com.example.jetnews.ui

import com.google.gson.annotations.SerializedName

data class Book (
    val id: String,
    val title: String,
    val author: String,
    val img: String,
    @SerializedName("is_paid")
    val isPaid: String,
    val price: String,
    @SerializedName("thumb_nail")
    val thumbNail: String,
    val source: String,
    @SerializedName("download_path")
    val downloadPath: String,
    @SerializedName("category_id")
    val categoryId: String,
    @SerializedName("catebory_name")
    val categoryName: String
)
