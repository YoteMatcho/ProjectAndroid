package com.example.projectandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.foundation.text.KeyboardOptions

import com.example.projectandroid.ui.theme.ProjectAndroidTheme

// MainActivity é a tela principal do seu aplicativo.
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Faz o app usar toda a área da tela, incluindo as bordas do sistema.

        // Define o conteúdo da interface do usuário usando Jetpack Compose.
        setContent {
            // Aplica o tema visual do seu aplicativo (cores, fontes, etc.).
            ProjectAndroidTheme {
                // Scaffold cria uma estrutura básica de tela, como a área segura para o conteúdo.
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Um Column que ocupa a tela toda e aplica o padding do sistema,
                    // garantindo que o conteúdo não seja escondido por barras do celular.
                    Column(
                        modifier = Modifier
                            .fillMaxSize() // Faz esta coluna ocupar toda a largura e altura.
                            .padding(innerPadding) // Aplica o padding para evitar sobreposição.
                    ) {
                        // Chama a função 'App' que contém todo o conteúdo e lógica do seu aplicativo.
                        App()
                    }
                }
            }
        }
    }
}

// App é a função Composable principal onde a maior parte da interface e lógica do app está.
@Composable
fun App(){

    // 'valorGasolina' guarda o texto digitado pelo usuário para o preço da gasolina.
    var valorGasolina by remember { mutableStateOf("") }
    // 'valorGasoleo' guarda o texto digitado pelo usuário para o preço da gasoleo.
    var valorGasoleo by remember { mutableStateOf("") }

    // 'resultadoTexto' guarda a mensagem que será exibida ao usuário (ex: "Gasoleo é mais vantajosa!").
    var resultadoTexto by remember { mutableStateOf("Preencha os valores") }
    // 'corDoResultado' guarda a cor do texto do resultado, que muda de acordo com o cálculo.
    var corDoResultado by remember { mutableStateOf(Color.White) }

    // 'mensagemErro' guarda mensagens de erro, como quando o usuário digita algo inválido.
    var mensagemErro by remember { mutableStateOf("") }

    // --- Lógica para Calcular a Melhor Opção ---
    // Esta é uma função que será executada quando o botão "Calcular" for pressionado.

    val calcularMelhorOpcao = {
        val gasolinaNum = valorGasolina.toDoubleOrNull()
        val gasoleoNum = valorGasoleo.toDoubleOrNull()

        mensagemErro = "" // Limpa qualquer erro anterior

        // Primeiro, verifica se ambos os valores são numéricos e não nulos
        if (gasolinaNum != null && gasoleoNum != null) {
            // Agora, verifica se QUALQUER UM dos valores é zero.
            // Se gasolinaNum for 0 OU gasoleoNum for 0, exibe um erro.
            if (gasolinaNum == 0.0 || gasoleoNum == 0.0) { // <--- LINHA MODIFICADA PARA INCLUIR O GASÓLEO
                mensagemErro = "Os preços da Gasolina e do Gasóleo não podem ser zero."
                resultadoTexto = "Erro!"
                corDoResultado = Color.Gray
            } else {
                // Se nenhum dos preços for zero, proceed com a lógica de comparação
                if (gasolinaNum == gasoleoNum) {
                    resultadoTexto = "Os valores são equivalentes."
                    corDoResultado = Color.Yellow
                } else {
                    if (gasoleoNum < gasolinaNum) {
                        resultadoTexto = "Gasóleo é mais vantajosa!"
                        corDoResultado = Color.Green
                    } else {
                        resultadoTexto = "Gasolina é mais vantajosa!"
                        corDoResultado = Color.Red
                    }
                }
            }
        } else {
            // Se algum dos campos não for um número válido
            mensagemErro = "Por favor, digite valores numéricos válidos."
            resultadoTexto = "Erro!"
            corDoResultado = Color.Gray
        }
    }

    // --- Lógica para o Botão "Limpar" ---
    // Esta função será executada quando o botão "Limpar" for pressionado.
    val limparCampos = {
        valorGasolina = "" // Limpa o campo da gasolina.
        valorGasoleo = "" // Limpa o campo da água.
        resultadoTexto = "Preencha os valores" // Volta à mensagem inicial.
        corDoResultado = Color.White // Volta a cor branca para o resultado.
        mensagemErro = "" // Limpa qualquer mensagem de erro.
    }

    //  Design da Tela do Aplicativo
    // Coluna principal que organiza todos os elementos verticalmente.
    // Ela ocupa a tela inteira e centraliza seu conteúdo.
    Column(
        modifier = Modifier
            .fillMaxSize() // Faz a coluna preencher toda a tela.
            .background(color = Color(0xFF00BCD4)), // Define a cor de fundo da tela (azul claro).
        verticalArrangement = Arrangement.Center, // Centraliza o conteúdo verticalmente.
        horizontalAlignment = Alignment.CenterHorizontally // Centraliza o conteúdo horizontalmente.
    ) {
        // Uma coluna interna para organizar os itens específicos do app (título, campos, botões)
        // com espaçamento entre eles.
        Column (
            verticalArrangement = Arrangement.spacedBy (16.dp), // Adiciona 16dp de espaço entre cada item.
            horizontalAlignment = Alignment.CenterHorizontally // Centraliza os itens dentro desta coluna.
        ) {
            // Título do aplicativo.
            Text(
                text = "Custo: Gasoleo ou Gasolina?",
                style = TextStyle(
                    color = Color.White, // Texto branco.
                    fontSize = 32.sp // Tamanho grande.
                ),
                fontWeight = FontWeight.Bold // Negrito.
            )

            // Texto que exibe o resultado do cálculo.
            Text(
                text = resultadoTexto, // O texto muda de acordo com o cálculo.
                style = TextStyle(
                    color = corDoResultado, // A cor do texto muda de acordo com o resultado.
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            // Exibe a mensagem de erro APENAS se houver uma mensagem.
            if (mensagemErro.isNotEmpty()) {
                Text(
                    text = mensagemErro,
                    style = TextStyle(
                        color = Color.Red, // Mensagem de erro em vermelho.
                        fontSize = 16.sp
                    )
                )
            }

            Spacer(modifier = Modifier.size(24.dp)) // Espaço vazio para separar elementos.

            // Campo para o usuário digitar o preço da Gasolina.
            TextField(
                value = valorGasolina, // O texto exibido no campo.
                onValueChange = { novoValor -> // Chamado toda vez que o texto é alterado.
                    // Validação: permite apenas números e um ponto decimal.
                    if (novoValor.matches(Regex("^\\d*\\.?\\d*\$"))) {
                        valorGasolina = novoValor
                    }
                },
                label = {
                    Text(text = "Preço por litro da Gasolina (€)") // Texto que flutua como rótulo.
                },
                // Define o tipo de teclado a ser mostrado (alfanumérico, para permitir o ponto decimal).
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

            // Campo para o usuário digitar o preço da Gasoleo. Funciona igual ao campo da Gasolina.
            TextField(
                value = valorGasoleo,
                onValueChange = { novoValor ->
                    if (novoValor.matches(Regex("^\\d*\\.?\\d*\$"))) {
                        valorGasoleo = novoValor
                    }
                },
                label = {
                    Text(text = "Preço por litro da Gasoleo (€)")
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

            Spacer(modifier = Modifier.size(16.dp)) // Espaço antes dos botões.

            // Botão "Calcular".
            Button(
                onClick = calcularMelhorOpcao, // Quando clicado, executa a lógica de cálculo.
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)) // Cor de fundo verde.
            ) {
                Text("Calcular") // Texto do botão.
            }

            Spacer(modifier = Modifier.size(8.dp)) // Espaço entre os botões.

            // Botão "Limpar".
            Button(
                onClick = limparCampos, // Quando clicado, zera os campos e o resultado.
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF44336)) // Cor de fundo vermelha.
            ) {
                Text("Limpar") // Texto do botão.
            }
        }
    }
}

// Função de pré-visualização no Android Studio.Permite ver como o app ficará sem precisar rodar no emulador.
@Preview(showBackground = true) // Mostra um fundo para facilitar a visualização.
@Composable
fun AppPreview() {
    ProjectAndroidTheme { // Aplica o tema do app para a pré-visualização.
        App() // Mostra o Composable 'App'.
    }
}
