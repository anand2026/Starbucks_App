package com.example.starbucksapp.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.LaunchedEffect
import com.example.starbucksapp.components.logocomponent
import com.example.starbucksapp.navigation.home
import com.example.starbucksapp.ui.theme.background
import kotlinx.coroutines.delay

@Composable
fun startscreen(
    navHostController: NavHostController
) {
    LaunchedEffect(key1 = Unit) {
        delay(2000)
        navHostController.navigate(home)

    }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(background), contentAlignment = Alignment.Center){
        logocomponent()
    }
}