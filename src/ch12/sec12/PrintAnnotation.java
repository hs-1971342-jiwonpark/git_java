package ch12.sec12;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

public class PrintAnnotation {

	@Target({ ElementType.METHOD })
	@Retention(RetentionPolicy.RUNTIME)
	public @interface PrintAnnotations {
		String value() default "-";

		int number() default 15;
	}
}
