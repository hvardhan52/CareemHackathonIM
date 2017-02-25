package com.main.inventory_system.utilities;

import java.lang.reflect.Field;

import org.bson.Document;

public class UtilityMethods {

	public static <E> Document JavaToDocument(E object) throws IllegalArgumentException, IllegalAccessException{
		 Document doc = new Document();
		 for (Field f : object.getClass().getDeclaredFields()) {
			f.setAccessible(true);
	    String name = f.getName();
	    Object value = f.get(object);
	    doc.append(name, value);
	}
	return doc;
	}
}
