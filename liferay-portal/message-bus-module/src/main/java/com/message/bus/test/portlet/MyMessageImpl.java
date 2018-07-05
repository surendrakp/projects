/**
 * Copyright (c) 2015 Capgemini. All rights reserved.
 */

package com.message.bus.test.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;

import org.osgi.service.component.annotations.Component;

/**
 * @author Balavigneshwaran M
 *
 */

@Component(
		immediate = true, property = {"destination.name=test/msglistener" },
		service = MessageListener.class
)

public class MyMessageImpl extends BaseMessageListener {


	private static Log _log = LogFactoryUtil.getLog(MyMessageImpl.class);

	

	@Override
	protected void doReceive(Message message) throws MessageListenerException {
		
		try {
			
			System.out.println("Recieved Message : " + message.toString());
			
			String testStr = message.getString("testStr");
			
			System.out.println("Inside RepositoryMessageImpl  testStr=="+testStr);
			
				
		}
		catch(Exception e) {
			
			_log.error("Invertio : Error creating repository : " + e.getMessage());
			
			e.printStackTrace();
			
		}
		
	}
	
	
	
	
}
