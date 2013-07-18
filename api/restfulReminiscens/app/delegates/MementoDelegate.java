package delegates;

import java.util.ArrayList;
import java.util.List;

import models.Memento;
import models.MentionPerson;
import models.Person;

import pojos.MementoBean;
import pojos.MementoParticipationBean;
import pojos.MentionPersonBean;
import utils.PlayDozerMapper;

public class MementoDelegate {

	public static MementoDelegate getInstance() {
		return new MementoDelegate();
	}

	public List<MementoBean> getAll() {
		List<models.Memento> modelMementos = models.Memento.all();
		List<MementoBean> pojosMementos = new ArrayList<MementoBean>();
		for (models.Memento memento : modelMementos) {
			MementoBean mementoBean = PlayDozerMapper.getInstance().map(
					memento, MementoBean.class);
			pojosMementos.add(mementoBean);
		}
		return pojosMementos;
	}

	public List<MementoBean> getAllPersonMemento(Long personId) {
		List<models.Memento> modelMementos = models.Memento
				.getAllStoryMementoByPersonId(personId);
		List<MementoBean> pojosMementos = new ArrayList<MementoBean>();
		for (models.Memento memento : modelMementos) {
			MementoBean mementoBean = PlayDozerMapper.getInstance().map(
					memento, MementoBean.class);
			pojosMementos.add(mementoBean);
		}
		return pojosMementos;
	}

	public MementoBean getMemento(Long mementoId) {
		models.Memento memento = models.Memento.read(mementoId);
		if (memento != null) {
			MementoBean mementoBean = PlayDozerMapper.getInstance().map(
					memento, MementoBean.class);
			return mementoBean;
		} else {
			return null;
		}
	}

	public void create(MementoBean mementoBean) {
		models.Memento memento = PlayDozerMapper.getInstance().map(mementoBean,
				models.Memento.class);
		models.Memento.create(memento);
		memento = models.Memento.read(memento.getMementoId());
		PlayDozerMapper.getInstance().map(memento, mementoBean);
	}

	public void update(MementoBean bean, Long id) {
		models.Memento memento = PlayDozerMapper.getInstance().map(bean,
				models.Memento.class);
		memento.update(id);
		memento = models.Memento.read(memento.getMementoId());
		PlayDozerMapper.getInstance().map(memento, bean);
	}

	public void deleteMemento(Long id) {
		models.Memento.delete(id);
	}

	public MementoParticipationBean addMementoParticipantByPersonId(Long id,
			Long pid) {
		Long mementoId = id;
		Long personId = pid;
		MentionPerson mp = models.MentionPerson.readFirstByPersonId(personId);

		models.MementoParticipation modelPart = null;

		if (mp != null) {
			Long mentionPersonId = mp.getMentionPersonId();
			modelPart = models.MementoParticipation.read(mentionPersonId,
					mementoId);
		} else {
			Person p = models.Person.read(personId);
			mp = new MentionPerson();
			mp.setPerson(p);
			mp.setFullname(p.getFirstname() + " " + p.getLastname());
			mp.save();
		}

		if (modelPart == null) {
			Memento m = models.Memento.read(mementoId);
			m.getParticipants().add(mp);
			m.update();
		}

		modelPart = models.MementoParticipation.read(mp.getMentionPersonId(),
				mementoId);
		
		MementoParticipationBean bean = new MementoParticipationBean();
		PlayDozerMapper.getInstance().map(modelPart, bean);
		return bean;
	}

	public MentionPersonBean addMementoMentionParticipant(Long id, 
			MentionPersonBean mentionPersonBean) {
		models.MentionPerson mentionPerson = PlayDozerMapper.getInstance().map(mentionPersonBean,
				models.MentionPerson.class);
		models.MentionPerson.create(mentionPerson);
		models.Memento memento = models.Memento.read(id);
		memento.getParticipants().add(mentionPerson);
		memento.update();
		PlayDozerMapper.getInstance().map(mentionPerson, mentionPersonBean);
		return null;
	}
}
