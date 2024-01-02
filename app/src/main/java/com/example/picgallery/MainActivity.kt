@file:OptIn(ExperimentalAnimationApi::class)

package com.example.picgallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.picgallery.ui.base.BaseActivity
import com.example.picgallery.ui.navigation.UserNavigation
import com.example.picgallery.ui.theme.BLEACHED_SILK
import com.example.picgallery.ui.theme.PicGalleryTheme
import com.example.picgallery.ui.theme.WHITE
import com.example.picgallery.util.Constants.DARK_THEME
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalAnimationApi
@AndroidEntryPoint
class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PicGalleryTheme {

             setDayTheme()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = BLEACHED_SILK
                ) {
                 UserNavigation()
                }
            }
        }
    }
}
private fun setDayTheme() {
    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
}
private fun setDarkTheme() {
    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
}



@Preview(DARK_THEME, widthDp = 360, heightDp = 640)
@Composable
fun DefaultPreview() {
    PicGalleryTheme {
       UserNavigation()
    }
}