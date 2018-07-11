package test.pivotal.pal.trackerapi;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;

public class SecurityConfig {


    @LocalServerPort
    public String port;

    @Autowired
    public TestRestTemplate restTemplate;

    @Before
    public void setUpSecurity() throws Exception {
        RestTemplateBuilder builder = new RestTemplateBuilder()
                .rootUri("http://localhost:" + port)
                .basicAuthorization("user", "password");

        restTemplate = new TestRestTemplate(builder);
    }


}
