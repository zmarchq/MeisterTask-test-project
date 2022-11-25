package configs.mobile;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:mobile.properties"})
public interface LocalConfig extends Config {

    @Key("deviceName")
    String deviceName();

    @Key("platformName")
    String platformName();

    @Key("platformVersion")
    String platformVersion();

    @Key("appPackage")
    String appPackage();

    @Key("appActivity")
    String appActivity();

    @Key("appUrl")
    String appUrl();
}
