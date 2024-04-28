package projeto_pi_quiz;

import java.util.Scanner;
import java.util.Random;

import perguntas.perguntas_dificil;
import perguntas.perguntas_facil;
import perguntas.perguntas_medio;
import funcoes.faz_menu;
import funcoes.faz_questao;

public class programa {

	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);

		faz_menu.menu();

		int pontuacao = 0;
		int qtdePerguntas = 1;

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

		Random random = new Random();

		// Array com as perguntas e alternativas
		if (dificuldade.equalsIgnoreCase("facil")) {
			String[][] questoes = perguntas_facil.getQuestoes();
			
			// Array booleano para rastrear perguntas selecionadas
			boolean[] selecionados = new boolean[questoes.length]; 
																	
			// Selecionar aleatoriamente 3 índices de perguntas únicos
			int[] indicesSelecionados = new int[qtdePerguntas];
			for (int i = 0; i < qtdePerguntas; i++) {
				int indice;
				do {
					indice = random.nextInt(questoes.length); // Gera um número aleatório entre 0 e o número de questões
				} while (selecionados[indice]); // Verifica se o número já foi selecionado

				selecionados[indice] = true; // Marca o índice como selecionado
				indicesSelecionados[i] = indice; // Armazena o índice selecionado
			}

			// Exibir as perguntas selecionadas aleatoriamente ao usuário
			for (int indice : indicesSelecionados) {
				System.out.println("\nPergunta:");
				if (faz_questao.fazPergunta(questoes[indice], sc))
					pontuacao++;
			}
		}

		if (dificuldade.equalsIgnoreCase("medio")) {
			String[][] questoes = perguntas_medio.getQuestoes();

			boolean[] selecionados = new boolean[questoes.length];

			int[] indicesSelecionados = new int[qtdePerguntas];
			for (int i = 0; i < qtdePerguntas; i++) {
				int indice;

				do {
					indice = random.nextInt(questoes.length);
				} while (selecionados[indice]);

				selecionados[indice] = true;
				indicesSelecionados[i] = indice;
			}

			for (int indice : indicesSelecionados) {
				System.out.println("\nPergunta:");
				if (faz_questao.fazPergunta(questoes[indice], sc))
					pontuacao++;
			}
		}

		if (dificuldade.equalsIgnoreCase("dificil")) {
			String[][] questoes = perguntas_dificil.getQuestoes();

			boolean[] selecionados = new boolean[questoes.length];

			int[] indicesSelecionados = new int[qtdePerguntas];
			for (int i = 0; i < qtdePerguntas; i++) {
				int indice;

				do {
					indice = random.nextInt(questoes.length);
				} while (selecionados[indice]);

				selecionados[indice] = true;
				indicesSelecionados[i] = indice;
			}

			for (int indice : indicesSelecionados) {
				System.out.println("\nPergunta:");
				if (faz_questao.fazPergunta(questoes[indice], sc))
					pontuacao++;
			}
		}

		System.out.println("\nFim do Quiz!");
		System.out.printf("Sua pontuação total é: %d de %d", pontuacao, qtdePerguntas);

		sc.close();
	}
}
