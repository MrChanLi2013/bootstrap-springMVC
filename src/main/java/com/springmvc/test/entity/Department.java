package com.springmvc.test.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_department")
public class Department implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id",unique = true,nullable = false)
	private Integer id;
	/**
	 * 单位名称
	 */
	@Column(name = "name")
	private String name;
	/**
	 * 单位描述
	 */
	@Column(name = "description",length = 100)
	private String description;
	/**
	 * 联系人名字
	 */
	@Column(name = "contact_name")
	private String contactName;
	/**
	 * 联系人电话
	 */
	@Column(name = "phone_number",length = 15)
	private Integer phoneNumber;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public Integer getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
}
