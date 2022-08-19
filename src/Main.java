import org.w3c.dom.css.Counter;

import java.util.*;
import java.util.stream.IntStream;


public class Main {

    static Scanner s = new Scanner(System.in);
    static List<Integer>monedas = new ArrayList<>();
    static List <Integer> productos = List.of(270, 340, 390);
    static List <Integer> montos = List.of(100, 50, 10);

    public static void main(String[] args) {
        //Lista de comidas para escoger
        System.out.println("1. Sandwich   $270");
        System.out.println("2. Churrasco   $340");
        System.out.println("3. Milanesa   $390");
        System.out.print("Escoja el producto que desee: ");
        int comida = s.nextInt(); //por teclado escoje la opcion que desea consumir

        int paga = pagado(pagar(productos.get(comida-1)));
        int producto = productos.get(comida-1);
        cambio(paga, producto);

    }
    public static List<Integer> pagar(int producto){
        //el producto escogido es recibido en el metodo
        //mientras que el monto a pagar sea menor que el precio del producto este seguira pidiendo que ingrese
        while(pagado(monedas)<=producto){
            System.out.print("Ingrese monto a pagar: ");
            int moneda = s.nextInt();
            if(montos.contains(moneda)){
                monedas.add(moneda);
            }else{
                System.out.println("Solo se acepta monedas de 100, 50 y 10");
            }
        }
        return monedas;
    }

    public static int pagado (List<Integer>monedas){
        //sume de todas las monedas ingresadas --pagar--
        int paga = 0;
        for(int i:monedas){paga = paga+i;}
        return paga;
    }

    public static void cambio(int paga, int producto){
        //resta el pago con el precio del producto y el cambio lo va comparanod para dar el cambio correspondiente
        int residuo = paga - producto;
        System.out.println("Usted pago: "+paga+" y su cambio es de: "+residuo);
        System.out.println("Su cambio es el siguiente:");
        while(residuo!=0){
            if(residuo>=100){
                System.out.println(100);
                residuo -= 100;
            }else if(residuo>=50 && 100 >= residuo){
                System.out.println(50);
                residuo -= 50;
            }else if(residuo>=10 && residuo<=50){
                System.out.println(10);
                residuo -= 10;
            }
        }
    }

}
