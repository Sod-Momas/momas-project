package cc.momas.momasjob;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sod-Momas
 * @since 2022/11/13
 */
@RestController
@RequestMapping("job")
public class JobController {
    @RequestMapping("ping")
    String ping() {
        return "pong";
    }
}
