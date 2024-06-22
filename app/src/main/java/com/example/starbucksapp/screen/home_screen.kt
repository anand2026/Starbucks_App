package com.example.starbucksapp.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.size
import androidx.navigation.NavHostController
import com.example.starbucksapp.R
import com.example.starbucksapp.components.IconComponent
import com.example.starbucksapp.components.appIconcompopnent
import com.example.starbucksapp.components.logocomponent
import com.example.starbucksapp.data.Menu
import com.example.starbucksapp.data.menuList
import com.example.starbucksapp.navigation.product_detail
import com.example.starbucksapp.ui.theme.DarkGreen
import com.example.starbucksapp.ui.theme.Grey
import com.example.starbucksapp.ui.theme.LightRed
import com.example.starbucksapp.ui.theme.Red
import com.example.starbucksapp.ui.theme.TextColor
import com.example.starbucksapp.ui.theme.background

@Composable
fun homeScreen(
    navHostController:NavHostController
) {
    var find= remember {
        mutableStateOf("")
    }
    var selected by remember {
        mutableStateOf(1)
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(background)){
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)) {
            header()
            LazyColumn(){
                item {
                    textdescription()
                    SearchbarScreen(text = find.value, onValueChange ={find.value=it} )
//                  kuch error aa rha hai

                    LazyRow(modifier =Modifier.padding(20.dp)){
                        items(menuList){
                            customchip(menu = it, selected = it.id == selected ){data->
                                selected=data
                            }
                        }
                    }
                    popular{
                        navHostController.navigate(product_detail)
                    }
                }
            }

        }
    }}

//kuch error aa rha hai

@Composable
fun customchip(
    menu: Menu,
    selected:Boolean,
    modifier: Modifier=Modifier,
    onValueChange: (Int) -> Unit
) {
    TextButton(onClick = { onValueChange(menu.id) },
        shape = RoundedCornerShape(22.dp), colors = ButtonDefaults.textButtonColors(
            containerColor = if(selected) DarkGreen else Grey,
            contentColor = if(selected) Color.White else TextColor
        )
        ,
        contentPadding = PaddingValues(10.dp,5.dp),
        modifier = Modifier.padding(end=10.dp)
    ) {
        Text(text = menu.title, style = TextStyle(
            fontSize =20.sp,
            fontWeight = FontWeight.W400
        ))
    }
    }

@Composable
fun SearchbarScreen(
    text: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = text,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = "Search",
                style = TextStyle(
                    fontWeight = FontWeight.W600,
                    color = Color.DarkGray,
                    fontSize = 16.sp
                )
            )
        },
        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "") },
        modifier = modifier.fillMaxWidth(), // Use the modifier parameter here
        shape = RoundedCornerShape(26.5.dp),
        singleLine = true,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        colors=TextFieldDefaults.colors(
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            cursorColor = DarkGreen
        ),
        //filter icon nahi aa rha hai
        trailingIcon = { Icon(imageVector =Icons.Default.List , contentDescription ="" ,modifier=modifier.fillMaxHeight())}
    )
}


@Composable
fun textdescription() {
    Text(text ="Our way of loving you back", style = TextStyle(
        fontSize = 25.sp,
        fontWeight = FontWeight.W600,
        color = Color.Black
    ),
        modifier = Modifier.padding(vertical = 30.dp)
    )
}
    @Composable
    fun header() {
        Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween)
        {
            // appIconcompopnent(icon = R.drawable.menu)
            Icon(imageVector = Icons.Default.Menu, contentDescription ="", modifier = Modifier.size(46.dp) )
            logocomponent(size = 58.dp)
           // appIconcompopnent(icon = R.drawable.bag) // }
            Icon(imageVector = Icons.Default.ShoppingCart, contentDescription ="",modifier = Modifier.size(46.dp) )
        
    }}

@Composable
fun popular(
    onClick: () -> Unit
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 10.dp)) {
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "Popular", style = TextStyle(
                fontSize = 22.sp,
                fontWeight = FontWeight.W500,
                color = TextColor
            )
            )
            Text(text = "See All", style = TextStyle(
                fontSize = 22.sp,
                fontWeight = FontWeight.W500,
                color = DarkGreen
            )
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        LazyRow{
            items(5){
                itemeachrow {
                    onClick()
                }
            }
        }
    }
    
}

@Composable
fun itemeachrow(
    onClick: ()->Unit
) {
    var selected = rememberSaveable {
        mutableStateOf(false)
    }
    Card (
        shape = RoundedCornerShape(14.dp),
        modifier = Modifier
            .width(220.dp)
            .padding(end = 10.dp)
            .clickable { onClick() }
    ){
        Box(
            modifier = Modifier
                .background(LightRed, RoundedCornerShape(bottomStart = 14.dp, bottomEnd = 14.dp))
                .fillMaxWidth()
                .height(200.dp), contentAlignment = Alignment.Center
        ) {
            Image(painter = painterResource(id = R.drawable.staarbucks), contentDescription ="",
                modifier=Modifier.size(180.dp))
        }
        Column(modifier = Modifier.padding(15.dp)) {
            Text(text = "Chocolate Cappuchina", style = TextStyle(
                color = TextColor,
                fontSize = 20.sp,
                fontWeight = FontWeight.W500
            ))
            Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                Text(text = "$20.00", style = TextStyle(
                    color = DarkGreen,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.W400
                ))
                IconButton(onClick = { selected.value=  !selected.value }, modifier = Modifier.size(24.dp)) {
                    IconComponent(icon = R.drawable.heart,
                        tint = if(selected.value) Red else TextColor)
                }
            }
        }
    }
}