1º Visão Geral do Projeto:

A aplicação exibe uma tela com os textos "Água ou Gasolina" e "Gasolina" dispostos um abaixo do outro. É um ponto de partida para entender como layouts simples podem ser construídos com Jetpack Compose, utilizando componentes como Column e Text.

Estrutura do Código:

O código principal reside no arquivo MainActivity.kt e é composto por:

MainActivity: A atividade principal da aplicação, responsável por configurar o tema e o layout da tela.
App(): Uma função @Composable que define a estrutura da interface do usuário principal, utilizando Column para organizar os componentes Text verticalmente.
Greeting(): Uma função @Composable de exemplo, comum em projetos iniciais do Android Studio com Compose, que exibe um texto com uma saudação.
GreetingPreview(): Uma função @Preview que permite visualizar o Greeting no Android Studio sem precisar executar a aplicação no emulador ou dispositivo real.

Tecnologias Utilizadas:

Kotlin: Linguagem de programação.

Jetpack Compose: Kit de ferramentas moderno para construir interfaces de usuário no Android.

Android Studio: Ambiente de Desenvolvimento Integrado (IDE) para desenvolvimento Android.

2º Como Instalar e Executar:

2.1 Pré-requisitos: Um dispositivo Android físico ou um emulador configurado no Android Studio.

 2.2 Abrir no Android Studio: Selecionar "Open an existing Android Studio project" e navegue até a pasta projectandroid.
 
 2.3 Sincronizar o Gradle:Aguarde o Android Studio sincronizar o projeto com o Gradle.Pode levar alguns minutos.
 
 2.4 Executar o Aplicativo: Clique no botão "Run" (o ícone de triângulo verde) na barra de ferramentas.

3º Captura de Tela:

A imagem abaixo mostra a interface de desenvolvimento do Android Studio, com o código-fonte MainActivity.kt à esquerda e o emulador Android à direita, exibindo o resultado da execução do aplicativo.

