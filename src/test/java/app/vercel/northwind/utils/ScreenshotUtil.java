package app.vercel.northwind.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class ScreenshotUtil {

    public static void capturar(WebDriver driver, String nameArquivo) throws IOException {

        File origem = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        Path destino = Paths.get("evidencias", nameArquivo + ".png");

        destino.toFile().getParentFile().mkdirs();

        Files.copy(origem.toPath(), destino, StandardCopyOption.REPLACE_EXISTING);
    }

}
