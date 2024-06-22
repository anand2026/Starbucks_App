package com.example.starbucksapp.navigation

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.starbucksapp.screen.homeScreen
import com.example.starbucksapp.screen.productdetailscreen
import com.example.starbucksapp.screen.startscreen

@androidx.compose.runtime.Composable
fun starbucknavigation() {
 val navHostController= rememberNavController()
 NavHost(navController = navHostController, startDestination = start ) {
  composable(start){
   startscreen(navHostController = navHostController)
  }
  composable(home){
   homeScreen(navHostController = navHostController)
  }
  composable(product_detail){
   productdetailscreen(navHostController = navHostController)
  }
 }

}
const val start="start_screen"
const val home="home_screen"
const val product_detail="product_detail_screen"