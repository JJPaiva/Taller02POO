
import java.util.Scanner;

public class Validaciones {

    public static int[][] matriz= new int[10][3];

    public static void main(String[] args) {
        EditarDisponibilidad(1234123, 10);
        System.out.println(matriz[0][0]);
    }

    public static String Input() {
        Scanner sn = new Scanner(System.in);
        String aux;
        aux = sn.nextLine();
        return aux;
    }

    public static String formatoInput(String valor){
        Scanner sn = new Scanner(System.in);
        while(!valor.matches("[0-9]*$")){
            System.out.println("Por favor ingrese un valor correcto");
            valor = sn.nextLine();
        }
        return valor;
    }
    
    public static int stringToInt(String valor) {
        int aux= Integer.parseInt(valor);
        return aux;
    }

    public static int InputNumeroPositivo(String[] args){
        return stringToInt(formatoInput(Input()));
    }

    public static int[] valores(int val1, int val2) {
        int[] arr= new int[2];
        arr[0]=val1;
        arr[1]=val2;
        return arr;
    }

    public static void EditarDisponibilidad(int val1, int val2) {
        try {
            matriz[val1-1][0]=val2;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Se ha ingresado un numero de habitación inexixstente");
        }
    }



}


