/*
 * SPDX-FileCopyrightText: 2025 Swiss Confederation
 *
 * SPDX-License-Identifier: MIT
 */

package ch.admin.bit.eid;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ConfigurationPropertiesScan
@EnableJpaRepositories
@EntityScan
@Slf4j
public class TrustRegistryDataServiceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext app = SpringApplication.run(TrustRegistryDataServiceApplication.class, args);
        Environment env = app.getEnvironment();

        String appName = env.getProperty("spring.application.name");
        String serverPort = env.getProperty("server.port");
        log.info(
                """
                        
                        ----------------------------------------------------------------------------
                        \t'{}' is running!\s
                        \tProfile(s): \t\t\t\t{}
                        \tSwaggerUI:   \t\t\t\thttp://localhost:{}/swagger-ui.html
                        ----------------------------------------------------------------------------""",
                appName,
                env.getActiveProfiles(),
                serverPort
        );
    }
}
