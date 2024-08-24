package practice;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrintNCharacters {

    public static void main(String[] args) {
    /*
    1. get a(char) and increase pointer
    loop 2. get 1(num) and incrase pointer and get next letter and check if it is number or letter
    3. if it is number { add number }
    4. if it is char { print for current number and char  }
    5. at last alway print
    */
    String input = "b3c6d15";
    int n = input.length();
    int pointer = 0;
    char c = 'n';
    String num = "";
    while(pointer < n) {
        c = input.charAt(pointer++);
        do {
            char temp = input.charAt(pointer++);
            if(temp >= '0' && temp <= '9') {
               num += temp;
            } else {
                pointer--;
                break;
            }
        } while(pointer < n);
        printLetter(c, Integer.parseInt(num));
        num = "";
    }

    //printLetter(c, Integer.parseInt(num));

    }

    static void printLetter(char c, int n) {
        for(int i = 0; i < n; i++) {
            System.out.print(c);
        }
    }
}


// a1b10
