package com.projectcompany.Projectname.config;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

@Component
public class JsonDateDeserializer extends JsonDeserializer<Date> {
	
	private static final DateFormat DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		try {
			return DATEFORMAT.parse(p.getText());
		} catch (ParseException e) {
			return new Date();
		}
	}
}
