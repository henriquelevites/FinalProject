package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOpps;
import workflows.ApiFlows;

import java.util.List;

@Listeners(utilities.Listeners.class)
public class StudentsAPI extends CommonOpps {

    @Test(description="Test01: Get Student Details From Server")
    @Description("This test verifies student properties")
    public void test01_verifyStudentDetails () {
        int indexToGet = 5; /* index of student to verify details (to verify another student,
                          please change index and expected strings */
        Verifications.verifyTexts(ApiFlows.getStudentProperty("[" + indexToGet + "].firstName"), "Harper");
        Verifications.verifyTexts(ApiFlows.getStudentProperty("[" + indexToGet + "].lastName"),"Rashad");
        Verifications.verifyTexts(ApiFlows.getStudentProperty("[" + indexToGet + "].email"),"vestibulum@ridiculusmus.edu");
        Verifications.verifyTexts(ApiFlows.getStudentProperty("[" + indexToGet + "].programme"),	"Disaster Management");
    }

    @Test(description="Test02: Add New Student To Server and Verify")
    @Description("This test adds a new student to students list and verifies it first name")
    public void test02_addStudentAndVerify() {
        ApiFlows.postStudent("Henrique","Levites", "henrique102@h.co.il", "Treino em casa");
        List<String> firstNames = ApiFlows.getStudentPropertyList("firstName");
        Verifications.verifyTexts(firstNames.get(firstNames.size()-1), "Henrique");
    }

    @Test(description= "Test03: Update Student in Server and Verify")
    @Description("This test updates a student in students list and verifies it")
    public void test03_updateStudentAndVerify() {
        String id = ApiFlows.getStudentProperty("[100].id");
        ApiFlows.updateStudent("Henrique 101","Levites","henrique101@h.co.il","Programa 101", id);
        Verifications.verifyTexts(ApiFlows.getStudentProperty("[100].firstName"), "Henrique 101");
        Verifications.verifyTexts(ApiFlows.getStudentProperty("[100].programme"), "Programa 101");
    }

    @Test(description= "Test04: Delete Student and Verify")
    @Description("This test deletes a student in students list and verifies it")
    public void test04_deleteStudentAndVerify() {
        //  int indexToUpdate = 102;
        String id = ApiFlows.getStudentProperty("[100].id");
        ApiFlows.deleteStudent(id);
        List<String> ids = ApiFlows.getStudentPropertyList("id");
        Verifications.verifyTexts(Integer.toString(ids.size()), Integer.toString(100));
    }
}
