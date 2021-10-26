package com.coding;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller

public class MainController {
	
	//Getting Session Attributes
	public Integer getCount( HttpSession session ){
		Integer counter = ( Integer ) session.getAttribute( "numCount" );
 		// If the count is not already in session
		if ( counter == null ) {
			// Use setAttribute to initialize the count in session
			// Include here method with the session.setAttribute("numCount", num);
			addCountToSession( session, 0 );
			counter = ( Integer )session.getAttribute( "numCount" );
		}
        return (Integer)counter;
    }
	
	//Setting Session Attributes
	public void addCountToSession(HttpSession session, int num) {
		session.setAttribute("numCount", num);
	}
	
	@RequestMapping( value = "/", method = RequestMethod.GET )
	public String index( HttpSession session ) {
		int count = getCount( session );
		addCountToSession( session, ++count );
		return "index.jsp";
	}
	
	@RequestMapping( value = "/counter", method = RequestMethod.GET )
	public String counter( Model model, HttpSession session ) {
		model.addAttribute( "numCount", getCount( session ) );
		return "counter.jsp";
	}
	
	@RequestMapping( value= "/reset", method = RequestMethod.GET )
	public String Reset(HttpSession session) {
		session.removeAttribute("numCount");
		return "redirect:/counter";
	}
	
}
