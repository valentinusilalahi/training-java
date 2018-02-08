package silalahi.valentinus.oop.dao.impl;

import java.math.BigDecimal;
import java.util.Date;

import silalahi.valentinus.oop.Pembelian;
import silalahi.valentinus.oop.dao.Diskon;

/**
 * Project 	: java-oop 
 * User		: valentinus silalahi 
 * Email	: valentinus.silalahi@gmail.com 
 * Telegram : @valentinusilalahi 
 * Date		: 08/02/18
 */

public class DiskonImpl implements Diskon {

	public BigDecimal hitungDiskon(Pembelian p) {
		Date waktuTransaksi = p.getWaktuTransaksi();
		if(dekatTahunBaru(waktuTransaksi)){
			return new BigDecimal(0.2).multiply(p.hitungTotalDiskon());
		}
		return null;
	}
	
	public boolean dekatTahunBaru(Date waktu){
		
		return false;
	}

}
