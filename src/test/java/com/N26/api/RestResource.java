package com.N26.api;

import io.restassured.response.Response;

import java.util.HashMap;

import static com.N26.api.Route.API;
import static com.N26.api.Route.TOKEN;
import static com.N26.api.SpecBuilder.*;
import static io.restassured.RestAssured.given;

public class RestResource {

    public static Response post(String path, Object request){
        return given(getRequestSpec()).
                body(request).
        when().post(path).
        then().spec(getResponseSpec()).
                extract().
                response();
    }

    public static Response postAccount(HashMap<String, String> formParams){
        return given(getAccountRequestSpec()).
                formParams(formParams).
        when().post(API + TOKEN).
        then().spec(getResponseSpec()).
                extract().
                response();
    }

    public static Response get(String path, HashMap<String, String> queryParams){
        return given(getRequestSpec()).
                queryParams(queryParams).
        when().get(path).
        then().spec(getResponseSpec()).
                extract().
                response();
    }

    /*public static Response get(String path, String token){
        return given(getRequestSpec()).
                auth().oauth2(token).
                when().get(path).
                then().spec(getResponseSpec()).
                extract().
                response();
    }*/

    public static Response get(String path){
        return given(getRequestSpec()).
                when().get(path).
                then().spec(getResponseSpec()).
                extract().
                response();
    }

    public static Response update(String path, Object request){
        return given(getRequestSpec()).
                body(request).
        when().put(path).
        then().spec(getResponseSpec()).
                extract().
                response();
    }

    public static Response delete(String path){
        return given(getRequestSpec()).
                when().get(path).
                then().spec(getResponseSpec()).
                extract().
                response();
    }
}
