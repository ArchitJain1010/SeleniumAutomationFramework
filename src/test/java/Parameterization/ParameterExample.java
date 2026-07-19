package Parameterization;

import org.testng.annotations.Test;

import org.testng.annotations.Parameters;
public class ParameterExample {
	
	@Test (groups="parameter")
	@Parameters({"browser", "url"})
    public void launchApplication(String browser, String url) {

        System.out.println("Browser Name : " + browser);
        System.out.println("Application URL : " + url);

    }

}
