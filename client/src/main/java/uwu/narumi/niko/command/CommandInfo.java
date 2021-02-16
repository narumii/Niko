package uwu.narumi.niko.command;

import static java.lang.annotation.ElementType.TYPE_USE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = TYPE_USE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CommandInfo {

  String alias();

  String description() default "";

  String usage() default "";

  String[] aliases() default {};
}
