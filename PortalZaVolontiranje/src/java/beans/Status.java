
package beans;

import java.util.HashMap;
import java.util.Map;

public class Status {
    public static Map<Integer, String> statusi;
    static {
        statusi = new HashMap<>();
        statusi.put(1, "zaposlen");
        statusi.put(2, "nezaposlen");
        statusi.put(3, "na skolovanju");
        statusi.put(4, "u penziji");
    }
}
