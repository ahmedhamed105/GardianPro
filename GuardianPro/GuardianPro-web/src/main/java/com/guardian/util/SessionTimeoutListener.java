/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.util;

import java.io.IOException;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.DispatcherType;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author ahmed.elemam
 */
public class SessionTimeoutListener implements PhaseListener {
    private String getLoginPath() {
        return "/faces/index.xhtml";
    }
 
    @Override
    public void beforePhase(final PhaseEvent event) {
        final FacesContext facesContext = FacesContext.getCurrentInstance();
        if (!facesContext.getPartialViewContext().isAjaxRequest() || facesContext.getRenderResponse()) { // not ajax or too late
            return;
        }
 
        final HttpServletRequest request = HttpServletRequest.class.cast(facesContext.getExternalContext().getRequest());
        if (request.getDispatcherType() == DispatcherType.FORWARD && getLoginPath().equals(request.getServletPath())) { // isLoginRedirection()
            final String redirect = facesContext.getExternalContext().getRequestContextPath() + request.getServletPath();
            try {
                facesContext.getExternalContext().redirect(redirect);
            } catch (final IOException e) {
                // here use you preferred logging framework to log this error
            }
        }
    }
    
     @Override
    public void afterPhase(final PhaseEvent event) {
        // no-op
    }
 
    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
}
