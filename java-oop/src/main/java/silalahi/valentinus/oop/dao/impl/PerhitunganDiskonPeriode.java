package silalahi.valentinus.oop.dao.impl;

import java.math.BigDecimal;

import silalahi.valentinus.oop.Pembelian;
import silalahi.valentinus.oop.dao.DiskonBersyarat;

/**
 * Project 	: java-oop 
 * User		: valentinus silalahi 
 * Email	: valentinus.silalahi@gmail.com 
 * Telegram : @valentinusilalahi 
 * Date		: 08/02/18
 */

public class PerhitunganDiskonPeriode implements DiskonBersyarat {
	
	private Pembelian pembelian;

	public BigDecimal hitungDiskon(Pembelian p) {
		this.pembelian=p;
		if(berlaku()){
			return new BigDecimal(0.5).multiply(p.hitungTotalDiskon());
		}
		return null;
	}

	public boolean berlaku() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
