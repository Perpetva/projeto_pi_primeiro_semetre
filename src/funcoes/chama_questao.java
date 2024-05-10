package funcoes;

import java.util.Random;
import java.util.Scanner;

import projeto_pi_quiz.programa;

public class chama_questao {
	public static void chama_pergunta (String[][] a) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		
		String[][] questoes = a;

		// Array booleano para rastrear perguntas selecionadas
		boolean[] selecionados = new boolean[questoes.length];

		// Selecionar aleatoriamente X índices de perguntas únicos
		int[] indicesSelecionados = new int[programa.qtdePerguntas];
		for (int i = 0; i < programa.qtdePerguntas; i++) {
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
				programa.pontuacao++;
		}
		
		sc.close();
	}
}
