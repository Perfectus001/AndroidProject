package com.example.projetfinalandroid

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Top
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projetfinalandroid.ui.theme.ProjetFinalAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjetFinalAndroidTheme {
                BackHome()
            }
        }
    }
}

@Composable
fun BackHome(){
    // Mettre un fond blanc sur toute la surface de l'écran
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        ScreenMain()
    }
}

@Composable
fun ScreenMain(){
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxHeight(0.13f)
                .fillMaxWidth()
        ){
            Text(
                text = "Bienvenue sur Genius Android",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(top= 25.dp)
                .fillMaxHeight(0.3f)
                .fillMaxWidth()
        ){
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.network),
                contentDescription = "Icône SVG personnalisée",
                modifier = Modifier.size(100.dp),
                tint = Color.DarkGray
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxHeight()
                    .fillMaxWidth()
            ){
                Text(
                    text = "Calculez votre IMC ou faites de nouvelles rencontres \n Votre bien-être commence ici !",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.height(70.dp)
                .fillMaxWidth()
        ){
            Text(
                text = "Veuillez faire un choix",
                fontSize = 15.sp,
                fontStyle = FontStyle.Italic,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.offset(x = 10.dp)
            )
        }

        val context = LocalContext.current
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(top= 25.dp)
                .fillMaxHeight(0.3f)
                .fillMaxWidth()
        ){
            Button(
                onClick = {
                    // Crée et lance l'intent pour
                    val intent = Intent(context, IMC_APP::class.java)
                    context.startActivity(intent)
                }
            ) {
                Text("Calcul IMC")
            }
            Button(
                onClick = {
                    // Crée et lance l'intent pour Stranger_Book
                    val intent = Intent(context, Stranger_Book::class.java)
                    context.startActivity(intent)
                }
            ) {
                Text("Stranger Book")
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProjetFinalAndroidTheme {
        BackHome()
    }
}