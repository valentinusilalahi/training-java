package com.silalahi.valentinus.hibernate.domain;

import java.io.Serializable;
import java.math.BigDecimal;

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
public class Pinjaman implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private Karyawan peminjam;
	private Persetujuan persetujuan;
	private BigDecimal nilai;
	private StatusPeminjaman statusPeminjaman = StatusPeminjaman.DISETUJUI;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Karyawan getPeminjam() {
		return peminjam;
	}
	public void setPeminjam(Karyawan peminjam) {
		this.peminjam = peminjam;
	}
	public Persetujuan getPersetujuan() {
		return persetujuan;
	}
	public void setPersetujuan(Persetujuan persetujuan) {
		this.persetujuan = persetujuan;
	}
	public BigDecimal getNilai() {
		return nilai;
	}
	public void setNilai(BigDecimal nilai) {
		this.nilai = nilai;
	}
	public StatusPeminjaman getStatusPeminjaman() {
		return statusPeminjaman;
	}
	public void setStatusPeminjaman(StatusPeminjaman statusPeminjaman) {
		this.statusPeminjaman = statusPeminjaman;
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
		Pinjaman other = (Pinjaman) object;
		if((this.id ==null && other.id != null) || (this.id != null && !this.id.equals(other.id))){
			return false;
		}
		return true;
	}
	
	@Override
	public String toString(){
		return "com.silalahi.valentinus.hibernate.domain.Pinjaman[id="+id+"]";
	}
	
}
