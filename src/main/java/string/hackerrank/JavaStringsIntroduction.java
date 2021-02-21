package string.hackerrank;

import java.util.Scanner;

public class JavaStringsIntroduction {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        System.out.println(A.length()+B.length());
        System.out.println(A.compareTo(B)>0?"Yes":"No");
        StringBuilder stringBuilderA = new StringBuilder();
        StringBuilder stringBuilderB = new StringBuilder();
        stringBuilderA.replace(0,1, stringBuilderA.substring(0,1).toUpperCase());
        stringBuilderB.replace(0,1, stringBuilderB.substring(0,1).toUpperCase());
        System.out.println(stringBuilderA.toString()+" "+stringBuilderB.toString());
    }
}
