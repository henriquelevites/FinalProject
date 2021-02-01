package workflows;

import extensions.ApiActions;
import io.qameta.allure.Step;
import utilities.CommonOpps;
import java.util.List;

public class ApiFlows extends CommonOpps {

    @Step("Business Flow: Get Student Property")
    public static String getStudentProperty (String jPath) {
        response = ApiActions.get("http://localhost:9000/student/");
        return ApiActions.extractFromJSON(response, jPath);
    }

    @Step("Business Flow: Get Student Property List")
    public static List<String> getStudentPropertyList (String jPath) {
        response = ApiActions.get("http://localhost:9000/student/");
        return ApiActions.extractListFromJSON(response, jPath);
    }

    @Step("Business Flow: Create New Student in Students List")
    public static void postStudent(String firstName, String lastName, String email, String programme) {
        requestParams.put("firstName", firstName);
        requestParams.put("lastName", lastName);
        requestParams.put("email", email);
        requestParams.put("programme", programme);
        ApiActions.post(requestParams, "student/");
    }

    @Step("Business Flow: Update Existing Student in Students List")
    public static void updateStudent(String firstName, String lastName, String email, String programme, String id) {
        requestParams.put("firstName", firstName);
        requestParams.put("lastName", lastName);
        requestParams.put("email", email);
        requestParams.put("programme", programme);
        ApiActions.put(requestParams, "student/"+ id);
    }

    @Step("Business Flow: Update Existing Student in Students List")
    public static void deleteStudent(String id) {
        ApiActions.delete("student/", id);
    }
}
