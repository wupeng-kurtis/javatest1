package javaVersion.info;

import java.util.Vector;
import java.util.TreeMap;

public class SellerInfo {
	protected String descriptor;
	protected String key;
	protected Vector<String> varList;
	protected int varNum;
//        protected TreeMap<String,TreeMap<Integer,String> > sellerData;
        public SellerInfo()
        {
            
        }
	public SellerInfo(String descriptor, String key) {
		this.descriptor = descriptor;
		this.key = key; 
		varNum = 0;
		for(int i = 0; i < descriptor.length(); ++i) {
			if(descriptor.charAt(i) == '#') ++varNum;
		}
		varList = new Vector<String>();
//                sellerData=new TreeMap<>();
		varList.setSize(varNum);
	}

	// setter and getter
	public int getVarNum() {
		return varNum;
	}
	public void setVarNum(int varNum) {
		this.varNum = varNum;
	}
	public String getDescriptor() {
		return descriptor;
	}
	public void setDescriptor(String descriptor) {
		this.descriptor = descriptor;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getVarByIndex(int index) {
		return varList.elementAt(index);
	}
	
	// (to be overrided)
	public int updateByUserInfo(UserInfo userInfo) {
		return 0;
	}
	public int register() {
		SellerLibrary.putInfo(this);
		return 0;
	}

}
