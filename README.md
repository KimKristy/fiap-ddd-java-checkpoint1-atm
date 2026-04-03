# FIAP Bank ATM

Projeto desenvolvido para o Checkpoint 1 da disciplina de Domain Driven Design - Java.

## Funcionalidades

- Cadastro de usuário
- Criação de senha forte (com validação)
- Login com até 3 tentativas
- Consulta de saldo
- Depósito
- Saque com validação
- Menu interativo via console

## Tecnologias

- Java
- Scanner
- Estruturas condicionais e de repetição

## Como executar

1. Compile o código:

javac FiapBankAtm.java

2. Execute:

java FiapBankAtm

## Regras do sistema

- Senha deve conter:
  - Mínimo 8 caracteres
  - Número
  - Letra maiúscula
  - Caractere especial
  - Limite de 3 tentativas de login
- Não permite:
  - Depósito negativo
  - Saque sem saldo

---

Desenvolvido para fins acadêmicos