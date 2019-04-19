package com.org.chapter2.staticfactory;

public class NutritionFacts {
    private final int servingSize;
    private final int servings;
/*    private final int calories;
    private final int fag;
    private final int sodium;
    private final int carbohydrate;*/
    public NutritionFacts(int servingSize,int servings){
        this.servingSize=servingSize;
        this.servings=servings;
    }
 /*   public NutritionFacts(int servingSize,int servings,int calories){
        this(servingSize,servings,0);
    }*/
}
