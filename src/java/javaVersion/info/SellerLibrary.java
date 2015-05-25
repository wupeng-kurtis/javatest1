package javaVersion.info;

import java.util.Hashtable;

public class SellerLibrary {
	static Hashtable<String, SellerInfo> lib = new Hashtable<String, SellerInfo>();
	
	
	public static SellerInfo getInfo(String key) {
		return lib.get(key);
	}
	public static void putInfo(SellerInfo sellerInfo) {
		lib.put(sellerInfo.getKey(), sellerInfo);
	}
}
