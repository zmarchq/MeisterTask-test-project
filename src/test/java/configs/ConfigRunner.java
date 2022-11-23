package configs;

import com.codeborne.selenide.Configuration;
import drivers.mobile.LocalMobileDriver;
import drivers.mobile.RemoteMobileDriver;
import drivers.web.WebDriver;
import helpers.Attach;
import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.*;

public class ConfigRunner {
   private final String platform = getProperty("platform");
   private final String isRemote = getProperty("isRemote");

    public void runBeforeAllPlatformConfiguration() {
        switch (platform) {
            case "web":
                WebDriver driver = new WebDriver();
                driver.configure();
                break;
            case "mobile":
                if (isRemote.equals("true")) {
                    Configuration.browser = RemoteMobileDriver.class.getName();
                } else {
                    Configuration.browser = LocalMobileDriver.class.getName();
                }
                Configuration.browserSize = null;
                break;
            default:
                throw new IllegalArgumentException("Can't find platform " + platform + ". Possible variants: web, mobile");
        }
    }

    public void runAfterEachPlatformConfig() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        switch (platform) {
            case "web":
                Attach.browserConsoleLogs();
                Attach.addVideo();
                break;
            case "mobile":
                if (isRemote.equals("true")) {
                    String sessionId = sessionId().toString();
                    closeWebDriver();
                    Attach.video(sessionId);
                }
                break;
        }
    }

    @SneakyThrows
    private String getProperty(String key) {
        FileInputStream fis;
        Properties property = new Properties();
        fis = new FileInputStream("gradle.properties");
        property.load(fis);
        fis.close();
        return property.getProperty(key);
    }
}
