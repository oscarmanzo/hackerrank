package com.globant.google.nest.phonebook;

//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;

class Solution {
   
    private static final String NOT_FOUND = "Not found";
    
    public static void main(String []argh) {
        Solution app = new Solution();
        Scanner in = new Scanner(System.in);
        app.run(in);
    }
    
    public void run(Scanner in) {
        Map<String, Person> persons = new HashMap<String, Person>();
        List<String> queries = new ArrayList<String>();
        
        int n = in.nextInt();
        in.nextLine();
        
        for(int i=0;i<n;i++) {
            String name = in.nextLine();
            int phone = in.nextInt();
            in.nextLine();

            Person person = new Person();
            person.name = name;
            person.phone = phone;

            persons.put(name, person);
        }

        while(in.hasNext()) {
            String s = in.nextLine();
            queries.add(s);
        }

        
        executeQueries(queries, persons);

    }
    
    private void executeQueries(List<String> queries, Map<String, Person> persons){
        
        for (String query : queries){

            if (!persons.containsKey(query)){
                System.out.println(NOT_FOUND);
                continue;
            }
            
            Person person = persons.get(query);
            System.out.println(person.name +"="+ person.phone);
        }
    }
    
    class Person {
        String name;
        int phone;
    }
}
