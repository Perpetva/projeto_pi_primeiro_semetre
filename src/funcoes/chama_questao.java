package funcoes;

import java.util.Random;
import java.util.Scanner;

public class chama_questao {
	public static void chama_pergunta (String[][] a) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		
		String[][] questoes = a;

		int pontuacao = 0; // Não mexer!!!
		int qtdePerguntas = 15; // Não mexer!!!

		// Array booleano para rastrear perguntas selecionadas
		boolean[] selecionados = new boolean[questoes.length];

		// Selecionar aleatoriamente os índices de perguntas únicos
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
		for (int i = 0; i < indicesSelecionados.length; i++) {
			System.out.printf("\n%dª Pergunta:\n", i +1);
			int indice = indicesSelecionados[i];
			
			if (faz_questao.fazPergunta(questoes[indice], sc)) {
				pontuacao++;
			}
		}
		System.out.printf("\nO quiz acabou!\n"
				+ "Parabéns! Você acertou %d de %d perguntas!\n\nVocê é %s!", pontuacao, qtdePerguntas, verificacao.verificador(pontuacao));
	
		sc.close();
	}
}
