package com.example.picgallery.ui.navigation

enum class NavigationItem {
    USERLIST,
    ALBUMS,
    DETAILS


}
sealed class Screen(val route: String){
    object UserList : Screen(NavigationItem.USERLIST.name)
    object Albums : Screen(NavigationItem.ALBUMS.name)
    object Details :Screen(NavigationItem.DETAILS.name)
}
