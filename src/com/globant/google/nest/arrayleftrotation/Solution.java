package com.globant.google.nest.arrayleftrotation;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /*String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        scanner.close();*/
        int[] a = {1, 2, 3, 4, 5};
        int d = 2;

        rotate(d, a);
    }

    private static void rotate(int d, int[] a) {

        if (d == a.length) {
            print(a);
            return;
        }

        int[] b = new int[a.length + d];
        int[] c = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }

        for (int i = 0; i < d; i++) {
            b[a.length + i] = a[i];
        }

        for (int j = 0, i = d; i < b.length; i++, j++) {
            c[j] = b[i];
        }

        print(c);
    }

    private static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] +" ");
        }
    }

}
