package net.demo.web.controller.backend;

import net.demo.service.PersonService;
import net.demo.web.form.backend.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes
public class UserController {

  @Autowired
  private PersonService personService;

	@RequestMapping(value = "/addCUser", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("personForm")
                             UserForm userForm, BindingResult result) {
		
		System.out.println("First Name:" + userForm.getName() +
					"Last Name:" + userForm.getCountry());
		personService.addPerson(userForm);
		
		return "redirect:contacts.html";
	}
	
	@RequestMapping("/users")
	public ModelAndView showUsers() {
		
		return new ModelAndView("user", "command", new UserForm());
	}
}
