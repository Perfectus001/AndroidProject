package com.example.projetfinalandroid

import android.app.DatePickerDialog
import android.content.Intent
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projetfinalandroid.ui.theme.ProjetFinalAndroidTheme
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class IMC_APP : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjetFinalAndroidTheme {
                BackFont()
            }
        }
    }
}

@Composable
fun BackFont(){
    // Mettre un fond blanc sur toute la surface de l'écran
    var nom by remember { mutableStateOf("") }
    var prenom by remember { mutableStateOf("") }
    var dateNaissance by remember { mutableStateOf(Calendar.getInstance()) }
    var sexe by remember { mutableStateOf("Homme") }
    //var age by remember { mutableStateOf(0) }
    var poids by remember { mutableStateOf(0.0) } // Poids en kg
    var taille by remember { mutableStateOf(0.0) } // Taille en cm
    var niveauActivite by remember { mutableStateOf("Sédentaire") }
    var imcResult by remember { mutableStateOf(0.0) }
    var testSub by remember {mutableStateOf(false)}
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        if(!testSub){
            ScreenIMC(
                nom,
                prenom,
                dateNaissance,
                sexe,
                poids,
                taille,
                niveauActivite,
                imcResult,
                onNomChange = {newNom -> nom = newNom},
                onPrenomChange = {newPrenom -> prenom = newPrenom},
                onDateNais = {newDate -> dateNaissance = newDate},
                onSexeChange = {newSexe -> sexe = newSexe},
                onPoidsChange = {newPoids -> poids = newPoids},
                onTailleChange = {newTaille -> taille = newTaille},
                onNiveauActChange = {newNiveau -> niveauActivite = newNiveau},
                onResulIMCChange = {newResultIMC -> imcResult = newResultIMC},
                onTestSubChange = {newVal -> testSub = newVal}
            )
        }else{
            if(!sexe.isNotEmpty()){
                sexe = "Femme"
            }
            if (nom.isNotEmpty() && prenom.isNotEmpty() && isDateBeforeToday(dateNaissance) &&
                sexe.isNotEmpty() && poids > 0 && taille > 0 && niveauActivite.isNotEmpty()) {
                Result(
                    nom = nom,
                    prenom = prenom,
                    dateNaissance = dateNaissance,
                    sexe = sexe,
                    poids = poids,
                    taille = taille,
                    niveauActivite = niveauActivite,
                    imcResult = imcResult
                )
            } else {
                // Affichez un message d'erreur si des champs sont vides
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Transparent)
                        .padding(16.dp) // Ajout d'un peu de padding pour l'esthétique
                ) {
                    // En-tête du tableau
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .fillMaxHeight(0.3f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Veuillez remplir tous les champs correctement.",
                            color = Color.Red,
                            modifier = Modifier.padding(16.dp)
                        )
                    }

                    // En-tête du tableau
                    Column(
                        modifier = Modifier.fillMaxWidth()
                            .fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Le nom ne doit pas être vide.",
                            modifier = Modifier.padding(7.dp)
                        )
                        Text(
                            text = "Le prenom ne doit pas être vide.",
                            modifier = Modifier.padding(7.dp)
                        )
                        Text(
                            text = "La date de naissance doit pas être inférieur à la date du jour en cours.",
                            modifier = Modifier.padding(7.dp)
                        )
                        Text(
                            text = "La taille doit être supérieur à zéro.",
                            modifier = Modifier.padding(7.dp)
                        )
                        Text(
                            text = "Le poids doit être supérieur à zéro.",
                            modifier = Modifier.padding(7.dp)
                        )
                    }
                }

            }
        }
    }
}

fun isDateBeforeToday(date: Calendar): Boolean {
    // Obtenir la date d'aujourd'hui
    val today = Calendar.getInstance()
    // Remettre à zéro l'heure pour ignorer le temps
    today.set(Calendar.HOUR_OF_DAY, 0)
    today.set(Calendar.MINUTE, 0)
    today.set(Calendar.SECOND, 0)
    today.set(Calendar.MILLISECOND, 0)

    // Retourne true si la date passée est antérieure à aujourd'hui
    return date.before(today)
}

