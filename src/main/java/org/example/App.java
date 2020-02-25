package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.cost.ConstructionCostOfHouse;
import org.example.interest.CompoundInterest;
import org.example.interest.SimpleInterest;
import org.apache.log4j.BasicConfigurator;

import java.util.Scanner;

public class App
{
    static void cost(){
        Scanner input = new Scanner(System.in);
        final Logger logger = LogManager.getLogger(App.class);
        String[] materials = ConstructionCostOfHouse.getMaterials();
        for (int index = 0; index < materials.length; index++)
        {
//                    System.out.println("Enter " + (index + 1) + " to select " + materials[index]);
            logger.info("Enter " + (index + 1) + " to select " + materials[index]);
        }

        byte materialChoice = (byte) (input.nextByte() - 1);
//                System.out.println("Enter the Area of the house...");
        logger.info("Enter the Area of the house...");
        float area = input.nextFloat();
        boolean automationRequired = false;
        if(materials[materialChoice].equals("High Standard Material"))
        {
//                    System.out.println("Enter \"True\" if you need automation or else enter \"False\"...");
            logger.info("Enter \"True\" if you need automation or else enter \"False\"...");
            automationRequired = input.nextBoolean();
        }
//                System.out.println(HouseConstructionCost.calculateCost(materials[materialChoice],
//                        area, automationRequired));
        logger.info(ConstructionCostOfHouse.calculateCost(materials[materialChoice],
                area, automationRequired));

    }
    static void interest(){
        Scanner input = new Scanner(System.in);
        final Logger logger = LogManager.getLogger(App.class);
        logger.info("Enter \"SI\" to calculate simple interest or \"CI\" to calculate compound interest...");
        switch (input.next())
        {
            case "SI":
//                        System.out.println("Enter \"Principal Amount\" , \"Duration in Years\" and \"Rate of Interest\"...");
//                        System.out.println(SimpleInterest.calculateInterest(input.nextFloat(), input.nextFloat(), input.nextFloat()));
                logger.info("Enter \"Principal Amount\" , \"Duration in Years\" and \"Rate of Interest\"...");
                logger.info(SimpleInterest.calculateInterest(input.nextFloat(), input.nextFloat(), input.nextFloat()));
                break;
            case "CI":
//                        System.out.println("Enter \"Principal Amount\" , \"Duration in Years\" and \"Rate of Interest\"...");
//                        System.out.println(CompoundInterest.calculateInterest(input.nextFloat(), input.nextFloat(), input.nextFloat()));
                logger.info("Enter \"Principal Amount\" , \"Duration in Years\" and \"Rate of Interest\"...");
                logger.info(CompoundInterest.calculateInterest(input.nextFloat(), input.nextFloat(), input.nextFloat()));
                break;
            default:
//                        System.err.println("Wrong Choice...");
                logger.warn("Wrong Choice...");
        }
    }
    public static void main( String[] args )
    {
        final Logger logger = LogManager.getLogger(App.class);
        BasicConfigurator.configure();
        logger.debug("hello");
        Scanner input = new Scanner(System.in);
//        System.out.println("Enter \"interest\" to calculate the Interest or \"cost\" to calculate the house " +
//                "construction cost...");
        logger.info("Enter \"interest\" to calculate the Interest or \"cost\" to calculate the house " +
                "construction cost...");

        switch (input.next())
        {
            case "interest":
//                System.out.println("Enter \"SI\" to calculate simple interest or \"CI\" to calculate compound interest...");
                interest();
                break;
            case "cost":
            {
                cost();
                break;
            }
            default:
//                System.err.println("Wrong Choice...");
                logger.warn("Wrong Choice...");
        }
    }
}
