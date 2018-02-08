package silalahi.valentinus.oop;

import java.math.BigDecimal;

import silalahi.valentinus.oop.dao.Pembayaran;

/**
 * Project 	: java-oop 
 * User		: valentinus silalahi 
 * Email	: valentinus.silalahi@gmail.com 
 * Telegram : @valentinusilalahi 
 * Date		: 08/02/18
 */

public class Tunai extends Pembayaran {
	private BigDecimal bayar;
	
	public BigDecimal hitungKembalian(){
		return bayar.subtract(getJumlah());
	}

	public BigDecimal getBayar() {
		return bayar;
	}

	public void setBayar(BigDecimal bayar) {
		this.bayar = bayar;
	}
	
}
