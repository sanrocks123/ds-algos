package sanrockzz.gradledemo.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sanrockzz.gradledemo.service.HealthCheckService;

/**
 * @author Sanjeev Saxena
 */

@Tag(name = "health", description = "health check services")
@RestController
@RequestMapping(value = "/v1", produces = APPLICATION_JSON_VALUE)
public class HealthController {

    @Autowired
    private HealthCheckService healthCheck;

    /**
     *
     */
    @GetMapping(value = "/health")
    public ResponseEntity<Map<String, Object>> serviceHealthCheck() {
        return new ResponseEntity<Map<String, Object>>(healthCheck.getHealthStatus(),
            HttpStatus.OK);
    }
}