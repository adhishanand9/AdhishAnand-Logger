package org.example.cost;

import org.example.cost.exception.InvalidArea;
import org.example.cost.exception.InvalidMaterialSelection;

public class ConstructionCostOfHouse
{
    private static final int STANDARD_MATERIAL_COST = 1200;
    private static final int MEDIUM_STANDARD_MATERIAL_COST = 1500;
    private static final int HIGH_STANDARD_MATERIAL_COST = 1800;
    private static final int HIGH_MATERIAL_COST_WITH_AUTOMATION = 2500;

    private static String[] materials = new String[]{"Standard Material", "Above Standard Materials", "High Standard Material"};

    public static float calculateCost(String materialChoice, float area, boolean automationRequirement )
    {
        if (area == 0)
            throw new InvalidArea();
        if(materialChoice.equalsIgnoreCase(materials[0]))
        {
            return area*STANDARD_MATERIAL_COST;
        }
        else if(materialChoice.equalsIgnoreCase(materials[1]))
        {
            return area*MEDIUM_STANDARD_MATERIAL_COST;
        }
        else if (materialChoice.equalsIgnoreCase(materials[2]))
        {
            if (automationRequirement)
                return area*HIGH_MATERIAL_COST_WITH_AUTOMATION;
            return area*HIGH_STANDARD_MATERIAL_COST;
        }
        else
            throw new InvalidMaterialSelection();
    }

    public static String[] getMaterials()
    {
        return materials;
    }
}
