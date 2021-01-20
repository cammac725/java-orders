package local.cammac.orders.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class H2ServerConfiguration {

    @Value("${h2.tcp.port:9092}")
    private String h2TcpPort;

    @Value("${h2.web.port:8082}")
    private String h2WebPort;


}
