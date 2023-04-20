import java.util.Scanner;

public class Taller02 {

    public static void main(String[] args) {
        
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

    public static void matriz(String[] args) {
        
    }



}


