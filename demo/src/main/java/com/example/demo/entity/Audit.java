package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"create_dt", "update_dt"}, allowGetters = true)
public abstract class Audit implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_dt", nullable = false, updatable = false)
    @CreatedDate
    private Date create_dt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_dt", nullable = false)
    @LastModifiedDate
    private Date update_dt;

	public Date getCreate_dt() {
		return create_dt;
	}

	public void setCreate_dt(Date create_dt) {
		this.create_dt = create_dt;
	}

	public Date getUpdate_dt() {
		return update_dt;
	}

	public void setUpdate_dt(Date update_dt) {
		this.update_dt = update_dt;
	}

    
}
