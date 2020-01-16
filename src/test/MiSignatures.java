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

public class MiSignatures {

	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
		Signature signature = Signature.getInstance("SHA256WithDSA");
		KeyPairGenerator kpg=KeyPairGenerator.getInstance("DSA");
		KeyPair kp=kpg.generateKeyPair();
		PrivateKey priv=kp.getPrivate();
		PublicKey pub=kp.getPublic();
		signature.initSign(priv, new SecureRandom());
		String h="hola como estas";
		signature.update(h.getBytes());
		
		byte[] digitalSignature = signature.sign();
		
		
		Signature signature2 = Signature.getInstance("SHA256WithDSA");
		signature2.initVerify(pub);
		signature2.update(h.getBytes());
		
		System.out.println(signature2.verify(digitalSignature));
		
		
		
		
		
	}

}
