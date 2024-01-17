package com.example.picgallery.ui.components.useralbums

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.picgallery.R
import com.example.picgallery.domain.model.UserAlbums

@Composable
fun AlbumItem(album:UserAlbums,onAlbumClick:(UserAlbums)->Unit){
    Box(
        modifier = Modifier
            .size(120.dp, 120.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colors.primary)
            .clickable {
                onAlbumClick(album)
            }
    ) {
        // You can customize the content inside the album item as per your design
        Text(
            text = album.album_categpry_name,
            color  = colorResource(id = R.color.text),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}