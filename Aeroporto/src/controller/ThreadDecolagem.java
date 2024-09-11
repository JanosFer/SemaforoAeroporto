package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadDecolagem extends Thread{
	private final int TID = (int) getId();
	private Semaphore norte;
	private Semaphore sul;
	
	public ThreadDecolagem(Semaphore semaforo) {
		norte = semaforo;
		sul = semaforo;
	}
	
	public void run() {
		
		try {
			String pista = "norte";
			norte.acquire();
			decolar(pista);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}finally {
			norte.release();
		}
		
		try {
			String pista = "sul";
			sul.acquire();
			decolar(pista);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}finally {
			sul.release();
		}
	}
	
	private void decolar(String pista) {
		Random aleat = new Random();
		
		int taxiar = 300 + aleat.nextInt(401);
		int decolar = 500 + aleat.nextInt(501);
		int afastar = 600 + aleat.nextInt(201);
		
		try {
			Thread.sleep(taxiar);
			System.out.println("O avião de matrícula " + TID + " taxiou na pista " + pista + " em " + (taxiar) + " milisegundos.");
			Thread.sleep(decolar);
			System.out.println("O avião de matrícula " + TID + " decolouou na pista " + pista + " em " + (decolar) + " milisegundos.");
			Thread.sleep(afastar);
			System.out.println("O avião de matrícula " + TID + " afastou da área pela pista " + pista + " em " + (afastar) + " milisegundos.");
		} catch (InterruptedException e){
			System.err.println(e.getMessage());
		}
	}
}
