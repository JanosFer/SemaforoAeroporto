package view;

import java.util.concurrent.Semaphore;

import controller.ThreadDecolagem;

public class Principal {

	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(2);
		for(int i = 0; i < 12; i++) {
			ThreadDecolagem t = new ThreadDecolagem(semaforo);
			t.start();
		}
	}

}
