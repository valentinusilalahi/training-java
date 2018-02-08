package silalahi.valentinus.oop;

import java.math.BigDecimal;
import java.util.Date;

import silalahi.valentinus.oop.dao.impl.DiskonDanTotalPajakPpn;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Demo Java OOP" );
        
        //Data Produk
        Produk produk = new Produk();
        produk.setKode("001");
        produk.setNama("Produk-001");
        produk.setHarga(new BigDecimal("15500"));
        
        //Pilih Produk
        PembelianDetail pd = new PembelianDetail();
        pd.setProduk(produk);
        pd.setJumlah(5);
        
        //Pesan Produk
        Pembelian pembelian = new Pembelian();
        pembelian.setWaktuTransaksi(new Date());
        pembelian.setNota("Pembelian 001");
        pembelian.getDaftarPembelianDetail().add(pd);
        pd.setPembelian(pembelian);
        System.out.println("Total Belanja : "+pembelian.hitungTotalPembelian());
        
        //Lihat Diskon
        DiskonDanTotalPajakPpn disTax = new DiskonDanTotalPajakPpn();
        disTax.setMinimalDiskon(new BigDecimal(500000));
        disTax.setPersentaseDiskon(new BigDecimal(0.55));
        disTax.setPersentasePajak(new BigDecimal(0.15));
        
        //mana yang di enable pasang di class pembelian
        pembelian.getDaftarDiskon().add(disTax);
        pembelian.getDaftarPajak().add(disTax);
        System.out.println("Total Bayar : "+pembelian.hitungTotalPembelian());
        
        //Pembayaran
        Tunai tunai = new Tunai();
        tunai.setBayar(new BigDecimal(500000));
        System.out.println("Kembalian : "+tunai.hitungKembalian());
        pembelian.setPembayaran(tunai);
        
        //Pengiriman Barang
        Pengiriman pengiriman = new Pengiriman();
        pengiriman.setWaktuPengiriman(new Date());
        pengiriman.setStatus(StatusPengiriman.TERKIRIM);
        pembelian.setPengiriman(pengiriman);
    }
}
