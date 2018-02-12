package com.silalahi.valentinus.hibernate.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
	
	@ManyToOne 
	@JoinColumn(name="id_peminjam", nullable=false)
	private Karyawan peminjam;
	
	@OneToOne 
	@JoinColumn(name="id_persetujuan", nullable=false)
	private Persetujuan persetujuan;
	
	@Column(nullable=false)
	private BigDecimal nilai;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status_pinjaman", nullable=false)
	private StatusPeminjaman statusPeminjaman = StatusPeminjaman.DISETUJUI;
	
	@OneToMany(mappedBy="pinjaman", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Pembayaran> daftarPembayaran = new ArrayList<Pembayaran>();
	
	@OneToMany(mappedBy="pinjaman", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Pencairan> daftarPencairan = new ArrayList<Pencairan>(); 
	
	public List<Pembayaran> getDaftarPembayaran() {
		return daftarPembayaran;
	}
	public void setDaftarPembayaran(List<Pembayaran> daftarPembayaran) {
		this.daftarPembayaran = daftarPembayaran;
	}
	public List<Pencairan> getDaftarPencairan() {
		return daftarPencairan;
	}
	public void setDaftarPencairan(List<Pencairan> daftarPencairan) {
		this.daftarPencairan = daftarPencairan;
	}
	
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
