package com.projectcompany.Projectname.config;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

@Component
public class JsonDateSerializer extends JsonSerializer<Date>{
	private static final DateFormat DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		String formattedDate = DATEFORMAT.format(value);
		gen.writeString(formattedDate);
	}
}
