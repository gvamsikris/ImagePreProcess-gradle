package com.reverend.imagePreProcess.model;


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author vgajula
 *
 */
@Entity
@Table(name = "PROJECT_BATCH", schema = "PUBLIC", catalog = "BOOTDB")
public class ProjectBatch implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7334452868116125962L;
	private ProjectBatchId id;
	private Project project;
	private Batch batch;

	public ProjectBatch() {
	}

	public ProjectBatch(ProjectBatchId id) {
		this.id = id;
	}

	public ProjectBatch(ProjectBatchId id, Project project, Batch batch) {
		this.id = id;
		this.project = project;
		this.batch = batch;
	}

	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "projectBatchesId", column = @Column(name = "PROJECT_BATCHES_ID")), @AttributeOverride(name = "batchId", column = @Column(name = "BATCH_ID")) })
	public ProjectBatchId getId() {
		return this.id;
	}

	public void setId(ProjectBatchId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECT_BATCHES_ID", insertable = false, updatable = false)
	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BATCH_ID", insertable = false, updatable = false)
	public Batch getBatch() {
		return this.batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

}
