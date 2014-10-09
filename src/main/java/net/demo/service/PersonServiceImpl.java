package net.demo.service;

import net.demo.dao.PersonDAO;
import net.demo.model.Person;
import net.demo.web.form.backend.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

  @Autowired
  private PersonDAO personDAO;

  @Override
  @Transactional
  public void addPerson(UserForm userForm) {
    Person person = new Person();
    person.setId(userForm.getId());
    person.setCountry(userForm.getCountry());
    person.setName(userForm.getName());
    this.personDAO.addPerson(person);
  }

  @Override
  @Transactional
  public void updatePerson(UserForm userForm) {
    Person person = personDAO.getPersonById(userForm.getId());
    if (person == null) return;

    person.setCountry(userForm.getCountry());
    person.setName(userForm.getName());
    this.personDAO.updatePerson(person);
  }

  @Override
  @Transactional
  public List<Person> listPersons() {
    return this.personDAO.listPersons();
  }

  @Override
  @Transactional
  public Person getPersonById(int id) {
    return this.personDAO.getPersonById(id);
  }

  @Override
  @Transactional
  public void removePerson(int id) {
    this.personDAO.removePerson(id);
  }

}
