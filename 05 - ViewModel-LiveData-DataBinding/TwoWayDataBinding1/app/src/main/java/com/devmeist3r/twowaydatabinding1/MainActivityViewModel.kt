package com.devmeist3r.twowaydatabinding1

import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {

    @Bindable
    val userName = MutableLiveData<String>()

    init {
        userName.value = "Lucas"
    }

}