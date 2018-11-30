package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Teclado {

	private static BufferedReader teclado = new BufferedReader (new InputStreamReader(System.in));
	
			
	public static String LerTexto(String texto) { 
		try {
			
			return teclado.readLine();
			
		} catch (IOException e) {
			return null;
			
		}
						
	}
	
	public static int LerInt(String texto) {
		
		return Integer.parseInt(LerTexto(texto));
		
	}
	
	public static double lerDouble(String texto) {
		
		return Double.parseDouble(LerTexto (texto));
		
	}
	
}


