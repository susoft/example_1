package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
//데이터베이스  user 테이블과 매핑한다는 뜻.
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class Emp extends Audit {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
	
	@NotBlank
	private String name;
	
	@NotBlank
    private String email;
	
	//컬럼명과 변수명이 틀릴때 매핑하기 위함. insert, update 시 필요없는 필드.
	@Column(name = "email", insertable = false, updatable = false)
    private String emails;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "emp")
	@OrderBy("id DESC")
	private Set<Group> group = new HashSet<Group>();
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmails() {
		return emails;
	}

	public void setEmails(String emails) {
		this.emails = emails;
	}

	public Set<Group> getGroup() {
		return group;
	}

	public void setGroup(Set<Group> group) {
		this.group = group;
	}

	
}
