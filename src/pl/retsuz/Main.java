package pl.retsuz;

import functions.Function;
import functions.examples.builder.ExampleBuilder;
import functions.examples.cosineexample.CosineExampleBuilder;
import integrals.IntegralAlgorithm;
import integrals.MonteCarlo;
import integrals.Trapeze;

public class Main {

    protected static ExampleBuilder functionBuilder;
    protected static Function givenExample;
    protected static IntegralAlgorithm algorithm;
    protected static IntegralAlgorithm algorithm1;
    public static void main(String[] args) {
        double a = 0;
        double b = Math.PI/2;
        int n= 9999999;

        functionBuilder = new CosineExampleBuilder();
        givenExample = functionBuilder.build();
        algorithm = new MonteCarlo();
        algorithm1 = new Trapeze();

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

        System.out.println("Numeryczna - MC\t"+monteIntegral);
        System.out.println("Numeryczna - Trapeze\t"+trapezeIntegral);
        System.out.println("Dokładna\t"+exactIntegral);
        System.out.println("Błąd\t\t"+error);
    }
}
