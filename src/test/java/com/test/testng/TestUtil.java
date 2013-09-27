package com.test.testng;

import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.QualityKey;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestUtil {
	private ScreenRecorder screenRecorder;
	public WebDriver driver;
	public String finalFormat;
	static InputStream inStream = null;
	static OutputStream outStream = null;

	@BeforeClass()
	public void setup() throws Exception {
//start recording
		startRecording();
		dateFormat();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
	}

	public void startRecording() throws Exception {
		GraphicsConfiguration gc = GraphicsEnvironment
				.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration();

		screenRecorder = new ScreenRecorder(gc, new Format(MediaTypeKey,
				MediaType.FILE, MimeTypeKey, MIME_AVI), new Format(
				MediaTypeKey, MediaType.VIDEO, EncodingKey,
				ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, CompressorNameKey,
				ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24,
				FrameRateKey, Rational.valueOf(15), QualityKey, 1.0f,
				KeyFrameIntervalKey, 15 * 60), new Format(MediaTypeKey,
				MediaType.VIDEO, EncodingKey, "black", FrameRateKey,
				Rational.valueOf(30)), null);
		screenRecorder.start();

	}

	@AfterClass()
	public void stopRecording() throws Exception {

		driver.quit();
		screenRecorder.stop();
		moveAndDeleteVideo();
	}

	public void dateFormat() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String dateFinal = dateFormat.format(date);

		DateFormat timeFormat = new SimpleDateFormat("HH.mm.ss");
		Date time = new Date();
		String timeFinal = timeFormat.format(time);

		finalFormat = "ScreenRecording " + dateFinal + " at " + timeFinal;
		System.out.println(finalFormat.trim());
	}

	public void moveAndDeleteVideo() {

		try {

			File afile = new File("C:\\Users\\sai\\Videos\\" + finalFormat
					+ ".avi");
			File bfile = new File("E:\\New Folder (3)\\" + finalFormat + ".avi");

			inStream = new FileInputStream(afile);
			outStream = new FileOutputStream(bfile);

			byte[] buffer = new byte[1024];

			int length;
			// copy the file content in bytes
			while ((length = inStream.read(buffer)) > 0) {

				outStream.write(buffer, 0, length);

			}

			inStream.close();
			outStream.close();

			// delete the original file
			afile.delete();

			System.out.println("File is copied successful!");
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
