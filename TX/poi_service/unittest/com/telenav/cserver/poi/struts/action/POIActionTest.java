package com.telenav.cserver.poi.struts.action;

import junit.framework.Assert;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.telenav.cserver.poi.protocol.PoiBrowserProtocolRequestParser;
import com.telenav.cserver.poi.protocol.PoiBrowserProtocolResponseFormatter;
import com.telenav.cserver.util.MockHttpServletRequest;
import com.telenav.cserver.util.MockHttpServletResponse;
import com.telenav.cserver.util.helper.log2txnode.Log2TxNode;
import com.telenav.j2me.datatypes.TxNode;

public class POIActionTest {
	
	private int	ajaxChildValue = 110;
	private String actionName = "queryPoi.do";
	private String actionName_SearchAlongroute = "queryPoi_mock.do";
	private String failString = "couldn't find the TxNode in file when testing queryPoi action";
	
	private ActionMapping mapping = new ActionMapping();
	private MockHttpServletRequest request = null;
	private MockHttpServletResponse response = new MockHttpServletResponse();;
	private PoiBrowserProtocolRequestParser parser = new PoiBrowserProtocolRequestParser();
	private PoiBrowserProtocolResponseFormatter formatter = new PoiBrowserProtocolResponseFormatter();
	
	public 	POIAction POIAction = new POIAction();
	
	@Before
	public void setUp() throws Exception {
		
		POIAction.setRequestParser(parser);
		POIAction.setResponseFormatter(formatter);
		mapping.addForwardConfig(new ActionForward("success","/jsp/AjaxResponse.jsp", false));
		mapping.addForwardConfig(new ActionForward("failure","/jsp/ErrorMsgPage.jsp", false));
		
		request = (MockHttpServletRequest)Log2TxNode.getInstance().log2TxNode2HttpServletRequest(request, actionName, ajaxChildValue);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDoActionAction() {
		try 
		{
			if(request == null)
			{
				Assert.fail(failString);
			}
			
			POIAction.doAction(mapping, request, response);
			TxNode node = (TxNode)request.getAttribute("node");
			Assert.assertNotNull(node);
			
			request = (MockHttpServletRequest)Log2TxNode.getInstance().log2TxNode2HttpServletRequest(request, actionName_SearchAlongroute, ajaxChildValue);
			POIAction.doAction(mapping, request, response);
			TxNode node2 = (TxNode)request.getAttribute("node");
			Assert.assertNotNull(node2);
			
			
		} catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
