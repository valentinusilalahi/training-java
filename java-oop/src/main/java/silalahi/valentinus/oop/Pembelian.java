package silalahi.valentinus.oop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import silalahi.valentinus.oop.dao.Diskon;
import silalahi.valentinus.oop.dao.Pajak;
import silalahi.valentinus.oop.dao.Pembayaran;

/**
 * Project 	: java-oop 
 * User		: valentinus silalahi 
 * Email	: valentinus.silalahi@gmail.com 
 * Telegram : @valentinusilalahi 
 * Date		: 08/02/18
 */

public class Pembelian {
	
	private String nota;
	private Date waktuTransaksi;
	private Pembayaran pembayaran;
	private Pengiriman pengiriman;
	
	public String getNota() {
		return nota;
	}
	public void setNota(String nota) {
		this.nota = nota;
	}
	public Date getWaktuTransaksi() {
		return waktuTransaksi;
	}
	public void setWaktuTransaksi(Date waktuTransaksi) {
		this.waktuTransaksi = waktuTransaksi;
	}
	
	private List<Diskon> daftarDiskon = new ArrayList<Diskon>();
	private List<PembelianDetail> daftarPembelianDetail = new ArrayList<PembelianDetail>();
	private List<Pajak> daftarPajak = new ArrayList<Pajak>();
	
	public BigDecimal hitungTotalDiskon(){
		BigDecimal hasil = BigDecimal.ZERO;
		for(Diskon px : daftarDiskon){
			hasil = hasil.add(px.hitungDiskon(this));
		}
		return hasil;
	}
	
	public BigDecimal hitungTotalPembelian(){
		BigDecimal hasil = BigDecimal.ZERO;
		for(PembelianDetail pd : daftarPembelianDetail){
			hasil = hasil.add(pd.hitungSubTotal());
		}
		return hasil;
	}
	public List<Diskon> getDaftarDiskon() {
		return daftarDiskon;
	}
	public void setDaftarDiskon(List<Diskon> daftarDiskon) {
		this.daftarDiskon = daftarDiskon;
	}
	public List<PembelianDetail> getDaftarPembelianDetail() {
		return daftarPembelianDetail;
	}
	public void setDaftarPembelianDetail(List<PembelianDetail> daftarPembelianDetail) {
		this.daftarPembelianDetail = daftarPembelianDetail;
	}
	public List<Pajak> getDaftarPajak() {
		return daftarPajak;
	}
	public void setDaftarPajak(List<Pajak> daftarPajak) {
		this.daftarPajak = daftarPajak;
	}
	public Pembayaran getPembayaran() {
		return pembayaran;
	}
	public void setPembayaran(Pembayaran pembayaran) {
		this.pembayaran = pembayaran;
	}
	public Pengiriman getPengiriman() {
		return pengiriman;
	}
	public void setPengiriman(Pengiriman pengiriman) {
		this.pengiriman = pengiriman;
	}
	
}
