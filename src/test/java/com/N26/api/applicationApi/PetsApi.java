package com.N26.api.applicationApi;

import com.N26.api.RestResource;
import com.N26.api.Route;
import com.N26.pojo.pets.Pets;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.HashMap;

public class PetsApi {

    @Step
    public static Response post(String petId, Pets requestPets){
        return RestResource.post(Route.PET + "/" + petId, requestPets);
    }

    @Step
    public static Response post(Pets requestPets){
        return RestResource.post(Route.PET, requestPets);
    }

    @Step
    public static Response get(String petId){
        return RestResource.get(Route.PET + "/" + petId);
    }

    @Step
    public static Response get(HashMap<String, String> queryParams){
        return RestResource.get(Route.PET + Route.FIND_BY_STATUS, queryParams);
    }

    @Step
    public static Response update(Pets requestPets){
        return RestResource.update(Route.PET, requestPets);
    }

    @Step
    public static Response delete(Long petId){
        return RestResource.delete(Route.PET + "/" + petId);
    }
}
