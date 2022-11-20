package drivers.web;

import com.codeborne.selenide.Configuration;
import configs.web.WebDriverConfig;
import configs.web.ConfigReader;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriver {
    private static final WebDriverConfig config = ConfigReader.Instance.read();

    public static void configure() {
        Configuration.timeout = config.timeout();
        Configuration.browser = config.getBrowser();
        Configuration.browserSize = config.browserSize();
        Configuration.browserVersion = config.browserVersion();
        if (config.isRemote()) {
            Configuration.remote = config.getRemoteUrl();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }
    }
}
