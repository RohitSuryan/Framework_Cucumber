package stepDefinations;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomePageSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private HomePage homePage ; 
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable dataTable) {
	  
		List<Map<String, String>> credList = dataTable.asMaps();
		String username = credList.get(0).get("username");
		String password = credList.get(0).get("password");
		
		DriverFactory.getDriver().get("https://freecrm.com/");
		homePage = loginPage.doLogin(username, password);
	}

	@Given("user is on Home page")
	public void user_is_on_Home_page() {
		String title = homePage.getHomePagetitle();
		System.out.println("Home Page title is: " + title);
	}

	@Then("user gets Home section")
	public void user_gets_Home_section(DataTable sectionsTable) {
	   
		List<String> expHomeSectionsList = sectionsTable.asList();
		System.out.println("Expected Home section list : " + expHomeSectionsList);
		
		List<String> actualHomeSectionList = homePage.getHomeSectionsList();
		System.out.println("Actual Home section list : " + actualHomeSectionList);

		Assert.assertTrue(expHomeSectionsList.containsAll(actualHomeSectionList));
	}

	@Then("Home section count should be {int}")
	public void Home_section_count_should_be(Integer exSectionCount) {
//	   Assert.assertTrue(homePage.getHomeSectionCount() == exSectionCount);
		System.out.println(homePage.getHomeSectionCount());

	}
	
}
