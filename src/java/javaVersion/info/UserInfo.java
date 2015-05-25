package javaVersion.info;

import java.util.Date;

public class UserInfo {
	private Date date;
	
	public UserInfo() {
		date = new Date();
	}
	
	public String getTime() {
		return date.toString();
	}
    public String getPhoneModel() {
        return "testModel";
    }
    public String getPhoneOS() {
        return "testOS";
    }
    public String getLocation() {
        return "location!";
    }
    public int getHour() {
        return 12;
    }
}
