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
@Table(name = "BATCH_IMAGE", schema = "PUBLIC", catalog = "BOOTDB")
public class BatchImage implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5603187277875609399L;
	private BatchImageId id;
	private Batch batch;
	private Image image;

	public BatchImage() {
	}

	public BatchImage(BatchImageId id) {
		this.id = id;
	}

	public BatchImage(BatchImageId id, Batch batch, Image image) {
		this.id = id;
		this.batch = batch;
		this.image = image;
	}

	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "batchImagesId", column = @Column(name = "BATCH_IMAGES_ID")), @AttributeOverride(name = "imageId", column = @Column(name = "IMAGE_ID")) })
	public BatchImageId getId() {
		return this.id;
	}

	public void setId(BatchImageId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BATCH_IMAGES_ID", insertable = false, updatable = false)
	public Batch getBatch() {
		return this.batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IMAGE_ID", insertable = false, updatable = false)
	public Image getImage() {
		return this.image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

}
