package com.java.jdbc;

import java.util.HashMap;

/**
 * <h2>Hash_Map_Demo Class</h2>
 * <p>
 * Process for Displaying Hash_Map_Demo
 * </p>
 * 
 * @author User
 *
 */
public class Hash_Map_Demo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // Creating an empty HashMap
        HashMap<Integer, String> hash_map = new HashMap<Integer, String>();

        hash_map.put(10, "Geeks");
        hash_map.put(15, "4");
        hash_map.put(20, "Geeks");
        hash_map.put(25, "Welcomes");
        hash_map.put(30, "You");

        // Displaying the HashMap
        System.out.println("Initial Mappings are: " + hash_map);

        // Checking for the key_element '20'
        System.out.println("Is the key '20' present? " + hash_map.containsKey(20));

        // Checking for the key_element '5'
        System.out.println("Is the key '5' present? " + hash_map.containsKey(5));
    }

}
