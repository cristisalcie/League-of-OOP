package terrain;

import abilities.Deflect;
import abilities.Drain;
import abilities.Execute;
import abilities.Slam;
import abilities.Ignite;
import abilities.Fireblast;
import abilities.Backstab;
import abilities.Paralysis;

public abstract class AbstractTerrain {
    public abstract void affect(Execute execute);
    public abstract void affect(Slam slam);
    public abstract void affect(Drain drain);
    public abstract void affect(Deflect deflect);
    public abstract void affect(Fireblast fireblast);
    public abstract void affect(Ignite ignite);
    public abstract void affect(Backstab backstab);
    public abstract void affect(Paralysis paralysis);
}
