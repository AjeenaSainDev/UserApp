package com.example.picgallery.domain.model

data class UserAlbums(val album_categpry_name: String , val album:List<Albums>)



data class  Albums (val album_title : String , val image_urls:String)