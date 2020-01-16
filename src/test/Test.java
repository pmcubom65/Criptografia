package test;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class Test {

	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		KeyPairGenerator kpg=KeyPairGenerator.getInstance("RSA");
		KeyPair kp=kpg.generateKeyPair();
		PrivateKey priv=kp.getPrivate();
		PublicKey pub=kp.getPublic();
		
		Cipher cipher=Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, pub);
		String s="hola";
		cipher.update(s.getBytes());
		byte[] b=cipher.doFinal();
		for (byte byt: b) {
			System.out.print((char) byt);
		}
		System.out.println();
		
		cipher.init(Cipher.DECRYPT_MODE, priv);
		cipher.update(b);
		byte[] salida=cipher.doFinal();
		for (byte sa: salida) {
			System.out.print((char) sa);
		}
	
	}

}
