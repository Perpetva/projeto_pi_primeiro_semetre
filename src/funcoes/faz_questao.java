package funcoes;

import java.util.Scanner;

public class faz_questao {
	public static boolean fazPergunta(String[] pergunta, Scanner sc) {
		// A função recebe uma pergunta, sua resposta correta, um scanner para entrada
		// do usuário
		// e uma lista variável de alternativas.

		System.out.println(pergunta[0]); // Imprime a pergunta

		// Imprime as alternativas dinamicamente
		for (int i = 2; i < pergunta.length; i++) {
			System.out.println(pergunta[i]);
		}

		System.out.print("Escolha a opção correta (a, b, c ou d): "); // Solicita a resposta do usuário

		String resposta = sc.nextLine(); // Lê a resposta do usuário e a converte para minúsculas

		// Verifica se a resposta do usuário é igual à resposta correta
		if (resposta.equalsIgnoreCase(pergunta[1])) {
			System.out.println("Resposta correta!"); // Imprime "Resposta correta!" se estiver correta
			return true; // Retorna verdadeiro indicando que a resposta está correta
		} else {
			System.out.println("Resposta incorreta! A resposta correta é: " + pergunta[1]);
			// Imprime a resposta correta se a resposta do usuário estiver incorreta
			return false; // Retorna falso indicando que a resposta está incorreta
		}
	}
}
