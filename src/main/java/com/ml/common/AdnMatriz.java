package com.ml.common;

public class AdnMatriz {
	private char[][] adnMatriz;
	private int totalSecuencias;
	
	public char[][] getAdnMatriz() {
		return adnMatriz;
	}
	public void setAdnMatriz(char[][] adnMatriz) {
		this.adnMatriz = adnMatriz;
	}
	public int getTotalSecuencias() {
		return totalSecuencias;
	}
	public void setTotalSecuencias(int totalSecuencias) {
		this.totalSecuencias = totalSecuencias;
	}
	
	public void incrementarEnUnoSecuencia() {
		this.totalSecuencias = this.totalSecuencias + 1;
	}
}
