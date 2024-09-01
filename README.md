# Analisador Léxico

Ao longo do semestre da disciplina Teoria de Compiladores (DCC045) será construído um compilador para a linguagem lang. Assim, neste primeiro trabalho foi desenvolvido um analisador léxico.
Implementamos um programa de teste que usa o analisador léxico implementado. Tal programa recebe como entrada um arquivo contendo um programa na linguagem e imprime, na saída padrão, a sequência de tokens produzido pelo analisador léxico, um token por linha.

## 📄 Linguagem

* Um identificador é uma sequência de letras, dígitos e sobrescritos (underscore) que, obrigatoriamente, começa com uma letra minúscula. Exemplos de identificadores: var, var 1 e fun10;
* Um nome de tipo é semelhante a regra de identificadores, porém a primeira letra é maiúscula; Exemplos de nomes de tipos: Racional e Point;
* Um literal inteiro é uma sequência de um ou mais dígitos;
* Um literal ponto flutuante é uma sequência de zero ou mais dígitos, seguido por um ponto e uma sequência de um ou mais dígitos. Exemplos de literais ponto flutuante: 3.141526535, 1.0 e .12345;
* Um literal caractere é um ́único caractere delimitado por aspas simples. Os caracteres especiais quebra-de-linha, tabulação, backspace e carriage return são definidos usando os caracteres de escape \n, \t, \b e \r, respectivamente. Para especificar um caractere \, é usado \\ e para a aspas simples o \’. Exemplos de literais caractere: ’a’, ’\n’, ’\t’ e ’\\”;
* Um literal lógico é um dos valores true ou false;
* O literal nulo é null;
* Os símbolos usados para operadores e separadores são (, ), [, ], {, }, >, ;, :, ::, ., ,, =, <, ==, !=, +, -, *, /, %, && e !.


## Versão do JAVA
**11.0.22**

## Compilação
Execute o comando na raiz da aplicação
```bash
make

# ou

java -jar lib/jflex-full-1.8.2.jar src/scanner/lang.jflex && javac src/*.java src/scanner/*.java -d target
```

## Execução
Execute o comando na raiz da aplicação.
```bash
make run FILE=./examples_Agata_Gabriel/right/exampleCHAR.lan

# ou

java -cp target App ./examples_Agata_Gabriel/right/exampleCHAR.lan
```
 - OBS: Substitua o caminho do arquivo para testar outros exemplos

## ✒️ Autores
Ágata Meireles Carvalho

Gabriel Frasson Costa

# Analisador Sintático

O analisador sintático foi construído utilizando a ferramenta ANTLR. Como o ANTLR não integra com o JFLEX, o analisador léxico foi reconstruído na ferramenta, juntamente com o analisador sintático.

## Versão do JAVA
**11.0.22**

## Compilação
Execute o comando na raiz da aplicação
```bash
make
```

## Execução - Testes sintáticos
Execute o comando na raiz da aplicação.
```bash
make run-tests
```

## Execução - Interpretador
Execute o comando na raiz da aplicação.
```bash
make run-interpreter FILE=./exemplos/testes/sintaxe/certo/attrADD.lan
```
 - OBS: Substitua o caminho do arquivo para testar outros exemplos