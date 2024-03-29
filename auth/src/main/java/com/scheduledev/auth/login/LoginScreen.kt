package com.scheduledev.auth.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.scheduledev.common.handle
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    authViewModel: AuthViewModel = hiltViewModel()
) {

    val state by authViewModel.screenStateLiveData.observeAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    Scaffold(
        topBar = { Toolbar() },
        snackbarHost = { SnackbarHost(snackbarHostState) },
        content = { paddingValues ->

            Body(
                paddingValues,
                state is LoginScreenState.Loading,
                loginClick = { email, password ->
                    authViewModel.obtainEvent(
                        LoginScreenEvent.LoginEvent(
                            email = email,
                            password = password
                        )
                    )
                })
            if (state is LoginScreenState.Error) {
                val scope = rememberCoroutineScope()
                LaunchedEffect(key1 = "") {
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            (state as LoginScreenState.Error).exc.handle()
                        )
                    }
                }
            }
        })
}

@Composable
fun Toolbar() {
    Row(
        modifier = Modifier
            .height(48.dp)
            .fillMaxWidth()
            .background(color = Color(0xFF123123)),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text("Matehub", color = Color(0xFFFFFFFF), fontSize = 24.sp)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Body(
    rootPadding: PaddingValues,
    isLoading: Boolean,
    loginClick: (email: String, password: String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(rootPadding)
            .padding(16.dp)
    ) {
        val emailText = remember { mutableStateOf("") }
        val passwordText = remember { mutableStateOf("") }
        val showPassword = remember { mutableStateOf(false) }

        OutlinedTextField(
            value = emailText.value,
            onValueChange = {
                emailText.value = it
            },
            label = { Text(text = "Email") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            singleLine = true,
            shape = RoundedCornerShape(12.dp)
        )
        OutlinedTextField(
            value = passwordText.value,
            onValueChange = {
                passwordText.value = it
            },
            label = { Text(text = "Password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            singleLine = true,
            visualTransformation = if (showPassword.value) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val image = if (showPassword.value) {
                    Icons.Filled.VisibilityOff
                } else {
                    Icons.Filled.Visibility
                }

                val description = if (showPassword.value) "Hide password" else "Show password"

                IconButton(onClick = { showPassword.value = !showPassword.value }) {
                    Icon(imageVector = image, description, tint = Color(0xFF123123))
                }
            },
            shape = RoundedCornerShape(12.dp)
        )
        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier.fillMaxSize()
        ) {
            OutlinedButton(
                shape = RoundedCornerShape(12.dp),
                onClick = {
                    loginClick(emailText.value, passwordText.value)
                },
                modifier = Modifier
                    .height(64.dp)
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                if (isLoading) {
                    CircularProgressIndicator()
                } else {
                    Text(text = "Здарова заебал", color = Color(0xFF123123))
                }
            }
        }

    }
}
