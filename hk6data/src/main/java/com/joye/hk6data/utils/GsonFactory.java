package com.joye.hk6data.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;
import java.util.Date;

/**
 * GSON 工厂
 * 
 * 使用：{@link GsonFactory#SingleTon#create()}
 * 
 * @author Wx
 *
 */
public enum GsonFactory {

	SingleTon;

	private GsonBuilder builder;

	private GsonFactory() {
		builder = new GsonBuilder().registerTypeAdapter(Date.class,
				new GsonDateAdapter());
	}

	public Gson create() {
		return builder.create();
	}
	
	public void registerTypeAdapter(Type type, Object typeAdapter){
		builder.registerTypeAdapter(type, typeAdapter);
	}
}
