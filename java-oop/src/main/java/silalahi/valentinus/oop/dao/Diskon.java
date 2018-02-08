package silalahi.valentinus.oop.dao;

import java.math.BigDecimal;

import silalahi.valentinus.oop.Pembelian;

/**
 * Project 	: java-oop 
 * User		: valentinus silalahi 
 * Email	: valentinus.silalahi@gmail.com 
 * Telegram : @valentinusilalahi 
 * Date		: 08/02/18
 */

public interface Diskon {
	
	public BigDecimal hitungDiskon(Pembelian p);

}
