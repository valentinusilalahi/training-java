package com.silalahi.valentinus.hibernate.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.silalahi.valentinus.hibernate.domain.Karyawan;
import com.silalahi.valentinus.hibernate.service.AplikasiKasbonService;

/**
 * Project : java-hibernate 
 * User : valentinus silalahi 
 * Email : valentinus.silalahi@gmail.com 
 * Telegram : @valentinusilalahi 
 * Date : 12/02/18
 */

@Service("AplikasiKasbonService")
@Transactional
public class AplikasiKasbonServiceImpl implements AplikasiKasbonService {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void save(Karyawan karyawan) {
		sessionFactory.getCurrentSession().saveOrUpdate(karyawan);
	}

	@Override
	public Karyawan findById(Long id) {
		return (Karyawan) sessionFactory
				.getCurrentSession()
				.get(Karyawan.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<Karyawan> findAllKaryawan(Integer start, Integer rows) {
		if(start == null || start < 0) start = 0;
		if(rows == null || rows < 0) rows = 20;
		return sessionFactory.getCurrentSession()
				.createQuery("select k from Karyawan order by k.nip")
				.setFirstResult(start)
				.setMaxResults(rows)
				.list();
	}

	@Override
	public Long countAllKaryawan() {
		return (Long) sessionFactory.getCurrentSession()
				.createQuery("select count(k) from Karyawan")
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Karyawan> findKaryawanByNama(String nama) {
		return sessionFactory.getCurrentSession()
				.createQuery("select k from Karyawan "
						+ "where k.nama = :nama "
						+ "order by k.nip")
				.setString("nama", "%"+nama+"%")
				.list();
	}

	@Override
	public Karyawan findKaryawanByNip(String nip) {
		return (Karyawan) sessionFactory.getCurrentSession()
				.createQuery("select k from Karyawan "
						+ "where k.nip = :nip "
						+ "order by k.nip")
				.setString("nip", "%"+nip+"%")
				.uniqueResult();
	}

}
