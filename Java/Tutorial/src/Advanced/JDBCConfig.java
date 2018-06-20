package Advanced;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({METHOD, TYPE})//Annotation's position: method and type(Interface, class)
@Retention(RetentionPolicy.RUNTIME) //Life Circle
@Inherited
@Documented
public @interface JDBCConfig {

	String ip();
	int port() default 3306;
	String database();
	String encoding();
	String user() default "root";
	String password();
}
