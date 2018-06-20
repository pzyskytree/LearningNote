package Advanced;
import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


public class FindFile {

	@Target(METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface FileTypes{
		FileType[] value();
	}
	
	@Target(METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	@Repeatable(FileTypes.class)
	public @interface FileType{
		String value();
	}
	
	@FileType(".java")
	@FileType(".html")
	@FileType(".css")
	@FileType(".js")
	public void work() {
		try {
			FileType[] filetypes = this.getClass().getMethod("work").getAnnotationsByType(FileType.class);
			System.out.println("Check Content from files with these suffix");
			for (FileType t : filetypes) {
				System.out.println(t.value());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new FindFile().work();
	}
}
