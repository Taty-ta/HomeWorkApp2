package hw_3;

import javax.xml.soap.SOAPPart;
import java.util.Arrays;
public class MainHw {
    public static void main(String[] args){
//        invertedNumbers();
//        System.out.println();
//        arrayOfNumbers();
//        changeArray();
        fillDiagonal();
//        int a = 4;
//        int b= 6;
//        System.out.print(wrongReturn(a,b));
        }
        /**
         *целочисленный массив, состоящий из элементов 0 и 1.
         *  Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
         * */
        public static void invertedNumbers(){
            int[] numbers = {1,1,1,0,0,1,0,1,0,1};
            for (int i = 0; i < numbers.length; i++){
                if (numbers[i]>0) {
                    numbers[i] = 0;
                }else {
                    numbers[i] = 1;
                }
                System.out.print(numbers[i]);
            }
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
        * сделала 2 диагонали))
        *
         * */
        public static void fillDiagonal() {

            int[][] arr = new int[6][6];
            for (int i = 0; i < 6; i++) {
                System.out.println();
                for (int j = 0; j < 6; j++) {
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
        * в процедуре сформировали массив как объявить и как вернуть массив
        * */
       public static int wrongReturn(int len, int initialValue){
           int[] arr = new int[len];
           for (int i = 0; i < len; i++) {
               arr[i] = arr[i]+ initialValue;

           }
           return 1;
       }
}

