package silalahi.valentinus.oop.dao;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Project 	: java-oop 
 * User		: valentinus silalahi 
 * Email	: valentinus.silalahi@gmail.com 
 * Telegram : @valentinusilalahi 
 * Date		: 08/02/18
 */

public abstract class Pembayaran {
	
	private BigDecimal jumlah;
	private Date waktu;
	
	public BigDecimal getJumlah() {
		return jumlah;
	}
	public void setJumlah(BigDecimal jumlah) {
		this.jumlah = jumlah;
	}
	public Date getWaktu() {
		return waktu;
	}
	public void setWaktu(Date waktu) {
		this.waktu = waktu;
	}
	
}
