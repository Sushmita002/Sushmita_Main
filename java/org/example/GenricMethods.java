package org.example;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GenricMethods {
    public static void takeSreenShort(WebDriver driver,String browserName,String resolutionName) throws IOException {
        DateFormat dateFormat = new SimpleDateFormat("dd_MMM_YYYY_hh_mm_ss_SSS");
        Date date = new Date();
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destination = new File(browserName + "/" + resolutionName + "/" + dateFormat.format(date) + ".png");
        org.apache.commons.io.FileUtils.copyFile(screenshot, destination);
    }
    public static void recordTheSession()
    {
//        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
//        MonteMedia monteMedia = MonteMedia.getInstance();
//        ScreenCapture screenCapture = monteMedia.createScreenCapture(screenRect);
//        VideoCaptureAttributes videoAttributes = new VideoCaptureAttributes();
//        videoAttributes.setBitRate(8000000);
//        videoAttributes.setFrameRate(30);
//        videoAttributes.setCompressionQuality(0.8f);
//        VideoCapture capture = monteMedia.createVideoCapture(screenCapture, videoAttributes);
//        capture.start();
//        Thread.sleep(5000); // Record for 5 seconds
//        capture.stop();
//        capture.saveAs(new File("videos/" + browserName + "_" + resolutionName + ".mp4"));

    }
}
