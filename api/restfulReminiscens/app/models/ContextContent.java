package models;

import java.util.List;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;
import play.db.ebean.Model;

@Entity
@Table(name = "Context_Content")
public class ContextContent extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9000709644175989610L;

	@Column(name = "context_id")
	private Long contextId;

	@Column(name = "context_index_id")
	private Long publicMementoId;

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
	@JoinColumn(name = "context_index_id", updatable = false, insertable = false)
	private PublicMemento publicMemento;

	public static Model.Finder<Long, ContextContent> find = new Finder<Long, ContextContent>(
			Long.class, ContextContent.class);

	public static List<ContextContent> all() {
		return find.all();
	}

	public static void create(ContextContent participation) {
		participation.save();
	}

	public static ContextContent createObject(ContextContent participation) {
		participation.save();
		return participation;
	}

	public static void update(Long contextId, Long publicMementoId) {
		find.where().eq("contextId", contextId)
				.eq("publicMementoId", publicMementoId).findUnique().update();
	}

	public static void delete(Long contextId, Long publicMementoId) {
		find.where().eq("contextId", contextId)
				.eq("publicMementoId", publicMementoId).findUnique().delete();
	}

	public static ContextContent read(Long contextId, Long publicMementoId) {
		return find.where().eq("contextId", contextId)
				.eq("publicMementoId", publicMementoId).findUnique();
	}

	public static List<ContextContent> contextContentByContext(Long contextId) {
		List<ContextContent> participationList = find.where()
				.eq("contextId", contextId).findList();
		return participationList;
	}

	public static List<ContextContent> contextContentByPerson(Long personId) {

		Long contextId = models.Context.findByPerson(personId).getContextId();

		List<ContextContent> contexContentList = find.where()
				.eq("contextId", contextId).findList();
		return contexContentList;
	}

	public static List<ContextContent> participationByPublicMemento(
			Long publicMementoId) {
		List<ContextContent> participationList = find.where()
				.eq("publicMementoId", publicMementoId).findList();
		return participationList;
	}

	public Long getContextId() {
		return contextId;
	}

	public void setContextId(Long contextId) {
		this.contextId = contextId;
	}

	public Long getPublicMementoId() {
		return publicMementoId;
	}

	public void setPublicMementoId(Long publicMementoId) {
		this.publicMementoId = publicMementoId;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public PublicMemento getPublicMemento() {
		return publicMemento;
	}

	public void setPublicMemento(PublicMemento publicMemento) {
		this.publicMemento = publicMemento;
	}

}
