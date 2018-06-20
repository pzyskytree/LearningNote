package Advanced;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

public class Annotation {

	@SuppressWarnings({ "unused", "rawtypes" })
	public static void main(String[] args) {
		//@Override
		//@Deprecated
		hackMap();
		//@SuppressWarnings :Ignore Warning
		List heros = new ArrayList();
		//@SageVarargs : For changable number parameter methods (Static or Final)
		//@FunctionalInterface
		//Only one abstract Method in Interface not for default method
		
		//Self Define Annotation
		//@interface
		
		//MetaAnnotation : Annotation for self-defined annotation
		//Metadata is data [information] that provides information about other data
		//1. @Target({METHOD, TYPE})
		//Annotation's position: method and type(Interface, class)
//		ElementType.TYPE：能修饰类、接口或枚举类型
//		ElementType.FIELD：能修饰成员变量
//		ElementType.METHOD：能修饰方法
//		ElementType.PARAMETER：能修饰参数
//		ElementType.CONSTRUCTOR：能修饰构造器
//		ElementType.LOCAL_VARIABLE：能修饰局部变量
//		ElementType.ANNOTATION_TYPE：能修饰注解
//		ElementType.PACKAGE：能修饰包
		//2.@Retention(RetentionPolicy.RUNTIME) 
		//Life Circle
//		RetentionPolicy.SOURCE： 注解只在源代码中存在，编译成class之后，就没了。@Override 就是这种注解。
//		RetentionPolicy.CLASS： 注解在java文件编程成.class文件后，依然存在，但是运行起来后就没了。@Retention的默认值，即当没有显式指定@Retention的时候，就会是这种类型。
//		RetentionPolicy.RUNTIME： 注解在运行起来之后依然存在，程序可以通过反射获取这些信息，自定义注解@JDBCConfig 就是这样
		//3. @Inherited
		//4. @Documented API file has instruction for annotation
		//5. @Repeatable
	}	
	
	@Override
	public String toString() {
		return "Annotation";
	}
	
	//It is not inherited method
//	@Override
//	public String fromString() {
//		return "Annotation";
//	}
	
	@Deprecated
	public static void hackMap() {
		System.out.println("Use deprecated Method");
	}
	
	@SafeVarargs
	public static<T> T getFirstOne(T...elements) {
		return elements.length > 0 ? elements[0] : null;
	}
}

