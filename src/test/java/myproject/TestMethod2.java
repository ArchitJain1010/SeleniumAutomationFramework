package myproject;

import org.testng.annotations.Test;

public class TestMethod2 {
	@Test (priority=2, groups= {"regression"})
	public void testMethod1() {
		System.out.println("This is test Method1");
	}
	@Test (priority=1)
public void testMethod2() {
	System.out.println("This is test method2");
}

}
