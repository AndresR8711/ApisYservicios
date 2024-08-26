import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetWithUrlParams {


    @BeforeMethod
    public void setup() {
        RestAssured.useRelaxedHTTPSValidation("SSL");
    }

    @Test//se crea anotacion tipo test para poder ejecutar la API, para no usar el main
    public void getWithUrlParams() {

        RequestSpecification request = given() //se define un objeto de tipo request especification
                .baseUri("https://api.restful-api.dev") //se define la URl base
                .basePath("/objects")// se agrega el recurso
                .formParam("id", 1)
                 .formParam("id", 2)//primera forma de llamar los paramentros de a uno por uno
                 .formParam("id", 4,5);//segunda forma de llamar los paramentros de a uno por uno


        Response response = request // se crea objeto donde se guarda la respuesta del Api
                .when()
                .get();

        response.prettyPrint(); //mostrar la API en pantalla
        Assert.assertEquals(response.getStatusCode(), 200);


    }
}