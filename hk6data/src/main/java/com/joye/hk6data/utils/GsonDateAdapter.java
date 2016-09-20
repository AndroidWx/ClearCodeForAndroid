package com.joye.hk6data.utils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.util.Date;

/**
 * 日期 GSON 序列化适配器
 * 
 * Date <==> CST
 * 
 * @author W,x
 *
 */
public class GsonDateAdapter implements JsonDeserializer<Date>,
		JsonSerializer<Date> {

	@Override
	public JsonElement serialize(Date src, Type typeOfSrc,
								 JsonSerializationContext context) {
		
		if(src != null){
			return new JsonPrimitive(src.getTime());
		}
		
		return JsonNull.INSTANCE;
	}

	@Override
	public Date deserialize(JsonElement json, Type typeOfT,
							JsonDeserializationContext context) throws JsonParseException {
		
		if (json == null) {
			return null;
		}
		
		return new Date(json.getAsLong());
	}

}
