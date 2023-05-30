package cc.momas.faker;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

/**
 * @author 陈伟明
 * @since 2023/5/29
 */
@ShellComponent
public class HelloCommand {
    /**
     * <pre>
     *     shell:>add --a 1 --b 2
     * </pre>
     */
    @ShellMethod("Add two integers together.")
    public int add(int a, int b) {
        return a + b;
    }
}
