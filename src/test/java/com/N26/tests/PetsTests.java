package com.N26.tests;

import com.N26.api.StatusCode;
import com.N26.pojo.Error;
import com.N26.pojo.pets.Pets;
import com.N26.utils.FakerUtils;
import com.N26.api.applicationApi.PetsApi;
import com.N26.utils.DataLoader;
import io.qameta.allure.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PetsTests extends BaseTest{

    @DataProvider(name = "AddANewPet")
    public Object[][] getParams(){
        return new Object[][] {{"available"}, {"pending"}, {"sold"}};
    }

    @Story("Add a pet to the store")
   /* @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    @TmsLink("12345")
    @Issue("1234567")*/
    @Description("Add a new pet to the store and validate the response contains name and status")
    @Test(description = "should be able to add a pet to the store", dataProvider = "AddANewPet")
    public void shouldBeAbleToAddANewPet(String status){

        Pets requestPet = petsBuilder(FakerUtils.generateAnimalName(), status);
        Response response = PetsApi.post(requestPet);
        assertStatusCode(response.statusCode(), StatusCode.CODE_200);
        assertPetNameAndStatus(response.as(Pets.class), requestPet);
    }

    @Test(description = "should be able to get pet details and " +
            "match the response with expected value", dataProvider = "AddANewPet")
    public void shouldBeAbleToGetPetDetailsUsingStatus(String status){

        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("status", status);
        Response response = PetsApi.get(queryParams);
        assertStatusCode(response.statusCode(), StatusCode.CODE_200);

        JsonPath jsonPath = response.jsonPath();
        List<String> allPets = Arrays.asList(jsonPath.getString("status").split(","));
        assertPetContains(allPets, queryParams.get("status"));
    }

    /**
     * As per the API, any other value of status than available,
     * pending or sold should return 400 status code
     * But there is a bug in this API, hence this test case fails.
     */
    @Test(description = "should not be able to get pet details")
    public void shouldNotBeAbleToGetPetDetailsUsingIncorrectStatus(){

        String status = "dead";
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("status", status);
        Response response = PetsApi.get(queryParams);
        assertStatusCode(response.statusCode(), StatusCode.CODE_400); //It will fail
    }

    @Test(description = "should be able to get pet details using PetId")
    public void shouldBeAbleToGetPetDetailsUsingPetId(){

        String petId = DataLoader.getInstance().getGetPetId();
        Response response = PetsApi.get(petId);
        assertStatusCode(response.statusCode(), StatusCode.CODE_200);
        assertPetId(response.as(Pets.class), petId);
    }

    @Test(description = "should be able to update the Pet details")
    public void shouldBeAbleToUpdateExistingPetId(){

        Pets requestPet = petsBuilder(FakerUtils.generateAnimalName(), "available",
                Long.valueOf(DataLoader.getInstance().getUpdatePetId()));

        Response response = PetsApi.update(requestPet);
        assertStatusCode(response.statusCode(), StatusCode.CODE_200);
        assertPetNameAndStatus(response.as(Pets.class), requestPet);
        assertPetId(response.as(Pets.class), DataLoader.getInstance().getUpdatePetId());
    }

    @Test(description = "should be able to delete the Pet details")
    public void shouldBeAbleToDeletePetId(){

        Pets requestPet = petsBuilder(FakerUtils.generateAnimalName(), "available");
        Response response = PetsApi.post(requestPet);
        Long petId = response.as(Pets.class).getId();

        Response deleteApiResponse = PetsApi.delete(petId);
        assertStatusCode(deleteApiResponse.statusCode(), StatusCode.CODE_200);
    }

    @Step
    public Pets petsBuilder(String name, String status){
        return Pets.builder().
                name(name).
                status(status).
                build();
    }

    @Step
    public Pets petsBuilder(String name, String status, Long petId){
        return Pets.builder().
                id(petId).
                name(name).
                status(status).
                build();
    }

    @Step
    public void assertPetNameAndStatus(Pets responsePetList, Pets requestPetList){
        assertThat(responsePetList.getName(), equalTo(requestPetList.getName()));
        assertThat(responsePetList.getStatus(), equalTo(requestPetList.getStatus()));
    }

    @Step
    public void assertPetId(Pets responsePetList, String petId){
        assertThat(responsePetList.getId(), equalTo(Long.valueOf(petId)));
    }

    @Step
    public void assertPetContains(List<String> allPets, String status){
        Assert.assertTrue(allPets.stream().allMatch(e->e.equals(status)));
    }

    @Step
    public void assertStatusCode(int actualStatusCode, StatusCode statusCode){
        assertThat(actualStatusCode, equalTo(statusCode.code));
    }

    @Step
    public void assertError(Error responseErr, StatusCode statusCode){
        assertThat(responseErr.getError().getStatus(), equalTo(statusCode.code));
        assertThat(responseErr.getError().getMessage(), equalTo(statusCode.msg));
    }
}
