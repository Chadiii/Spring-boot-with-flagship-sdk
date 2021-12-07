package com.nginx.web;

import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abtasty.flagship.main.Flagship;
import com.abtasty.flagship.visitor.Visitor;

@Controller
public class ExampleController {

	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(value = "/")
	private ModelAndView hello(HttpServletRequest req) throws InterruptedException, ExecutionException {
		
		String userAgent=req.getHeader("user-agent");
		  String browserName = "";
		  
		  if(userAgent.contains("Chrome")){ //checking if Chrome
		        browserName= "Chrome";
		    }
		    else if(userAgent.contains("Firefox")){  //Checking if Firefox
		       browserName= "Firefox";
		    }
		  
		  Visitor visitor = Flagship.newVisitor("visitor_unique_id").build();
		  visitor.updateContext("browser", browserName );
		  visitor.synchronizeModifications().get();
		  Boolean IsVIP = visitor.getModification("IsVIP", false);
		  
		return new ModelAndView("hello", "message", IsVIP);
		
	}

}
