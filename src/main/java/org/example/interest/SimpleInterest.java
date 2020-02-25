package org.example.interest;

public class SimpleInterest
{
    public static double calculateInterest(float principal, float numberOfYears, float interestRate)
    {
        if(principal==0||numberOfYears==0||interestRate==0)
            return -1;
        return Double.parseDouble(String.format("%.2f", principal*numberOfYears*interestRate/100));
        // Above code is rounding the interest to 2 decimal places and converting back to Double data type...
    }
}
