package com.example.projetfinalandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
                BackFontSB()
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
    val imageList = listOf(
        R.drawable.zendaya,
        R.drawable.hart,
        R.drawable.nathalie,
        R.drawable.gadot,
        R.drawable.mufasa,
        R.drawable.cavill
    )

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
                    imageVector = ImageVector.vectorResource(id = R.drawable.menu),
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
                .fillMaxHeight(0.90f)
                .fillMaxWidth()
                .background(Color.Black)
        ){
            LazyColumn(
                modifier = Modifier.fillMaxSize()
                                    .background(Color.White),
                verticalArrangement = Arrangement.spacedBy(16.dp)

            ){
                items(imageList) { imageRes ->
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally

                    ){
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(35.dp)
                                .background(Color.White),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(0.48f)
                                    .fillMaxHeight()
                                    .background(Color.White),
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                Icon(
                                    imageVector = ImageVector.vectorResource(id = R.drawable.account_circle),
                                    contentDescription = "Icône SVG personnalisée",
                                    modifier = Modifier.size(25.dp).offset(x = 10.dp),
                                    tint = Color.DarkGray
                                )
                            }
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(0.98f)
                                    .fillMaxHeight()
                                    .background(Color.White),
                                horizontalArrangement = Arrangement.End,
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                Icon(
                                    imageVector = ImageVector.vectorResource(id = R.drawable.points),
                                    contentDescription = "Icône SVG personnalisée",
                                    modifier = Modifier.size(25.dp).offset(x = -10.dp),
                                    tint = Color.DarkGray
                                )
                            }
                        }

                        // L'image principale
                        Image(
                            painter = painterResource(id = imageRes),
                            contentDescription = "Image principale",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(550.dp),
                            contentScale = ContentScale.Crop
                        )

                        // Row d'icônes en bas de l'image
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(35.dp)
                                .background(Color.White),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(0.1f)
                                    .fillMaxHeight()
                                    .background(Color.White),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                Icon(
                                    imageVector = ImageVector.vectorResource(id = R.drawable.thumb),
                                    contentDescription = "Icône SVG personnalisée",
                                    modifier = Modifier.size(25.dp),
                                    tint = Color.DarkGray
                                )
                            }
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(0.11f)
                                    .fillMaxHeight()
                                    .background(Color.White),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                Icon(
                                    imageVector = ImageVector.vectorResource(id = R.drawable.done_all),
                                    contentDescription = "Icône SVG personnalisée",
                                    modifier = Modifier.size(25.dp),
                                    tint = Color.DarkGray
                                )
                            }
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(0.125f)
                                    .fillMaxHeight()
                                    .background(Color.White),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                Icon(
                                    imageVector = ImageVector.vectorResource(id = R.drawable.chat),
                                    contentDescription = "Icône SVG personnalisée",
                                    modifier = Modifier.size(25.dp),
                                    tint = Color.DarkGray
                                )
                            }
                        }
                    }
                }
            }
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
                verticalAlignment = Alignment.Top,
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
                    modifier = Modifier.size(28.dp),
                            tint = Color.DarkGray
                )
            }
            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth(0.25f)
                    .fillMaxHeight()
            ){
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.thumb),
                    contentDescription = "Icône SVG personnalisée",
                    modifier = Modifier.size(27.dp),
                    tint = Color.DarkGray
                )
            }
            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth(0.33f)
                    .fillMaxHeight()
            ){
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.add),
                    contentDescription = "Icône SVG personnalisée",
                    modifier = Modifier.size(35.dp),
                    tint = Color.DarkGray
                )
            }
            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth(0.50f)
                    .fillMaxHeight()
            ){
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.search),
                    contentDescription = "Icône SVG personnalisée",
                    modifier = Modifier.size(27.dp),
                    tint = Color.DarkGray
                )
            }
            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .fillMaxHeight()
            ){
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.person),
                    contentDescription = "Icône SVG personnalisée",
                    modifier = Modifier.size(28.dp),
                    tint = Color.DarkGray
                )
            }

        }

    }
}

/*@Composable
fun Greeting3(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}*/

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    ProjetFinalAndroidTheme {
        BackFontSB()
    }
}