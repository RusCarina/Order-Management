package org.example;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.*;

public class Reflection {
    int i;

    /**
     * @param object obiect
     */
    public static void retrieveProperties(Object object) {

        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value;
            try {
                value = field.get(object);
                System.out.println(field.getName() + "=" + value);

            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param obj obiect
     * @return obiect
     */
    public static List<Object> getValues(Object obj) {
        // ArrayList<Object> values = new ArrayList<>();
        List<Object> values = new ArrayList<>();
        for (Field field: obj.getClass().getDeclaredFields()){
            field.setAccessible(true);
            try{
                values.add(field.get(obj));
            } catch (IllegalArgumentException | IllegalAccessException e8){
                e8.printStackTrace();
            }
        }
        return values;
    }

    /**
     * @param obj obiect
     * @return obiect
     */
    public static List<String> getFields(Object obj){
        List<String> fieldNames = new ArrayList<>();
        Class<?> clasa = obj.getClass();
        Field[] fields= clasa.getDeclaredFields();
        for(Field field: fields){
            String fieldName = field.getName();
            fieldNames.add(fieldName);
        }
        return fieldNames;
    }
}
