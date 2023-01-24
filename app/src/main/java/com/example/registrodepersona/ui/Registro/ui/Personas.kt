package com.example.registrodepersona.ui.Registro.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



@Composable
fun RegistroScreen(){
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp)) {
        Registro(Modifier.align(Alignment.Center))
    }
}

@Composable
fun Registro(modifier: Modifier) {
    Column(modifier = modifier) {
        Elementos(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(16.dp))
        NombresField()
        Spacer(modifier = Modifier.padding(4.dp))
        TelefonoField()
        Spacer(modifier = Modifier.padding(4.dp))
        CelularField()
        Spacer(modifier = Modifier.padding(4.dp))
        EmailField()
        Spacer(modifier = Modifier.padding(4.dp))
        DireccionField()
        Spacer(modifier = Modifier.padding(4.dp))
        FechaField()
        Spacer(modifier = Modifier.padding(4.dp))
        MyMenu()
        Spacer(modifier = Modifier.padding(16.dp))
        RegistroButton(Modifier.align(Alignment.CenterHorizontally))
    }
}

@Composable
fun Elementos(modifier: Modifier) {
    Text(text = "Registro de Personas",
        modifier = modifier)
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NombresField(){
    TextField(value = "", onValueChange = {},
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Nombres")},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.outlinedTextFieldColors(textColor = Color(0xFFE7DFDF),
            backgroundColor = Color(0xFFE7DFDF),
        )
    )
}
@Composable
fun TelefonoField() {
    TextField(value = "", onValueChange = {},
        placeholder = { Text(text = "Telefono")},
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.outlinedTextFieldColors(textColor = Color(0xFFE7DFDF),
            backgroundColor = Color(0xFFE7DFDF),
        )
    )
}
@Composable
fun CelularField() {
    TextField(value = "", onValueChange = {},
        placeholder = { Text(text = "Celular")},
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.outlinedTextFieldColors(textColor = Color(0xFFE7DFDF),
            backgroundColor = Color(0xFFE7DFDF),
        )
    )
}
@Composable
fun EmailField() {
    TextField(
        value = "", onValueChange = {},
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Email") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color(0xFFE7DFDF),
            backgroundColor = Color(0xFFE7DFDF),
        )
    )
}
@Composable
fun DireccionField(){
    TextField(value = "", onValueChange = {},
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Direccion")},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.outlinedTextFieldColors(textColor = Color(0xFFE7DFDF),
            backgroundColor = Color(0xFFE7DFDF),
        )
    )
}
@Composable
fun FechaField(modifier: Modifier = Modifier){
    TextField(value = "", onValueChange = {},
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Fecha de Nacimiento")},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.outlinedTextFieldColors(textColor = Color(0xFFE7DFDF),
            backgroundColor = Color(0xFFE7DFDF),
        )
    )
}
@Composable
fun MyMenu(){
    val ocupaciones = listOf("")
    var ocupacioneSeleccionada by remember { mutableStateOf("") }
    var expandido by remember { mutableStateOf(false)}
    Column(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            label = { Text("Ocupacion") },
            trailingIcon ={
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = null
                )
            },
            value = ocupacioneSeleccionada,
            onValueChange = { ocupacioneSeleccionada = it},
            readOnly = true, enabled = false,
            modifier = Modifier
                .clickable {
                    expandido = true
                    Log.e("tag", "expandido")
                }
                .fillMaxWidth()

        )
        DropdownMenu(expanded = expandido,
            onDismissRequest =  { expandido = false},
        modifier = Modifier.fillMaxWidth()
        ) {
            ocupaciones.forEach {item ->
                DropdownMenuItem(onClick = {
                    expandido = false
                    ocupacioneSeleccionada = item
                }) {
                    Text(text = item)

                }
            }

        }

    }
}

@Composable
fun RegistroButton(modifier: Modifier) {
    OutlinedButton(onClick = {}, modifier = Modifier
        .fillMaxWidth()
        .height(48.dp), colors = ButtonDefaults.buttonColors(
        backgroundColor = Color(0xFF6575CE),
        disabledContentColor = Color(0xFF6575CE),
        contentColor = Color.White,
        disabledBackgroundColor = Color.White
    )
    ) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "Guardar")
        Text(text = "Guardar",
            modifier = modifier)
    }
}

