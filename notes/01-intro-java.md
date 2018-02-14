# Pengenalan Java Core #

## Variable dan Memory Management Java ##

### variable ###

* contoh code java
```java
public class Person{
	
	public String nama;						// contoh instance-variable
	
	public static void main(String[] xxx){
		Person p;							// local-variable/reference-variable p;
		p = new Person();					// object Person di-instansiasi
		p.setNama("valentinus")
		
		Person copy = p;					// local-variable yang menunjuk ke-object yang sama
		copy.setNama("silalahi");
	}
	
	public String getNama(){
		return nama;
	}
	
	public void setNama(String nama){		// contoh local-variable nama
		this.nama = nama;
	}
}
```

__variable java dibagi menjadi 3__** :
1. variable lokal adalah variable yang ada di dalam method, hanya hidup ketika method di eksekusi; jika program keluar method maka variable akan diserahkan ke `gerbage-collector` untuk dibersihkan
2. variable static adalah variable yang tidak bisa di ubah lagi value nya
3. variable instance (non-static) adalah variable yang menunjuk ke si-object

### pass by value and pass by reference ###

* **pass-by-value** adalah nilai yang di lempar dari kode pemanggil ke dalam method merupakan nilai variable nya dengan ketentuan bila menggunakan tipe variable bawaan `java` ; jika nilai variable di dalam method berubah maka nilai variable di dalam pemanggil tidak ikut berubah

`Contoh-code nya`
```java
public class PassByValue{

	public static void ubahNama(String nama){
		nama = "valentinus";
		System.out.println("nama baru: " + nama);
	}

	public static void main(String[] xxx){
	String nama = "silalahi";
		System.out.println("nama lama: " + nama);			// output : nama lama: silalahi
		ubahNama(nama);										// output : nama baru: valentinus
		System.out.println("nama lama: " + nama);			// output : nama lama: silalahi
	}
	
}
```

* **pass-by-reference** adalah object atau tipe data array, jika digunakan sebagai parameter; data yang dilempar dari kode pemanggil ke dalam method yang dibawa adalah alamat(reference) dari variable nya dan jika variable di dalam method berubah maka nilai variable di pemanggil juga ikut berubah.

`Contoh-code nya`
```java
public class PassByReference{
	
	public static void ubahNama(String[] nama){
		nama[0] = "valentinus";
		System.out.println("nama baru: " + nama[0]);
	}
	
	public static void main(String[] arg){
		String[] nama = new String[1];
		nama[0] = "silalahi";
		
		System.out.println("nilai lama: " + nama[0]);	// output : nilai lama: silalahi
		ubahNama(nama);									// output : nama baru: valentinus
		System.out.println("nilai lama: " + nama[0]);	// output : nilai lama: valentinus
	}
	
}
```

### Gerbage Collector ###

Gerbage Collector adalah mekanisme JVM untuk menghapus object yang ada di memory kalau sudah tidak dibutuhkan. Di dalam java memory digunakan oleh `heap` dan `stack` adalah tempat kumpulan variable java juga tempat hidupnya method.

Gerbage Collector berjalan/dikontrol sepenuhnya oleh JVM. Hanya JVM yang bisa menentukan kapan GC akan berjalan.

Defenisi dari "object yang tidak dibutuhkan/digunakan lagi?" itu maksudnya adalah jika suatu object tidak dapat lagi diakses oleh `thread` yang masih hidup, maka bisa dipastikan bahwa object tersebut tidak bisa lagi digunakan. object dalam keadaan seperti itulah yang akan dihapus GC dari dalam `heap`

### Referensi ###

* [JavaSE Documentation] https://docs.oracle.com/javase/tutorial/getStarted/index.html)