package com.ht.util;

public class HTException extends Exception {

	private static final long serialVersionUID = -4980619486374675623L;

	public HTException(){
		super();
	}

	public HTException(String msg){
		super(msg);
	}
	
	public HTException(Throwable t){
		super(t);
	}
	
	public HTException(String msg,Throwable t){
		super(msg,t);
	}
	
}
