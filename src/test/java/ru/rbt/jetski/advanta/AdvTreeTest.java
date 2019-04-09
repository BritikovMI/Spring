package ru.rbt.jetski.advanta;


import java.util.*;

/**
 * Created by BritikovMI on 07.03.2019.
 */
public class AdvTreeTest {


    public static void main(String[] args) {

            Map<Integer, String> random = new HashMap<Integer, String>();
            for (int i = 0; i < 10; i++) {
                random.put((int) (Math.random() * 100), String.valueOf((int) (Math.random() * 100)));
            }

            System.out.println("Initial Map: " + Arrays.toString(random.entrySet().toArray()));

            TreeMap<Integer, String> sorted = new TreeMap<Integer, String>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1.compareTo(o2);
                }
            });
            sorted.putAll(random);
            System.out.println("Sorted Map: " + Arrays.toString(sorted.entrySet().toArray()));

    }
}