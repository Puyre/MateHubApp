package com.scheduledev.auth.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sheduledev.domain.usecases.AuthUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class AuthViewModel @Inject constructor(
    private val authUseCase: AuthUseCase
) : ViewModel() {

    private val _screenStateLiveData = MutableLiveData<LoginScreenState>()
    val screenStateLiveData: LiveData<LoginScreenState>
        get() = _screenStateLiveData

    fun obtainEvent(event: LoginScreenEvent) {
        when (event) {
            is LoginScreenEvent.LoginEvent -> onLoginEvent(event)
        }
    }

    private fun onLoginEvent(event: LoginScreenEvent.LoginEvent) {
        _screenStateLiveData.postValue(LoginScreenState.Loading)
        viewModelScope.launch {
            try {
                authUseCase(login = event.email, password = event.password)
            } catch (e: Exception) {
                _screenStateLiveData.postValue(LoginScreenState.Error(message = "Error бля"))
            }
        }
    }
}