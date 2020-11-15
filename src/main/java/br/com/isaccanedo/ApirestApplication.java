package br.com.isaccanedo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Isac Canedo
 */

@RestController
@SpringBootApplication
public class ApirestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApirestApplication.class, args);

	}

	@RequestMapping("/")
	public String cifra() throws NoSuchAlgorithmException {
		Date date = new Date();
		SimpleDateFormat f = new SimpleDateFormat(("ddMMyyyyhhmmss"));
		String dataAtual = f.format(date);
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.reset();
		md.update(dataAtual.getBytes());
		return "EndPoint funcionando\n"+" - Hash do chamado: " + new BigInteger(1, md.digest()).toString(16);
	}

}