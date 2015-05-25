package javaVersion.util;

import javaVersion.info.SellerInfo;
import javaVersion.info.UserInfo;

import java.awt.image.BufferedImage;  
import java.io.File;  
import java.util.Hashtable;    

import javax.imageio.ImageIO;  

import com.google.zxing.BinaryBitmap;  
import com.google.zxing.DecodeHintType;  
import com.google.zxing.LuminanceSource;  
import com.google.zxing.MultiFormatReader;  
import com.google.zxing.Result;  
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;  
import com.google.zxing.common.HybridBinarizer;  

public class Scanner {
	
    public static String decode(String imgPath) {  
        BufferedImage image = null;  
        Result result = null;  
        try {  
            image = ImageIO.read(new File(imgPath));  
            if (image == null) {  
                System.out.println("the decode image may be not exit.");  
            }  
            LuminanceSource source = new BufferedImageLuminanceSource(image);  
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));  
  
            Hashtable<DecodeHintType, Object> hints = new Hashtable<DecodeHintType, Object>();  
            hints.put(DecodeHintType.CHARACTER_SET, "GBK");  
  
            result = new MultiFormatReader().decode(bitmap, hints);  
            return result.getText();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
    
	private static String parse(String descriptor) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		String key = getKeyFromDescriptor(descriptor);
		//SellerInfo sellerInfo = SellerLibrary.getInfo(key);
		Class<?> ownClass = Class.forName("javaVersion.info."+key);
		Object obj = ownClass.newInstance();
		SellerInfo sellerInfo = (SellerInfo) obj;
		UserInfo userInfo = new UserInfo();
		sellerInfo.updateByUserInfo(userInfo);
		String ret =  output(sellerInfo);
		return ret;
	}
	
	public static String scan(String imgPath) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		String descriptor = decode(imgPath);
		String result = parse(descriptor);
		return result;
	}
	
	private static String output(SellerInfo sellerInfo) {
		String ret = new String("");
		String descriptor = sellerInfo.getDescriptor();
		int count = 0;
		for(int i = 0; i < descriptor.length(); ++i) {
			if(descriptor.charAt(i) == '#') {
				ret += sellerInfo.getVarByIndex(count++);
			} else {
				ret += descriptor.charAt(i);
			}
		}
		return ret;
	}
	
	private static String getKeyFromDescriptor(String descriptor) {
		int index = descriptor.indexOf("#");
		return descriptor.substring(0, index);
	}
}
