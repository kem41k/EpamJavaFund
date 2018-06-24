import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Mark<T extends Number> {
    @Getter private T mark;

    public Mark(T mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return mark.toString();
    }
}
