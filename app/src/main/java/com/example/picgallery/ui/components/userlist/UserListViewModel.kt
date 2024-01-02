package com.example.picgallery.ui.components.userlist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.picgallery.data.repository.DataSource
import com.example.picgallery.domain.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(private  val dataRepository: DataSource):ViewModel(){

    var uiState by mutableStateOf(UserUiState())
        private set
    init {
        getUserList()
    }
    fun getUserList(){
        viewModelScope.launch {
            dataRepository.getUsers()?.let { result ->
                uiState = if (result.isNotEmpty()) {
                    uiState.copy(

                        users = result.map { // Returns a list containing the results of applying
                            // the given transform function to each element in the original collection.
                            User(
                                id= it.id,
                                name = it.name,
                                email = it.email,
                                company = it.company,
                                username = it.username,
                                address = it.address,
                                phone= it.phone,
                                website = it.website

                            )
                        })
                } else {
                    uiState.copy(  users = result)
                }
            }

            }
        }

}