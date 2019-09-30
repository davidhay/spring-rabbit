package com.ealanta;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;

import com.ealanta.generated.cli.PORSchema;
import com.ealanta.generated.cli.PositionSchema;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
public class JsonToCorrectPojoTest {

	@Value("classpath:json/por-example-1.json")
	private Resource porExample1;
	
	
	@Value("classpath:json/position-example-1.json")
	private Resource posExample1;
	
	private String jsonPosExample1;
	private String jsonPorExample1;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@Before
	public void setup() throws IOException {
		jsonPosExample1 = inputStreamToString(this.posExample1.getInputStream());
		jsonPorExample1 = inputStreamToString(this.porExample1.getInputStream());
	}
	
	private String inputStreamToString(InputStream inputStream) throws IOException {
		StringWriter writer = new StringWriter();
		IOUtils.copy(inputStream, writer, StandardCharsets.UTF_8);
		return writer.toString();
	}
	
	@Test
	public void testPosJsonToPojo() throws Exception {
		System.out.println(this.jsonPosExample1);
		PositionSchema pos = mapper.readerFor(PositionSchema.class).readValue(this.posExample1.getInputStream());
		
		Assert.assertEquals(Long.valueOf(123456789123456L), pos.getPositionID());
		Assert.assertEquals(PositionSchema.ChangeDeleteIndicator.D, pos.getChangeDeleteIndicator());
		Assert.assertEquals(Long.valueOf(1234567890L), pos.getPositionNumber());
		Assert.assertEquals("test",pos.getPositionTitle());
		Assert.assertEquals("ACODE",pos.getOccupationCode());
		Assert.assertEquals("Around",pos.getAreaOfWork());
		Assert.assertEquals("Spec",pos.getSecondSpeciality());
		Assert.assertEquals("NTH/RTFED/040/STR/210", pos.getDeaneryNumber());
		Assert.assertEquals("Northern", pos.getManagingOffice());
		Assert.assertEquals("CodingCode", pos.getOdsCode());
		Assert.assertEquals("NTH", pos.getGradeTrust());
		Assert.assertEquals("High", pos.getGradePayscale());
		Assert.assertEquals("Senior", pos.getGradeDesc());
		Assert.assertEquals("WTO", pos.getWorkplaceOrg());
	}
	
	@Test
	public void testPorJsonToPojo() throws IOException {
		System.out.println(this.jsonPorExample1);
		PORSchema por = mapper.readerFor(PORSchema.class).readValue(this.porExample1.getInputStream());
		
		Assert.assertEquals(Long.valueOf(123456789123456L), por.getPositionID());
		Assert.assertEquals(PORSchema.ChangeDeleteIndicator.D, por.getChangeDeleteIndicator());
		Assert.assertEquals(Long.valueOf(1234567890L), por.getPositionNumber());
		Assert.assertEquals("test",por.getPositionTitle());
		
		Assert.assertEquals("NTH/RTFED/040/STR/210", por.getDeaneryNumber());		
		Assert.assertEquals("Northern", por.getManagingOffice());
		Assert.assertEquals("CodingCode", por.getOdsCode());
		Assert.assertEquals(PORSchema.HostLeadIndicator.HOST_EMPLOYER, por.getHostLeadIndicator());
		
		Assert.assertEquals(Long.valueOf(234L), por.getEmployingOrgVPDCode());
		Assert.assertEquals("Happy Org", por.getEsrOrganisation());
		Assert.assertEquals("there", por.getEsrLocation());		
	}

}
