package pojos;

import java.io.File;
import java.io.Serializable;

import org.joda.time.DateTime;

import utils.JodaDateTime;

public class FileBean  implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3980159110846013300L;

	private Long fileId;
	private String filename;
	private String URI;
	private String contentType;
	private String extension; 
	private String hashcode; 
	private Long owner;
	@JodaDateTime(format = "yyyy-MM-dd HH:mm:ss")
	private DateTime creationDate;
	private File file; 
	
	
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
	public Long getOwner() {
		return owner;
	}
	public void setOwner(Long userId) {
		this.owner = userId;
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
	public DateTime getCreationDate() {
		return creationDate;
	}
	public String getCreationDateAsString () {
		return creationDate == null ? null : creationDate.toString("yyyy-MM-dd HH:mm:ss");
	}
	public void setCreationDate(DateTime creationDate) {
		this.creationDate = creationDate;
	}
	public Long getFileId() {
		return fileId;
	}
	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
}
