package com.ealanta;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Before;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class BaseSchemaValidationTest {

	protected ObjectMapper mapper = new ObjectMapper();

	protected Schema schema;

	@Before
	public void setup() throws Exception {		
		this.schema = getSchema();
	}
	
	public abstract Schema getSchema() throws Exception ;

	protected String getJsonString(Object obj) throws JsonProcessingException {
		return mapper.writeValueAsString(obj);
	}

	protected JSONObject getJson(String jsonString) throws JSONException {
		JSONObject result = new JSONObject(new JSONTokener(jsonString));
		return result;
	}

	protected boolean isValid(Object obj) throws Exception {
		try {
			JSONObject json = getJson(getJsonString(obj));
			schema.validate(json);
			return true;
		} catch (ValidationException ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
