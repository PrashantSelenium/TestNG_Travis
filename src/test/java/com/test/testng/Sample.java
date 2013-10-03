package com.test.testng;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Sample {

	/**
	 * @param args
	 * @throws Exception
	 */
	static InputStream inStream = null;
	static OutputStream outStream = null;
	public static void main(String[] args) throws Exception {

		TestUtil test = new TestUtil();
		test.startRecording();
		
		
		// TODO Auto-generated method stub
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String dateFinal = dateFormat.format(date);

		DateFormat timeFormat = new SimpleDateFormat("HH.mm.ss");
		Date time = new Date();
		String timeFinal = timeFormat.format(time);

		String finalFormat ="ScreenRecording " + dateFinal + " at " + timeFinal;
		System.out.println(finalFormat.trim());
		test.stopRecording();
		
		
		try{
			
    	    File afile =new File("C:\\Users\\sai\\Videos\\"+ finalFormat +".avi");
    	    File bfile =new File("E:\\New Folder (3)\\"+ finalFormat +".avi");
 
    	    inStream = new FileInputStream(afile);
    	    outStream = new FileOutputStream(bfile);
 
    	    byte[] buffer = new byte[1024];
 
    	    int length;
    	    //copy the file content in bytes 
    	    while ((length = inStream.read(buffer)) > 0){
 
    	    	outStream.write(buffer, 0, length);
 
    	    }
 
    	    inStream.close();
    	    outStream.close();
 
    	    //delete the original file
    	    afile.delete();
 
    	    System.out.println("File is copied successful!"); }
		
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
