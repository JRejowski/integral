package integrals;

public class Trapeze extends IntegralAlgorithm{

    public Trapeze(){
        this.sum=0;
    }

    @Override
    public void calculateIntegral() {

        if(a>b)
        {
            double tmp = a;
            a=b;
            b=tmp;
        }

        double krok = ((b-a)/n);

        for(double i=a;i<b-krok;i+=krok)
        {
            double temp = ((function.getValue(i)+function.getValue(i+krok))*krok)/2;
            sum +=temp;
        }



    }

}