@Composable
fun DateSelectionRow(
    dateNaissance: Calendar,
    onDateNais: (Calendar) -> Unit
) {
    // Récupère le contexte pour ouvrir le DatePickerDialog
    val context = androidx.compose.ui.platform.LocalContext.current
    // Formate la date pour l'affichage dans le TextField
    val formattedDate = remember(dateNaissance) {
        val day = dateNaissance.get(Calendar.DAY_OF_MONTH)
        val month = dateNaissance.get(Calendar.MONTH) + 1 // Les mois commencent à 0
        val year = dateNaissance.get(Calendar.YEAR)
        "$day/$month/$year"
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .height(75.dp)
            .fillMaxWidth(0.9f)
    ) {
        // Libellé "Date"
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
        ) {
            Text(
                text = "Date",
                color = Color.DarkGray,
                modifier = Modifier.offset(x = 13.dp)
            )
        }
        // Row contenant deux zones : une pour le bouton icône (fond rouge) et une pour le TextField (fond noir)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            // Zone avec fond rouge : bouton icône
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth(0.1f)
                    .height(80.dp)
                    .background(Color.White)
            ) {
                IconButton(
                    onClick = {
                        // Création et affichage d'un DatePickerDialog
                        val datePickerDialog = DatePickerDialog(
                            context,
                            { _: android.widget.DatePicker, year, month, dayOfMonth ->
                                // Mise à jour de la date via le callback onDateNais
                                val newCalendar = Calendar.getInstance()
                                newCalendar.set(year, month, dayOfMonth)
                                onDateNais(newCalendar)
                            },
                            dateNaissance.get(Calendar.YEAR),
                            dateNaissance.get(Calendar.MONTH),
                            dateNaissance.get(Calendar.DAY_OF_MONTH)
                        )
                        datePickerDialog.show()
                    }
                ) {
                    // Icône de date (utilise une icône système par exemple)
                    Icon(
                        painter = androidx.compose.ui.res.painterResource(id = android.R.drawable.ic_menu_today),
                        contentDescription = "Sélectionner la date",
                        tint = Color.DarkGray,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
            // Zone avec fond noir : TextField affichant la date
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                TextField(
                    value = formattedDate,
                    onValueChange = { /* Aucun changement manuel autorisé */ },
                    enabled = false, // Désactive la modification manuelle
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}


@Composable
fun ScreenIMC(
    nom: String,
    prenom: String,
    dateNaissance: Calendar,
    sexe: String,
    poids: Double,
    taille: Double,
    niveauActivite: String,
    imcResult: Double,
    onNomChange: (String) -> Unit,
    onPrenomChange: (String) -> Unit,
    onDateNais: (Calendar) -> Unit,
    onSexeChange: (String) -> Unit,
    onPoidsChange: (Double) -> Unit,
    onTailleChange: (Double) -> Unit,
    onNiveauActChange: (String) -> Unit,
    onResulIMCChange: (Double) -> Unit,
    onTestSubChange: (Boolean) -> Unit
){
    val activityLevels = listOf("Sédentaire", "Faible", "Actif", "Sportif", "Athlète")
    var currentIndex by remember { mutableStateOf(activityLevels.indexOf(niveauActivite)) }
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
    ){
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .background(Color.Transparent)
        ){
            Text(
                text = "Calculateur de IMC",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Default,
                modifier = Modifier.padding(start = 16.dp)
            )

        }

        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
                .background(Color.Transparent)
        ){
            Text(
                text = "Formulaire à remplir",
                fontFamily = FontFamily.Default,
                color = Color.LightGray,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(Color.Transparent)
        ){

            TextField(
                value = nom,
                onValueChange = { onNomChange(it) },
                label = { Text("Nom") },
                modifier = Modifier.fillMaxWidth(0.9f)
            )

            Spacer(modifier = Modifier.height(30.dp))

            TextField(
                value = prenom,
                onValueChange = { onPrenomChange(it) },
                label = { Text("Prenom") },
                modifier = Modifier.fillMaxWidth(0.9f)
            )

            Spacer(modifier = Modifier.height(30.dp))

            DateSelectionRow(
                dateNaissance = dateNaissance,
                onDateNais = onDateNais
            )
            Spacer(modifier = Modifier.height(30.dp))

            SexeSelection(
                sexe = sexe,
                onSexeChange = onSexeChange
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(57.dp)
                    .background(Color.Transparent)
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .background(Color.Transparent)
                ){
                    var textValue2 by remember { mutableStateOf("") }
                    TextField(
                        value = textValue2,
                        onValueChange = { newValue ->
                            textValue2 = newValue
                            onTailleChange(textValue2.toDoubleOrNull() ?: 0.0) // Conversion en Int ou 0 en cas d'erreur
                        },
                        label = { Text("Taille en m") },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                }
            }
            Spacer(modifier = Modifier.height(30.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(57.dp)
                    .background(Color.Transparent)
            ){
                IconButton(
                    modifier = Modifier.size(15.dp)
                        .background(Color.LightGray, shape = CircleShape),
                    onClick = {
                        if(poids > 2 ){
                            onPoidsChange(poids - 1)
                        }
                    }
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.check),
                        contentDescription = "Sélectionner la date",
                        tint = Color.DarkGray,
                        modifier = Modifier.size(30.dp)
                    )
                }
                var textValue by remember { mutableStateOf("") }
                OutlinedTextField(
                    value = poids.toString(),
                    onValueChange = { newValue ->
                        textValue = newValue
                        onTailleChange(textValue.toDoubleOrNull() ?: 0.0) // Conversion en Int ou 0 en cas d'erreur
                    },
                    label = { Text("Poids") },
                    modifier = Modifier.fillMaxWidth(0.7f),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                IconButton(
                    modifier = Modifier.size(15.dp)
                        .background(Color.LightGray, shape = CircleShape),
                    onClick = {
                            onPoidsChange(poids + 1)

                    }
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.add),
                        contentDescription = "Sélectionner la date",
                        tint = Color.DarkGray,
                        modifier = Modifier.size(30.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(30.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .background(Color.Transparent)
            ){
                Text(
                    text = "Niveau d'activité",
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(57.dp)
                    .background(Color.Transparent)
            ){
                IconButton(
                    modifier = Modifier.size(15.dp)
                        .background(Color.LightGray, shape = CircleShape),
                    onClick = {
                        if (currentIndex > 0) {
                            currentIndex -= 1
                            onNiveauActChange(activityLevels[currentIndex])
                        }
                    }
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.arrow_left),
                        contentDescription = "Sélectionner la date",
                        tint = Color.DarkGray,
                        modifier = Modifier.size(30.dp)
                    )
                }
                var textValue = activityLevels[currentIndex]
                TextField(
                    value = textValue,
                    onValueChange = {},
                    enabled = false,
                    modifier = Modifier.fillMaxWidth(0.7f)
                )
                IconButton(
                    modifier = Modifier.size(15.dp)
                        .background(Color.LightGray, shape = CircleShape),
                    onClick = {
                        if (currentIndex < activityLevels.size - 1) {
                            currentIndex += 1
                            onNiveauActChange(activityLevels[currentIndex])
                        }
                    }
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.arrow_right),
                        contentDescription = "Sélectionner la date",
                        tint = Color.DarkGray,
                        modifier = Modifier.size(30.dp)
                    )
                }
            }



            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {
                    onTestSubChange(true)
                    onResulIMCChange(poids/(taille * taille))
                }
            ) {
                Text("Calculer")
            }

        }



    }
}

