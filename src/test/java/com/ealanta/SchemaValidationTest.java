package com.ealanta;

import java.nio.charset.StandardCharsets;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StreamUtils;

import com.ealanta.domain.Customer;
import com.ealanta.domain.NotACustomer;

@RunWith(SpringRunner.class)
public class SchemaValidationTest extends BaseSchemaValidationTest {

	@Value("classpath:schemas/customer-schema.json")
	private Resource customerSchemaResource;

	@Test
	public void testValidCustomerAgainstSchema() throws Exception {
		Assert.assertTrue(isValid(new Customer("FIRST", "LAST")));
	}

	@Test
	public void testInvalidCustomerAgainstSchema() throws Exception {
		Assert.assertFalse(isValid(new NotACustomer("FIRST", "SURNAME")));
	}

	@Override
	public Schema getSchema() throws Exception {
		String customerJsonSchema = StreamUtils.copyToString(this.customerSchemaResource.getInputStream(),
				StandardCharsets.UTF_8);
		JSONObject schema = getJson(customerJsonSchema);
		SchemaLoader loader = SchemaLoader.builder().schemaJson(schema).build();
		return loader.load().build();
	}


}
