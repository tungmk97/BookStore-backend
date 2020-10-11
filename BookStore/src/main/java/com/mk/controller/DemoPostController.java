package com.mk.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/demo-post")
public class DemoPostController {
  @PostMapping
  public String getValue(HttpServletRequest request) {
    String name = (String) request.getAttribute("name");
    String age = request.getParameter("age");
    System.out.println(name);

    return "end";
  }
}
