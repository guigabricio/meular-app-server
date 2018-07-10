/**
 * Autbank Projetos e Consultoria Ltda.<br>
 * <br>
 * Criado em 22/01/2009 - 19:21:12<br>
 *  
 * @version $Revision: 1.2 $ de $Date: 2013/08/20 20:26:41 $<br>
 *           por $Author: adrianom $<br>
 * @author luizricardo<br>
 */
package com.gabricio.meular.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Classe auxiliar com rotinas de Texto (String)
 */
public abstract class Texto {

	/**
	 * Prepara um par�metro de busca Se for != null && != "" -> %[valor]%
	 * 
	 * @return
	 */
	public static String preparaParametroBusca(String str) {

		return Texto.ehVazio(str) ? null : "%" + str.trim().toUpperCase() + "%";

	}

	/**
	 * Torna a primeira letra me mai�scula e mant�m o resto normal
	 */
	public static String primeiraMaiuscula(String str) {

		return str.substring(0, 1).toUpperCase() + str.substring(1);

	}

	/**
	 * Torna a primeira letra me mai�scula e o resto em min�sculas
	 */
	public static String apenasPrimeiraMaiuscula(String str) {

		return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();

	}

	/**
	 * Torna a primeira letra me min�scula e mant�m o resto normal
	 */
	public static String primeiraMinuscula(String str) {

		return str.substring(0, 1).toLowerCase() + str.substring(1);

	}

	/**
	 * Diz se uma string � vazia: null ou "" (com trim)
	 */
	public static boolean ehVazio(String texto) {

		return texto == null || texto.trim().equals("");

	}

	public static boolean ehNulo(Object obj) {

		return obj == null;

	}

	/**
	 * Recebe uma String e retorna a mesma string com um trim(), ou, caso o
	 * par�metro seja nulo, retorna o valorPadrao
	 */
	public static String toString(String texto, String valorPadrao) {

		return (texto == null || texto.trim().equals("")) ? valorPadrao : texto.trim();

	}

	/**
	 * Recebe uma String e retorna a mesma string com um trim(), ou, caso o
	 * par�metro seja nulo, retorna uma nova string vazia
	 */
	public static String toString(String texto) {

		return (texto == null) ? "" : texto.trim();

	}

	/**
	 * Recebe uma String e retorna nulo se a mesma for nula ou vazia
	 */
	public static String vazioPraNulo(String texto) {

		return (texto == null || texto.equals("")) ? null : texto;

	}

	/**
	 * Recebe um Object e retorna umaa string com um trim(), ou, caso o par�metro
	 * seja nulo, retorna uma nova string vazia
	 */
	public static String toString(Object texto) {

		return (texto == null) ? "" : ((String) texto).toString().trim();

	}

	/**
	 * Converte uma String para um n�mero inteiro
	 */
	public static int toInt(String textoNumerico) {

		try {

			return ((textoNumerico == null) || textoNumerico.trim().equals("")) ? 0 : Integer.parseInt(textoNumerico);

		} catch (NumberFormatException e) {

			return 0;

		}

	}

	/**
	 * Corta um texto, validando o tamanho da string passada para evitar exce��es ao
	 * utilizar diretamente o m�todo String.substring
	 * 
	 * Se tamanho for negativo, ent�o pega o texto at� o final da string
	 */
	public static final String cortar(String texto, int inicio, int tamanho) {

		if (texto == null) {

			return "";

		} else {

			if (inicio < 0) {

				inicio = 0;

			}

			if (tamanho < 0) {

				tamanho = texto.length();

			}

			if (texto.length() > inicio) {

				if (texto.length() > inicio + tamanho) {

					return texto.substring(inicio, inicio + tamanho);

				} else {

					return texto.substring(inicio, texto.length());

				}

			} else {

				return "";

			}

		}

	}

	/**
	 * Corta um texto, validando o tamanho da string passada para evitar exce��es ao
	 * utilizar diretamente o m�todo String.substring
	 */
	public static final String cortar(String texto, int tamanho) {

		if (texto == null || tamanho <= 0) {

			return "";

		} else {

			if (texto.length() > tamanho) {

				return texto.substring(0, tamanho);

			} else {

				return texto;

			}

		}

	}

	/**
	 * preenche a String com zeros at� completar o tamanhoTotal
	 */
	public static String preencheZeros(String valor, int tamanhoTotal, boolean esquerda) {

		return preenche(valor, tamanhoTotal, ' ', esquerda);

	}

	/**
	 * preenche a String com brancos at� completar o tamanhoTotal
	 */
	public static String preencheBrancos(String valor, int tamanhoTotal, boolean esquerda) {

		return preenche(valor, tamanhoTotal, ' ', esquerda);

	}

	/**
	 * preenche a String com o caracter especificado at� completar o tamanhoTotal
	 */
	public static String preenche(String texto, int tamanho, char caracter, boolean esquerda) {

		if (texto == null) {

			texto = "";

		}

		if (texto.length() > tamanho) {

			return texto.substring(0, tamanho);

		} else {

			StringBuffer strBuffer = new StringBuffer();
			if (!esquerda) {

				strBuffer.append(texto);

			}
			for (int i = 0; i < tamanho - texto.length(); i++) {

				strBuffer.append(caracter);

			}
			if (esquerda) {

				strBuffer.append(texto);

			}
			return strBuffer.toString();

		}

	}

	/*
	 * Boolean <-> String
	 */

	/**
	 * Retorna true se str = "S" ou false caso contr�rio
	 */
	public static final boolean ehVerdadeiro(String str) {
		return str != null && Texto.cortar(str, 1).equals("S");
	}

