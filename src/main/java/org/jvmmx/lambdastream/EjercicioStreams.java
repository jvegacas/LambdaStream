package org.jvmmx.lambdastream;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjercicioStreams {
	
	int a;
	int b;
	
	public EjercicioStreams() {	
	}
	public EjercicioStreams(int a, int b) {	
		this.a = a;
		this.b = b;
	}
	void comprobarthis() {
		System.out.println(this);
	}
	static int aa = 3;
	static int bb;
	static void meth(int x) {
	System.out.println("x = " + x);
	System.out.println("a = " + aa);
	System.out.println("b = " + bb);
	}
	
	
    
    private static final String PALABRA = "[- .:;,¡!]";
    
    /**
     * Cuenta las líneas del archivo usando el reader provisto
     */
    private void ejercicio1() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get("poema.txt"), StandardCharsets.UTF_8)){
            
            // código aquí
        	Integer lineasPoema = (int) reader.lines().count();
        	System.out.println(lineasPoema);
        }
    }

    /**
     * Crea una lista de palabras sin duplicados del archivo provisto en reader
     * Tip: Ya se cuenta con la expresión PALABRA
     */
    private void ejercicio2() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get("poema.txt"), StandardCharsets.UTF_8)){
            
 //            código aquí
 //       	List<String> palabras=reader.lines().peek(System.out::println).count();
//        	Long numero =reader.lines()
//        		//			.peek(System.out::println)
//        					.flatMap(l->Stream.of(l.split(PALABRA)))
//        		//			.peek(System.out::println)
//        					.map(p->p.toUpperCase().trim())
//        					.filter(p -> !p.isEmpty())
//        					.distinct()
//        					.sorted()
//        		//			.peek(System.out::println)
//        					.count();
//        		//			.peek(System.out::println)
//        			//		.distinct();
//        			//		.peek(System.out::println);
//        					
//        	System.out.println(numero);
        	
        	List<String> palabras = reader.lines()
        		//	.peek(System.out::println)
					.flatMap(l->Stream.of(l.split(PALABRA)))
				//	.peek(System.out::println)
					.map(p->p.toUpperCase().trim())
					.filter(p -> !p.isEmpty())
					.distinct()
					.sorted()
				//	.peek(System.out::println)
					.collect(Collectors.toList());
					
					
       	palabras.stream().forEach(p->System.out.println("palabra :"+p));
        								
        								
   
        }
    }
    
    /**
     * Crea una lista de palabras en minusculas y sin duplicados 
     * del archivo provisto en reader y ordenadas alfabéticamente
     */
    private void ejercicio3() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get("poema.txt"), StandardCharsets.UTF_8)){
            
            // código aquí
            
        }
    }
    
    /**
     * Modifica el ejercicio3 para que las palabras esten ordenadas por longitud
     */
    private void ejercicio4() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get("poema.txt"), StandardCharsets.UTF_8)){
            
            List<String> palabrasOrdenadasLongitud = reader.lines()
            												.flatMap(t->Stream.of(t.split(PALABRA)))
            												.map(String::trim)
            												.map(String::toLowerCase)
            												.distinct()
            												.sorted((p1,p2)->p2.length()-p1.length())
            												.peek(System.out::println)
            												.collect(Collectors.toList());
            
        }
    }
    
    /**
     * Has un histograma de cada palabra que aparece, todas en minúsculas
     */
    private void ejercicio5() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get("poema.txt"), StandardCharsets.UTF_8)){
            
            // código aquí
        	Map<String, Long> histograma = new HashMap<String, Long>();
        	histograma = reader.lines()
        						.flatMap(linea->Stream.of(linea.split(PALABRA)))
        						.filter(p->!p.isEmpty())
        						.map(String::trim)
        						.map(String::toLowerCase)
        						.collect(Collectors.groupingBy(
        								             Function.identity(), 
        								             Collectors.counting()));
        	
        	ArrayList<Entry<String, Long>> list = new ArrayList<>(histograma.entrySet());
        	Collections.sort(list, valueComparator);
   //     	Collections.sort(list, Map.Entry.comparingByValue(Comparator.reverseOrder()));
        	
        	
        	for(Entry<String, Long> letra:list) {
        		System.out.println(letra);
        	}
        	
        	
        	
        	
        	
//        	
//        	for (Entry<String, Long> jugador : histograma.entrySet()){
//        		String clave = jugador.getKey();
//        		Long valor = jugador.getValue();
//        		System.out.println(clave+"  ->  "+valor);
//        	}
        }
    }
    
    /**
     * Complementa el código para la clase RandomWords 
     * con una lista de 1000 palabras agrupalas por longitud
     */
    private void ejercicio6() throws IOException {
//        RandomWords rand = new RandomWords();
//        List<String> list = rand.createList(1000);
        System.out.println(this);
//        for(String obj : list) {
//        	System.out.println(obj);
//        }
//      
        
    }
    
    
    public static void main(String[] args) throws IOException {
        EjercicioStreams es = new EjercicioStreams();
        System.out.println("Lambdas y Stream API EjercicioStreams");
//        System.out.println("Ejercicio 1");
//        es.ejercicio1();
//        System.out.println("Ejercicio 2");
//        es.ejercicio2();
//        System.out.println("Ejercicio 3");
//        es.ejercicio3();
//        System.out.println("Ejercicio 4");
//        es.ejercicio4();
//        System.out.println("Ejercicio 5");
//        es.ejercicio5();
//        System.out.println("Ejercicio 6");
//        es.ejercicio6();
        
        EjercicioStreams ob1 = new EjercicioStreams();
        ob1.a=1;
        ob1.b=2;
        EjercicioStreams ob2 = new EjercicioStreams(4,6);
        ob2=ob1;
        ob1.a=3;
        System.out.println(ob1.a + " " + ob1.b);
        System.out.println(ob1.hashCode());
        System.out.println(ob2.a + " " + ob2.b);
        System.out.println(ob2.hashCode());
        
        ob1.comprobarthis();
        ob2.comprobarthis();
       
        EjercicioStreams.bb=3;
        EjercicioStreams.meth(47);
       
        System.out.println("*******************");
        String strOb1 = "First String";
        String strOb2 = "Second String";
        String strOb3 = "First String ";
        System.out.println("Length of strOb1: " +
        strOb1.length());
        System.out.println("Char at index 3 in strOb1: " +
        strOb1.charAt(3));
        if(strOb1.equals(strOb2))
        System.out.println("strOb1 == strOb2");
        else
        System.out.println("strOb1 != strOb2");
        if(strOb1.equals(strOb3))
        System.out.println("strOb1 == strOb3");
        else
        System.out.println("strOb1 != strOb3");
        
        System.out.println(strOb1.hashCode());
        strOb3.trim();
        System.out.println(strOb3
        		.hashCode());
        
    }
    
    static {
    	System.out.println("Static block initialized.");
    	bb = aa * 4;
    	}
    
    Comparator<Entry<String, Long>> valueComparator = new Comparator<Entry<String, Long>>() {

	    @Override
	    public int compare(Entry<String, Long> e1, Entry<String, Long> e2) {
	        return e2.getValue().compareTo(e1.getValue());
	    }
	};
    
}
