package com.ealanta;

import java.nio.charset.StandardCharsets;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaClient;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StreamUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@RunWith(SpringRunner.class)
public class AllOfSchemaValidationTest extends BaseSchemaValidationTest {

	@Value("classpath:schemas/allOf-schema.json")
	private Resource customerSchemaResource;

	@Test
	public void testValidCustomerAgainstSchema() throws Exception {
		Assert.assertTrue(isValid(new ParentChild("p1", "p2","c1","c2")));
	}


	@Override
	public Schema getSchema() throws Exception {
		String customerJsonSchema = StreamUtils.copyToString(this.customerSchemaResource.getInputStream(),
				StandardCharsets.UTF_8);
		
		
		JSONObject schema = getJson(customerJsonSchema);
		SchemaLoader schemaLoader = SchemaLoader.builder()
		        .schemaClient(SchemaClient.classPathAwareClient())
		        .schemaJson(schema)
		        .resolutionScope("classpath://schemas/") // setting the default resolution scope
		        .build();
		return schemaLoader.load().build();
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class ParentChild {
		private String parent1;
		private String parent2;
		private String parent3;
		private String parent4;
	}
}
