package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotHelper {

    // Ekran görüntüsünü alır ve verilen dosya yoluna kaydeder
    public static void takeScreenshot(WebDriver driver, String fileName) {
        // Screenshot alma işlemi
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Dosya adlandırma formatı
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotPath = "src/test/resources/screenshots/" + fileName + "_" + timestamp + ".png";

        // Screenshot'u kaydet
        try {
            FileHandler.copy(screenshot, new File(screenshotPath));
            System.out.println("Ekran görüntüsü kaydedildi: " + screenshotPath);
        } catch (Exception e) {
            System.out.println("Ekran görüntüsü kaydedilemedi: " + e.getMessage());
        }
    }


}


