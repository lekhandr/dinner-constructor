package ru.practicum.dinner;
import java.util.Random;
import java.util.HashMap;
import java.util.ArrayList;
public class DinnerConstructor {

HashMap<String,ArrayList<String>> hash;

    Random random = new Random();

    DinnerConstructor() {
        hash = new HashMap<>();

    }



    void saveDish(String type, String name) {
         String info = ("В тип " + type + " добавлено блюдо: " + name + ".");
        if (checkDish(name)) {
            System.out.println("Блюдо уже добавлено в меню");
        } else if (checkType(type)) {
            hash.get(type).add(name);
            System.out.println(info);
        } else {
            ArrayList<String> dishForNewType = new ArrayList<>();
            dishForNewType.add(name);
            hash.put(type, dishForNewType);
            System.out.println(info);
        }
    }

    void generateDishCombo(int number, ArrayList<String> types) {

        for (int i = 0; i < number; i++) {
            ArrayList<String> сomboDish = new ArrayList<>();
            for (String type : types) {
                int dishNumber = random.nextInt(hash.get(type).size());
                String dish = hash.get(type).get(dishNumber);
                сomboDish.add(dish);


            }

            System.out.println(сomboDish);
        }
    }

    boolean checkType(String type) {

        return hash.containsKey(type);
    }

    boolean checkDish(String name) {
        for (ArrayList<String> dishes : hash.values()) {
            if (dishes.contains(name)) {
                return true;
            }
        }
        return false;
    }


}//class DinnerConstructor
