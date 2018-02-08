package silalahi.valentinus.oop;

import java.util.Date;

/**
 * Project 	: java-oop 
 * User		: valentinus silalahi 
 * Email	: valentinus.silalahi@gmail.com 
 * Telegram : @valentinusilalahi 
 * Date		: 08/02/18
 */

public class Pengiriman {
	
	private Date waktuPengiriman;
	private StatusPengiriman status;
	
	public Date getWaktuPengiriman() {
		return waktuPengiriman;
	}
	public void setWaktuPengiriman(Date waktuPengiriman) {
		this.waktuPengiriman = waktuPengiriman;
	}
	public StatusPengiriman getStatus() {
		return status;
	}
	public void setStatus(StatusPengiriman status) {
		this.status = status;
	}
	
}
