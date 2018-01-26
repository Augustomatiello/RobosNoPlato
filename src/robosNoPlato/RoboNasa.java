package robosNoPlato;

public class RoboNasa extends Robo{

	private int limiteHorizontal;
	private int limiteVertical;
	
	public RoboNasa(int x, int y, char direcaoInicial) {
		criaDirecao();
		disposicao = new int [3];
		disposicao [0] = x;
		disposicao [1] = y;
		disposicao [2] = converteDirecaoInt(direcaoInicial);
	}

	private void criaDirecao() {
		direcao = new char[4];	
		direcao [0] = 'O'; 
		direcao [1] = 'N'; 
		direcao [2] = 'L'; 
		direcao [3] = 'S'; 
	}

	private int converteDirecaoInt(char direcaoInicial) {
		switch(direcaoInicial){
			case '0' : return 0;
			case 'N' : return 1;
			case 'L' : return 2;
			case 'S' : return 3;
			default : return 5;
		}
	}

	@Override
	public void movimento(String movimentos) {
		int i = 0;
		while(i < movimentos.length()){
			if (movimentos.charAt(i) == 'E'){
				disposicao [2] = (disposicao[2] + 4 - 1)%4;
			}
			else if (movimentos.charAt(i) == 'D'){
				disposicao [2] = (disposicao[2] + 1)%4;
			}
			else if (movimentos.charAt(i) == 'A'){
				move();
			}
			i++;
		}
	}

	public void defineLimite(int limiteX, int limiteY){
		limiteHorizontal = limiteX;
		limiteVertical = limiteY;
	}
	
	private void move() {
		if(disposicao[2] == 0 && disposicao[0] > 0){
			disposicao[0] --;
		}
		else if(disposicao[2] == 1 && disposicao[1] < limiteVertical){
			disposicao[1] ++;
		}
		else if(disposicao[2] == 2 && disposicao[0] < limiteHorizontal){
			disposicao[0] ++;
		}
		else if(disposicao[2] == 3 && disposicao[1] > 0){
			disposicao[1] --;
		}
	}

	@Override
	public void imprimeDisposicao() {
		System.out.print(disposicao[0] + " " + disposicao[1] + " " + direcao[disposicao[2]] + "\n");
		
	}

}
