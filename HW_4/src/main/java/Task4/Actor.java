package Task4;

import lombok.Value;

import java.io.Serializable;
import java.util.Date;

@Value
public class Actor implements Serializable {
    String name;
    Date dateOfBirth;
    String country;
}
