import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Crear un algoritmo para jugar a tres en raya: en una cuadrícula de tres celdas por tres, los jugadores se turnan para escribir su símbolo (X y O) en una celda vacía. El primer jugador que logre alinear (en fila, columna o diagonal) tres de sus símbolos, gana.

        //Declaración de variables
        String[][] tablero = new String[3][3];
        int fila, columna;
        String jugador = "X";
        boolean ganador = false;
        int contador = 0;

        //Inicializar el tablero
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = " ";
            }
        }

        //Bucle principal del juego (mientras no haya ganador y no se hayan jugado todas las casillas)
        while (!ganador && contador < 9) {
            //Mostrar el tablero
            System.out.println("  0 1 2");
            for (int i = 0; i < tablero.length; i++) {
                System.out.print(i + " ");
                for (int j = 0; j < tablero[i].length; j++) {
                    System.out.print(tablero[i][j] + " ");
                }
                System.out.println();
            }

            //Pedir al usuario la fila y la columna
            System.out.println("Jugador " + jugador + ", introduce la fila y la columna");
            fila = scanner.nextInt();
            columna = scanner.nextInt();

            //Comprobar si la casilla está vacía
            if (tablero[fila][columna].equals(" ")) {
                //Si está vacía, poner el símbolo del jugador
                tablero[fila][columna] = jugador;
                //Cambiar de jugador
                if (jugador.equals("X")) {
                    jugador = "O";
                } else {
                    jugador = "X";
                }
                //Incrementar el contador
                contador++;
            } else {
                //Si no está vacía, mostrar un mensaje de error
                System.out.println("Casilla ocupada");
            }

            //Comprobar si hay ganador
            //Comprobar filas
            for (int i = 0; i < tablero.length; i++) {
                if (tablero[i][0].equals(tablero[i][1]) && tablero[i][0].equals(tablero[i][2]) && !tablero[i][0].equals(" ")) {
                    ganador = true;
                }
            }

            //Comprobar columnas
            for (int i = 0; i < tablero.length; i++) {
                if (tablero[0][i].equals(tablero[1][i]) && tablero[0][i].equals(tablero[2][i]) && !tablero[0][i].equals(" ")) {
                    ganador = true;
                }
            }

            //Comprobar diagonales
            if (tablero[0][0].equals(tablero[1][1]) && tablero[0][0].equals(tablero[2][2]) && !tablero[0][0].equals(" ")) {
                ganador = true;
            }
            if (tablero[0][2].equals(tablero[1][1]) && tablero[0][2].equals(tablero[2][0]) && !tablero[0][2].equals(" ")) {
                ganador = true;
            }

        }
    }
}