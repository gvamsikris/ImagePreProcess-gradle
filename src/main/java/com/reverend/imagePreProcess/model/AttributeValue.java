package com.reverend.imagePreProcess.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * 
 * @author vgajula
 *
 */
@Entity
@Table(name = "ATTRIBUTE_VALUE", schema = "PUBLIC", catalog = "BOOTDB")
public class AttributeValue implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2865031562409361665L;
	private Long id;
	private long version;
	private AttributeType attributeType;
	private String value;

	public AttributeValue() {
	}

	public AttributeValue(AttributeType attributeType, String value) {
		this.attributeType = attributeType;
		this.value = value;
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
	@JoinColumn(name = "ATTRIBUTE_TYPE_ID", nullable = false)
	public AttributeType getAttributeType() {
		return this.attributeType;
	}

	public void setAttributeType(AttributeType attributeType) {
		this.attributeType = attributeType;
	}

	@Column(name = "VALUE", nullable = false)
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