@Composable
fun Result(
    nom: String,
    prenom: String,
    dateNaissance: Calendar,
    sexe: String,
    poids: Double,
    taille: Double,
    niveauActivite: String,
    imcResult: Double
) {
    // Déterminez la catégorie de l'IMC
    val imcCategory = when {
        imcResult < 18.5 -> "Insuffisance pondérale (maigreur)"
        imcResult in 18.5..24.9 -> "Corpulence normale"
        imcResult in 25.0..29.9 -> "Surpoids"
        imcResult in 30.0..34.9 -> "Obésité modérée"
        imcResult in 35.0..39.9 -> "Obésité sévère"
        imcResult >= 40 -> "Obésité morbide"
        else -> "IMC non calculé"
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .padding(16.dp) // Ajout d'un peu de padding pour l'esthétique
    ) {
        // En-tête du tableau
        Row(
            modifier = Modifier.fillMaxWidth().height(300.dp),

            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            Text(text = "Données Personnelles", fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(7.dp))

        // Tableau des résultats
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Nom:", fontWeight = FontWeight.Bold)
                Text(text = nom)
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Prénom:", fontWeight = FontWeight.Bold)
                Text(text = prenom)
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Date de Naissance:", fontWeight = FontWeight.Bold)
                Text(text = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(dateNaissance.time))
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Sexe:", fontWeight = FontWeight.Bold)
                Text(text = sexe)
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Poids:", fontWeight = FontWeight.Bold)
                Text(text = "$poids kg")
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Taille:", fontWeight = FontWeight.Bold)
                Text(text = "$taille m")
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Niveau d'activité:", fontWeight = FontWeight.Bold)
                Text(text = niveauActivite)
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "IMC:", fontWeight = FontWeight.Bold)
                Text(text = "%.2f".format(imcResult)) // Affichage de l'IMC avec 2 décimales
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Affichage de la catégorie IMC
        Text(text = "Catégorie IMC: $imcCategory", fontWeight = FontWeight.Bold)
    }
}

@Composable
fun SexeSelection(
    sexe: String,
    onSexeChange: (String) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth(0.9f)) {
        // Libellé en haut
        Text(
            text = "Sexe",
            color = Color.DarkGray,
            modifier = Modifier.fillMaxWidth().offset(x = 13.dp),
            fontSize = 16.sp

        )
        Spacer(modifier = Modifier.height(1.dp))
        // Row contenant les boutons radio espacés uniformément
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = sexe == "Homme",
                    onClick = { onSexeChange("Homme") }
                )
                Text(text = "Homme")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = sexe == "Femme",
                    onClick = { onSexeChange("Femme") }
                )
                Text(text = "Femme")
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    ProjetFinalAndroidTheme {
        BackFont()
    }
}