/**
 * Exemplo de leitura e escrita em arquivo 
 * 
 */
package br.com.txt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JOptionPane;

/**
 * @author Leonardo Mendes
 *
 */
public class Arquivo {


	public static void main(String[] args) {
		
		Escrever();
		Lendo();
	}

	private static void Lendo() {
		// Definindo o charset
		Charset utf8 = StandardCharsets.UTF_8;
		
		try {
			
			// Buscando o arquivo para leitura
			BufferedReader reader = Files.newBufferedReader(Paths.get("C:\\user\\texto1.txt"), utf8);
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				JOptionPane.showMessageDialog(null, line);
			}
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao ler arquivo.");
		}
		
	}

	public static void Escrever() {

		// Definindo o charset
		Charset utf8 = StandardCharsets.UTF_8;

		try {
			
			// Criando o arquivo para escrita
			BufferedWriter w = Files.newBufferedWriter(Paths.get("C:\\user\\texto1.txt"), utf8);
			
			String texto = JOptionPane.showInputDialog("Informe o texto a ser escrito");
			
			// Escrevendo no arquivo.
			w.write(texto);

			// Gravando
			w.flush();

			// Fechando a conexão com o arquivo
			w.close();

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao escrever no arquivo.");
		}
	}
}
