package models;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import play.db.ebean.Model;

@Entity
@Table(name="File")
public class File extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7427940699391709658L;
	
	@Id
    @GeneratedValue
    @Column(name="file_id")
	private Long fileId;
	@Column
	private String filename;
	@Column
	private String URI;
	@Column
	private String contentType;
	@Column
	private String extension; 
	@Column
	private String hashcode;
	@Column(name="user_id")
	private Long owner;
	@Temporal(TemporalType.DATE)
	@Column(name="creation_date")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime creationDate;
	
	public static Model.Finder<Long,File> find = new Model.Finder<Long, File>(
            Long.class,File.class
    );

    public static List<File> all(){
        return find.all();
    }
    
    public static void create(File city){
        city.save();
    }
    
    public static File createObject(File city){
        city.save();
        return city;
    }
    
    public static void delete(Long id){
        find.ref(id).delete();
    }
    
    public static File read(Long id){
        return find.byId(id);
    }
    
    public static File readByHashCode(String hashcode){
        return find.where().eq("hashcode", hashcode).findUnique();
    }

	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getURI() {
		return URI;
	}

	public void setURI(String uRI) {
		URI = uRI;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getHashcode() {
		return hashcode;
	}

	public void setHashcode(String hashcode) {
		this.hashcode = hashcode;
	}

	public Long getOwner() {
		return owner;
	}

	public void setOwner(Long owner) {
		this.owner = owner;
	}

	public DateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(DateTime creationDate) {
		this.creationDate = creationDate;
	}	
}
