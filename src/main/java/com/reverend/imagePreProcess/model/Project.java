package com.reverend.imagePreProcess.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="PROJECT")
public class Project {

	private Long id;
	private String path;
	private String preProcessor;
	private String Supervisor;
	private List<Batch> batches;
	private Date createdOn;
	private Date updatedOn;

	@Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPreProcessor() {
		return preProcessor;
	}

	public void setPreProcessor(String preProcessor) {
		this.preProcessor = preProcessor;
	}

	public String getSupervisor() {
		return Supervisor;
	}

	public void setSupervisor(String supervisor) {
		Supervisor = supervisor;
	}

	@OneToMany
	public List<Batch> getBatches() {
		return batches;
	}

	public void setBatches(List<Batch> batches) {
		this.batches = batches;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}


}
