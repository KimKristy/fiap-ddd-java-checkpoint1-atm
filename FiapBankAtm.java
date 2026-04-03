import java.util.Scanner;

public class FiapBankAtm {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // ===== FASE A: CADASTRO =====
        System.out.print("Digite seu nome completo: ");
        String nomeCompleto = scanner.nextLine().trim();

        String primeiroNome = nomeCompleto.split(" ")[0];
        System.out.println("Bem-vindo, " + primeiroNome + "!");

        String senha;
        String regexSenha = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[!@#$%^&*()\\-_+=?><]).{8,}$";

        while (true) {
            System.out.print("Cadastre uma senha forte: ");
            senha = scanner.nextLine();

            if (senha.matches(regexSenha)) {
                System.out.println("Senha cadastrada com sucesso!");
                break;
            } else {
                System.out.println("Senha fraca! Tente novamente.");
            }
        }

        // ===== LOGIN =====
        int tentativas = 0;
        boolean autenticado = false;

        while (tentativas < 3) {
            System.out.print("Digite sua senha: ");
            String tentativaSenha = scanner.nextLine();

            if (tentativaSenha.equals(senha)) {
                autenticado = true;
                break;
            } else {
                tentativas++;
                System.out.println("Senha incorreta! Tentativas restantes: " + (3 - tentativas));
            }
        }

        if (!autenticado) {
            System.out.println("ACESSO BLOQUEADO");
            return;
        }

        // ===== FASE B: MENU =====
        double saldo = 0.0;
        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("[1] Consultar Saldo");
            System.out.println("[2] Depositar");
            System.out.println("[3] Sacar");
            System.out.println("[4] Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.printf("Saldo atual: R$ %.2f\n", saldo);
                    break;

                case 2:
                    System.out.print("Digite o valor para depósito: ");
                    double deposito = scanner.nextDouble();

                    if (deposito > 0) {
                        saldo += deposito;
                        System.out.println("Depósito realizado com sucesso!");
                    } else {
                        System.out.println("Valor inválido!");
                    }
                    break;

                case 3:
                    System.out.print("Digite o valor para saque: ");
                    double saque = scanner.nextDouble();

                    if (saque <= 0) {
                        System.out.println("Valor inválido!");
                    } else if (saque > saldo) {
                        System.out.println("Saldo insuficiente!");
                    } else {
                        saldo -= saque;
                        System.out.println("Saque realizado com sucesso!");
                    }
                    break;

                case 4:
                    System.out.println("O FIAP Bank agradece sua preferência!");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 4);

        scanner.close();
    }
}