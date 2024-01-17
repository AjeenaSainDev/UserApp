package com.example.picgallery.ui.components.useralbums

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.picgallery.domain.model.UserAlbums

@Composable
fun UserAlbums (albums:List<UserAlbums>,onAlbumClick:(UserAlbums)->Unit){
    LazyRow(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
    horizontalArrangement = Arrangement.spacedBy(8.dp)){
        items(albums){album ->
            AlbumItem(album = album, onAlbumClick = onAlbumClick)
        }
    }
}