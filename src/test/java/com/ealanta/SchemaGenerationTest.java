package com.ealanta;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import com.ealanta.domain.Customer;
import com.ealanta.schema.JsonSchemaGenerator;
import com.github.victools.jsonschema.generator.OptionPreset;

@RunWith(SpringRunner.class)
@Import(JsonSchemaGenerator.class)
public class SchemaGenerationTest {

	@Autowired
	private JsonSchemaGenerator generator;

	private Class<Customer> customerClass = Customer.class;

	@Test
	public void testGenerateSchema() {
		String plainJson = generate(customerClass, OptionPreset.PLAIN_JSON);
		String javaObject = generate(customerClass, OptionPreset.JAVA_OBJECT);
		String full = generate(customerClass, OptionPreset.FULL_DOCUMENTATION);
		
		System.out.printf("PLAIN JSON  %s%n", plainJson);
		System.out.printf("JAVA OBJECT %s%n", javaObject);
		System.out.printf("FULL        %s%n", full);
	}

	private String generate(Class<?> clazz, OptionPreset preset) {
		String schema = generator.generateSchema(clazz, OptionPreset.PLAIN_JSON);
		return schema;
	}
}
