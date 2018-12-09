package pl.sdacademy.ownannotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.TYPE}) //TYPE = KLASA
@Retention(RetentionPolicy.RUNTIME)
public @interface FirstAnnotation {
  String value() default ""; //value nie musi mieć nazwy adnotacji
  int length();
}
