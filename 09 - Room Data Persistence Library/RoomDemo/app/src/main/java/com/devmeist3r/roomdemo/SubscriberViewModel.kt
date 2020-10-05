package com.devmeist3r.roomdemo

import android.util.Patterns
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devmeist3r.roomdemo.db.Subscriber
import com.devmeist3r.roomdemo.db.SubscriberRepository
import kotlinx.coroutines.launch
import java.util.regex.Pattern

class SubscriberViewModel(private val repository: SubscriberRepository) : ViewModel(), Observable {

  val subscribers = repository.subscribers
  private var isUpdateOrDelete = false
  private lateinit var subscriberToUpdateToDelete: Subscriber

  private val statusMessage = MutableLiveData<Event<String>>()

  val message: LiveData<Event<String>>
    get() = statusMessage

  @Bindable
  val inputName = MutableLiveData<String>()

  @Bindable
  val inputEmail = MutableLiveData<String>()

  @Bindable
  val saveOrUpdateButtonText = MutableLiveData<String>()

  @Bindable
  val clearAllOrderDeleteButtonText = MutableLiveData<String>()

  init {
    saveOrUpdateButtonText.value = "Save"
    clearAllOrderDeleteButtonText.value = "Clear All"
  }

  fun saveOuUpdate() {
    if (inputEmail.value == null) {
      statusMessage.value = Event("Please info your name")
    } else if (inputEmail.value == null) {
      statusMessage.value = Event("Please info your e-mail")
    } else if (!Patterns.EMAIL_ADDRESS.matcher(inputEmail.value!!).matches()) {
      statusMessage.value = Event("Please info correct e-mail")
    } else {
      if (isUpdateOrDelete) {
        subscriberToUpdateToDelete.name = inputName.value!!
        subscriberToUpdateToDelete.email = inputEmail.value!!

        update(subscriberToUpdateToDelete)
      } else {
        val name = inputName.value!!
        val email = inputEmail.value!!
        insert(Subscriber(0, name, email))
        inputName.value = null
        inputEmail.value = null
      }
    }
  }

  fun clearAllOrDelete() {
    if (isUpdateOrDelete) {
      delete(subscriberToUpdateToDelete)
    } else {
      clearAll()
    }
  }

  fun insert(subscriber: Subscriber) = viewModelScope.launch {
    val newRowId = repository.insert(subscriber)
    if (newRowId > -1) {
      statusMessage.value = Event("Subscriber Inserted Successfully $newRowId")
    } else {
      statusMessage.value = Event("Error Occurred")
    }
  }

  fun update(subscriber: Subscriber) = viewModelScope.launch {
    val noOfRows = repository.update(subscriber)
    if (noOfRows > 0) {
      inputName.value = null
      inputEmail.value = null
      isUpdateOrDelete = false
      saveOrUpdateButtonText.value = "Save"
      clearAllOrderDeleteButtonText.value = "Clear All"
      statusMessage.value = Event("Subscriber Updated Successfully")
    } else {
      statusMessage.value = Event("Error Occurred")
    }

  }

  fun delete(subscriber: Subscriber) = viewModelScope.launch {
    val noOfRowsDeleted = repository.delete(subscriber)

    if (noOfRowsDeleted > 0) {
      inputName.value = null
      inputEmail.value = null
      isUpdateOrDelete = false
      saveOrUpdateButtonText.value = "Save"
      clearAllOrderDeleteButtonText.value = "Clear All"
      statusMessage.value = Event("Subscriber Deleted Successfully")
    } else {
      statusMessage.value = Event("Error Occurred")
    }
  }

  fun clearAll() = viewModelScope.launch {
    val noOfRowsDeleted = repository.deleteAll()
    if (noOfRowsDeleted > 0) {
      statusMessage.value = Event("All Subscribers Deleted Successfully")
    } else {
      statusMessage.value = Event("Error Occurred")
    }
  }

  fun initUpdateAndDelete(subscriber: Subscriber) {
    inputName.value = subscriber.name
    inputEmail.value = subscriber.email
    isUpdateOrDelete = true
    subscriberToUpdateToDelete = subscriber

    saveOrUpdateButtonText.value = "Update"
    clearAllOrderDeleteButtonText.value = "Delete"
  }

  override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

  }

  override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

  }

}
