package com.ealanta;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;

import com.ealanta.domain.Customer;
import com.ealanta.domain.DateOfBirth;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jsonschema.main.JsonValidator;

import org.junit.*;

@RunWith(SpringRunner.class)
public class SchemaValidationTest {

	@Value("classpath:schemas/customer-schema.json")
	private Resource customerSchemaResource;
	
	private ObjectMapper mapper = new ObjectMapper();

	private JsonNode schemaAsJsonNode;
	
	private static final JsonValidator VALIDATOR = JsonSchemaFactory.byDefault().getValidator();
	private DateOfBirth dob = new DateOfBirth(1, 1, 1971);
	private DateOfBirth dobExtra = new DateOfBirth(2, 2, 1972);
	private Customer customerNoDob;//VALID
	private Customer customerWithDob;//VALID
	private Customer customerWithDobExtra;//NOT VALID - DOB HAS EXTRA PROPERTIES NOT IN SCHEMA;
	
	
	@Before
	public void setup() throws Exception {
		this.schemaAsJsonNode = mapper.readTree(customerSchemaResource.getInputStream());
		customerNoDob = new Customer("first","last");
		customerWithDob = new Customer("first","last");
		customerWithDob.setDob(dob);
		customerWithDobExtra = new Customer("first","last");
		customerWithDobExtra.setDob(dobExtra);
	}

	@Test
	public void testSimpleCustomerAgainstSchema() throws Exception {
		Assert.assertTrue(isValid(schemaAsJsonNode, getJson(this.customerNoDob)));
	}
	
	@Test
	public void testNotACustomerAgainstSchema() throws Exception {
		Assert.assertFalse(isValid(schemaAsJsonNode, getJson(new NotACustomer("first","last"))));
	}
	
	private boolean isValid(JsonNode schemaJsonNode, JsonNode jsonNode) throws Exception {
		ProcessingReport result = VALIDATOR.validate(schemaJsonNode, jsonNode);
		if(result.isSuccess()) {
			System.out.printf("VALID JSON [%s]%n",jsonNode.toString());
			return true;
 		} else {
			result.forEach(pm -> {
				System.out.printf("MSG [%s]%n",pm);
			});
			return false;
		}
	}
	
	private JsonNode getJson(Object obj) throws JsonProcessingException {
		return mapper.convertValue(obj, JsonNode.class);
	}
	
	public static class NotACustomer {
		public NotACustomer(String first, String surname) {
			super();
			this.first = first;
			this.surname = surname;
		}
		private final String first;
		private final String surname;
		public String getFirst() {
			return first;
		}
		public String getSurname() {
			return surname;
		}		
	}
	
}
