package com.globant.google.nest.list;

import java.io.*;
import java.util.*;

public class Solution {

    private final static String QUERY_INSERT = "Insert";
    private final static String QUERY_DELETE = "Delete";

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner scanner = new Scanner(System.in);

        Solution app = new Solution();        
        app.run(scanner);
    }
    
    public void run(Scanner scanner) {
        List<Query> queries = new ArrayList<Query>();

        String in01 = scanner.nextLine();
        String in02 = scanner.nextLine();
        String in03 = scanner.nextLine();
        
        int elements 	= Integer.valueOf(in01);
        String valuesIn = in02;
        int queriesN 	= Integer.valueOf(in03);

        List<Integer> valuesList = toList(valuesIn);
        
        for (int i=0; i<queriesN; i++){
            Query query = buildQuery(scanner);
            queries.add(query);
        }

        List<Integer> result = execute(queries, valuesList);
        
        print(result);
        
    }
    
    private void print(List<Integer> values){
        StringBuilder buf = new StringBuilder();

        for (Integer value : values){
            buf.append(value.intValue() +" ");
        }

        System.out.println(buf.toString().trim());

    }
    
    private List<Integer> execute(List<Query> queries, List<Integer> valuesList){

        for (Query query : queries) {
            if (QUERY_INSERT.equals(query.query)){
                valuesList.add(query.index, query.value);
                
            } else if (QUERY_DELETE.equals(query.query)){
                valuesList.remove(query.index);
            }
        }

        return valuesList;
    }

    private List<Integer> toList(String valuesIn){
        List<Integer> valuesList = new ArrayList<Integer>();
        
        String[] values = valuesIn.split(" ");
        
        for (String value : values){
            Integer valInt = Integer.valueOf(value);
            valuesList.add(valInt);
        }
        
        return valuesList;
    }
    
    private Query buildQuery(Scanner scanner){
        int index = -1;
        int value = -1;
        
        String query = scanner.nextLine();
        
        if (QUERY_INSERT.equals(query)){        	
            String values = scanner.nextLine();
            List<Integer> valuesList = toList(values);
            
            index = valuesList.get(0);
            value = valuesList.get(1);
            
        } else if (QUERY_DELETE.equals(query)){
        	String valInt = scanner.nextLine();
            index = Integer.valueOf(valInt);
        }
        
        Query queryObj = new Query();
        queryObj.query = query;
        queryObj.index = index;
        queryObj.value = value;
        
        return queryObj;
    }
    
    class Query {
        String query;
        int index;
        int value;
    }    
}
