package testNGsessions;

import org.testng.annotations.Test;

public class DependsOnMethodConcept {
//When the dependency is defined for a test, if the test other test test fails then the dependent tets will get skipped from execution
//its not a good practice to define the dependency
//Tests should always be independent of each other
//following AAA rule is the recommended way of designing the tests in the framework


	@Test
	public void a_test() {
		System.out.println("a test");
		int i=9/0;  //This test will fail because of arithmetic exception
	}
	@Test(dependsOnMethods="a_test") //This test will get skipped from execution
	public void b_test() {
		System.out.println("b test");
	}
	@Test(dependsOnMethods="a_test") //This test will get skipped from execution
	public void c_test() {
		System.out.println("c test");
	}
	@Test(dependsOnMethods="a_test") //This test will get skipped from execution
	public void d_test() {
		System.out.println("d test");
	}

}
