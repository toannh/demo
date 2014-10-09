package net.demo.service;

import net.demo.model.Person;
import net.demo.web.form.backend.UserForm;

import java.util.List;

public interface PersonService {

	public void addPerson(UserForm userForm);
	public void updatePerson(UserForm userForm);
	public List<Person> listPersons();
	public Person getPersonById(int id);
	public void removePerson(int id);
	
}
