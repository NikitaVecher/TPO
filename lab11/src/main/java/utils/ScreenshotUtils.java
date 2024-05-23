package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScreenshotUtils {
    public static void takeScreenshot(WebDriver driver, String filePath) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(srcFile.toPath(), Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
