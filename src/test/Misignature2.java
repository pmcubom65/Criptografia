package test;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;

public class Misignature2 {

	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
		Signature signature=Signature.getInstance("SHA256WithDSA");
		KeyPairGenerator kpg=KeyPairGenerator.getInstance("DSA");
		KeyPair keypair=kpg.generateKeyPair();
		PrivateKey privatekey=keypair.getPrivate();
		PublicKey publickey=keypair.getPublic();
		signature.initSign(privatekey, new SecureRandom());
		String s="hola que tal";
		signature.update(s.getBytes());
		
		byte[] salida=signature.sign();
		Signature signature2=Signature.getInstance("SHA256WithDSA");
		signature2.initVerify(publickey);
		signature2.update(s.getBytes());
		System.out.println(signature2.verify(salida));
		
	}
}
