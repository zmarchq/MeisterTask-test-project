package drivers.web;

import com.codeborne.selenide.Configuration;
import configs.web.WebConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ProjectConfiguration {
    private final WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

    public void configure() {
        System.out.println(config.isRemote());
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
