package customerService.controller;

import java.text.SimpleDateFormat;

import java.util.Date;

public class test {

	public static void main(String[] args) {
		
		
		Date now=new Date();
		  
		SimpleDateFormat ft = new SimpleDateFormat ( " yyyy-MM-dd hh:mm:ss " ) ;
		  
	      System . out . println( "當前時間為: " + ft . format (now) ) ;
		
	}

}
