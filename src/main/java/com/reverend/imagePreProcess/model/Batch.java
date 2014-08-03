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
@Table(name = "BATCH", schema = "PUBLIC", catalog = "BOOTDB")
public class Batch implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5026881620908985199L;
	private Long id;
	private long version;
	private Project project;
	private Date dateCreated;
	private Date lastUpdated;
	private String path;
	private long noOfImages;
	private Set<Image> images = new HashSet<Image>(0);

	public Batch() {
	}

	public Batch(Project project, Date dateCreated, Date lastUpdated, String path) {
		this.project = project;
		this.dateCreated = dateCreated;
		this.lastUpdated = lastUpdated;
		this.path = path;
	}

	public Batch(Project project, Date dateCreated, Date lastUpdated, String path, Set<Image> images) {
		this.project = project;
		this.dateCreated = dateCreated;
		this.lastUpdated = lastUpdated;
		this.path = path;
		this.images = images;
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
	@JoinColumn(name = "PROJECT_ID", nullable = false)
	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "batch", cascade=CascadeType.ALL)
	public Set<Image> getImages() {
		return this.images;
	}

	public void setImages(Set<Image> images) {
		this.images = images;
	}

	@Column(name = "NO_OF_IMAGES", nullable = true)
	public long getNoOfImages() {
		return noOfImages;
	}

	public void setNoOfImages(long noOfImages) {
		this.noOfImages = noOfImages;
	}

}
