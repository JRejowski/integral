package view;

import integrals.IntegralAlgorithm;
import integrals.Trapeze;
import integrals.MonteCarlo;

import java.util.Scanner;

public class StandardView implements IntegralView{
    private Scanner sc = new Scanner(System.in);

    public double readDoubleWithMessage(String msg){
        System.out.println(msg);
        String line = sc.nextLine();
        return Double.parseDouble(line);
    }

    public int readIntegerWithMessage(String msg){
        System.out.println(msg);
        String line = sc.nextLine();
        return Integer.parseInt(line);
    }
}
