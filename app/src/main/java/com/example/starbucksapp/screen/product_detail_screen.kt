package com.example.starbucksapp.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.starbucksapp.components.appIconcompopnent
import com.example.starbucksapp.ui.theme.background
import com.example.starbucksapp.R
import com.example.starbucksapp.components.IconComponent
import com.example.starbucksapp.components.logocomponent
import com.example.starbucksapp.ui.theme.DarkGreen
import com.example.starbucksapp.ui.theme.Grey400
import com.example.starbucksapp.ui.theme.LightRed
import com.example.starbucksapp.ui.theme.TextColor

@Composable
fun productdetailscreen(
    navHostController: NavHostController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(background)
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(20.dp) ) {
            productheader{
                navHostController.navigateUp()
        }
            Spacer(modifier = Modifier.height(20.dp))
            LazyColumn(modifier = Modifier.fillMaxSize()){
                 item { showproduct()
                     Productdescription()
                 }
            }
        }

            Buttoncomponent(modifier = Modifier
                .padding(20.dp)
                .align(Alignment.BottomCenter)

            )



    }
}

@Composable
fun Productdescription(
    modifier: Modifier=Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp)
    ) {
        Text(text = "Coffee", style = TextStyle(
            fontSize = 18.sp,
            color = DarkGreen,
            fontWeight = FontWeight.W400
        ))
        Row (
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(text = "Chocolate Cappuchino",
                fontSize = 22.sp,
                fontWeight = FontWeight.W500,
                modifier = Modifier.weight(0.8f)
                )
            Row(modifier= Modifier
                .fillMaxWidth()
                .weight(0.2f)) {
                IconComponent(icon = R.drawable.star,
                    size=20.dp,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .weight(0.8f)
                    )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "4.5", style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W400,
                    color = Grey400
                ),
                    modifier=Modifier.weight(0.2f)
                    )
            }
        }
        Spacer(modifier = Modifier.height(18.dp))
        Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sit amet suscipit ipsum. Nullam vehicula elit tortor, eu imperdiet orci auctor ut. Mauris ac purus nec mi ultrices iaculis. Etiam consequat, mauris et hendrerit hendrerit, velit nisi rhoncus tellus, ac auctor tortor massa nec dolor. Donec id dignissim dolor, id dignissim sapien.", style = TextStyle(
            fontSize = 18.sp,
            color = TextColor,
            fontWeight = FontWeight.W400
        ))
    }
}
@Composable
fun showproduct(

) {
    var count = remember {
        mutableStateOf(0)
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(LightRed, RoundedCornerShape(14.dp)),
        contentAlignment = Alignment.Center
    ) {
        Column (modifier = Modifier
            .padding(vertical = 20.dp)
            .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
            Image(painter = painterResource(id = R.drawable.staarbucks), contentDescription = "",
                modifier = Modifier.size(200.dp))
            Box(modifier = Modifier.background(Color.White, RoundedCornerShape(20.dp))) {
                Row {
                    appIconcompopnent(icon = R.drawable.plus){
                        Log.d("sdfd","${count.value}")
                        count.value++
                        Log.d("sdfd","${count.value}")

                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = "${count.value}", style = TextStyle(
                        fontSize = 25.sp,
                        fontWeight = FontWeight.W500,
                        color = TextColor
                    ),
                        modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    Spacer(modifier = Modifier.width(10.dp))
                    appIconcompopnent(icon = R.drawable.minus){
                        if(count.value>0)
                        count.value--
                    }
                }
            }
        }
    }
    
}
@Composable
fun productheader(
    onClick: () -> Unit

) {
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        appIconcompopnent(icon =R.drawable.back ){
            onClick()
        }
        logocomponent(size=55.dp)
        appIconcompopnent(icon = R.drawable.heart)
    }

}

@Composable
fun Buttoncomponent(
    modifier: Modifier=Modifier
) {
    Button(onClick = { /*TODO*/ },
        modifier=modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor= DarkGreen,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(37.dp),
        contentPadding = PaddingValues(15.dp),
        elevation = ButtonDefaults.buttonElevation(0.dp)
    ) {
        Text(text = "Add to bag", style = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.W500
        ))
    }
}