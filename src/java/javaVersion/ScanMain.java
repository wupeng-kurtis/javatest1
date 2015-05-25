package javaVersion;

import javaVersion.util.Scanner;

public class ScanMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SellerInfo sellerInfo = new WelcomeInfo();
		//sellerInfo.register();
		//Generator.generate(sellerInfo, "welcome.jpg");
		String result;
		try {
			result = Scanner.scan(args[0]);
			System.out.println(result);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
