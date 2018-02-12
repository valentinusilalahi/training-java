package com.silalahi.valentinus.hibernate.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Project : java-hibernate 
 * User : valentinus silalahi 
 * Email : valentinus.silalahi@gmail.com 
 * Telegram : @valentinusilalahi 
 * Date : 12/02/18
 */

@Entity
public class Karyawan implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String nip;
	private String nama;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNip() {
		return nip;
	}
	public void setNip(String nip) {
		this.nip = nip;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	
	@Override
	public int hashCode(){
		int hash =0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}
	
	public boolean equals(Object object){
		if(!(object instanceof Karyawan)){
			return false;
		}
		Karyawan other = (Karyawan) object;
		if((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))){
			return false;
		}
		return true;
	}
	
	public String toString(){
		return "com.silalahi.valentinus.hibernate.domain.Karyawan[id="+id+"]";
	}
	
}
