package drivers.web;

import com.codeborne.selenide.Configuration;
import configs.web.WebConfig;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ProjectConfiguration {
    private final WebConfig config;

    public ProjectConfiguration(WebConfig webConfig) {
        config = webConfig;
    }


    public void configure() {
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
