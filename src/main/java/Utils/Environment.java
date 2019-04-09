package Utils;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:dev.properties"
})
public interface Environment extends Config {
    String url();
    String email();
    String password();
}
