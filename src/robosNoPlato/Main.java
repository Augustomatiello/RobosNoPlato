package robosNoPlato;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	
	private static int tamanhox;
	private static int tamanhoy;
	
	
	public static void main(String[] args) throws IOException {
		run("exemplo.txt");
	}
	
	@SuppressWarnings("resource")
	public static void run(String file) throws IOException{
			try {
				Pattern p ;
				Matcher m ;
				
				BufferedReader br = new BufferedReader(new FileReader(file));
			    String line;
			    line = br.readLine();
			    p = Pattern.compile("^\\d+\\s\\d+$");
				m = p.matcher(line);
			    
				if(!m.find()){
					throw new IllegalArgumentException();
				}
				
			    int iniciox, inicioy;
			    char direcaoInicial;
			    RoboNasa robo;
			    
			    Scanner in = new Scanner(line);
			    tamanhox = in.nextInt();
			    tamanhoy = in.nextInt();
			    in.close();
			    
			    line = br.readLine();
			    
			    while (line != null) {
			    	p = Pattern.compile("^\\d+\\s\\d+\\s[NSLO]$");
					m = p.matcher(line);
				    
					if(!m.find()){
						throw new IllegalArgumentException();
					}
			    	
			    	in = new Scanner(line);
			    	
			    	iniciox = in.nextInt();
			    	inicioy = in.nextInt();
			    	direcaoInicial = in.next(".").charAt(0);
			    	
			    	if(iniciox > tamanhox || inicioy > tamanhoy){
			    		throw new IllegalArgumentException();
			    	}
			    	
			    	robo = new RoboNasa(iniciox, inicioy, direcaoInicial);
			    	robo.defineLimite(tamanhox, tamanhoy);
			    	
			    	line = br.readLine();
			    	p = Pattern.compile("^[ADE]+$");
					m = p.matcher(line);
				    
					if(!m.find()){
						throw new IllegalArgumentException();
					}
					
			    	robo.movimento(line);
			    	robo.imprimeDisposicao();
			    	
			    	line = br.readLine();
			    
			    	in.close();
			    }
			    br.close();
			}
			catch (FileNotFoundException e){
				System.out.print("Arquivo não encontrado\n");
			}
			catch (IllegalArgumentException e){
				System.out.print("Entrada inválida\n");
			}
		}

}
