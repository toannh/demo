package net.demo.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by toannh on 10/10/14.
 */
@Controller
@RequestMapping(name = "/")
public class HelloController extends HttpServlet{
  @RequestMapping(value = "/hello")
  public String hello(){
    return "view.hello";
  }

  @RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
  public String defaultPage(ModelAndView model) {

    model.addObject("title", "Spring Security + Hibernate Example");
    model.addObject("message", "This is default page!");
    return "view.hello";
  }

  @RequestMapping(value = "/admin**", method = RequestMethod.GET)
  public String adminPage(ModelAndView model) {

    model.addObject("title", "Spring Security + Hibernate Example");
    model.addObject("message", "This page is for ROLE_ADMIN only!");

    return "view.admin";

  }

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String login(ModelAndView model, @RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {

    if (error != null) {
      model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
    }

    if (logout != null) {
      model.addObject("msg", "You've been logged out successfully.");
    }

    return "view.login";

  }

  // customize the error message
  private String getErrorMessage(HttpServletRequest request, String key) {

    Exception exception = (Exception) request.getSession().getAttribute(key);

    String error = "";
    if (exception instanceof BadCredentialsException) {
      error = "Invalid username and password!";
    } else if (exception instanceof LockedException) {
      error = exception.getMessage();
    } else {
      error = "Invalid username and password!";
    }

    return error;
  }

  // for 403 access denied page
  @RequestMapping(value = "/403", method = RequestMethod.GET)
  public String accesssDenied(ModelAndView model) {

    // check if user is login
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (!(auth instanceof AnonymousAuthenticationToken)) {
      UserDetails userDetail = (UserDetails) auth.getPrincipal();
      System.out.println(userDetail);

      model.addObject("username", userDetail.getUsername());

    }

    return "error.403";

  }
}
