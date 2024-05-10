package projeto_pi_quiz;

import java.util.Scanner;

import perguntas.*;
import funcoes.chama_questao;
import funcoes.faz_menu;

public class programa {

	//globais
	public static int qtdePerguntas = 3;
	public static int pontuacao = 0; // Não mexer

	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		
		faz_menu.menu();

		String dificuldade = sc.nextLine();

		while (!dificuldade.equalsIgnoreCase("facil") && !dificuldade.equalsIgnoreCase("medio") && !dificuldade.equalsIgnoreCase("dificil")) {
			System.out.println("Você digitou algo diferente de Facil, Medio ou Dificil\nTente novamente.\nCaso queira sair do programa digite 'Sair'");
			dificuldade = sc.nextLine();
			
			if (dificuldade.equalsIgnoreCase("sair")) {
				System.out.println("Encerrando o programa...");
				Thread.sleep(3000);
				System.out.println("Programa encerrado.");
				System.exit(0);
			}
		}

		if (dificuldade.equalsIgnoreCase("facil")) {
			chama_questao.chama_pergunta(perguntas_facil.getQuestoes());
			
		} else if (dificuldade.equalsIgnoreCase("medio")) {
			chama_questao.chama_pergunta(perguntas_medio.getQuestoes());
			
		} else {
			chama_questao.chama_pergunta(perguntas_dificil.getQuestoes());
		}

		System.out.println("\nFim do Quiz!");
		System.out.printf("Você acertou %d de %d perguntas", pontuacao, qtdePerguntas);
		
		// Da pra fazer a verificação no final.
		// 'Perna de pau', 'Em treinamento', 'Federado', 'Campeão'. (como no overleaf)
		// Só precisamos ver qual a condição de cada um.

		sc.close();
	}
}
