package com.N26.utils;

import java.util.Properties;

public class DataLoader {
    private final Properties properties;
    private static DataLoader dataLoader;

    private DataLoader(){
        properties = PropertyUtils.propertyLoader("src/test/resources/data.properties");
    }

    public static DataLoader getInstance(){
        if(dataLoader == null){
            dataLoader = new DataLoader();
        }
        return dataLoader;
    }

    public String getGetPetId(){
        String prop = properties.getProperty("get_pet_id");
        if(prop != null) return prop;
        else throw new RuntimeException("property get_pet_id is not specified in the data.properties file");
    }

    public String getUpdatePetId(){
        String prop = properties.getProperty("update_pet_id");
        if(prop != null) return prop;
        else throw new RuntimeException("property update_pet_id is not specified in the data.properties file");
    }
}
