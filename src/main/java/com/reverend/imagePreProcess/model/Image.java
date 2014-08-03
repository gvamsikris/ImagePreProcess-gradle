package com.reverend.imagePreProcess.model;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "IMAGE", schema = "PUBLIC", catalog = "BOOTDB")
public class Image implements java.io.Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2354326996494212763L;
	public static final String SAVED = "saved";
	public static final String NEW = "new";
	
	private Long id;
	private long version;
	private Batch batch;
	private Date dateCreated;
	private Date lastUpdated;
	private String name;
	private String path;
	private String status;
	private Set<Attribute> attributes = new HashSet<Attribute>(0);

	public Image() {
		setStatus(NEW);
	}

	public Image(Batch batch, Date dateCreated, Date lastUpdated, String name, String path, String status) {
		this.batch = batch;
		this.dateCreated = dateCreated;
		this.lastUpdated = lastUpdated;
		this.name = name;
		this.path = path;
		this.status = status;
	}

	public Image(Batch batch, Date dateCreated, Date lastUpdated, String name, String path, String status, Set<Attribute> attributes) {
		this.batch = batch;
		this.dateCreated = dateCreated;
		this.lastUpdated = lastUpdated;
		this.name = name;
		this.path = path;
		this.status = status;
		this.attributes = attributes;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BATCH_ID", nullable = false)
	public Batch getBatch() {
		return this.batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
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

	@Column(name = "NAME", nullable = false)
	public String getName() {
		return this.name;
	}
	

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "PATH", nullable = false)
	public String getPath() {
		return this.path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "image", cascade=CascadeType.ALL)
	public Set<Attribute> getAttributes() {
		return this.attributes;
	}

	public void setAttributes(Set<Attribute> attributes) {
		this.attributes = attributes;
	}

	@Column(name = "STATUS", nullable = true)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
