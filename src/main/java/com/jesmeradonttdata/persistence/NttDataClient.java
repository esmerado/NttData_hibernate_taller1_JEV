package com.jesmeradonttdata.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
 * Javier Esmerado Vela - Hibernate - Taller 1.
 * 
 * Entidad de la tabla NTTDATA_HEX_CLIENT.
 * 
 * @author jesmerad
 *
 */
@Entity
@Table(name="NTTDATA_HEX_CLIENT")
public class NttDataClient extends AbstractEntity implements Serializable {

	/** SERIAL VERSION */
	private static final long serialVersionUID = 1L;

	/**
	 * Auto increment for de Client ID.
	 */
	private static Long GENERATOR = 0L;
	
	/** Identifier - Primary Key */
	private Long clientID;
	
	/** Client name */
	private String name;

	/** First surname */
	private String firstSurname;

	/** Second surname */
	private String secondSurname;

	/** Identity number */
	private Long nif;
	
	

	public NttDataClient() {
		//this.clientID = GENERATOR++;
	}

	/**
	 * 
	 * @return the playerId.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getClientID() {
		return clientID;
	}

	/**
	 * 
	 * @param clientID to set.
	 */
	public void setClientID(Long clientID) {
		this.clientID = clientID;
	}

	/**
	 * 
	 * @return the name.
	 */
	@Column(name = "NAME", nullable = false)
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return the first surname.
	 */
	@Column(name = "FIRST_SURNAME", nullable = false)
	public String getFirstSurname() {
		return firstSurname;
	}

	/**
	 * 
	 * @param firstSurname to set.
	 */
	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}

	/**
	 * 
	 * @return the second surname.
	 */
	@Column(name = "SECOND_SURNAME", nullable = false)
	public String getSecondSurname() {
		return secondSurname;
	}

	/**
	 * 
	 * @param secondSurname to set.
	 */
	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	/**
	 * 
	 * @return the nif.
	 */
	@Column(name = "NIF", nullable = false)
	public Long getNif() {
		return nif;
	}

	/**
	 * 
	 * @param nif to set.
	 */
	public void setNif(Long nif) {
		this.nif = nif;
	}

	@Override
	public String toString() {
		return "NttDataClient [clientID=" + clientID + ", name=" + name + ", firstSurname=" + firstSurname
				+ ", secondSurname=" + secondSurname + ", nif=" + nif + "]";
	}
	
	@Transient
	public Class<?> getClase() {
		return NttDataClient.class;
	}
}
