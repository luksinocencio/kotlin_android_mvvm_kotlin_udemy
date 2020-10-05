package com.devmeist3r.viewmodelscopedemo1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.devmeist3r.viewmodelscopedemo1.model.UserRepository
import kotlinx.coroutines.Dispatchers

class MainActivityViewModel: ViewModel() {

  private var usersRepository = UserRepository()

  var users = liveData(Dispatchers.IO) {
    val result = usersRepository.getUsers()
    emit(result)
  }

//  fun getUserData() {
//    viewModelScope.launch {
//      var result: List<User>? = null
//      withContext(IO) {
//        result = userRepository.getUsers()
//      }
//      users.value = result
//    }
//  }

}
