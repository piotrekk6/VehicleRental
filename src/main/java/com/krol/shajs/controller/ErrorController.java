package com.krol.shajs.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ErrorController  implements org.springframework.boot.autoconfigure.web.ErrorController {

    private final ErrorAttributes errorAttributes;

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public Map<String, Object> error(HttpServletRequest aRequest){
        Map<String, Object> body = getErrorAttributes(aRequest,getTraceParameter(aRequest));
        String trace = (String) body.get("trace");
        if(trace != null){
            String[] lines = trace.split("\n\t");
            body.put("trace", lines);
        }
        return body;
    }

    @Override
    public String getErrorPath() {
        return null;
    }
    private Map<String, Object> getErrorAttributes(HttpServletRequest aRequest, boolean includeStackTrace) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(aRequest);
        return errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
    }
    private boolean getTraceParameter(HttpServletRequest request) {
        String parameter = request.getParameter("trace");
        if (parameter == null) {
            return false;
        }
        return !"false".equals(parameter.toLowerCase());
    }
}
