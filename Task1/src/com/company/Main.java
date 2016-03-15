package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main app = new Main();
        app.startApplication();
    }

    public void startApplication() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter array dimension: ");
        int n = in.nextInt();

        int[] mas = new int[n];

        System.out.print("Enter array elements are separated by a space: ");
        for(int i=0;i < mas.length; i++){
            mas[i]=in.nextInt();
        }
        in.close();

        Sorting(mas);

        for(int i = 0; i < mas.length; i++){
            System.out.print(mas[i]);
            System.out.print(" ");
        }
    }

    public void Sorting(int[] mas){
        int min, index, i, j;
        for(i = 0; i < mas.length; i++){
            index = i;
            min = mas[i];
            for(j = i+1; j< mas.length; j++){
                if(mas[j] < min){
                    min = mas[j];
                    index = j;
                }
            }
            mas[index] = mas[i];
            mas[i] = min;
        }
    }
}
