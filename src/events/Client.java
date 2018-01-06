package events;

import java.util.HashSet;
import java.util.Set;

public class Client {

    private Set<String> promoCodes = new HashSet<>();

    public void addPromoCode(String code) {
        promoCodes.add(code);
    }

    public boolean hasPromoCode() {
        return promoCodes.size() > 0;
    }
}
