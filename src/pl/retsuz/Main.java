package pl.retsuz;

import functions.Function;
import functions.examples.builder.ExampleBuilder;
import functions.examples.cosineexample.CosineExampleBuilder;
import integrals.IntegralAlgorithm;
import integrals.MonteCarlo;
import integrals.Trapeze;
import view.IntegralView;
import view.StandardView;

public class Main {

    protected static ExampleBuilder functionBuilder;
    protected static Function givenExample;
    protected static IntegralAlgorithm algorithm;
    protected static IntegralAlgorithm algorithm1;
    protected static IntegralView view;
    public static void main(String[] args) {
        double a;
        double b;
        int n;

        view = new StandardView();
        functionBuilder = new CosineExampleBuilder();
        givenExample = functionBuilder.build();
        algorithm = new MonteCarlo();
        algorithm1 = new Trapeze();

        a = view.readDoubleWithMessage("Podaj wartość a:");
        b = view.readDoubleWithMessage("Podaj wartość b:");
        n = view.readIntegerWithMessage("Podaj wartość n:");

        algorithm.setFunction(givenExample);
        algorithm.setA(a);
        algorithm.setB(b);
        algorithm.setN(n);
        algorithm.calculateIntegral();

        algorithm1.setFunction(givenExample);
        algorithm1.setA(a);
        algorithm1.setB(b);
        algorithm1.setN(n);
        algorithm1.calculateIntegral();

        double monteIntegral = algorithm.getIntegral();
        double trapezeIntegral = algorithm1.getIntegral();
        double exactIntegral = givenExample.getExactIntegralValue(b)-givenExample.getExactIntegralValue(a);
        double error = Math.abs(monteIntegral-exactIntegral);
        double error2 = Math.abs(trapezeIntegral-exactIntegral);

        System.out.println("Numeryczna - MC\t"+monteIntegral);
        System.out.println("Numeryczna - Trapeze\t"+trapezeIntegral);
        System.out.println("Dokładna\t"+exactIntegral);
        System.out.println("Błąd MC\t\t"+error);
        System.out.println("Błąd Trapezy\t\t"+error2);
    }
}
