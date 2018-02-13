# Dependecy Injection atau Inversion of Control menggunakan Spring Framwork #

### Contoh Code menggunakan Java ###

* Client Code

```java
public class Produk {
	private Long id;
	private String kodeProduk
	private String nama;
	private BigDecimal harga;
	
	// generate Getter dan Setter
}
```

```java
@Repository
public class ProdukDao {
	@Autowired
	private DataSource dataSource;
	
	public void create(Produk p){
		String sql = "INSERT INTO produk (kodeProduk, nama, harga)";
		sql += "?,?,?";
		
		Connection dbConnect = dataSource.getConnection();
		PreparedStatement ps = dbConnect.prepareStatement(sql);
		ps.setString(1, p.getKodeProduk());
		ps.setString(2, p.getNama);
		ps.setString(3, p.getHarga));
		ps.executeUpdate();dbConnect.close();
	}
	
	// implement method method laennya disini
}
```

* konfigurasi DI di Spring dengan menggunakan `konfig-spring.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">

    <bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">
        <property name="driverClassName" value="com.mysql.jdbc.Driver" />
        <property name="url" value="jdbc:mysql://localhost/belajar_ioc_spring" />
        <property name="username" value="root" />
        <property name="password" value="admin" />
    </bean>
    
    <context:component-scan base-package="com.silalahi.valentinus.belajar.spring" />
		
</beans>
```

* Demo Spring framework

```java
public class DemoSpringDI {

	public static void main(String[] xxx) {
	
		Produk p = new Produk();
		p.setKodeProduk("B-001");
		p.setNama("Barang-001");
		p.setHarga(new BigDecimal(15000.00));
	
		ApplicationContext springContainer
			= new ClassPathXmlApplicationContext("konfig-spring.xml")
			
		ProdukDao pd = springContainer.getBean(ProdukDao.class);
		pd.create(p);
	}
	
}
```

### Penjelasan ###

* Dependency Injection merupakan penyedia kebutuhan yang digunakan aplikasi dalam memudahkan jalannya aplikasi. contohnya konek database dengan aplikasi.

Spring mempunyai fitur `componen-scan` yang bertugas untuk melihat isi `package` yang kita konfig di file `konfig-spring.xml` yang dibuat tadi; kemudian akan mencari class-class yang diberi anotasi(@) seperti berikut :
* @Repository
* @Controller
* @Service
* @Component

Setelah ditemukan, Spring akan melakukan inisialisasi terhadap `class-class` tersebut; mengisi(inject) semua kebutuhannya(dependency).
Untuk Injection ini, kita tidak perlu lagi menyediakan `setter-method` ataupun `menambahkan argument di constructor` karena Spring sudah menyediakan anotation @Autowired

Perhatikan contoh diatas `datasource` akan di inject lewat file konfig-spring.xml yang kita buat dengan adanya anotasi @Repository dan @Autowired yang ada di class `ProdukDao`.

Setelah konfigurasi sudah sesuai, Spring akan membaca file konfigurasi dengan `new ClassPathXmlApplicationContext("classpath:konfig-spring.xml")`
Apabila aplikasi berbasis web, akan di-inisialisasi di `web.xml` seperti ini :
```xml
<context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>
        classpath*:konfig-spring.xml
    </param-value>
</context-param>
<listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
</listener>
```

Semoga penjelasan Dependency injection yang disertai contoh-code ini cukup jelas. Terima kasih :D

### Referensi ###

* [spring framework docs](https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#beans-introduction)