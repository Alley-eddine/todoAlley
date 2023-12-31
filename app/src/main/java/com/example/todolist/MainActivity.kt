package com.example.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Column {
                var textfield by remember {
                    mutableStateOf(value = "")
                }
                var tableau by remember {
                    mutableStateOf(emptyList<String>())
                }
                Text(text = "ToDOList", modifier = Modifier.align(CenterHorizontally), color =Color.Red)
                Text(text = "Ajouter une tache", modifier = Modifier.padding())
                
                TextField(value = textfield, onValueChange = {textfield= it} )
                
                Button(onClick = { 
                    if (textfield != ""){
                        tableau = tableau + textfield
                        textfield =""
                    }
                }) {
                    Row {
                        Text(text = "Cliquez sur moi", modifier = Modifier.padding())
                    }}
                LazyColumn{
                    items(tableau.size){ index ->
                        Text(text = tableau[index])
                        Button(onClick = {
                            tableau = tableau - tableau[index]
                            textfield = ""
                        }) {
                            Row {
                                Text(text = "Supprimer", modifier = Modifier.padding(), color= Color.Blue)
                            }
                            Button(onClick = {}) {
                                Text(text = "Alley", modifier = Modifier.padding())
                            }
                        }
                        
                    }
                }
                
            }
        }
    }
}

