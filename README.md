## Gerar Scanner
Execute na raiz da aplicação para gerar o analisador léxico:
```bash
java -jar lib/jflex-full-1.8.2.jar src/scanner/lang.jflex
```

## Compilação
```bash
javac src/*.java src/scanner/*.java -d bin
```

## Execução
```bash
java -cp bin App ./exemplos/testes/sintaxe/certo/attrADD.lan
```