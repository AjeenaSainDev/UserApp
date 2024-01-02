package com.example.picgallery.ui.components.userlist

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
@Composable
fun userList(navHostController: NavHostController,userListViewModel: UserListViewModel = hiltViewModel()){
LazyColumn{
    item {
        Spacer(modifier = Modifier.height(8.dp))
    }

    userListViewModel.uiState.users?.let { list ->
        items(list){
            itemUserCard(user = it, onItemClicked = {user->
                navHostController.navigate("details/${user.name}/${user.email}/${user.address.city}")
            })
        }
    }
}

}
