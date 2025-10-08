package com.nanawally.uppgifter.ianimal;

public class AnimalUtil {

    public static void checkAnimalType(IAnimal animal) {
        if (animal instanceof IMammal) {
            System.out.println("This is a mammal");
        }

        if (animal instanceof IReptile) {
            System.out.println("This is a reptile");
        }
    }
}
