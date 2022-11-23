package drivers.mobile;

import com.codeborne.selenide.WebDriverProvider;
import configs.mobile.RemoteConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class RemoteMobileDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        RemoteConfig config = ConfigFactory.create(RemoteConfig.class, System.getProperties());

        mutableCapabilities.setCapability("browserstack.user", config.browserStackUser());
        mutableCapabilities.setCapability("browserstack.key", config.browserStackKey());
        mutableCapabilities.setCapability("app", config.appUrl());
        mutableCapabilities.setCapability("device", config.deviceName());
        mutableCapabilities.setCapability("os_version", config.platformVersion());
        mutableCapabilities.setCapability("project", config.projectName());
        mutableCapabilities.setCapability("build", config.build());
        mutableCapabilities.setCapability("name", config.name());

        try {
            return new RemoteWebDriver(new URL(config.browserStackUrl()), mutableCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Can't create driver!", e);
        }
    }
}
