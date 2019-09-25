package com.ealanta;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeeMicroService {

	@GetMapping("hello/{name}")
	public String endpoint(@PathVariable("name") String name) {
		return String.format("Hello %s", name);
	}
	
	@PostMapping(value = "/endpoint", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> greetingJson(@RequestBody String raw) {
		
		DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		LocalDateTime now = LocalDateTime.now(ZoneOffset.UTC);
		String dateString = FORMATTER.format(now);
				
		System.out.printf("[%s]JSON IS [%s]%n", dateString, raw);
		return ResponseEntity.ok().body(raw);
	}
}
