package configs.mobile;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:mobile.properties"})
public interface RemoteConfig extends Config {

    @Key("browserstack.user")
    String browserStackUser();

    @Key("browserstack.key")
    String browserStackKey();

    @Key("browserstack.url")
    String browserStackUrl();

    @Key("browserstack.appUrl")
    String appUrl();

    @Key("deviceName")
    String deviceName();

    @Key("platformVersion")
    String platformVersion();

    @Key("projectName")
    String projectName();

    @Key("build")
    String build();

    @Key("name")
    String name();
}
