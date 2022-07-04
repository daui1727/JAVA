package com.springbook.injection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {

	public static void main(String[] args) {
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		CollectionBean bean = (CollectionBean)factory.getBean("CollectionBean");
		List<String> addressList = bean.getAddressList();
		for(String address : addressList) {
			System.out.println(address.toString());
		}
		
		System.out.println("----------------------------");
		
		Set<String> addressSet = bean.getAddressSet();
		for(String set : addressSet) {
			System.out.println(set.toString());
		}
		
		System.out.println("----------------------------");

		Map<String, String> addressMap = bean.getAddressMap();
		for(String key : addressMap.keySet()) {
			System.out.println(key + " " + addressMap.get(key));
		}
		
		System.out.println("----------------------------");

		Properties addressProperties = bean.getAddressProperties();
		for(String key : addressProperties.stringPropertyNames()) {
			System.out.println(key + " " + addressProperties.getProperty(key));
		}
		
		
		factory.close();
	}

}
