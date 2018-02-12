package com.silalahi.valentinus.hibernate.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Project : java-hibernate 
 * User : valentinus silalahi 
 * Email : valentinus.silalahi@gmail.com 
 * Telegram : @valentinusilalahi 
 * Date : 12/02/18
 */

@Entity
public class Pencairan implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_pinjaman", nullable=false)
	private Pinjaman pinjaman;
	
	@ManyToOne
	@JoinColumn(name="id_kasir", nullable=false)
	private Karyawan kasir;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="waktu_pencairan", nullable=false)
	private Date waktuPencairan = new Date();
	
	@Column(nullable=false)
	private BigDecimal nilai;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pinjaman getPinjaman() {
		return pinjaman;
	}

	public void setPinjaman(Pinjaman pinjaman) {
		this.pinjaman = pinjaman;
	}

	public Karyawan getKasir() {
		return kasir;
	}

	public void setKasir(Karyawan kasir) {
		this.kasir = kasir;
	}

	public Date getWaktuPencairan() {
		return waktuPencairan;
	}

	public void setWaktuPencairan(Date waktuPencairan) {
		this.waktuPencairan = waktuPencairan;
	}

	public BigDecimal getNilai() {
		return nilai;
	}

	public void setNilai(BigDecimal nilai) {
		this.nilai = nilai;
	}
	
	@Override
	public int hashCode(){
		int hash =0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}
	
	@Override
	public boolean equals(Object object){
		if(!(object instanceof Pinjaman)){
			return false;
		}
		Pencairan other = (Pencairan) object;
		if((this.id ==null && other.id != null) || (this.id != null && !this.id.equals(other.id))){
			return false;
		}
		return true;
	}
	
	@Override
	public String toString(){
		return "com.silalahi.valentinus.hibernate.domain.Pencairan[id="+id+"]";
	}
	
}
