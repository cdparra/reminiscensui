package delegates;

import java.util.ArrayList;
import java.util.List;

import pojos.PersonBean;
import utils.PlayDozerMapper;

public class PersonDelegate {
    
    public static PersonDelegate getInstance(){
        return new PersonDelegate();
    }

    public List<PersonBean> getAll() {
        List<models.Person> modelPersons = models.Person.all();
        List<PersonBean> pojosPersons = new ArrayList<PersonBean>();
        for (models.Person person : modelPersons) {
            PersonBean personBean = PlayDozerMapper.getInstance().map(person, PersonBean.class);
            pojosPersons.add(personBean);
        }
        return pojosPersons;
    }

    public PersonBean getPerson(Long id) {
        models.Person person = models.Person.read(id);
        if (person != null) {
        	PersonBean personBean = PlayDozerMapper.getInstance().map(person, PersonBean.class);
        	return personBean;
        } else {
        	return null; 
        }
    }

    /**
     * TODO
     * @param personBean
     */
    public void create(PersonBean personBean){
        models.Person person = PlayDozerMapper.getInstance().map(personBean, models.Person.class);
        models.Person.create(person);
    }

    public void update(PersonBean bean, Long id){
        models.Person course = PlayDozerMapper.getInstance().map(bean, models.Person.class);
        course.update(id);
    }

    public void deletePerson(Long id) {
        models.Person.delete(id);
    }
    
}
