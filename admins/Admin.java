package admins;

import angels.AbstractAngel;
import heroes.AbstractHero;

public interface Admin {
    void checkAngel(AbstractAngel angel);
    void checkHero(AbstractHero hero);
}
