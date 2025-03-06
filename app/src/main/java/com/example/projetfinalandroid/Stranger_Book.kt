package com.example.projetfinalandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projetfinalandroid.ui.theme.ProjetFinalAndroidTheme

class Stranger_Book : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjetFinalAndroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting3(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun BackFontSB(){
    // Mettre un fond blanc sur toute la surface de l'écran
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        ScreenSB()
    }
}

@Composable
fun ScreenSB(){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.Transparent)
    ){
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(Color.Transparent)
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth(0.2f)
                    .fillMaxHeight()
            ){
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.retour),
                    contentDescription = "Icône SVG personnalisée",
                    modifier = Modifier.size(26.dp),
                    tint = Color.DarkGray
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .fillMaxHeight()
            ){
                Text(
                    text = "My Match",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Cursive
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .fillMaxHeight()
            ){
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.points),
                    contentDescription = "Icône SVG personnalisée",
                    modifier = Modifier.size(30.dp),
                    tint = Color.DarkGray
                )
            }

        }
        //End Header

        //For liste
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxHeight(0.93f)
                .fillMaxWidth()
                .background(Color.Black)
        ){

        }

        //Footer
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.Transparent)
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth(0.2f)
                    .fillMaxHeight()
                    .background(Color.Transparent)
                    .padding(0.dp)
            ){
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.home),
                    contentDescription = "Icône SVG personnalisée",
                    modifier = Modifier.size(36.dp),
                            tint = Color.DarkGray
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth(0.25f)
                    .fillMaxHeight()
            ){
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.thumb),
                    contentDescription = "Icône SVG personnalisée",
                    modifier = Modifier.size(35.dp),
                    tint = Color.DarkGray
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth(0.33f)
                    .fillMaxHeight()
            ){
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.add),
                    contentDescription = "Icône SVG personnalisée",
                    modifier = Modifier.size(42.dp),
                    tint = Color.DarkGray
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth(0.50f)
                    .fillMaxHeight()
            ){
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.search),
                    contentDescription = "Icône SVG personnalisée",
                    modifier = Modifier.size(35.dp),
                    tint = Color.DarkGray
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .fillMaxHeight()
            ){
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.person),
                    contentDescription = "Icône SVG personnalisée",
                    modifier = Modifier.size(38.dp),
                    tint = Color.DarkGray
                )
            }

        }

    }
}

@Composable
fun Greeting3(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    ProjetFinalAndroidTheme {
        BackFontSB()
    }
}