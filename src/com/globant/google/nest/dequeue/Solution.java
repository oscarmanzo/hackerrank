package com.globant.google.nest.dequeue;

import java.util.*;

public class Solution {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            
            Deque<Integer> deque = new ArrayDeque<>();
            
            int max = 0;
            
            int n = in.nextInt();
            int m = in.nextInt();
            
            for (int i = 0, j = 1; i < n; i++, j++) {
                int num = in.nextInt();
                
                deque.addLast(num);
                
                if (deque.size() == m){
                    int temp = hasUnique(deque);
                    if (temp > max) max = temp;
                    
                    deque.removeFirst();
                }
                
                if (j == m) j = 1;
                
            }
            
            System.out.println(max);
            
        }
        
        static int hasUnique(Deque<Integer> deque){
            Iterator<Integer> iterator = deque.iterator();
            
            Set<Integer> set = new HashSet<>();
            
            while (iterator.hasNext()){
                int num = iterator.next();
                set.add(num);
            }
            
            return set.size();
        }
        
    }
