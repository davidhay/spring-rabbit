package com.ealanta.schema;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.victools.jsonschema.generator.OptionPreset;
import com.github.victools.jsonschema.generator.SchemaGenerator;
import com.github.victools.jsonschema.generator.SchemaGeneratorConfig;
import com.github.victools.jsonschema.generator.SchemaGeneratorConfigBuilder;

@Component
public class JsonSchemaGenerator {

	public String generateSchema(Class<?> clazz, OptionPreset preset) {
		ObjectMapper objectMapper = new ObjectMapper();
		SchemaGeneratorConfigBuilder configBuilder = new SchemaGeneratorConfigBuilder(objectMapper, preset);
		SchemaGeneratorConfig config = configBuilder.build();
		SchemaGenerator generator = new SchemaGenerator(config);
		JsonNode jsonSchema = generator.generateSchema(clazz);
		return jsonSchema.toString();
	}
	
	public String generateSchema(Class<?> clazz) {
		return generateSchema(clazz, OptionPreset.FULL_DOCUMENTATION);
	}
}

