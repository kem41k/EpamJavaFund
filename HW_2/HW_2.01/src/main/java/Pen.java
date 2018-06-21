import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor(staticName = "createPen")
// We can use Lombok to generate equals() and hashCode(), but not this time =)
// @EqualsAndHashCode
public class Pen {
    public static enum Color {
        BLUE,
        BLACK,
        RED
    }

    public static enum Type {
        BALLPOINT,
        ROLLERBALL,
        FOUNTAIN,
        FELTTIP,
        GEL,
        STYLUS
    }

    private final String penProducer;
    private final Color penColor;
    private final Type penType;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Pen somePen = (Pen)obj;
        if (penProducer != somePen.penProducer)
            return false;
        if (penColor != somePen.penColor)
            return false;
        if (penType != somePen.penType)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        //return (int)(penProducer.hashCode() + penColor.hashCode() + penType.hashCode());
        final int PRIME = 31;
        int result = this.penProducer == null ? 0 : this.penProducer.hashCode();
        result += this.penType == null ? 0 : this.penType.hashCode();
        result += this.penColor == null ? 0 : this.penColor.hashCode();
        return result * PRIME;
    }

    @Override
    public String toString() {
        return getClass().getName() + " @ Producer: " + penProducer + ", color: " + penColor.toString() + ", type: " + penType.toString();
    }
}
