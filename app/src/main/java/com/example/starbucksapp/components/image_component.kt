package com.example.starbucksapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.starbucksapp.R

@Composable
fun logocomponent(
    modifier: Modifier = Modifier,
    size: Dp =155.dp
) {
    Image(painter = painterResource(id = R.drawable.logo), contentDescription = "",
        modifier=Modifier.size(size=size))
}