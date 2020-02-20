package com.ml.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ml.common.AdnMatriz;
import com.ml.common.EsUnMutanteException;
import com.ml.controller.StatResponse;
import com.ml.dao.IStatDao;
import com.ml.entities.Stat;

@Service
public class ADNServiceImpl implements ADNService{
	private final static int OCURRENCIAS_SER_MUTANTE = 2;

	@Autowired
	private IStatDao iStatDao;
	
	@Override
	public AdnMatriz convertirArrayStringEnMatriz(String[] dna) {
		int totalFilasYColumnas = dna.length;
		AdnMatriz adnMatriz = new AdnMatriz();
		
		char[][] adnCharMatriz = new char[totalFilasYColumnas][totalFilasYColumnas];
		
		for(int fila = 0; fila < totalFilasYColumnas; fila++) {
			adnCharMatriz[fila] = dna[fila].toCharArray();
		}
		
		adnMatriz.setAdnMatriz(adnCharMatriz);
		return adnMatriz;
	}

	@Override
	public void esMutanteRecorriendoHorizontal(AdnMatriz adnMatriz) {		
		int totalColumnasYFilas = adnMatriz.getAdnMatriz()[0].length;
		int totalCoincidenciaLetraAnterior = 0;
		char letraAnteriorADN; 
		
		for(int fila = 0; fila < totalColumnasYFilas; fila++) {
			letraAnteriorADN = '-'; //Asigno un valor que no se corresponde con el ADN mutante
			
			for(int columna = 0; columna < totalColumnasYFilas; columna++) {
				char letraActualADN = adnMatriz.getAdnMatriz()[fila][columna];
				
				if(letraActualADN == letraAnteriorADN) {
					totalCoincidenciaLetraAnterior++;
				} else {
					totalCoincidenciaLetraAnterior = 0;
				}
				
				letraAnteriorADN = letraActualADN;
						
				if(totalCoincidenciaLetraAnterior == 3) {
					System.out.println("Encontro una secuencia horizontal - fila: " + fila + " letra: " + letraActualADN);
					adnMatriz.incrementarEnUnoSecuencia();
					
					if(adnMatriz.getTotalSecuencias() >= OCURRENCIAS_SER_MUTANTE) {
						throw new EsUnMutanteException();
					}
				}
			
			}
		}
		
	}
	

	@Override
	public void esMutanteRecorriendoVertical(AdnMatriz adnMatriz) {
		int totalColumnasYFilas = adnMatriz.getAdnMatriz()[0].length;
		int totalCoincidenciaLetraAnterior = 0;
		char letraAnteriorADN; 
	
		for(int columna = 0; columna < totalColumnasYFilas; columna++) {		
		
			letraAnteriorADN = '-'; //Asigno un valor que no se corresponde con el ADN mutante
			
			for(int fila = 0; fila < totalColumnasYFilas; fila++) {
				char letraActualADN = adnMatriz.getAdnMatriz()[fila][columna];
				
				if(letraActualADN == letraAnteriorADN) {
					totalCoincidenciaLetraAnterior++;
				} else {
					totalCoincidenciaLetraAnterior = 0;
				}
				
				letraAnteriorADN = letraActualADN;
						
				if(totalCoincidenciaLetraAnterior == 3) {
					System.out.println("Encontro una secuencia vertical - columna: " + fila + " letra: " + letraActualADN);
					adnMatriz.incrementarEnUnoSecuencia();
					
					if(adnMatriz.getTotalSecuencias() >= OCURRENCIAS_SER_MUTANTE) {
						throw new EsUnMutanteException();
					}
				}
			
			}
		}
		
	}
	
	//Triangulo con diagonal izquierda a derecha
	/*INPUT
	A T G C G A
	C A G T G C
	T T A T G T
	A G A A G G
	C C C C T A
	T C A C T G
	
	Metodo analiza:
	A T G C G A
	  A G T G C
	    A T G T
	      A G G
	        T A
	          G
	          */
	@Override
	public void esMutanteRecorriendoOblicuoDiagonalIzqaDerechaPart1(AdnMatriz adnMatriz) {
		int totalColumnasYFilas = adnMatriz.getAdnMatriz()[0].length;
		//QQQ Valido que la cantidad de columnas sea mayor o igual para que puedan aparecer coincidencias oblicuoas
		if(totalColumnasYFilas < 4) {
			return;
		}
		
		int totalCoincidenciaLetraAnterior = 0;
		char letraAnteriorADN; 
	
		for(int columna = totalColumnasYFilas ; columna > 0; columna--) {
			int totalCasillerosOblicuosDisponible = (totalColumnasYFilas - columna) + 1;
			
			if( totalCasillerosOblicuosDisponible >= 4) {
				//QQQ Significa que puede existir la posibilidad de que haya 4 en secuencia 
				
				letraAnteriorADN = '-'; //Asigno un valor que no se corresponde con el ADN mutante
				
				for(int fila = 0; fila < totalCasillerosOblicuosDisponible; fila++) {
					char letraActualADN = adnMatriz.getAdnMatriz()[fila][(columna - 1) + fila];
					if(letraActualADN == letraAnteriorADN) {
						totalCoincidenciaLetraAnterior++;
					} else {
						totalCoincidenciaLetraAnterior = 0;
					}
					
					letraAnteriorADN = letraActualADN;
							
					if(totalCoincidenciaLetraAnterior == 3) {
						System.out.println("Encontro una secuencia oblicua desde la derecha - columna: " + (columna -1) + " letra: " + letraActualADN);
						adnMatriz.incrementarEnUnoSecuencia();
						
						if(adnMatriz.getTotalSecuencias() >= OCURRENCIAS_SER_MUTANTE) {
							throw new EsUnMutanteException();
						}
					}
				
				}
			}
		}

	}

