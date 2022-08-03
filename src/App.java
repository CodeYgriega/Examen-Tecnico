import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class App {
    public static void main(String[] args) throws Exception {

        //comienza el ejercicio 1: 

        List<Integer> a = new ArrayList<Integer>();
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
    
        List<Integer> b = new ArrayList<Integer>();
        b.add(2);
        b.add(4);
        b.add(5);

        verificarSiContieneElArray(a, b);

        //comienza el ejercicio 3:

        List<Integer> array = new ArrayList<Integer>();
        array.add(44);
        array.add(37);
        array.add(24);
        array.add(50);
        array.add(21);

        calcularMultiploDe7MasCercano(array);

        //comienza el ejercicio 2:

        List<Integer> array1 = new ArrayList<Integer>();
        array1.add(1);
        array1.add(3);
        array1.add(4);
        List<Integer> array2 = new ArrayList<Integer>();
        array2.add(3);
        array2.add(5);
        array2.add(4);
        List<Integer> array3 = new ArrayList<Integer>();
        array3.add(3);
        array3.add(1);
        array3.add(6);

        devolverNuevoArray(array1, array2, array3);
    }

    //funcion del ejercicio 1: 

    public static void verificarSiContieneElArray(List<Integer> primero, List<Integer> segundo){
        if(primero.containsAll(segundo)){
            System.out.println("El array " + primero + " contiene todos los elementos del array " + segundo);
        }
        else{
            System.out.println("El array " + primero + " NO contiene todos los elementos del array " + segundo);
        }
    } 
    
    //funcion del ejercicio 3:

    public static void calcularMultiploDe7MasCercano(List<Integer> array){
        //variables para definir la distancia hasta el multiplo de 7 mas cercano, hacia arriba y abajo
        int distanciaArriba = 0;
        int distanciaAbajo = 0;

        //ordeno el array en forma descendente
        array.sort(Collections.reverseOrder());
        //recorriendo el array, numero por numero
        for(Integer numero : array){
            System.out.println("numero del array: " + numero);

            //si es multiplo de 7, solo lo imprimira y la distancia será 0
            if(esMultiploDe7(numero)){
                distanciaArriba = 0;
                System.out.println("El numero " + numero + " es multiplo de 7 y su distancia es " + distanciaArriba);
            }

            //y sino, empezamos a calcular donde esta su multiplo mas cercano
            else{
                //ciclo para determinar cuanta distancia hacia arriba hay para llegar al multiplo de 7
                for(int i= numero; i <= Integer.MAX_VALUE; i++){
                    //la variable distanciaArriba tendra el valor de las iteraciones hechas
                    distanciaArriba = i;
                    //y el codigo se detendra cuando sea multiplo de 7
                    if(i % 7 == 0) break;
                }
                //finalmente la distancia final hacia arriba sera restando el numero principal y las iteraciones hechas
                //System.out.println("la distancia final hacia arriba es: " + (distanciaArriba - numero));

                //ciclo para determinar cuanta distancia hacia abajo hay para llegar al multiplo de 7
                for(int i= numero; i >= Integer.MIN_VALUE; i--){
                    //la variable distanciaAbajo tendra el valor de las iteraciones hechas
                    distanciaAbajo = i;
                    //y el codigo se detendra cuando sea multiplo de 7
                    if(i % 7 == 0) break;
                }
                //finalmente la distancia final hacia abajo sera restando el numero principal y las iteraciones hechas
                //System.out.println("la distancia final hacia abajo es: " + (numero - distanciaAbajo));

                //ahora esta condicional determinara cual es la menor distancia,
                //si la distancia hacia abajo es menor que la distancia de arriba,
                //entonces se determinara que esa es la menor distancia y sino,
                //la menor distancia sera la distancia hacia arriba
                if((numero - distanciaAbajo) < (distanciaArriba - numero)){
                    System.out.println("La menor distancia es hacia abajo, con: " + (numero - distanciaAbajo));
                }
                else{
                    System.out.println("La menor distancia es hacia arriba, con: " + (distanciaArriba - numero));
                }
            }
        }
    }

    //funcion para saber si es multiplo de 7, usada en el ejercicio 3
    public static boolean esMultiploDe7(Integer numero){
        
        if(numero % 7 == 0){
            return true;
        }
        else{
            return false;
        }

    }
    
    //funcion del ejercicio 2: 
    public static List<Integer> devolverNuevoArray(List<Integer> array1, List<Integer> array2, List<Integer> array3){

        //creamos el array que devolvera la funcion
        List<Integer> arrayFinal = new ArrayList<Integer>();

        //recorremos el primer array
        for(int i = 0; i < array1.size(); i++){
            //variable para poder iterar y multiplicar facilmente
            int numerosDeArray1 = array1.get(i);
        //recorremos el segundo array
            for(int j = 0; j < array1.size(); j++){
                //variable para poder iterar y multiplicar facilmente
                int numerosDeArray2 = array2.get(j);
            //recorremos el tercer array
                for(int k = 0; k < array1.size(); k++){
                    //variable para poder iterar y multiplicar facilmente
                    int numerosDeArray3 = array3.get(k);

                    //prueba para ver que numeros iba tomando en cada iteracion
                    //System.out.println(numerosDeArray1 + "" + numerosDeArray2 + "" + numerosDeArray3);

                    //en esta variable se van guardando los numeros ya multiplicados
                    int numerosMultiplicados = numerosDeArray1 * numerosDeArray2 * numerosDeArray3;

                    //y por ultimo vamos añadiendo cada numero multiplicado al array que vamos a devolver
                    arrayFinal.add(numerosMultiplicados);

                }

            }

        }
        //pintamos el array final y lo retornamos
        System.out.println(arrayFinal);
        return arrayFinal;
    }
}
