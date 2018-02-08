package silalahi.valentinus.oop;

import java.math.BigDecimal;

/**
 * Project 	: java-oop 
 * User		: valentinus silalahi 
 * Email	: valentinus.silalahi@gmail.com 
 * Telegram : @valentinusilalahi 
 * Date		: 08/02/18
 */

public class PembelianDetail {
	
	private Pembelian pembelian;
	private Produk produk;
	private Integer jumlah;
	
	public Pembelian getPembelian() {
		return pembelian;
	}
	public void setPembelian(Pembelian pembelian) {
		this.pembelian = pembelian;
	}
	public Produk getProduk() {
		return produk;
	}
	public void setProduk(Produk produk) {
		this.produk = produk;
	}
	public Integer getJumlah() {
		return jumlah;
	}
	public void setJumlah(Integer jumlah) {
		this.jumlah = jumlah;
	}
	
	public BigDecimal hitungSubTotal(){
		return produk.getHarga().multiply(new BigDecimal(jumlah));
	}
	
}
