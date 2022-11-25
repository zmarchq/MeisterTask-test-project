package configs.web;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:web.properties"}
)
public interface WebConfig extends Config {
    @Key("browser")
    String getBrowser();

    @Key("remoteUrl")
    String getRemoteUrl();

    @Key("browserVersion")
    String browserVersion();

    @Key("browserSize")
    String browserSize();

    @Key("timeout")
    int timeout();

    @Key("isRemote")
    boolean isRemote();
}
