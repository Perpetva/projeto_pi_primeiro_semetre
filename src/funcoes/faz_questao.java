package funcoes;

import java.util.Scanner;

public class faz_questao {
	public static boolean fazPergunta(String[] pergunta, Scanner sc) {
		System.out.println(pergunta[0]); 

		// Imprime as alternativas dinamicamente
		for (int i = 2; i < pergunta.length; i++) {
			System.out.println(pergunta[i]);
		}

		System.out.print("Escolha a opção correta (a, b, c ou d): ");

		String resposta = sc.nextLine();

		// Verifica se a resposta do usuário é igual à resposta correta
		if (resposta.equalsIgnoreCase(pergunta[1])) {
			System.out.println("Resposta correta!"); 
			return true; 
		} else {
			System.out.println("Resposta incorreta! A resposta correta é: " + pergunta[1]);
			return false;
		}
	}
}
