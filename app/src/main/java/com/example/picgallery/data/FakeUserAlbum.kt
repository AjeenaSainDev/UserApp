package com.example.picgallery.data

import com.example.picgallery.domain.model.Albums
import com.example.picgallery.domain.model.UserAlbums

object FakeUserAlbum {

    val my_uploads = listOf(Albums("title1","image_url"),Albums("title2","image_url"),
    Albums("title3","image_url"), Albums("title4","image_url"))

    val profile_pics= listOf(Albums("title1","image_url"),Albums("title2","image_url"),
        Albums("title3","image_url"), Albums("title4","image_url"))

}

object FakeAlbumCategories {
    val album_list = listOf(UserAlbums("uploads",FakeUserAlbum.my_uploads),UserAlbums("profile_pics",FakeUserAlbum.profile_pics))
}