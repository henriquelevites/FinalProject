package extensions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import utilities.CommonOpps;

import java.util.List;

public class ApiActions extends CommonOpps {

    @Step("Get Data From Server")
    public static Response get(String paramValues) {
        response = httpRequest.get(paramValues);
    //  response.prettyPrint();
        return response;
    }

    @Step("Extract Data From Server")
    public static String extractFromJSON(Response response, String path) {
        jp = response.jsonPath();
        return jp.get(path).toString();
    }

    @Step("Extract List of Data From Server")
    public static List<String> extractListFromJSON(Response response, String path) {
        jp = response.jsonPath();
        return jp.getList(path);
    }

    @Step("Post Data to Server")
    public static void post(JSONObject params, String resource) {
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.post(resource);
        response.prettyPrint();
    }

    @Step("Update Data on Server")
    public static void put(JSONObject params, String resource) {
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.put(resource);
        response.prettyPrint();
    }

    @Step("Delete Data from Server")
    public static void delete(String resource, String id) {
        response = httpRequest.delete(resource + id);
        response.prettyPrint();
    }
}
