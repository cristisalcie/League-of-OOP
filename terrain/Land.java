package terrain;

import abilities.Execute;
import abilities.Slam;
import abilities.Fireblast;
import abilities.Ignite;
import abilities.Backstab;
import abilities.Paralysis;
import abilities.Drain;
import abilities.Deflect;
import common.Constants;

public final class Land extends AbstractTerrain {
    @Override
    public void affect(final Execute execute) {
        execute.setDmg(execute.getDmg() * Constants.KNIGHTONLANDMODIFIER);
    }
    @Override
    public void affect(final Slam slam) {
        slam.setAoTRounds(Constants.SLAMAOTROUNDS);
        slam.setDmg(slam.getDmg() * Constants.KNIGHTONLANDMODIFIER);
    }
    @Override
    public void affect(final Fireblast fireblast) {
        fireblast.setDmg(fireblast.getDmg() * Constants.PYROONLANDMODIFIER);
    }
    @Override
    public void affect(final Ignite ignite) {
        ignite.setAoTRounds(Constants.IGNITEDOTROUNDS);
        ignite.setDmg(ignite.getDmg() * Constants.PYROONLANDMODIFIER);
        ignite.setAoTDmg(ignite.getAoTDmg() * Constants.PYROONLANDMODIFIER);
    }
    @Override
    public void affect(final Backstab backstab) {
        backstab.setStrikeCounter(0); // Reset it to 0 if he is not on woods.
        backstab.setDmg(backstab.getDmg() * Constants.ROGUEONLANDMODIFIER);
    }
    @Override
    public void affect(final Paralysis paralysis) {
        paralysis.setAoTRounds(Constants.PARALYSISDOTROUNDS);
        paralysis.setDmg(paralysis.getDmg() * Constants.ROGUEONLANDMODIFIER);
        paralysis.setAoTDmg(
                paralysis.getAoTDmg() * Constants.ROGUEONLANDMODIFIER);
    }
    @Override
    public void affect(final Drain drain) {
        drain.setDmg(drain.getDmg() * Constants.WIZARDONLANDMODIFIER);
    }
    @Override
    public void affect(final Deflect deflect) {
        deflect.setDmg(deflect.getDmg() * Constants.WIZARDONLANDMODIFIER);
    }
}
