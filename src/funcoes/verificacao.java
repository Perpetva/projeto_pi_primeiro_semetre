package funcoes;

public class verificacao {
	public static String verificador(int condicao) {
		if (condicao >= 0 && condicao <= 5) {
			return "Perna de Pau";
		} else if (condicao >= 6 && condicao <= 10) {
			return "Treinado";
		} else if (condicao >= 11 && condicao <= 14) {
			return "Federado";
		} else {
			return "Campeão";
		}
	}
}
