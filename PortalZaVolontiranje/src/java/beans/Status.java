
package beans;

import java.util.HashMap;
import java.util.Map;

public class Status {
    public static Map<Integer, String> statusi;
    static {
        statusi = new HashMap<>();
        statusi.put(1, "Zaposlen");
        statusi.put(2, "Nezaposlen");
        statusi.put(3, "Na Školovanju");
        statusi.put(4, "U penziji");
    }
}
