package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;
import play.db.ebean.Model;
@Entity
@Table(name = "Participant_Memento")
public class MementoParticipation extends Model {
	
	private static final long serialVersionUID = -9000709644175989610L;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "mention_person_id", updatable = true, insertable = true)
	private MentionPerson mentionPerson;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "memento_id", updatable = true, insertable = true)
	private Memento memento;

	public static Model.Finder<Long, MementoParticipation> find = new Finder<Long, MementoParticipation>(
			Long.class, MementoParticipation.class);

	public static List<MementoParticipation> all() {
		return find.all();
	}

	public static void create(MementoParticipation participation) {
		participation.save();
	}

	public static MementoParticipation createObject(MementoParticipation participation) {
		participation.save();
		return participation;
	}

	public static void update(Long mentionPersonId, Long mementoId) {
		models.MentionPerson mp = models.MentionPerson.read(mentionPersonId);
		models.Memento m = models.Memento.read(mementoId);
		
		find.where().eq("mentionPerson", mp)
				.eq("memento", m).findUnique().update();
	}

	public static void delete(Long mentionPersonId, Long mementoId) {
		models.MentionPerson mp = models.MentionPerson.read(mentionPersonId);
		models.Memento m = models.Memento.read(mementoId);
		
		find.where().eq("mentionPerson", mp)
				.eq("memento", m).findUnique().delete();
	}

	public static MementoParticipation read(Long mentionPersonId, Long mementoId) {
		models.MentionPerson mp = models.MentionPerson.read(mentionPersonId);
		models.Memento m = models.Memento.read(mementoId);
		
		return find.where().eq("mentionPerson", mp)
				.eq("memento", m).findUnique();
	}

	// read participants by personId (already map personIds)
	public static List<MementoParticipation> readByPerson(Long personId) {
		List<MentionPerson> mpList = models.MentionPerson.readByPersonId(personId);
		List<MementoParticipation> partList = new ArrayList<MementoParticipation>();
		for (MentionPerson mentionPerson : mpList) {
			List<MementoParticipation> partialList = find.where()
					.eq("mentionPerson", mentionPerson).findList();
			partList.addAll(partialList);
		}
		return partList;
	}
	
	public static List<MementoParticipation> readByMemento(
			Long mementoId) {
		models.Memento m = models.Memento.read(mementoId);
		
		List<MementoParticipation> participationList = find.where()
				.eq("memento", m).findList();
		return participationList;
	}

	// check if a participant relationship between person and memento exists
	public static Boolean mementoParticipationExist(Long mentionPersonId, Long mementoId) {
		return read(mentionPersonId, mementoId)==null ? false : true;
	}

	public MentionPerson getMentionPerson() {
		return mentionPerson;
	}

	public void setMentionPerson(MentionPerson person) {
		this.mentionPerson = person;
	}

	public Memento getMemento() {
		return memento;
	}

	public void setMemento(Memento memento) {
		this.memento = memento;
	}

}
