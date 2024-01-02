package com.example.picgallery.ui.navigation

import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.picgallery.ui.components.details.UserDetails
import com.example.picgallery.ui.components.userlist.userList
import com.example.picgallery.util.Constants.DETAILS_ROUTE
import com.example.picgallery.util.Constants.IMAGE_URL
import com.example.picgallery.util.Constants.LOCATION
import com.example.picgallery.util.Constants.MINUS_THREE_HUNDRED
import com.example.picgallery.util.Constants.NAME
import com.example.picgallery.util.Constants.THREE_HUNDRED
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController


@ExperimentalAnimationApi
@Composable
fun UserNavigation(){
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(navController = navController, startDestination = Screen.UserList.route ){
        composable(Screen.UserList.route,
         exitTransition = {
             slideOutHorizontally (
                    animationSpec = tween(
                        durationMillis = THREE_HUNDRED,
                        easing = FastOutSlowInEasing
                    ),
                 targetOffsetX = { MINUS_THREE_HUNDRED}
                     )+ fadeOut(animationSpec = tween(THREE_HUNDRED))
         }   , popEnterTransition = {
                slideInHorizontally(
                    initialOffsetX = { MINUS_THREE_HUNDRED },
                    animationSpec = tween(
                        durationMillis = THREE_HUNDRED,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeIn(animationSpec = tween(THREE_HUNDRED))
            }

        ){
           userList(navController, hiltViewModel())
        }
        composable(
            "${Screen.Details.route}/{name}/{image}/{location}",
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { THREE_HUNDRED },
                    animationSpec = tween(
                        durationMillis = THREE_HUNDRED,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeIn(animationSpec = tween(THREE_HUNDRED))
            },
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { THREE_HUNDRED },
                    animationSpec = tween(
                        durationMillis = THREE_HUNDRED,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeOut(animationSpec = tween(THREE_HUNDRED))
            },
            arguments = listOf(navArgument(NAME) { type = NavType.StringType },
                navArgument(IMAGE_URL) { type = NavType.StringType },
                navArgument(LOCATION) { type = NavType.StringType })
        ) {
            UserDetails(
                navController,
                it.arguments?.getString(NAME) ?: "",
                it.arguments?.getString(IMAGE_URL) ?: "",
                it.arguments?.getString(LOCATION) ?: ""
            )
        }
    }
}