	//Triangulo con diagonal izquierda a derecha
	/*INPUT
	A T G C G A
	C A G T G C
	T T A T G T
	A G A A G G
	C C C C T A
	T C A C T G
	
	Metodo analiza:
	           
	C          
	T T        
	A G A      
	C C C C    
	T C A C T G
	          */
	@Override
	public void esMutanteRecorriendoOblicuoDiagonalIzqaDerechaPart2(AdnMatriz adnMatriz) {
		int totalColumnasYFilas = adnMatriz.getAdnMatriz()[0].length;
		//QQQ Valido que la cantidad de columnas sea mayor o igual para que puedan aparecer coincidencias oblicuoas
		if(totalColumnasYFilas < 4) {
			return;
		}
		
		int totalCoincidenciaLetraAnterior = 0;
		char letraAnteriorADN; 
	
		for(int fila = 1 ; fila < totalColumnasYFilas; fila++) {
			int totalCasillerosOblicuosDisponible = totalColumnasYFilas - fila;
			
			if( totalCasillerosOblicuosDisponible >= 4) {
				//QQQ Significa que puede existir la posibilidad de que haya 4 en secuencia 
				
				letraAnteriorADN = '-'; //Asigno un valor que no se corresponde con el ADN mutante
				
				for(int columna = 0; columna < totalCasillerosOblicuosDisponible; columna++) {
					char letraActualADN = adnMatriz.getAdnMatriz()[columna + fila][columna];
					if(letraActualADN == letraAnteriorADN) {
						totalCoincidenciaLetraAnterior++;
					} else {
						totalCoincidenciaLetraAnterior = 0;
					}
					
					letraAnteriorADN = letraActualADN;
							
					if(totalCoincidenciaLetraAnterior == 3) {
						System.out.println("Encontro una secuencia oblicua desde la derecha - columna: " + (columna -1) + " letra: " + letraActualADN);
						adnMatriz.incrementarEnUnoSecuencia();
						
						if(adnMatriz.getTotalSecuencias() >= OCURRENCIAS_SER_MUTANTE) {
							throw new EsUnMutanteException();
						}
					}
				
				}
			}
		}
	}
	
	
	//Triangulo con diagonal derecha a izquierda
	/*INPUT
	A T G C G A
	C A G T G C
	T T A T G T
	A G A A G G
	C C C C T A
	T C A C T G
		
	Metodo analiza:
	A T G C G A
	C A G T G 
	T T A T  
	A G A   
	C C    
	T     
	*/
		
	@Override
	public void esMutanteRecorriendoOblicuoDiagonalDerechaAizqPart1(AdnMatriz adnMatriz) {
		int totalColumnasYFilas = adnMatriz.getAdnMatriz()[0].length;
		//QQQ Valido que la cantidad de columnas sea mayor o igual para que puedan aparecer coincidencias oblicuoas
		if(totalColumnasYFilas < 4) {
			return;
		}
		
		int totalCoincidenciaLetraAnterior = 0;
		char letraAnteriorADN; 
	
		for(int columna = totalColumnasYFilas ; columna > 0; columna--) {
			int totalCasillerosOblicuosDisponible = columna;
			
			if( totalCasillerosOblicuosDisponible >= 4) {
				//QQQ Significa que puede existir la posibilidad de que haya 4 en secuencia 
				
				letraAnteriorADN = '-'; //Asigno un valor que no se corresponde con el ADN mutante
				
				for(int fila = 0; fila < totalCasillerosOblicuosDisponible; fila++) {
					char letraActualADN = adnMatriz.getAdnMatriz()[fila][(columna - 1) - fila];
					if(letraActualADN == letraAnteriorADN) {
						totalCoincidenciaLetraAnterior++;
					} else {
						totalCoincidenciaLetraAnterior = 0;
					}
					
					letraAnteriorADN = letraActualADN;
							
					if(totalCoincidenciaLetraAnterior == 3) {
						System.out.println("Encontro una secuencia oblicua desde la derecha - columna: " + (columna -1) + " letra: " + letraActualADN);
						adnMatriz.incrementarEnUnoSecuencia();
						
						if(adnMatriz.getTotalSecuencias() >= OCURRENCIAS_SER_MUTANTE) {
							throw new EsUnMutanteException();
						}
					}
				
				}
			}
		}
		
	}

