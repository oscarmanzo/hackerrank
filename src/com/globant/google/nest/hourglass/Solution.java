package com.globant.google.nest.hourglass;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static final int SUB_L = 3;

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int[][] totals = new int[4][4];

        for (int i=0; i<arr.length - 2; i++) {
            for (int j=0; j<arr.length - 2; j++) {
                int[][] sub = getHourglass(i, j, arr);
                totals[i][j] = sum(sub);
            }
        }

        return max(totals);
    }

    private static int max(int[][] totals) {
        int max = 0;

        for (int i=0; i<totals.length; i++) {
            for (int j=0; j<totals[i].length; j++) {
                int val = totals[i][j];

                if (val > max) max = val;
            }
        }

        return max;
    }

    private static int sum(int[][] sub) {
        int total = -10000000;

        for (int i=0; i<sub.length; i++) {
            for (int j=0; j<sub.length; j++) {

                if (i==1 && (j == 0 || j == 2))
                    continue;

                total += sub[i][j];
            }
        }

        return total;
    }

    private static int[][] getHourglass(int i, int j, int[][] arr){
        int[][] sub = new int[SUB_L][SUB_L];

         for (int x=0,  ii=i; ii< i + SUB_L; x++, ii++) {
            for (int y=0,  jj=j; jj< j + SUB_L; y++, jj++) {
                sub[x][y] = arr[ii][jj];
            }
        }

        return sub;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = {
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };

        /*for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }*/

        int result = hourglassSum(arr);
        System.out.println(result);
        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();
        //bufferedWriter.close();

        scanner.close();
    }
}
