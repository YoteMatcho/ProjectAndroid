package com.example.projectandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize // Importar fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.graphics.Color // Importar Color
import com.example.projectandroid.ui.theme.ProjectAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjectAndroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Certifique-se de que o padding interno seja aplicado se necessário
                    // App()
                    Column(modifier = Modifier
                        .fillMaxSize() // Adicionar fillMaxSize aqui para o Column
                        .padding(innerPadding)) { // Aplicar padding ao Column
                        App()
                    }
                }
            }
        }
    }
}

@Composable
fun App(){
    // Aplicar fillMaxSize() e background() ao Column para preencher a tela
    Column(
        modifier = Modifier
            .fillMaxSize() // Faz o Column ocupar toda a largura e altura disponíveis
            .background(color = Color(0xFF00BCD4)) // Define a cor de fundo
    ) {
        Text(text = "Água ou Gasolina")
        Text(text = "Gasolina")
        TextField(value = "2.00 ", onValueChange = {})
        TextField(value = "2.00 ", onValueChange = {})
    }
}

// O restante do seu código (Greeting e GreetingPreview) permanece o mesmo.
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProjectAndroidTheme {
        Greeting("Android")
    }
}