package testNGsessions;

import org.testng.annotations.Test;

public class ExpectedExceptionConcept {
	String name="Mythili";
	
//When we add expectedExceptions at the class level, then the test will pass even though it throwns an exception

	
	@Test(expectedExceptions=ArithmeticException.class)
	public void a_test() {
		System.out.println("a test");
		int i=9/0;  //Arithmetic Exception
	}
	
	
//In the below example, the test will get failed because arithmetic exception is mentioned instead of nullpointerexception
	@Test(expectedExceptions=ArithmeticException.class)
	public void b_test() {
		System.out.println("a test");
		ExpectedExceptionConcept obj=null;
		System.out.println(obj.name);//throws nullpointerexception
		
	}
	
	//multiple exceptions can be mentioned
	@Test(expectedExceptions= {ArithmeticException.class, NullPointerException.class})
	public void c_test() {
		System.out.println("a test");
		int a=9/0;
		ExpectedExceptionConcept obj=null;
		System.out.println(obj.name);//throws nullpointerexception
		
	}
	
	
	
	
	
	
	
	
	
}
