import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
@interface ClassPreamble {
    String author();
    String date();
    int currentRevision();
    String lastModyfied();
}

public class Annotations {
}
