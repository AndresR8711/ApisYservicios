import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetObject {

   @BeforeMethod
    public void setup() {
        RestAssured.useRelaxedHTTPSValidation("SSL");
    }

    @Test//se crea anotacion tipo test para poder ejecutar la API, para no usar el main
    public void getObject() {





        RequestSpecification request = given() //se define un objeto de tipo request especification
                .baseUri("https://api.restful-api.dev") //se define la URl base
                .basePath("/objects"); // se agrega el recurso

        Response response = request // se crea objeto donde se guarda la respuesta del Apid
                .when()
               //.get();
           .get("ff80818190966d7f0190a50af9d1239b");

        response.prettyPrint(); //mostrar la API en pantalla
        Assert.assertEquals(response.getStatusCode(), 200);


    }
}