	/**
	 * Retorna true se str = "N" ou false caso contr�rio
	 */
	public static final boolean ehFalso(String str) {
		return Texto.cortar(str, 1).equals("N");
	}

	/**
	 * Retorna "S" ou "N" se o par�metro for true ou false, respectivamente
	 */
	public static final String boolStr(boolean val) {
		return val ? "S" : "N";
	}

	/**
	 * Retorna "Sim" ou "N�o" se o par�metro for true ou false, respectivamente
	 */
	public static final String boolStrDesc(boolean val) {
		return val ? "Sim" : "N�o";
	}

	/**
	 * Retorna "Sim" se o par�metro for "S" ou "N�o" caso contr�rio
	 */
	public static final String boolStrDesc(String val) {
		return ehVerdadeiro(val) ? "Sim" : "N�o";
	}

	/**
	 * For�a que o retorno seja S ou N
	 */
	public static final String gravaSN(String val) {
		return boolStr(ehVerdadeiro(val));
	}

	/**
	 * Remove caracteres especiais da String Os caracteres podem ser substitu�dos
	 * conforme definidos no vetor "substituicaoCaracteres[][]" O que n�o estiver
	 * contido na "caracteresPermitidos" ser� removido
	 * 
	 * Basicamente, este m�todo faz uma itera��o sobre os caracteres Como a chave do
	 * mapa de substitui��o � o caracter que deve ser substitu�do, usa-se cada
	 * caracter para encontrar o valor que deve ser colocado Se algo � encontrado,
	 * acrescenta-se ao resultado, se n�o, vai para o pr�ximo
	 */
	public static final String removerCaracteresEspeciais(String texto) {
		StringBuffer resp = new StringBuffer();
		if (mapaSubstituicao == null || mapaSubstituicao.size() == 0) {
			throw new RuntimeException("Mapa de Subsbitui��o de Caracteres n�o Inicializado!");
		}
		if (texto == null) {
			return "";
		}
		int total = texto.length();
		for (int i = 0; i < total; i++) {
			String c = (String) mapaSubstituicao.get(new Character(texto.charAt(i)).toString());
			if (c != null) {
				resp.append(c);
			}
		}
		return resp.toString();
	}

	/**
	 * Este vetor funciona da seguinte forma: Todos os caracteres das colunas 2 em
	 * diante (2..N) ser�o substitu�dos pelo caracter da primeira coluna (1)
	 */
	private static final char substituicaoCaracteres[][] = { { 'C', '�' }, { 'A', '�', '�', '�', '�' },
			{ 'I', '�', '�', '�', '�' }, { 'E', '�', '�', '�', '�' }, { 'U', '�', '�', '�', '�' },
			{ 'O', '�', '�', '�', '�', '�' }, { 'N', '�' }, { 'c', '�' }, { 'a', '�', '�', '�', '�', '�' },
			{ 'i', '�', '�', '�', '�' }, { 'e', '�', '�', '�', '�' }, { 'u', '�', '�', '�', '�' },
			{ 'o', '�', '�', '�', '�', '�', '�' }, { 'n', '�' },
			// {' ', ',', '.', ':', '?', ';', '*', '/', '\\', '|', '%', '$', '#', '@', '!'}
	};

	/**
	 * Essa String definir� quais caracteres s�o permitidos na String Tudo o que n�o
	 * houver aqui ser� removido
	 */
	private static final String caracteresPermitidos = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789 ()_-";

	/**
	 * Este mapa armazenar� os caracteres permitidos e os que devem ser
	 * substitu�dos, de forma a otimizar a substitui��o
	 */
	private static final Map mapaSubstituicao;

	/**
	 * Inicializador est�tico, executado quando o Java carregar a classe Aqui o mapa
	 * de substitui��o � montado de forma a otimizar a substitui��o de caracteres O
	 * chave do mapa � o caracter que deve ser substitu�do, o valor � o que deve ser
	 * colocado no lugar
	 */
	static {

		mapaSubstituicao = new HashMap();
		for (int i = 0; i < substituicaoCaracteres.length; i++) {
			String c = Character.toString(substituicaoCaracteres[i][0]).intern();
			for (int j = 1; j < substituicaoCaracteres[i].length; j++) {
				mapaSubstituicao.put(Character.toString(substituicaoCaracteres[i][j]).intern(), c);
			}
		}

		for (int i = 0; i < caracteresPermitidos.length(); i++) {
			String c = Character.toString(caracteresPermitidos.charAt(i)).intern();
			mapaSubstituicao.put(c, c);
		}

	}

	public static String substituirParteDeTexto(CharSequence parteASubstituir, CharSequence novoValor,
			String textoCompleto) {
		return parteASubstituir == null || novoValor == null ? textoCompleto
				: Pattern.compile(parteASubstituir.toString(), 0x10).matcher(textoCompleto)
						.replaceAll(substituiSimbolos(novoValor.toString()));
	}

	private static String substituiSimbolos(String s) {
		if ((s.indexOf('\\') == -1) && (s.indexOf('$') == -1))
			return s;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '\\') {
				sb.append('\\');
				sb.append('\\');
			} else if (c == '$') {
				sb.append('\\');
				sb.append('$');
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	public static String imprimeBigDecimal(BigDecimal valor) {
		// return (valor == null) ? "": Formatador.getNumberFormat(((BigDecimal)
		// valor).scale()).format(((BigDecimal) valor));
		return (valor == null) ? "0" : valor.toString();
	}

	public String removeUltimoCaracter(String str) {
		if (str != null && str.length() > 0) {
			str = str.substring(0, str.length() - 1);
		}
		return str;
	}
}
