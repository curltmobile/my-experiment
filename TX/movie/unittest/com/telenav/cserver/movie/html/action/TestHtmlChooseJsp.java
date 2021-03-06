/**
 * (c) Copyright 2011 TeleNav.
 * All Rights Reserved.
 */
package com.telenav.cserver.movie.html.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import junit.framework.TestCase;

import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.powermock.api.easymock.PowerMock;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

/**
 * TestHtmlChooseJsp.java
 * @TODO
 * @author  xljiang@telenav.cn
 * @version 1.0 2011-9-27
 */

public class TestHtmlChooseJsp extends TestCase{
	private HttpServletRequest httpRequest = PowerMock.createMock(HttpServletRequest.class);
	private ActionMapping mapping = null;
	private HttpServletResponse httpResponse = PowerMock.createMock(HttpServletResponse.class);
	
	
	
	
	//---- modify me 2, over----------
	private Class<HtmlChooseJsp> actionType = HtmlChooseJsp.class;
	private HtmlChooseJsp testedAction = Whitebox.newInstance(actionType);
	//----
	@Override
	protected void setUp() throws Exception {
		MemberModifier.suppress(ActionMapping.class.getConstructors());
		mapping = PowerMock.createMock(ActionMapping.class);
	}
	public void testSimple() throws Exception{
		Object o = actionType.newInstance();
	}
	
	public void testDoAction() throws Exception{
		testedAction.doAction(mapping, httpRequest, httpResponse);
	}

}
