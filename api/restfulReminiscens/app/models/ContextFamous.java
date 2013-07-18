package models;

import java.util.List;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;
import play.db.ebean.Model;

@Entity
@Table(name = "Context_Famous")
public class ContextFamous extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9000709644175989610L;

	@Column(name = "context_id")
	private Long contextId;

	@Column(name = "famous_id")
	private Long famousPersonId;

	// @PrimaryKeyJoinColumn(name="EMPLOYEEID", referencedColumnName="ID")
	/*
	 * if this JPA model doesn't create a table for the "PROJ_EMP" entity,
	 * please comment out the @PrimaryKeyJoinColumn, and use the ff:
	 * 
	 * @JoinColumn(name = "employeeId", updatable = false, insertable = false)
	 * or
	 */
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "context_id", updatable = false, insertable = false)
	private Context context;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "famous_id", updatable = false, insertable = false)
	private FamousPerson famousPerson;

	public static Model.Finder<Long, ContextFamous> find = new Finder<Long, ContextFamous>(
			Long.class, ContextFamous.class);

	public static List<ContextFamous> all() {
		return find.all();
	}

	public static void create(ContextFamous famous) {
		famous.save();
	}

	public static ContextFamous createObject(ContextFamous contextFamous) {
		contextFamous.save();
		return contextFamous;
	}

	public static void update(Long contextId, Long famousPersonId) {
		find.where().eq("contextId", contextId)
				.eq("famousPersonId", famousPersonId).findUnique().update();
	}

	public static void delete(Long contextId, Long famousPersonId) {
		find.where().eq("contextId", contextId)
				.eq("famousPersonId", famousPersonId).findUnique().delete();
	}

	public static ContextFamous read(Long contextId, Long famousPersonId) {
		return find.where().eq("contextId", contextId)
				.eq("famousPersonId", famousPersonId).findUnique();
	}

	public static List<ContextFamous> contextFamousByContext(Long contextId) {
		List<ContextFamous> famousList = find.where()
				.eq("contextId", contextId).findList();
		return famousList;
	}

	public static List<ContextFamous> contextFamousByPerson(Long personId) {
		Long contextId = models.Context.findByPerson(personId).getContextId();
		return contextFamousByContext(contextId);
	}
}
