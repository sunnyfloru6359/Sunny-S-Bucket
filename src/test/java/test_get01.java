import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class test_get01 {

	@BeforeTest
	public static void main(String[] args) {

		Response response = RestAssured.get("https://dummy.restapiexample.com/api/v1/employees\r\n");
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());
		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
	}

	@Test
	public void test1() {
		Response response = RestAssured.get("https://dummy.restapiexample.com/api/v1/employee/1\r\n");
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());
		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
	}

	@AfterTest
	public void test2() {
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());
		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
	}
}
