package com.globant.google.nest.arraylist;

import java.io.*;
import java.util.*;

public class Solution {

    private final static String ERR = "ERROR!";
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        Solution app = new Solution();
        app.run(scanner);
    }

    public void run(Scanner scanner){
        
        int numLines = Integer.valueOf(scanner.nextLine());
        List<List<Integer>> valuesList = new ArrayList<List<Integer>>();
        
        for (int i=0; i<numLines; i++){
            String valuesNum = scanner.nextLine();
            List<Integer> numLine = toList(valuesNum);
            valuesList.add(numLine);
        }

        int numQueries = Integer.valueOf(scanner.nextLine());
        List<Query> queries = new ArrayList<Query>();
        
        for (int i=0; i<numQueries; i++){
            String valuesQuery = scanner.nextLine();
            Query query = buildQuery(valuesQuery);
            queries.add(query);
        }

        executeQueries(valuesList, queries);
        
    }

    private void executeQueries(List<List<Integer>> valuesList, List<Query> queries){
        
        for (Query query : queries){
            
            if (!isValid(query.line, valuesList)){
                System.out.println(ERR);
                continue;
            }
            
            List<Integer> line = valuesList.get(query.line-1);
            
            if (!isValid(query.position+1, line)){
                System.out.println(ERR);
                continue;
            }

            int value = line.get(query.position);
            System.out.println(value);
        }        
    }
    
    private boolean isValid(int index, List list){
        if (list==null) return false;
        
        if (index > list.size()) return false;
        
        return true;
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

    private Query buildQuery(String values){
        int line = 0;
        int position = 0;
        
        List<Integer> valuesList = toList(values);
            
        line = valuesList.get(0);
        position = valuesList.get(1);
        
        Query queryObj = new Query();
        queryObj.line = line;
        queryObj.position = position;
        
        return queryObj;
    }
    
    class Query {
        int line;
        int position;
    }
    
}