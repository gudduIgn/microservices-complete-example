package com.products.core.serializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.products.core.data.Catalogue;
import com.products.core.data.Product;

public class CatalogueSerializer extends JsonSerializer<Catalogue> {

	  @Override
	  public void serialize(Catalogue value, JsonGenerator generator,
	            SerializerProvider provider) throws IOException,
	            JsonProcessingException {
	    generator.writeStartObject();
	    generator.writeFieldName("id");
	    generator.writeNumber(value.getId());
	    generator.writeFieldName("name");
	    generator.writeString(value.getName());
	    generator.writeFieldName("products");
	    generator.writeStartArray();
	    for (Product product : value.getProducts()) {
	    	generator.writeObject(product);
		}
	    generator.writeEndArray();
	    generator.writeEndObject();
	  }
	}
