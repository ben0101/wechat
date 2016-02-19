package com.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class CheckSignature {
	
	public  static boolean isCorrect(String signature,String timestamp,String nonce,String TOKEN) throws NoSuchAlgorithmException{
		
	    String[] str = {TOKEN,timestamp,nonce};
		Arrays.sort(str);
		StringBuilder sb = new StringBuilder();
		for(String s : str){
			sb.append(s);
		}
		
		MessageDigest md = MessageDigest.getInstance("SHA");
		byte[] bt = md.digest(sb.toString().getBytes());
		StringBuilder result = new StringBuilder();
		for(int i = 0;i < bt.length;i++){
			result.append(Integer.toString((bt[i] & 0xff)+0x100,16).toString());
		}

		
		if( result.toString().equals(signature)){
			return true;
		}else{
			return false;
		}
	}
}
