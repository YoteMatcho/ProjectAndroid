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
import androidx.compose.material3.Button // Importe o Button
import androidx.compose.material3.ButtonDefaults // Importe para mudar a cor do botão
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
import com.example.projectandroid.ui.theme.ProjectAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjectAndroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Este Column aqui é o contêiner principal da sua tela

                    Column(
                        modifier = Modifier
                            .fillMaxSize() // Faz o Column ocupar a tela toda
                            .padding(innerPadding) // Aplica o espaço para não sobrepor barras do sistema
                    ) {
                        App() // a função que cria o conteúdo do aplicativo
                    }
                }
            }
        }
    }
}

@Composable
fun App(){
    // 'valorGasolina' guarda o texto que o usuário digita no campo da gasolina
    var valorGasolina by remember { mutableStateOf("") }
    // 'valorAgua' guarda o texto que o usuário digita no campo da água
    var valorAgua by remember { mutableStateOf("") }

    // 'resultadoTexto' vai mostrar a mensagem final (ex: "Água é melhor!")
    var resultadoTexto by remember { mutableStateOf("Preencha os valores") }
    // 'corDoResultado' vai mudar a cor do texto do resultado
    var corDoResultado by remember { mutableStateOf(Color.White) } // Começa com branco

    // 'mensagemErro' vai guardar uma mensagem se o usuário digitar algo errado
    var mensagemErro by remember { mutableStateOf("") }

    // Lógica para calcular e definir o texto e a cor ---
    // Esta função vai ser chamada quando o botão "Calcular" for clicado
    val calcularMelhorOpcao = {
        // Primeiro, tentamos transformar o texto dos campos em números
        val gasolinaNum = valorGasolina.toDoubleOrNull() // Transforma para número, ou null se não for válido
        val aguaNum = valorAgua.toDoubleOrNull() // Transforma para número, ou null se não for válido

        // Resetar a mensagem de erro a cada cálculo
        mensagemErro = ""

        // Verifica se os dois valores são números válidos
        if (gasolinaNum != null && aguaNum != null) {
            // Verifica se o valor da gasolina não é zero para evitar divisão por zero
            if (gasolinaNum != 0.0) {
                val proporcao = aguaNum / gasolinaNum

                // Lógica para decidir se é "Água" ou "Gasolina" (exemplo: se água for até 70% do preço da gasolina)
                if (proporcao < 0.7) { // Se a água for mais barata (ex: 0.5 significa metade do preço da gasolina)
                    resultadoTexto = "Gasolina é mais vantajosa!"
                    corDoResultado = Color.Red // Cor para Gasolina
                } else if (proporcao > 0.7) { // Se a água for mais cara
                    resultadoTexto = "Água é mais vantajosa!"
                    corDoResultado = Color.Green // Cor para Água
                } else { // Se os preços forem iguais ou a proporção for exata
                    resultadoTexto = "Os valores são equivalentes."
                    corDoResultado = Color.Yellow // Cor para equivalente
                }
            } else {
                // Se a gasolina for 0, não podemos dividir!
                mensagemErro = "O valor da Gasolina não pode ser zero."
                resultadoTexto = "Erro!"
                corDoResultado = Color.Gray // Cor para erro
            }
        } else {
            // Se algum dos campos não for um número válido
            mensagemErro = "Por favor, digite valores numéricos válidos."
            resultadoTexto = "Erro!"
            corDoResultado = Color.Gray // Cor para erro
        }
    }

    // Lógica para o botão "Limpar"
    val limparCampos = {
        valorGasolina = "" // Limpa o campo da gasolina
        valorAgua = "" // Limpa o campo da água
        resultadoTexto = "Preencha os valores" // Volta a mensagem inicial
        corDoResultado = Color.White // Volta a cor inicial
        mensagemErro = "" // Limpa a mensagem de erro
    }


    // Design da tela
    Column(
        modifier = Modifier
            .fillMaxSize() // Faz o Column ocupar toda a tela
            .background(color = Color(0xFF00BCD4)), // Cor de fundo da tela (azul claro)
        verticalArrangement = Arrangement.Center, // Centraliza os itens verticalmente
        horizontalAlignment = Alignment.CenterHorizontally // Centraliza os itens horizontalmente
    ) {
        Column (
            verticalArrangement = Arrangement.spacedBy (16.dp), // Espaço entre os componentes
            horizontalAlignment = Alignment.CenterHorizontally // Centraliza os itens internos deste Column
        ) {
            // Título principal do aplicativo
            Text(
                text = "Custo: Água ou Gasolina?",
                style = TextStyle(
                    color = Color.White, // Cor branca para o título
                    fontSize = 32.sp
                ),
                fontWeight = FontWeight.Bold
            )

            // Texto que mostra o resultado (com a cor que muda!)
            Text(
                text = resultadoTexto,
                style = TextStyle(
                    color = corDoResultado, // A cor do texto é definida pela lógica
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            // Se houver uma mensagem de erro, mostramos ela aqui
            if (mensagemErro.isNotEmpty()) {
                Text(
                    text = mensagemErro,
                    style = TextStyle(
                        color = Color.Red, // Cor vermelha para mensagens de erro
                        fontSize = 16.sp
                    )
                )
            }

            Spacer(modifier = Modifier.size(24.dp)) // Espaço entre o resultado e os campos

            // Campo para digitar o valor da Gasolina
            TextField(
                value = valorGasolina,
                onValueChange = { novoValor ->
                    // Aceita apenas números e um ponto decimal
                    if (novoValor.matches(Regex("^\\d*\\.?\\d*\$"))) {
                        valorGasolina = novoValor
                    }
                },
                label = {
                    Text(text = "Preço por litro da Gasolina (€)") // Rótulo do campo
                }
            )

            // Campo para digitar o valor da Água
            TextField(
                value = valorAgua,
                onValueChange = { novoValor ->
                    // Aceita apenas números e um ponto decimal
                    if (novoValor.matches(Regex("^\\d*\\.?\\d*\$"))) {
                        valorAgua = novoValor
                    }
                },
                label = {
                    Text(text = "Preço por litro da Água (€)") // Rótulo do campo
                }
            )

            Spacer(modifier = Modifier.size(16.dp)) // Espaço entre os campos e os botões

            // --- Botão "Calcular" ---
            Button(
                onClick = calcularMelhorOpcao, // Quando clicado, chama a função de cálculo
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)) // Cor verde para o botão
            ) {
                Text("Calcular")
            }

            Spacer(modifier = Modifier.size(8.dp)) // Espaço entre os botões

            // --- Botão "Limpar" ---
            Button(
                onClick = limparCampos, // Quando clicado, chama a função de limpeza
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF44336)) // Cor vermelha para o botão
            ) {
                Text("Limpar")
            }
        }
    }
}

// Para manter seu código funcionando no Preview do Android Studio
@Preview(showBackground = true)
@Composable
fun AppPreview() {
    ProjectAndroidTheme {
        App()
    }
}