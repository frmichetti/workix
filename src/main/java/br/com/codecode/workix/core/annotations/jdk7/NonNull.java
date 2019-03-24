package br.com.codecode.workix.core.annotations.jdk7;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * The Interface NonNull.
 */
@Documented
@Retention(SOURCE)
@Target(PARAMETER)
public @interface NonNull {
}
