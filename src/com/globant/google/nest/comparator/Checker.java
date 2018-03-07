package com.globant.google.nest.comparator;

import java.util.*;

public class Checker implements Comparator<Player> {
    
    public int compare(Player o1, Player o2){
        int result = 0;
        
        if (o1.score < o2.score) result = 1;
        if (o1.score == o2.score) result = 0;
        if (o1.score > o2.score) result = -1;
        
        if (result==0){
            result = o1.name.compareTo(o2.name);
        }
        
        return result;
    }    
    
}
