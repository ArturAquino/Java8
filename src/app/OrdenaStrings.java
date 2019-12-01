package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {
    public static void main(String[] args) {
        List<String> palavras = new ArrayList<String>();
        palavras.add("Alura online");
        palavras.add("Casa do Codigo");
        palavras.add("Caelum");

        // Old format
        Collections.sort(palavras);
        System.out.println("Old form: " + palavras);
        
        // Using Default Methods
        Comparator<String> comparador = new ComparadorDeStringPorTamanho();
        // Model 1
        Collections.sort(palavras, comparador);
        System.out.println("Using Default Methods, model 1: " + palavras);
        // Model 2
        palavras.sort(comparador);
        System.out.println("Using Default Methods, model 2: " + palavras);
        // Model 3
        palavras.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(s1.length() < s2.length()) 
                    return -1;
                if(s1.length() > s2.length()) 
                    return 1;
                return 0;
            }
        });

        // Model 4
        palavras.sort((String s1, String s2)  -> {
            if(s1.length() < s2.length()) 
                return -1;
            if(s1.length() > s2.length()) 
                return 1;
            return 0;
        });

        // Model 5
        palavras.sort((s1, s2)  -> Integer.compare(s1.length(), s2.length()));

        // Model 6 - comparado por meio de subtração: Similar ao Model 5
        palavras.sort((s1, s2)  -> s1.length() - s2.length());

        // Printing information
        // Old format
        for (String p : palavras) {
            System.out.println(p);
        }

        // Using Default Methods
        Consumer<String> consumidor = new ImprimeNaLinha();
        palavras.forEach(consumidor);

        // Using Anonymous Classes
        /**
         * Classes anônimas (Anônima pq não tem um nome)
         * são interessantes quando não tiverem reuso e
         * quando tiverem poucos métodos e sendo estes
         * de tamanho pequeno.
         */
        Consumer<String> consumidor1 = new Consumer<String>() {
			@Override
			public void accept(String s) {
				System.out.println("Using Anonymous Classes: " + s);
				
			}
        };
        palavras.forEach(consumidor1);

        // Second form to Use Anonymous Classes
        palavras.forEach(new Consumer<String>() {

			@Override
			public void accept(String s) {
                System.out.println("Second form to Use Anonymous Classes: " + s);
				
            }
        });

        // Third form using Lambda Notation
        palavras.forEach((String s) -> {
            System.out.println("Third form using Lambda Notation: " + s);
        });

        // Fourth form using Lambda Notation and Functional Interface
        /**
         * Interfaces funcionais são aquelas que tem
         * UM ÚNICO MÉTODO ABSTRATO.
         */
        palavras.forEach( s -> System.out.println("Third form using Lambda Notation: " + s));

        //Teste
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Executando um Runnable");
            }
        }).start();

        //Teste 2
        new Thread(() -> System.out.println("Executando um Runnable Lambda Format")).start();
    }
}

class ComparadorDeStringPorTamanho implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        if(s1.length() < s2.length()) 
            return -1;
        if(s1.length() > s2.length()) 
            return 1;
        return 0;
    }

}

class ImprimeNaLinha implements Consumer<String> {
    @Override
    public void accept(String s) {
        System.out.println(s);
    }
}