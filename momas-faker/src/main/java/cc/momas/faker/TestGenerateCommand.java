package cc.momas.faker;

import net.datafaker.Faker;
import org.springframework.shell.standard.AbstractShellComponent;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.Locale;

/**
 * @author 陈伟明
 * @since 2023/5/29
 */
@ShellComponent
public class TestGenerateCommand extends AbstractShellComponent {
    private static final Faker FAKER = new Faker(Locale.CHINA);

    @ShellMethod(value = "Test Generate Data.")
    public String testgen(@ShellOption(defaultValue = "name") String type) {
        switch (type) {
            case "name":
                return FAKER.name().fullName();
        }
        return "none";
    }
}
