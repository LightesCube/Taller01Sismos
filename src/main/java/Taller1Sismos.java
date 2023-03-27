import java.util.Random;
import java.util.Scanner;
import java.util.*;
public class Taller1Sismos {

        public static void main(String[] args) {
            introduccion();
        }

        public static void introduccion() {
            double[][] registro_sismico = new double[10][7];
            menu(registro_sismico);
        }

        public static void menu(double[][] registro_sismico) {
            boolean seguir = true;
            Scanner intro = new Scanner(System.in); //metodo de menu
            do {
                System.out.println("Bienvenido al menu, ingrese su opcion");
                System.out.println("(1) Ingresar Datos");
                System.out.println("(2) Mostar Sismo de mayor magnitud");
                System.out.println("(3) Contar sismos mayores o iguales a 5.0");
                System.out.println("(4) Enviar SMS por cada sismo mayor o igual a 7.0");
                System.out.println("(5) Salir");
                int opcion = intro.nextInt();
                switch (opcion) {
                    case 1:
                        llenarArreglo(registro_sismico);
                        break;
                    case 2:
                        buscarMayorSismo(registro_sismico);
                        break;
                    case 3:
                        contarSismos(registro_sismico);
                        break;
                    case 4:
                        enviarSMS(registro_sismico);
                        break;
                    case 5:
                        salir();
                        break;
                    default:

                        System.out.println("La opcion escogida no es valida, seleccione una nuevamente");
                }
            } while (seguir);
        }

        public static void llenarArreglo(double[][] registro_sismico) {  // simular el ingreso de datos con valores aleatorios entre 0.0 y 9.9 y retorna el arreglo.
            Random ran = new Random(); //metodo de random
            for (int i = 0; i < registro_sismico.length; i++) {
                for (int j = 0; j < registro_sismico[i].length; j++) {
                    registro_sismico[i][j] = ran.nextDouble(0, 9.9);
                }
            }
        }

        public static void buscarMayorSismo(double[][] registro_sismico) {  // retornar un valor con la magnitud del sismo de mayor intensidad.
            double mayorSismo = registro_sismico[0][0];
            for (int i = 0; i < registro_sismico.length; i++) {
                for (int j = 0; j < registro_sismico[i].length; j++) {
                    if (mayorSismo < registro_sismico[i][j]) {
                        mayorSismo = registro_sismico[i][j];
                    }
                }
            }
            System.out.println("El sismo de mayor intensidad fue de " + mayorSismo);
        }

        public static void contarSismos(double[][] registro_sismo) {  // retornar un valor que indica cuantos sismos se han producido con una magnitud mayor o igual a 5.0
            int numeroSismo = 0;
            for (int i = 0; i < registro_sismo.length; i++) {
                for (int j = 0; j < registro_sismo[i].length; j++) {
                    if (registro_sismo[i][j] >= 5.0) {
                        numeroSismo++;
                    }
                }
            }
            System.out.println("Hubieron " + numeroSismo + " con magnitud 5.0 o mayor");
        }

        public static void enviarSMS(double[][] registro_sismico) {  // simular un mensaje SMS por pantalla, retornando una String por cada sismo de magnitud mayor o igual a 7.0, con el mensaje: "Alerta!!! se debe evacuar zona costera!"
            for (int i = 0; i < registro_sismico.length; i++) {
                for (int j = 0; j < registro_sismico[i].length; j++) {
                    if (registro_sismico[i][j] >= 7.0) {
                        System.out.println("Alerta!!! se debe evacuar zona costera!");
                    }
                }
            }
        }

        public static void salir() {  // permite decidir si el usuario desea salir o no del programa.
            System.exit(0);
        }
    }

