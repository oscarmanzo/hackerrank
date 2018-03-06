package com.globant.google.nest.balancedbrackets;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String isBalanced(String s) {

        Stack<Character> stack = new Stack<Character>();
        
        char[] chars = s.toCharArray();        
        
        for (char c : chars){
            
        	if (isOpen(c)) {
            	stack.push(c);
            
        	} else if (isClose(c)) {
                if (stack.isEmpty()) return "NO";
                
            	char last = stack.peek();

            	if (match(last, c)) {
            		stack.pop();
            	}
            }
        }        
        
        return stack.isEmpty()?"YES":"NO";
    }

    private static boolean match(char open, char close) {
    	
    	if ('(' == open && ')' == close) {
    		return true;
    	}
    	
    	if ('[' == open && ']' == close) {
    		return true;
    	}
    	
    	if ('{' == open && '}' == close) {
    		return true;
    	}
    	
    	return false;
    }

    private static boolean isOpen(char c){
        return "[{(".indexOf(c) > -1;
    }

    private static boolean isClose(char c){
        return ")}]".indexOf(c) > -1;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            String result = isBalanced(s);
            System.out.println(result);
        }
        in.close();
    }
    
}
