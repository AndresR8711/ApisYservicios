import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.File;
import static io.restassured.RestAssured.given;

public class UpdateObject {

    @BeforeMethod
    public void setup() {
        RestAssured.useRelaxedHTTPSValidation("SSL");
    }


    @Test//se crea anotacion tipo test para poder ejecutar la clase
    public void UpdateObject() {

        File putBody = new File("src\\main\\resources\\putBody.json");

        RequestSpecification request = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects")
                .header("Content-Type", "application/json")
                .body(putBody);


        Response response = request
                .when()
                .put("ff80818190966d7f0190a51941c323b0");
        //.get("4");

        response.prettyPrint(); //mostrar la API en pantalla
        int statusCode = response.getStatusCode();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

}
