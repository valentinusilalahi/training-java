package com.silalahi.valentinus.hibernate.service;

import java.util.List;

import com.silalahi.valentinus.hibernate.domain.Karyawan;

/**
 * Project : java-hibernate 
 * User : valentinus silalahi 
 * Email : valentinus.silalahi@gmail.com 
 * Telegram : @valentinusilalahi 
 * Date : 12/02/18
 */

public interface AplikasiKasbonService {
	
	//service yang berhubungan dengan Karyawan
	public void save(Karyawan karyawan);
	public Karyawan findById(Long id);
	public List<Karyawan> findAllKaryawan(Integer start, Integer rows);
	public Long countAllKaryawan();
	public List<Karyawan> findKaryawanByNama(String nama);
	public Karyawan findKaryawanByNip(String nip);
	
}
