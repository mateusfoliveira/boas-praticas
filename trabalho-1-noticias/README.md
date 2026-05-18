# Monitor de Fake News e Qualidade da Informação 

Este projeto é um sistema de simulação de monitoramento e classificação de notícias, desenvolvido como parte da avaliação da disciplina **DIM0501 - Boas Práticas de Programação** (2026.1).

O objetivo principal deste repositório é demonstrar a aplicação prática de técnicas de refatoração, *clean code*, modularização e programação defensiva sobre um código base inicialmente estruturado de forma inadequada.

## 🚀 Funcionalidades

O sistema interage com o usuário via terminal (CLI) e oferece as seguintes funcionalidades:

* **Adicionar Notícia Manualmente:** O usuário insere o texto e define a classificação da notícia (Confiável, Duvidosa ou Falsa).
* **Adicionar Notícia Automaticamente:** O sistema avalia o texto inserido e o classifica automaticamente com base em algumas regras:
    * Ausência de citação de fontes (ausência da palavra "FONTE").
    * Uso de linguagem sensacionalista (presença de termos como "URGENTE" ou "!!!").
    * Tamanho do texto.
* **Listar Notícias:** Exibe todas as notícias cadastradas no sistema e suas respectivas classificações.

## 🛠️ Arquitetura e Boas Práticas Aplicadas

O código foi inteiramente refatorado seguindo os pilares da engenharia de software de qualidade:

### 1. Legibilidade e Organização de Código
Para garantir a máxima legibilidade e organização, a base de código foi reestruturada com foco na eliminação de *Code Smells* e na aplicação estrita do Princípio da Responsabilidade Única (SRP). Identificadores (variáveis e métodos) foram renomeados para refletirem explicitamente as suas intenções, transformando o código numa estrutura autodocumentada.

### 2. Modularização (Padrão MVC)
* **`model/` (Modelo):** Contém as entidades de domínio do sistema (`Noticia.java` e o Enum `Classificacao.java`).
* **`InterfaceNoticia.java` (View):** Classe responsável exclusivamente por gerenciar a entrada e saída (I/O) do terminal, interagindo com o usuário e garantindo o tratamento prévio dos dados.
* **`ClassificadorNoticias.java` (Controller/Service):** Isola todas as regras de negócio e a lógica de classificação, além de gerenciar a persistência em memória.

### 3. Programação Defensiva e Resiliência
* **Fail-Fast:** O método `criarNoticia` lança `IllegalArgumentException` caso receba parâmetros nulos, blindando a integridade da lista de notícias.
* **Tratamento Prévio na Interface:** Uso de laços `while` e blocos `try-catch` para capturar erros de digitação (ex: conversão inválida de `String` para `Enum`) sem interromper a execução do programa, evitando *crashes*.
* **Cópias Defensivas:** O método `getNoticias()` retorna uma nova instância da lista (`new ArrayList<>(noticias)`), impedindo que o encapsulamento seja quebrado por alterações acidentais externas.

### 3. Imutabilidade e Segurança de Tipos
* Substituição de *Magic Strings* pelo Enum `Classificacao`, transferindo a responsabilidade de validação de domínio para o próprio compilador da linguagem Java.
* Aplicação da diretiva `final` nos atributos da classe `Noticia`, garantindo que o estado do objeto seja **100% imutável** após sua instanciação.

## 💻 Como Executar

Para rodar o projeto localmente, certifique-se de ter o [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/) instalado.

1.  Clone este repositório:
    ```bash
    git clone https://github.com/mateusfoliveira/boas-praticas.git
    ```
2.  Navegue até a pasta raiz do projeto:
    ```bash
    cd trabalho-1-noticias
    ```
3.  Compile os arquivos Java:
    ```bash
    javac Main.java model/*.java ClassificadorNoticias.java InterfaceNoticia.java
    ```
4.  Execute a classe principal:
    ```bash
    java Main
    ```

---

