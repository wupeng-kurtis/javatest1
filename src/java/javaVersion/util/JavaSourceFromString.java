package javaVersion.util;

import java.net.URI;

import javax.tools.SimpleJavaFileObject;

public class JavaSourceFromString extends SimpleJavaFileObject {

	final String code;
	protected JavaSourceFromString(String name, String code) {
		super(URI.create("string:///" + name.replace('.','/') + Kind.SOURCE.extension), Kind.SOURCE);
		this.code = code;
		// TODO Auto-generated constructor stub
	}
	
	public CharSequence getCharContent(boolean ignoreEncodingErrors) {
		return code;
	}

}
