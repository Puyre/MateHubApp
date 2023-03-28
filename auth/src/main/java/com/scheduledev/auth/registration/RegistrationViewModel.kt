package com.scheduledev.auth.registration

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sheduledev.domain.usecases.RegisterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase
) : ViewModel() {

    private val _screenStateLiveData = MutableLiveData<RegisterScreenState>()
    val screenStateLiveData: LiveData<RegisterScreenState>
        get() = _screenStateLiveData

    fun obtainEvent(event: RegisterScreenEvent) {
        when (event) {
            is RegisterScreenEvent.RegisterEvent -> onRegisterEvent(event)
        }
    }

    private fun onRegisterEvent(event: RegisterScreenEvent.RegisterEvent) {
        _screenStateLiveData.postValue(RegisterScreenState.Loading)
        viewModelScope.launch {
            try {
                registerUseCase(login = event.email, password = event.password)
            } catch (e: Exception) {
                _screenStateLiveData.postValue(RegisterScreenState.Error(exc = e))
            }
        }
    }
}