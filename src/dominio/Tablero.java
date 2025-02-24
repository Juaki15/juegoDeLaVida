package dominio;
import java.io.*;
import java.util.*;

/**
 * Esta clase contiene los metodos que usare para generar y hacer que cambien las matrices
 * @author Joaquin Moreno Guzman
 * @version 24-03-2021
 */
public class Tablero {
	private static int DIMENSION  = 30;
    private int[][] estadoActual = new int [DIMENSION][DIMENSION];
    private int[][] estadoSiguiente = new int [DIMENSION][DIMENSION];
    
    /**
     * Este método sirve para generar una matriz de forma aleatoria que contenga 0s y 1s
     */
    public void generarEstadoActual() {
    	for (int i = 0 ; i < DIMENSION; i++) {
    		for (int j = 0; j < DIMENSION; j++) {
    			double elementoArray = Math.random();
    			if (elementoArray < 0.5) {
    				estadoActual[i][j]=0;
    			}
    			if (elementoArray >=0.5) {
    				estadoActual[i][j]= 1;
    			}
    			//System.out.println(estadoActual[i][j]);
    		}
    		//System.out.println();
    	}
    	//System.out.println(estadoActual);
    }
    /**
     * Este es el metodo que servirá para leer la matriz del fichero
     * @param fichero para almacenar la mtriz
     */
    public void leerEstadoActual() {
    	try {
    		File fichero = new File("matriz");
    		Scanner sc = new Scanner (fichero);
    		for (int i = 0; i>DIMENSION; i++) {
    			String linea = sc.nextLine();
    			for (int j = 0; j< DIMENSION; j++) {
    				estadoActual[i+1][j+1] = Integer.parseInt(String.valueOf(linea.charAt(j)));
    			}
    		}
    		//System.out.println(fichero);
    	}catch (FileNotFoundException e) {
    		e.printStackTrace();
    	} 	
    }

    /**
     * Este es el método que sirve para que la matriz vaya cambiando sus ceros y unos segun las reglas del juego de la vida
     * @param c que un contador que sirve para saber si hay 3 celulas vivas alrededor
     */
    public void transitarAlEstadoSiguiente() {
    	int c = 0;
    	for (int i = 0; i < DIMENSION; i++) {
    		for (int j = 0; j < DIMENSION; j++) {
    			if (estadoActual[i][j] == estadoActual[0][0]) {
    				if (estadoActual[i+1][j]==1) {
    					c+=1;
    				}
    				if (estadoActual[i][j+1] == 1) {
    					c+=1;
    				}
    				if (estadoActual[i+1][j+1] == 1) {
    					c+=1;
    				}
    			}
    			if (estadoActual[i][j] == estadoActual[29][0]) {
    				if (estadoActual[i-1][j]==1) {
    					c+=1;
				}
    				if (estadoActual[i][j+1] == 1) {
    					c+=1;
    				}
    				if (estadoActual[i-1][j+1] == 1) {
    					c+=1;
    				}
    			}
    			if (estadoActual[i][j] == estadoActual[0][29]) {
    				if (estadoActual[i][j+1]==1) {
    					c+=1;
    				}
    				if (estadoActual[i+1][j] == 1) {
    					c+=1;
    				}
    				if (estadoActual[i+1][j-1] == 1) {
    					c+=1;
    				}
    			}
    			if (estadoActual[i][j] == estadoActual[29][29]) {
    				if (estadoActual[i-1][j-1]==1) {
    					c+=1;
    				}
    				if (estadoActual[i-1][j] == 1) {
    					c+=1;
    				}
    				if (estadoActual[i][j-1] == 1) {
    					c+=1;
    				}
    			}
    			if (i == 0 && j != 0 && j !=29) {
    				if (estadoActual[i+1][j] == 1) {
    					c+=1;
    				}
    				if (estadoActual[i+1][j+1] == 1) {
    					c+=1;
    				}
    				if (estadoActual[i][j+1] == 1) {
    					c+=1;
    				}
    				if (estadoActual[i+1][j-1] == 1) {
    					c+=1;
    				}
    				if (estadoActual[i][j-1] == 1) {
    					c+=1;
    				}
    			}
    			if (j == 0 && i != 0 && i !=29) {
    				if (estadoActual[i-1][j] == 1) {
    					c+=1;
    				}
    				if (estadoActual[i+1][j] == 1) {
    					c+=1;
    				}
    				if (estadoActual[i+1][j+1] == 1) {
    					c+=1;
    				}
    				if (estadoActual[i][j+1] == 1) {
    					c+=1;
    				}
    				if (estadoActual[i-1][j+1] == 1) {
    					c+=1;
    				}
    			}
    			if (i == 29 && j != 0 && j !=29) {
    				if (estadoActual[i][j+1] == 1) {
    					c+=1;
    				}
    				if (estadoActual[i-1][j-1] == 1) {
    					c+=1;
    				}
    				if (estadoActual[i-1][j] == 1) {
    					c+=1;
    				}
    				if (estadoActual[i-1][j+1] == 1) {
    					c+=1;
    				}
    				if (estadoActual[i][j+1] == 1) {
    					c+=1;
    				}
    			}
    			if (j == 29 && i != 0 && i !=29) {
    				if (estadoActual[i-1][j] == 1) {
    					c+=1;
    				}
    				if (estadoActual[i-1][j-1] == 1) {
    					c+=1;
    				}
    				if (estadoActual[i][j-1] == 1) {
    					c+=1;
    				}
    				if (estadoActual[i+1][j-1] == 1) {
    					c+=1;
    				}
    				if (estadoActual[i+1][j] == 1) {
    					c+=1;
    				}
    			}
    			if (j != 0 && j!= 29 && i != 0 && i !=29) {
    				if (estadoActual[i-1][j] == 1) {
    					c+=1;
    				}
    				if (estadoActual[i+1][j] == 1) {
    					c+=1;
    				}
    				if (estadoActual[i+1][j+1] == 1) {
    					c+=1;
    				}
    				if (estadoActual[i][j+1] == 1) {
    					c+=1;
    				}
    				if (estadoActual[i-1][j+1] == 1) {
    					c+=1;
    				}
    				if (estadoActual[i+1][j-1] == 1) {
    					c+=1;
    				}
    				if (estadoActual[i][j-1] == 1) {
    					c+=1;
    				}
    				if (estadoActual[i-1][j-1] == 1) {
    					c+=1;	
    				}
    			}
    			if (c == 3) {
        			estadoSiguiente[i][j] = 1;
        		}else if(estadoActual[i][j] == 1 && c == 2){
        			estadoActual[i][j] = 1 ;
        		}else {
        			estadoSiguiente[i][j] = 0;
        		}
    		}
    	}
    }

    /**
     * El método toString para imprimir la matriz
     * @param cadena para imprimir los caracteres
     */
    @Override
    public String toString() {
    	StringBuilder cadena = new StringBuilder();
    	for (int i = 1; i < DIMENSION; i++) {
    		for (int j = 0; j<DIMENSION; j++) {
    			if (estadoActual[i][j] == 0) {
    				cadena.append(" ");
    			}
    			if (estadoActual[i][j] == 1 ) {
    				cadena.append("X");
    			}
    		}
    		cadena.append("\n");
    	}
    	return cadena.toString();
    }
}
