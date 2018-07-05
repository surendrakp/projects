package com.message.bus.test.portlet;

import com.message.bus.test.constants.MessageBusModulePortletKeys;

import java.io.IOException;

import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

/**
 * @author surendku
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=message-bus-module Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + MessageBusModulePortletKeys.MessageBusModule,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class MessageBusModulePortlet extends MVCPortlet {
	
	
	
	public void messageListnerTest(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		
		
		String testString=ParamUtil.getString(actionRequest, "testStr");
		
		
		Message message = new Message();
		
		message.put("testStr", testString);
		
		MessageBusUtil.sendMessage("test/msglistener", message);
		
		
		
	}
	
}