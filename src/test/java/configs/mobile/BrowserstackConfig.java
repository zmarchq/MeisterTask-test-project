package configs.mobile;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
public interface BrowserstackConfig extends Config {

    @Key("browserstack.user")
    String browserStackUser();

    @Key("browserstack.key")
    String browserStackKey();

    @Key("browserstack.url")
    String browserStackUrl();

    @Key("browserstack.appUrl")
    String appUrl();

    @Key("browserstack.deviceName")
    String deviceName();

    @Key("browserstack.platformVersion")
    String platformVersion();

    @Key("browserstack.projectName")
    String projectName();

    @Key("browserstack.build")
    String build();

    @Key("browserstack.name")
    String name();
}
