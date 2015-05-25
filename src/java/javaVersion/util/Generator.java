package javaVersion.util;

import javaVersion.info.SellerInfo;

import java.io.File;
import java.util.Hashtable;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class Generator {
	private static int DEFAULT_WIDTH = 300;
	private static int DEFAULT_HEIGHT = 300;
	@SuppressWarnings("deprecation")
	public static void encode(String contents, int width, int height, String imgPath) {  
        Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();  
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);  
        hints.put(EncodeHintType.CHARACTER_SET, "GBK");  
        try {  
            BitMatrix bitMatrix = new MultiFormatWriter().encode(contents,  
                    BarcodeFormat.QR_CODE, width, height, hints);  
            File file = new File(imgPath);
            MatrixToImageWriter  
                    .writeToFile(bitMatrix, "png", file);  
  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
	public static int generate(SellerInfo sellerInfo, String path) {
		String descriptor = sellerInfo.getKey()+"#"+ sellerInfo.getDescriptor();
		encode(descriptor, DEFAULT_WIDTH, DEFAULT_HEIGHT, path);
		return 0;
	}
}
