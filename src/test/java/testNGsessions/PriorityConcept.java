package testNGsessions;

import org.testng.annotations.Test;

public class PriorityConcept {
//When priority is not defined for tets cases, then they are executed in alphabetical order
//When prioority is defined for some test cases, then the nonpriority test cases are executed first then priority ones
//priority can start from zero or a negative number	
//but practically zero or -ve number are not used in the framework
//The datatype of priority keyword is an integer

	
	@Test
	public void a_test() {
		System.out.println("a test");
	}
	@Test
	public void b_test() {
		System.out.println("b test");
	}
	@Test(priority=1)
	public void c_test() {
		System.out.println("c test");
	}
	@Test(priority=3)
	public void d_test() {
		System.out.println("d test");
	}
	@Test(priority=2)
	public void e_test() {
		System.out.println("e test");
	}

}
