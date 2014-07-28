package com.reverend.imagePreProcess.model;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
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
@Table(name = "ATTRIBUTE_TYPE", schema = "PUBLIC", catalog = "BOOTDB")
public class AttributeType implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5785631434342083675L;
	private Long id;
	private long version;
	private Date dateCreated;
	private Date lastUpdated;
	private String name;
	private Set<AttributeValue> attributeValues = new HashSet<AttributeValue>(0);
	private Set<Attribute> attributes = new HashSet<Attribute>(0);

	public AttributeType() {
	}

	public AttributeType(Date dateCreated, Date lastUpdated, String name) {
		this.dateCreated = dateCreated;
		this.lastUpdated = lastUpdated;
		this.name = name;
	}

	public AttributeType(Date dateCreated, Date lastUpdated, String name, Set<AttributeValue> attributeValues, Set<Attribute> attributes) {
		this.dateCreated = dateCreated;
		this.lastUpdated = lastUpdated;
		this.name = name;
		this.attributeValues = attributeValues;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "attributeType")
	public Set<AttributeValue> getAttributeValues() {
		return this.attributeValues;
	}

	public void setAttributeValues(Set<AttributeValue> attributeValues) {
		this.attributeValues = attributeValues;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "attributeType")
	public Set<Attribute> getAttributes() {
		return this.attributes;
	}

	public void setAttributes(Set<Attribute> attributes) {
		this.attributes = attributes;
	}

}
