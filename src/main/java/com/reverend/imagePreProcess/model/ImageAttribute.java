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
@Table(name = "IMAGE_ATTRIBUTE", schema = "PUBLIC", catalog = "BOOTDB")
public class ImageAttribute implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6078251710863030198L;
	private ImageAttributeId id;
	private Attribute attribute;
	private Image image;

	public ImageAttribute() {
	}

	public ImageAttribute(ImageAttributeId id) {
		this.id = id;
	}

	public ImageAttribute(ImageAttributeId id, Attribute attribute, Image image) {
		this.id = id;
		this.attribute = attribute;
		this.image = image;
	}

	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "imageAttributesId", column = @Column(name = "IMAGE_ATTRIBUTES_ID")),
			@AttributeOverride(name = "attributeId", column = @Column(name = "ATTRIBUTE_ID")) })
	public ImageAttributeId getId() {
		return this.id;
	}

	public void setId(ImageAttributeId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ATTRIBUTE_ID", insertable = false, updatable = false)
	public Attribute getAttribute() {
		return this.attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IMAGE_ATTRIBUTES_ID", insertable = false, updatable = false)
	public Image getImage() {
		return this.image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

}
