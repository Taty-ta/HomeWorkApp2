package hw_3;

import javax.xml.soap.SOAPPart;
import java.util.Arrays;
import java.util.Scanner;

public class MainHw {

    public static void main(String[] args){
        invertedNumbers(); //1
        System.out.println();

        arrayOfNumbers(); //2
        changeArray(); //3
        fillDiagonal(); //4
        System.out.println();
       int[] arr = wrongReturn(5,6); //5

        System.out.println(Arrays.toString(arr));

        mimMaxNamber(); //6
        int[] arrey = {4,3,1,1,1,1,2,3};
       Boolean result = equalParts( arrey); //7

        //arrayОffset(arrey); //8 тут у меня ерунда получилась потом подумаю
        }
        /**
         *целочисленный массив, состоящий из элементов 0 и 1.
         *  Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
         * */
        public static void invertedNumbers(){
            int[] numbers = {1,1,1,0,0,1,0,1,0,1};
            System.out.print(Arrays.toString(numbers));
            System.out.println();
            for (int i = 0; i < numbers.length; i++){
                if (numbers[i]>0) {
                    numbers[i] = 0;
                }else {
                    numbers[i] = 1;
                }

            }
            System.out.print(Arrays.toString(numbers));
        }
        /**
         * пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;
         * */
        public static void arrayOfNumbers(){
                int[] arr = new int[100];{
                for (int i = 0; i < 100; i++) {
                    arr[i] = i+1;

                    //System.out.println("arr[" + i + "] = " + arr[i]);
                }
                System.out.println(Arrays.toString(arr));
            }
        }
        /**
         *Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
         * */
        public static void changeArray(){
            int[] arr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
            for (int i = 0; i < arr.length; i++) {
              if (arr[i] < 6 ){
                  arr[i] = arr[i] * 6;
              }
                System.out.println("arr[" + i + "] = " + arr[i]);
            }
        }
        /*
        * Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        *  и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из
        * диагоналей, если обе сложно). Определить элементы одной из диагоналей можно по следующему принципу:
        * индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
        *
        *
         * */
        public static void fillDiagonal() {

            int[][] arr = new int[6][6];
            for (int i = 0; i < arr.length; i++) {
                System.out.println();
                for (int j = 0; j < arr[i].length; j++) {
                    if ( i == j || i+j == 5) {
                        arr[i][j] = 1;
                        System.out.print(arr[i][j] + " ");
                    }else {
                        arr[i][j] = 5;
                        System.out.print(arr[i][j] + " ");
                    }
                }

            }
        }
       /**
        * Написать метод, принимающий на вход два аргумента: len и initialValue,
        * и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;
        *
        * */
       public static int[] wrongReturn(int len, int initialValue){
           int[] arr = new int[len];
           for (int i = 0; i < len; i++) {
               arr[i] =  initialValue;

           }
           return arr;
       }
       /**
        *Задать одномерный массив и найти в нем минимальный и максимальный элементы
        * */
       public static void mimMaxNamber(){
           int[] arr = {3, 5 ,9, 2, 33, 17};
            int min = 100;
           int max = 0;

           for (int i = 0; i < arr.length; i++) {
               if(arr[i] > max){
                   max = arr[i];
               }

               if (arr[i] < min){
                   min = arr[i];
               }
           }
           System.out.println(" max = "+ max+ " min = "+min);
       }
       /**
        * Написать метод, в который передается не пустой одномерный целочисленный массив,
        * метод должен вернуть true, если в массиве есть место, в котором сумма левой и
        * правой части массива равны
        *
        * */
        public static boolean equalParts(int[] arrey){
            int sumleft = 0;
            int sumright  =0;
            for (int i = 0; i < arrey.length; i++) {
                sumright  =0;
                sumleft = sumleft+ arrey[i];

                for (int j = i+1; j < arrey.length ; j++) {
                    sumright = sumright+ arrey[j];
                }
                if(sumleft == sumright){

                    return true;
                }

                }
            return false;
            }
/**
 * Написать метод, которому на вход подается одномерный массив и число n
 * (может быть положительным, или отрицательным), при этом метод должен
 * сместить все элементы массива на n позиций. Элементы смещаются циклично.
 * Для усложнения задачи нельзя пользоваться вспомогательными массивами.
 * Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1]
 * при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.
 * */
        public static void arrayОffset(int[] arrey) {

    Scanner scanner = new Scanner(System.in);
    System.out.println("Введите число от -5 до 5 для смещения массива");
    int q = scanner.nextInt(); //{4,3,1,1,1,1,2,3}
    int buffer = 0;

    if (q < 0) {
        for (int i = 0; i < arrey.length; i++) {

        }
    } else if (q > 0) {
        for (int i = 0; i <= q - 1; i++) {
            for (int j = 0; j < q - i; j++) {
                if (arrey[j] > arrey[j + 1]) {

                    buffer = arrey[j];
                    arrey[j] = arrey[j + 1];
                    arrey[j + 1] = buffer;

                }
            }
        }
    }
    System.out.println(Arrays.toString(arrey));
    }

}


