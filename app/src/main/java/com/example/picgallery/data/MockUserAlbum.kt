package com.example.picgallery.data

import com.example.picgallery.domain.model.Albums
import com.example.picgallery.domain.model.UserAlbums

object MockUserAlbum {

    val my_uploads = listOf(Albums("title1","image_url"),Albums("title2","image_url"),
    Albums("title3","image_url"), Albums("title4","image_url"))

    val profile_pics= listOf(Albums("title1","image_url"),Albums("title2","image_url"),
        Albums("title3","image_url"), Albums("title4","image_url"))

}

object MockAlbumCategories {
    val album_list = listOf(UserAlbums("uploads",MockUserAlbum.my_uploads),UserAlbums("profile_pics",MockUserAlbum.profile_pics))
}