package stepDefinitions;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import utils.CommonMethods;
import org.openqa.selenium.WebElement;
import utils.ConfigReader;

public class SearchEmployee extends CommonMethods {
    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        WebElement PimTab=driver.findElement(By.id("menu_pim_viewPimModule"));
        doClick(PimTab);
    }
    @When("user enters valid employee Id")
    public void user_enters_valid_employee_id() {
        WebElement empId= driver.findElement(By.id("empsearch_id"));
        sendText(empId, ConfigReader.getPropertyValue("empId"));
    }
    @When("user selects job title")
    public void user_selects_job_title() {
        WebElement jobTitleDdl=driver.findElement(By.id("empsearch_job_title"));
        selectByOptions(jobTitleDdl,"Singer");

        WebElement employeeStatusDdl=driver.findElement(By.id("empsearch_employee_status"));
        selectByOptions(employeeStatusDdl,"Active");

        WebElement includeDdl=driver.findElement(By.id("empsearch_termination"));
        selectByOptions(includeDdl,"Current and Past Employees");

        WebElement subUnitDdl=driver.findElement(By.id("empsearch_sub_unit"));
        selectByOptions(subUnitDdl,"Test");
    }
    @When("clicks on search button")
    public void clicks_on_search_button() {
        WebElement searchBtn= driver.findElement(By.id("searchBtn"));
        doClick(searchBtn);
    }
    @When("user sees employee information displayed")
    public void user_sees_employee_information_displayed() {
        System.out.println("Successful");
    }
    @When("user enters valid {string} and valid {string}")
    public void user_enters_valid_and_valid(String username, String password) {
        WebElement userNameTextBox=driver.findElement(By.xpath("//input[@type='text']"));
        sendText(userNameTextBox,username);
        WebElement passwordTextBox=driver.findElement(By.xpath("//input[@type='password']"));
        sendText(passwordTextBox,password);
    }



}
