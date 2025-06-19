package com.example.projectandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Alignment // Importe Alignment para centralizar horizontalmente
import com.example.projectandroid.ui.theme.ProjectAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjectAndroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Este Column aqui é o contêiner principal da sua tela
                    // Ele ocupa a tela inteira e aplica o padding do Scaffold
                    Column(
                        modifier = Modifier
                            .fillMaxSize() // Faz o Column ocupar a tela toda
                            .padding(innerPadding) // Aplica o espaço para não sobrepor barras do sistema
                    ) {
                        App() // Aqui chamamos a função que cria o conteúdo do seu aplicativo
                    }
                }
            }
        }
    }
}

@Composable
fun App(){
    // Este Column contém seus textos e campos de texto
    // Agora ele está configurado para centralizar seu conteúdo
    Column(
        modifier = Modifier
            .fillMaxSize() // Muito importante: faz este Column preencher a tela
            .background(color = Color(0xFF00BCD4)), // Sua cor de fundo
        verticalArrangement = Arrangement.Center, // Centraliza os itens verticalmente (de cima para baixo)
        horizontalAlignment = Alignment.CenterHorizontally // Centraliza os itens horizontalmente (da esquerda para a direita)
    ) {
        Text(text = "Água ou Gasolina")
        Text(text = "Gasolina")
        TextField(value = "2.00 ", onValueChange = {})
        TextField(value = "2.00 ", onValueChange = {})
    }
}

// O restante do seu código (Greeting, GreetingPreview) permanece o mesmo
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