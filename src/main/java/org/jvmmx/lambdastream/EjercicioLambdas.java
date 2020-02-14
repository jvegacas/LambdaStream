package org.jvmmx.lambdastream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjercicioLambdas {


    /**
     * Imprimir una cadena formada de la primer letra de cada palabra en la lista
     */
    private void ejercicio1() {
        List<String> list = Arrays.asList(
                "Abraham", "Carlos", "Daniel","Esteban","Francisco","Gustavo","Hugo","Ignacio"
        );
        
        list.forEach(p->System.out.print(p.charAt(0)));
        System.out.println();
        StringBuilder resultado = new StringBuilder();
        list.forEach(l->resultado.append(l.charAt(0)).append(" "));
        System.out.println("Resultado: "+resultado);
    }
    
    /**
     * Imprimir sólo las palabras de longitud par
     */
    private void ejercicio2() {
        List<String> list = new ArrayList<>( Arrays.asList(
                "Abraham", "Carlos", "Daniel","Esteban","Francisco","Gustavo","Hugo","Ignacio"
        ));
        
        list.removeIf(p->p.length()%2!=0);
        list.forEach(p->System.out.println(p.toString()));
       

       

        
        
    }
    
    /**
     * Imprimir las palabras convertidas a mayúsculas 
     */
    private void ejercicio3() {
        List<String> list = Arrays.asList(
                "Abraham", "Carlos", "Daniel","Esteban","Francisco","Gustavo","Hugo","Ignacio"
        );
        
        StringBuilder res = new StringBuilder();
        
        list.forEach(p->res.append(p.toUpperCase()).append(" "));
        String resu=res.toString().trim();
        System.out.println("longitud de res: "+res.length()+" longitud de resu:"+resu.length());
        System.out.println("Resultado: " +res.toString().trim());
    }
    
    /**
     * Crear un hilo que imprima los números de la lista
     */
    private void ejercicio4() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        Long a = 500L;
		(new Thread(() -> list.forEach(System.out::println))).start();
    }
    
    /**
     * Crear un método que me filtre por palabras pares y lo muestre
     */
    private void ejercicio5() {
    	List<String> list = new ArrayList<>( Arrays.asList(
                "Abraham", "Carlos", "Daniel","Esteban","Francisco","Gustavo","Hugo","Ignacio"
        ));
    	list.stream().filter(l->l.length()%2!=0).forEach(l->System.out.println(l.toUpperCase())); 
    }
    
    public static void main(String[] args) {
        EjercicioLambdas el = new EjercicioLambdas();
        System.out.println("Lambdas y Stream API EjercicioLambdas");
        System.out.println("Ejercicio 1");
        el.ejercicio1();
        System.out.println("Ejercicio 2");
        el.ejercicio2();
        System.out.println("Ejercicio 3");
        el.ejercicio3();
        System.out.println("Ejercicio 4");
        el.ejercicio4();
        System.out.println("Ejercicio 5");
        el.ejercicio5();
        System.out.println();
        
        Stream.of("one", "two", "three", "four")
        .filter(e -> e.length() > 3)
        .peek(e -> System.out.println("Filtered value: " + e))
        .map(String::toUpperCase)
        .peek(e -> System.out.println("Mapped value: " + e))
        .collect(Collectors.toList());
        
        Person lokesh = new Person(1, "Lokesh8", "Kolen");
        Person brian = new Person(2, "Brian", "Clooney");
        Person alex = new Person(3, "Alex", "kolen");
         
        //Add some random persons
        List<Person> list = Arrays.asList(lokesh,brian,alex,lokesh,brian,lokesh);
 
        // Get distinct objects by key
        List<Person> distinctElements = list.stream()
                            //              .filter( distinctByKey(p -> p.getApellido().toUpperCase()) )
        					//				.distinct()
        									.sorted((o1,o2)->o1.getNombre().compareTo(o2.getNombre()))
                                            .collect( Collectors.toList() );
 
        // Let's verify distinct elements
        System.out.println( distinctElements );
        
        List<Integer> lista = Arrays.asList(-9, -18, 0, 25, 4); 
        
        System.out.print("The maximum value is : "); 
  
        // Using stream.max() to get maximum 
        // element according to provided Comparator 
        // and storing in variable var 
        int a=3;
        int var = lista.stream().mapToInt(p->p).filter(p->p>a).sum();
   //     int var = lista.stream().mapToInt(p->p).filter(p->p>a).sum();
        System.out.print(var); 
        
       
    
        
        
    }
    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor){
        Map<Object, Boolean> map = new HashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }



}
