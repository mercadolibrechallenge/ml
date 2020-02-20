package com.ml.services;

import com.ml.common.AdnMatriz;
import com.ml.controller.StatResponse;
import com.ml.entities.Stat;

public interface ADNService {
	
	//QQQ Analizar si a partir un matriz ADN es un mutante o no
	public void analizarSiEsMutanteONo(String[] dna);
	
	//QQQ Convertir los string en una matriz n x n
	public AdnMatriz convertirArrayStringEnMatriz(String[] dna);

	//QQQ Recorrer la matriz forma horizontal
	public void esMutanteRecorriendoHorizontal(AdnMatriz adnMatriz);

	//QQQ Recorrer en forma vertical
	public void esMutanteRecorriendoVertical(AdnMatriz adnMatriz);

	//QQQ Recorrer en forma oblicual de izquierda a derecha
	public void  esMutanteRecorriendoOblicuoDiagonalIzqaDerechaPart1(AdnMatriz adnMatriz);
	public void  esMutanteRecorriendoOblicuoDiagonalIzqaDerechaPart2(AdnMatriz adnMatriz);
	
	//QQQ Recorrer en forma oblicual de derecha a izq
	public void  esMutanteRecorriendoOblicuoDiagonalDerechaAizqPart1(AdnMatriz adnMatriz);
	public void  esMutanteRecorriendoOblicuoDiagonalDerechaAizqPart2(AdnMatriz adnMatriz);
	
	//QQQ Informa estadistica del adn
	public StatResponse obtenerEstadisticasInvocacionesADN();
	
	public Stat save(Stat stat);
	public long countByType(String type);
}
