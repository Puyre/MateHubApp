package com.scheduledev.auth.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {

    //добавляет логику по работе с экраном (scaffold)
    Scaffold(topBar = { Toolbar() }, content = { paddingValues ->

        Body(paddingValues)
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
fun Body(rootPadding: PaddingValues) {

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(rootPadding)
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text(text = "Email") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text(text = "Password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp)
        )

    }
}
