package com.jesmeradonttdata.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * 
 * Javier Esmerado Vela - Hibernate - Taller 1.
 * 
 * Abstract Entity.
 * 
 * @author jesmerad
 *
 */
@MappedSuperclass
public class AbstractEntity implements Serializable {

	/** SERIAL VERSION */
	private static final long serialVersionUID = 1L;

	/** Audit | User updated */
	private String updatedUser;

	/** Audit | Updated day */
	private String updatedDate;

	/**
	 * @return the updated user.
	 */
	@Column(name = "AUDIT_UPDATED_USER", nullable = false)
	public String getUpdatedUser() {
		return updatedUser;
	}

	/**
	 * 
	 * @param updatedUser to set.
	 */
	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}

	/**
	 * @return the updated date.
	 */
	@Column(name = "AUDIT_UPDATED_DATE", nullable = false)
	public String getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * 
	 * @param updatedDate to set.
	 */
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

}
