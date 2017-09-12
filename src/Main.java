import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ricskooo on 2017. 09. 09..
 */
public class Main {
    public static void main(String[] args) {

         euler1(1000);
         euler2();
         euler4();
         euler15();

        coinProblem(1500);
//        long cica = 324333333325;
//        System.out.println(String.valueOf(Math.abs(cica)).charAt(0));
        List<Integer> list = readFile("src/read.txt");
        System.out.println(list.size());
        System.out.println(list.toString());

        /////////////////

        List<Integer> listArray = new ArrayList<>();

        for(int i = 0;i < 15;i++){
            listArray.add((int) (Math.random() * 95) +1);
        }

        System.out.println(listArray);
        biggestElementinList(listArray);
        reverseElementList(listArray);

        ////////////////////////

        String[] helloWolrd = {"Hello", "World", "in", "a", "frame"};
        frameHelloWorld(helloWolrd);
    }

    private static void frameHelloWorld(String[] array) {
        int longestString = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i].length() > longestString){
                longestString = array[i].length();
            }
        }

        System.out.println(longestString);

        StringBuilder stringForWave = new StringBuilder();
        for (int j = 0; j< longestString + 2;j++){
            stringForWave.append("+");
        }

        System.out.println(stringForWave);
        for (int i = 0; i < array.length; i++) {
            if(array[i].length() < longestString){
                StringBuilder str1 = new StringBuilder();
                for(int x = 0 ; x < longestString-array[i].length();x++){
                    str1.append(" ");
                }
                System.out.println("+" + array[i] + str1 + "+");
            }else{
                System.out.println( "+" + array[i] + "+");
            }
        }
        System.out.println(stringForWave);
    }

    private static void reverseElementList(List<Integer> listArray) {
        Collections.sort(listArray);
        Collections.reverse(listArray);
        System.out.println(listArray);
    }

    private static void biggestElementinList(List<Integer> listArray) {
        Collections.sort(listArray);
        System.out.println(listArray.get(listArray.size()-1));
    }

    private static void prim(int value){
        int i = 2;
            while (value > 1) {
                while (value % i == 0) {
                    value = value / i;
                    System.out.println(value + " az osztó " + i);
                }
                i++;
            }
    }

    private static void euler1(int x){
        int currentSum=0;
        for(int i = 1; i < x;i++){
            if(i % 3 == 0 || i % 5 == 0){
                currentSum+=i;
                System.out.println(i);
            }
        }
        System.out.println("A végleges számok összege: " + currentSum);
    }

    private static void euler2(){
        List<Integer> listHelp = new ArrayList<>();
        listHelp.add(1);

        for(int i = 0;i < 10;i++){
            if(listHelp.size()<2){  //a lista kisebb mint kettő így el kell inditani valahol
               System.out.println(listHelp.get(0));
               listHelp.add(listHelp.get(0));
            }else{
                System.out.println(listHelp.get(0)+listHelp.get(1));
                listHelp.add(listHelp.get(0)+listHelp.get(1));
                listHelp.remove(listHelp.get(0));
            }
        }
    }


    private static void euler4(){
            outerloop:
            for(int i = 999; i > 100;i--) {
                for (int j = 999; j > 100; j--) {
                    long currentValue = i * j;
                    String reverseValue = new StringBuilder(String.valueOf(currentValue)).reverse().toString();
                    if (currentValue == Integer.parseInt(reverseValue)) {
                        System.out.println(i + "*" + j + " értéke: " + (i * j));
                        break outerloop;
                    }
                }
            }
    }

    private static void euler15(){
        final int boxNumbers = 20;
        final long[][] corner = new long[boxNumbers+1][boxNumbers+1];
        corner[0][0] = 0;
        for (int i=1; i <= boxNumbers; i++){
            corner[i][0] = 1;
            corner[0][i] = 1;
        }
        for (int i=1; i <= boxNumbers; i++){
            for (int j=1; j <=i; j++){
                corner[i][j] = corner[j][i] = corner[j-1][i] + corner[j][i-1];
            }
        }
        System.out.println(corner[boxNumbers][boxNumbers]);
    }

    public static List<Integer> readFile(String file) {
        List<Integer> chars = new ArrayList<>();
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {
            int ch;
            while ((ch = br.read()) != -1) {
                chars.add(ch);
                System.out.println(ch);
                break;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Missing file");
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Empty file");
            System.exit(0);
        }
        return chars;
    }

    private static void coinProblem(int value){
        int[] coinValue = {1000,500,250,125,35,10,5};
        int counter = 0;

        for (int i = 0; i < coinValue.length; i++) {
            while (value - coinValue[i] >= 0) {
                counter++;
                value = value - coinValue[i];
            }
            System.out.println(counter + " ennyi kell , ebből: " + coinValue[i]);
            counter = 0;
        }                           
    }


}
