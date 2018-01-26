package robosNoPlato;

public abstract class Robo {

	protected int [] disposicao;
	protected char [] direcao;
	
	public abstract void movimento(String movimentos);
	
	public abstract void imprimeDisposicao();

	
}
