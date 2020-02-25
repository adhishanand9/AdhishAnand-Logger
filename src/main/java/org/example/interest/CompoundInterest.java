package org.example.interest;

public class CompoundInterest
{
    public static double calculateInterest(float principal, float numberOfYears, float interestRate)
    {
        if(principal==0||numberOfYears==0||interestRate==0)
            return -1;
        return Double.parseDouble(String.format("%.2f", principal * Math.pow(1.0+interestRate/100.0,numberOfYears) - principal));
        // Above code is rounding the interest to 2 decimal places and converting back to Double data type...
    }
}
