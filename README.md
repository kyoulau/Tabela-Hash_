# 📘 Tabelas Hash com Diferentes Funções Hash

**Disciplina:** Resolução de Problemas Estruturados </br>
**Trabalho em Trio:** [Jun](https://github.com/julia-tatim), [Duda](https://github.com/dudatt), [Lau](https://github.com/kyoulau). </br>
**Tema:** Implementação de Tabelas Hash com Diferentes Funções Hash </br>
**Data:** 27/05/2025

## 📌 Objetivo

Implementar duas tabelas hash em Java, utilizando duas funções hash distintas. O foco principal é comparar a eficiência dessas implementações em termos de:

* Número de colisões. [cite: 1]
* Tempo de inserção e busca. [cite: 2]
* Distribuição das chaves na tabela. [cite: 1]

O programa lê uma lista de 5000 nomes de um arquivo de texto (`female_names.txt`), insere esses nomes nas duas tabelas hash (ambas com capacidade máxima de 32 posições) e, em seguida, realiza testes para coletar métricas de desempenho, imprimindo um relatório comparativo no console.

## ✅ Funcionalidades Implementadas

* **Leitura de Dados:** Leitura de 5000 nomes a partir de um arquivo `female_names.txt`. 
* **Duas Implementações de Tabela Hash:**
    * `FNVHashTable`: Utiliza a função de hash FNV-1a.
    * `SeparateChainingHashTable`: Utiliza uma função de hash polinomial para strings.
* **Tratamento de Colisões:** Ambas as tabelas utilizam o método de **Encadeamento Separado (Separate Chaining)** para tratar colisões, com cada posição da tabela podendo armazenar uma lista encadeada de elementos.
* **Design Orientado a Objetos:**
    * Uma classe abstrata `HashTable` define a estrutura genérica de uma tabela hash.
    * As classes `FNVHashTable` e `SeparateChainingHashTable` herdam de `HashTable` e implementam suas respectivas funções hash. 
* **Análise de Eficiência:**
    * Contabilização do número total de colisões durante as inserções para cada tabela. 
    * Medição do tempo total para inserir todas as chaves em cada tabela.
    * Medição do tempo total para buscar todas as chaves (previamente inseridas) em cada tabela. 
    * Verificação da distribuição das chaves, mostrando a quantidade de chaves em cada posição da tabela (indicativo de clusterização). 
* **Relatório Comparativo:** Impressão dos resultados dos testes de eficiência diretamente no console.
  
## 💻 Tecnologias Utilizadas

* Java (JDK 8 ou superior recomendado)

## 🧱 Estrutura do Projeto (Principais Arquivos)

* `Main.java`: Classe principal que orquestra a leitura dos dados, inicialização das tabelas, execução dos testes e impressão dos relatórios.
* `HashTable.java`: Classe abstrata que serve de base para as implementações de tabela hash. 
* `FNVHashTable.java`: Implementação da tabela hash utilizando a função FNV-1a.
* `SeparateChainingHashTable.java`: Implementação da tabela hash utilizando uma função hash polinomial.
* `ListaEncadeada.java`: Implementação de uma lista encadeada genérica, utilizada para o tratamento de colisões (encadeamento separado).
* `No.java`: Representa um nó na lista encadeada.
* `FileHandler.java`: Classe utilitária responsável pela leitura do arquivo de nomes. 
* `female_names.txt`: Arquivo de entrada contendo 5000 nomes femininos, um por linha. 

## ⚙️ Como Compilar e Executar o Projeto

1.  **Pré-requisitos:**
    * Certifique-se de ter o Java Development Kit (JDK) instalado e configurado no seu sistema.

2.  **Estrutura de Arquivos:**
    * Coloque todos os arquivos `.java` na mesma pasta (ou em uma estrutura de pacotes, ajustando os comandos de compilação e execução conforme necessário).
    * O arquivo `female_names.txt` deve estar localizado no caminho esperado pela classe `Main.java` (atualmente configurado como `src/female_names.txt`). Se você colocar os `.java` e o `.txt` todos na mesma pasta raiz do projeto, ajuste o caminho no `Main.java` para `female_names.txt`.

3.  **Compilação:**
    * Abra um terminal ou prompt de comando na pasta onde os arquivos `.java` estão localizados.
    * Compile os arquivos Java:
        ```bash
        javac Main.java HashTable.java FNVHashTable.java SeparateChainingHashTable.java ListaEncadeada.java No.java FileHandler.java
        ```
        Ou, de forma mais simples, se todos estiverem na mesma pasta:
        ```bash
        javac *.java
        ```

4.  **Execução:**
    * Após a compilação bem-sucedida, execute a classe principal:
        ```bash
        java Main
        ```

## ✅ Saída Esperada

O programa imprimirá no console um relatório contendo:

* O número total de nomes lidos do arquivo.
* Para cada uma das duas tabelas hash:
    * Tempo total de inserção de todas as chaves (em milissegundos). 
    * Tempo total de busca de todas as chaves (em milissegundos). 
    * Tempo total de execução (soma dos tempos de inserção e busca, em milissegundos).
    * Número total de colisões ocorridas durante as inserções. 
    * Distribuição das chaves na tabela (ex: "Slot 0: 150 chaves, Slot 1: 145 chaves, ..."). 

Este relatório permitirá a comparação direta da eficiência das duas funções hash implementadas. 
