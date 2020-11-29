package JantarFilosofos;

public class filosofo extends Thread {

	private int filosofo; 
	private int estado; 
	private Jantar jantar; 

	public filosofo(int chave, Jantar j) {
		this.filosofo = chave;		
		this.jantar = j;
	}

	public int getChave() { 
		return filosofo;
	}

	public void setStatus(int i) {
		estado = i;
		switch (i) {
		case 0:
			jantar.SetInfo(filosofo, 0);
			break;
		case 1:
			jantar.SetInfo(filosofo, 1);
			break;
		case 2:
			jantar.SetInfo(filosofo, 2);
			break;
		}
	}

	private void pensando() { 
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
	}

	private void comendo() { 
		try {
			Thread.sleep(2500);
		} catch (Exception e) {
		}
	}

	public void run() {
		while (true) {
			setStatus(0);
			pensando(); 
			jantar.fork.pegar(this);
			comendo(); 
			jantar.fork.liberar(this); 
		}

	}
}
