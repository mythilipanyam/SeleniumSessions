package testNGsessions;

import org.testng.annotations.Test;

public class InvocationCountConcept {
//SAme tets will be executed 10 times in the below example because of the invocation count
//To generate the load sequentially to check if the server is responding eg:creating the users back to back

	
	@Test(invocationCount=10)
	public void a_test() {
		System.out.println("a test");
	}

}
