/**
 * (c) Copyright 2011 TeleNav.
 *  All Rights Reserved.
 */
package com.telenav.cserver.html.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.telenav.cserver.framework.executor.ExecutorContext;
import com.telenav.cserver.framework.executor.ExecutorDispatcher;
import com.telenav.cserver.framework.executor.ExecutorRequest;
import com.telenav.cserver.framework.executor.ExecutorResponse;
import com.telenav.cserver.poi.executor.POIFeedbackSaveResponse;

/**
 * poi list feedback action
 * @author  zhhyan@telenav.cn
 * @version Feb 18, 2011
 */
public class HtmlPoiListFeedbackSaveAction extends HtmlPoiBaseAction {
	private static final Logger logger = Logger.getLogger(HtmlPoiReviewAction.class);
	
	@Override
	/**
	 * 1) parse paramter from httprequest
	 * 2) run logic in execute
	 * 3) format httprequest to front end
	 */
	protected ActionForward doAction(ActionMapping mapping,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception 
	{
		try {
			ExecutorRequest[] requests = this.requestParser.parse(httpServletRequest);
			POIFeedbackSaveResponse response = new POIFeedbackSaveResponse();
			if (requests != null && requests.length > 0) 
			{
				ExecutorDispatcher.getInstance().execute(requests[0], response,new ExecutorContext());
				
			} 
			if( response.getStatus() == ExecutorResponse.STATUS_FAIL )
			{
				httpServletRequest.setAttribute("errorCode", new Long(-1));
				httpServletRequest.setAttribute("errorMsg", response.getErrorMessage());
                return mapping.findForward("failure");
			}
			this.responseFormatter.format(httpServletRequest, new ExecutorResponse[]{response});
			return mapping.findForward("success");
		}
		catch (Exception e) 
		{
			logger.error("HtmlPoiFeedbackSaveAction#doAction",e);
            ActionMessages msgs = new ActionMessages();
            msgs.add("reviewfailed", new ActionMessage("errors.poi.failed"));
            addErrors(httpServletRequest, msgs);
            return mapping.findForward("failure");
		}
		
	}

}
