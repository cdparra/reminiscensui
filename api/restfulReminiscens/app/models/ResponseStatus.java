package models;

import java.util.List;

import javax.persistence.*;

import org.joda.time.DateTime;

import play.db.ebean.Model;

@Entity
public class ResponseStatus extends Model {

	@Id
    private Long status_code;
	
	private String status_message;

	/**
	 * @return the status_code
	 */
	public Long getStatus_code() {
		return status_code;
	}

	/**
	 * @param status_code the status_code to set
	 */
	public void setStatus_code(Long status_code) {
		this.status_code = status_code;
	}

	/**
	 * @return the status_message
	 */
	public String getStatus_message() {
		return status_message;
	}

	/**
	 * @param status_message the status_message to set
	 */
	public void setStatus_message(String status_message) {
		this.status_message = status_message;
	}
	
	
	
}
