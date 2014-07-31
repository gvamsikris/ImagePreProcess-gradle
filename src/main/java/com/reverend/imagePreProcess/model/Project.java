package com.reverend.imagePreProcess.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * 
 * @author vgajula
 *
 */
@Entity
@Table(name = "PROJECT", schema = "PUBLIC", catalog = "BOOTDB")
public class Project implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 644623798630109799L;
	private Long id;
	private long version;
	private Date dateCreated;
	private Date lastUpdated;
	private String path;
	private String preProcessor;
	private String supervisor;
	private List<Batch> batchs = new ArrayList<Batch>(0);

	public Project() {
	}

	public Project(Date dateCreated, Date lastUpdated, String path, String preProcessor, String supervisor) {
		this.dateCreated = dateCreated;
		this.lastUpdated = lastUpdated;
		this.path = path;
		this.preProcessor = preProcessor;
		this.supervisor = supervisor;
	}

	public Project(Date dateCreated, Date lastUpdated, String path, String preProcessor, String supervisor, List<Batch> batchs) {
		this.dateCreated = dateCreated;
		this.lastUpdated = lastUpdated;
		this.path = path;
		this.preProcessor = preProcessor;
		this.supervisor = supervisor;
		this.batchs = batchs;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Version
	@Column(name = "VERSION", nullable = false)
	public long getVersion() {
		return this.version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_CREATED", nullable = false, length = 23)
	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UPDATED", nullable = false, length = 23)
	public Date getLastUpdated() {
		return this.lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Column(name = "PATH", nullable = false)
	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Column(name = "PRE_PROCESSOR", nullable = true)
	public String getPreProcessor() {
		return this.preProcessor;
	}

	public void setPreProcessor(String preProcessor) {
		this.preProcessor = preProcessor;
	}

	@Column(name = "SUPERVISOR", nullable = true)
	public String getSupervisor() {
		return this.supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
	public List<Batch> getBatchs() {
		return this.batchs;
	}

	public void setBatchs(List<Batch> batchs) {
		this.batchs = batchs;
	}

}
