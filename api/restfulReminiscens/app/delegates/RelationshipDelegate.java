package delegates;

import java.util.ArrayList;
import java.util.List;

import pojos.RelationshipBean;
import utils.PlayDozerMapper;

public class RelationshipDelegate {
    
    public static RelationshipDelegate getInstance(){
        return new RelationshipDelegate();
    }

    public List<RelationshipBean> getAll() {
        List<models.Relationship> modelPersonRels = models.Relationship.all();
        List<RelationshipBean> pojosPersonRels = new ArrayList<RelationshipBean>();
        for (models.Relationship person : modelPersonRels) {
            RelationshipBean relBean = PlayDozerMapper.getInstance().map(person, RelationshipBean.class);
            pojosPersonRels.add(relBean);
        }
        return pojosPersonRels;
    }

    public RelationshipBean getPersonRelationship(Long id) {
        models.Relationship personRel = models.Relationship.read(id);
        if (personRel != null) {
        	RelationshipBean relBean = PlayDozerMapper.getInstance().map(personRel, RelationshipBean.class);
        	return relBean;
        } else {
        	return null; 
        }
    }

    public void create(RelationshipBean relBean){
        models.Relationship personRel = PlayDozerMapper.getInstance().map(relBean, models.Relationship.class);
        models.Relationship.create(personRel);
        personRel = models.Relationship.read(personRel.getRelationshipId());
        PlayDozerMapper.getInstance().map(personRel,relBean);
    }

    public void update(RelationshipBean bean, Long id) {
        models.Relationship person = PlayDozerMapper.getInstance().map(bean, models.Relationship.class);
        person.update(id);
        person = models.Relationship.read(person.getRelationshipId());
        PlayDozerMapper.getInstance().map(person,bean);
    }

    public void deleteRelationship(Long id) {
        models.Relationship.delete(id);
    }
    
    /*
     * Spetial Queries 
     * 
     */

    public List<RelationshipBean> getPersonRelationships(Long id) {
        List<models.Relationship> modelPersonRels = models.Relationship.findRelationshipsByPerson(id);
        List<RelationshipBean> pojosPersonRels = new ArrayList<RelationshipBean>();
        for (models.Relationship rel : modelPersonRels) {
            RelationshipBean relBean = PlayDozerMapper.getInstance().map(rel, RelationshipBean.class);
            pojosPersonRels.add(relBean);
        }
        return pojosPersonRels;
    }
    

    public List<RelationshipBean> getPersonCurators(Long id) {
        List<models.Relationship> modelPersonRels = models.Relationship.findCuratorsOfPerson(id);
        List<RelationshipBean> pojosPersonRels = new ArrayList<RelationshipBean>();
        for (models.Relationship rel : modelPersonRels) {
            RelationshipBean relBean = PlayDozerMapper.getInstance().map(rel, RelationshipBean.class);
            pojosPersonRels.add(relBean);
        }
        return pojosPersonRels;
    }
    
    
}