	//Triangulo con diagonal derecha a izquierda
	/*INPUT
	A T G C G A
	C A G T G C
	T T A T G T
	A G A A G G
	C C C C T A
	T C A C T G
		
	Metodo analiza:
	           
	          C
	        G T
	      A G G
	    C C T A
	  C A C T G  
	*/
	@Override
	public void esMutanteRecorriendoOblicuoDiagonalDerechaAizqPart2(AdnMatriz adnMatriz) {
		int totalColumnasYFilas = adnMatriz.getAdnMatriz()[0].length;
		//QQQ Valido que la cantidad de columnas sea mayor o igual para que puedan aparecer coincidencias oblicuoas
		if(totalColumnasYFilas < 4) {
			return;
		}
		
		int totalCoincidenciaLetraAnterior = 0;
		char letraAnteriorADN; 
	
		for(int fila = 1 ; fila < totalColumnasYFilas; fila++) {
			int totalCasillerosOblicuosDisponible = totalColumnasYFilas - fila;
			
			if( totalCasillerosOblicuosDisponible >= 4) {
				//QQQ Significa que puede existir la posibilidad de que haya 4 en secuencia 
				
				letraAnteriorADN = '-'; //Asigno un valor que no se corresponde con el ADN mutante
				
				for(int columna = 0; columna < totalCasillerosOblicuosDisponible; columna++) {
					char letraActualADN = adnMatriz.getAdnMatriz()[columna + fila][totalColumnasYFilas - columna - 1];
					if(letraActualADN == letraAnteriorADN) {
						totalCoincidenciaLetraAnterior++;
					} else {
						totalCoincidenciaLetraAnterior = 0;
					}
					
					letraAnteriorADN = letraActualADN;
							
					if(totalCoincidenciaLetraAnterior == 3) {
						System.out.println("Encontro una secuencia oblicua desde la derecha - columna: " + (columna -1) + " letra: " + letraActualADN);
						adnMatriz.incrementarEnUnoSecuencia();
						
						if(adnMatriz.getTotalSecuencias() >= OCURRENCIAS_SER_MUTANTE) {
							throw new EsUnMutanteException();
						}
					}
				
				}
			}
		}
		
	}

	@Override
	public void analizarSiEsMutanteONo(String[] dna) {
		try {
		//QQQ Convertir los string en una matriz n x n
		AdnMatriz adnMatriz = convertirArrayStringEnMatriz(dna);

		//QQQ Recorrer la matriz forma horizontal
		esMutanteRecorriendoHorizontal(adnMatriz);

		//QQQ Recorrer en forma vertical
		esMutanteRecorriendoVertical(adnMatriz);

		//QQQ Recorrer en forma oblicual de izquierda a derecha
		esMutanteRecorriendoOblicuoDiagonalIzqaDerechaPart1(adnMatriz);
		esMutanteRecorriendoOblicuoDiagonalIzqaDerechaPart2(adnMatriz);
		
		//QQQ Recorrer en forma oblicual de derecha a izq
		esMutanteRecorriendoOblicuoDiagonalDerechaAizqPart1(adnMatriz);
		esMutanteRecorriendoOblicuoDiagonalDerechaAizqPart2(adnMatriz);
		
		} catch (EsUnMutanteException e) {
			grabarBDEsMutanteOno("M");
			throw e;
		}
		
		grabarBDEsMutanteOno("N");
	}

	private void grabarBDEsMutanteOno(String type) {
		Stat stat = new Stat();
		stat.setType(type);
		this.iStatDao.save(stat);
	}

	@Override
	public Stat save(Stat stat) {
		return iStatDao.save(stat);
	}

	@Override
	public long countByType(String type) {
		long m = iStatDao.countByType("M");
		long n = iStatDao.countByType("N");
		return 0;
	}

	@Override
	public StatResponse obtenerEstadisticasInvocacionesADN() {
		long count_mutant_dna = iStatDao.countByType("M");
		long count_human_dna = iStatDao.countByType("N");
		
		long total = count_mutant_dna + count_human_dna;
		double ratio = 0.0;
		
		if(total > 0) {
			ratio = (double) count_mutant_dna / total;
		} 
		return new StatResponse(count_mutant_dna, count_human_dna, ratio);
	}
	
}