![Screenshot 1º](https://github.com/user-attachments/assets/cec71f76-d884-4abc-85cf-00925fee6493)

1º Visão Geral do Projeto:

A aplicação exibe uma tela com os textos "Água ou Gasolina" e "Gasolina", seguidos por dois campos de texto editáveis. A tela possui um fundo azul-claro, e todos os elementos são organizados verticalmente. Este projeto serve como uma introdução à criação de layouts com Jetpack Compose, incorporando componentes interativos como TextField.

Estrutura do Código: 

O código principal reside no arquivo MainActivity.kt e é composto por:

MainActivity: A atividade principal da aplicação, responsável por configurar o tema e o layout da tela.
App(): Uma função @Composable que define a estrutura da interface do usuário principal. Ela utiliza Column para organizar os componentes Text e TextField verticalmente, e agora aplica um background de cor ciano à Column e fillMaxSize() para preencher a tela.
Greeting(): Uma função @Composable de exemplo, comum em projetos iniciais do Android Studio com Compose, que exibe um texto com uma saudação.
GreetingPreview(): Uma função @Preview que permite visualizar o Greeting no Android Studio sem precisar executar a aplicação no emulador ou dispositivo real.

Tecnologias Utilizadas:

Kotlin: Linguagem de programação.

Jetpack Compose: Kit de ferramentas moderno para construir interfaces de usuário no Android.

Android Studio: Ambiente de Desenvolvimento Integrado (IDE) para desenvolvimento Android.

2º Como Instalar e Executar:

2.1 Pré-requisitos: Um dispositivo Android físico ou um emulador configurado no Android Studio.

 2.2 Abrir no Android Studio: Selecionar "Open an existing Android Studio project" e navegue até a pasta projectandroid.
 
 2.3 Sincronizar o Gradle:Aguarde o Android Studio sincronizar o projeto com o Gradle.Pode levar alguns minutos.
 
 2.4 Executar o Aplicativo: Clique no botão "Run" (o ícone de triângulo verde) na barra de ferramentas.

3º Captura de Tela:

A imagem abaixo mostra a interface de desenvolvimento do Android Studio, com o código-fonte MainActivity.kt à esquerda e o emulador Android à direita, exibindo o resultado da execução do aplicativo, agora com campos de entrada e um fundo colorido.


![Screenshot 2º](https://github.com/user-attachments/assets/78bdab4e-e90a-4109-a6d1-159a7f466ac3)


1º Visão Geral do Projeto:

A aplicação continua a exibir a tela com os textos "Água ou Gasolina" e "Gasolina", seguidos por dois campos de texto editáveis. A principal mudança nesta versão é que todos esses elementos estão agora centralizados tanto vertical quanto horizontalmente na tela. O fundo da tela continua sendo azul-claro.Este projeto é ideal para entender como alinhar e organizar componentes no Jetpack Compose para criar layouts visualmente equilibrados.

Estrutura do Código:

O código principal reside no arquivo MainActivity.kt e é composto por:

MainActivity: A atividade principal da aplicação, responsável por configurar o tema e o layout da tela.
App(): Uma função @Composable que define a estrutura da interface do usuário principal. Ela utiliza Column para organizar os componentes Text e TextField verticalmente. Nesta versão, a Column que contém o conteúdo principal foi configurada com:
.fillMaxSize(): Para preencher toda a área disponível.
.background(color = Color(0xFF00BCD4)): Para definir a cor de fundo.
verticalArrangement = Arrangement.Center: Para centralizar o conteúdo verticalmente.
horizontalAlignment = Alignment.CenterHorizontally: Para centralizar o conteúdo horizontalmente.
Greeting(): Uma função @Composable de exemplo, comum em projetos iniciais do Android Studio com Compose, que exibe um texto com uma saudação.
GreetingPreview(): Uma função @Preview que permite visualizar o Greeting no Android Studio sem precisar executar a aplicação no emulador ou dispositivo real.

Tecnologias Utilizadas:

Kotlin: Linguagem de programação.

Jetpack Compose: Kit de ferramentas moderno para construir interfaces de usuário no Android.

Android Studio: Ambiente de Desenvolvimento Integrado (IDE) para desenvolvimento Android.

2º Como Instalar e Executar:

2.1 Pré-requisitos: Um dispositivo Android físico ou um emulador configurado no Android Studio.

 2.2 Abrir no Android Studio: Selecionar "Open an existing Android Studio project" e navegue até a pasta projectandroid.
 
 2.3 Sincronizar o Gradle:Aguarde o Android Studio sincronizar o projeto com o Gradle.Pode levar alguns minutos.
 
 2.4 Executar o Aplicativo: Clique no botão "Run" (o ícone de triângulo verde) na barra de ferramentas.

3º Captura de Tela:

A imagem abaixo mostra a interface de desenvolvimento do Android Studio, com o código-fonte MainActivity.kt à esquerda e o emulador Android à direita, exibindo o resultado da execução do aplicativo, com os elementos da interface centralizados.

![Screenshot 3º](https://github.com/user-attachments/assets/e398afad-a17b-4cf2-98e4-d028306ffa4a)

1º Visão Geral do Projeto:

A aplicação permite ao usuário inserir os preços por litro da "Gasolina" e da "Água" em campos de texto. Ao clicar no botão "Calcular", o aplicativo avalia a proporção entre os preços e exibe uma mensagem indicando qual opção é "mais vantajosa", "mais barata" ou "equivalente", com a cor do texto mudando para refletir o resultado (vermelho para Gasolina, verde para Água, amarelo para equivalente). Há também um botão "Limpar" para redefinir os campos e o resultado, e uma validação básica para garantir que apenas números sejam inseridos, exibindo mensagens de erro quando necessário. A interface é centralizada na tela e possui um fundo azul-claro.

Estrutura do Código: 

O código principal reside no arquivo MainActivity.kt e é composto por:

MainActivity: A atividade principal da aplicação, responsável por configurar o tema e o layout base da tela.
App(): Uma função @Composable que contém a maior parte da lógica e da interface do usuário da aplicação:
Gerenciamento de Estado: Utiliza remember e mutableStateOf para gerenciar o estado dos campos de texto (valorGasolina, valorAgua), o texto do resultado (resultadoTexto), a cor do resultado (corDoResultado) e mensagens de erro (mensagemErro).
Lógica de Cálculo (calcularMelhorOpcao): Esta função é acionada pelo botão "Calcular". Ela tenta converter os valores de entrada para números (Double). Realiza validações para garantir que os inputs são numéricos e que o preço da gasolina não é zero. Com base na proporção entre os preços da água e da gasolina, ela atualiza o resultadoTexto e a corDoResultado (vermelho, verde, amarelo).
Lógica de Limpeza (limparCampos): Esta função é acionada pelo botão "Limpar". Ela redefine todos os campos de texto, o texto do resultado e a cor para seus estados iniciais.
Layout da Interface: Organiza os elementos da UI (título, texto do resultado, campos de texto, botões) dentro de Columns, utilizando fillMaxSize(), background(), verticalArrangement = Arrangement.Center e horizontalAlignment = Alignment.CenterHorizontally para centralizar todo o conteúdo na tela.
Campos de Texto (TextField): Dois campos de texto são usados para entrada dos preços. onValueChange inclui uma validação para aceitar apenas caracteres numéricos e um ponto decimal.
Botões (Button): Dois botões, "Calcular" e "Limpar", com cores distintas (Color(0xFF4CAF50) para Calcular e Color(0xFFF44336) para Limpar), que acionam as funções de cálculo e limpeza, respectivamente.
Estilização: Aplica TextStyle para definir cores de texto, tamanhos de fonte e pesos de fonte para o título e o resultado. Spacer é usado para adicionar espaçamento entre os elementos.
Greeting(): Uma função @Composable de exemplo.
GreetingPreview(): Uma função @Preview para visualização do Greeting no Android Studio.

Tecnologias Utilizadas:

Kotlin: Linguagem de programação.

Jetpack Compose: Kit de ferramentas moderno para construir interfaces de usuário no Android.

Android Studio: Ambiente de Desenvolvimento Integrado (IDE) para desenvolvimento Android.

2º Como Obter e Executar:

2.1 Pré-requisitos: Um dispositivo Android físico ou um emulador configurado no Android Studio.

 2.2 Abrir no Android Studio: Selecionar "Open an existing Android Studio project" e navegue até a pasta projectandroid.
 
 2.3 Sincronizar o Gradle:Aguarde o Android Studio sincronizar o projeto com o Gradle.Pode levar alguns minutos.
 
 2.4 Executar o Aplicativo: Clique no botão "Run" (o ícone de triângulo verde) na barra de ferramentas.


3º Captura de Tela:

A imagem abaixo mostra a interface de desenvolvimento do Android Studio, com o código-fonte MainActivity.kt à esquerda e o emulador Android à direita. O emulador exibe a tela do aplicativo com um título, o espaço para o resultado da comparação, dois campos de entrada de texto para os preços da Gasolina e da Água, e os botões "Calcular" e "Limpar", todos centralizados na tela azul-clara.

![Screenshot 4º](https://github.com/user-attachments/assets/5e8c0291-5e16-4f0c-b3b3-fd794b24d2bc)



