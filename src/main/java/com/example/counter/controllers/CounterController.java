package com.example.counter.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class CounterController {
	@GetMapping("/")
	public String setCount(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {	
			session.setAttribute("count", (int) session.getAttribute("count") + 1);
		}
		return "index.jsp";
	}
	
	@GetMapping("/count")
	public String getCount() {
		return "getCount.jsp";
	}
	
	@RequestMapping("/incrementByTwo")
    public String incrementByTwo(HttpSession session) {
        if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {	
			session.setAttribute("count", (int) session.getAttribute("count") + 2);
		}
        return "getCount.jsp";
    }

    @RequestMapping("/reset")
    public String resetCounter(HttpSession session) {
        session.setAttribute("count", 0);
        return "getCount.jsp";
    }
}
