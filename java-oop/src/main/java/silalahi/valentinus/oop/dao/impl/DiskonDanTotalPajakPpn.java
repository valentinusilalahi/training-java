package silalahi.valentinus.oop.dao.impl;

import java.math.BigDecimal;

import silalahi.valentinus.oop.Pembelian;
import silalahi.valentinus.oop.dao.Diskon;
import silalahi.valentinus.oop.dao.Pajak;

/**
 * Project 	: java-oop 
 * User		: valentinus silalahi 
 * Email	: valentinus.silalahi@gmail.com 
 * Telegram : @valentinusilalahi 
 * Date		: 08/02/18
 */

public class DiskonDanTotalPajakPpn implements Pajak, Diskon {
	
	private BigDecimal minimalDiskon;
	private BigDecimal persentaseDiskon;
	private BigDecimal persentasePajak;

	public BigDecimal hitungDiskon(Pembelian p) {
		if(p.hitungTotalPembelian().compareTo(minimalDiskon)>0){
			return p.hitungTotalPembelian().multiply(persentaseDiskon);
		}
		return persentaseDiskon;
	}

	public BigDecimal hitungPajak(Pembelian p) {
		return persentasePajak.multiply(p.hitungTotalPembelian());
	}

	public BigDecimal getMinimalDiskon() {
		return minimalDiskon;
	}

	public void setMinimalDiskon(BigDecimal minimalDiskon) {
		this.minimalDiskon = minimalDiskon;
	}

	public BigDecimal getPersentaseDiskon() {
		return persentaseDiskon;
	}

	public void setPersentaseDiskon(BigDecimal persentaseDiskon) {
		this.persentaseDiskon = persentaseDiskon;
	}

	public BigDecimal getPersentasePajak() {
		return persentasePajak;
	}

	public void setPersentasePajak(BigDecimal persentasePajak) {
		this.persentasePajak = persentasePajak;
	}
	
	

}
