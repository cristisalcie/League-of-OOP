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

public final class Woods extends AbstractTerrain {
    @Override
    public void affect(final Execute execute) {
        execute.setDmg(execute.getDmg() * Constants.KNIGHTONWOODSMODIFIER);
    }
    @Override
    public void affect(final Slam slam) {
        slam.setAoTRounds(Constants.SLAMAOTROUNDS);
        slam.setDmg(slam.getDmg() * Constants.KNIGHTONWOODSMODIFIER);
    }
    @Override
    public void affect(final Fireblast fireblast) {
        fireblast.setDmg(fireblast.getDmg() * Constants.PYROONWOODSMODIFIER);
    }
    @Override
    public void affect(final Ignite ignite) {
        ignite.setAoTRounds(Constants.IGNITEDOTROUNDS);
        ignite.setDmg(ignite.getDmg() * Constants.PYROONWOODSMODIFIER);
        ignite.setAoTDmg(ignite.getAoTDmg() * Constants.PYROONWOODSMODIFIER);
    }
    @Override
    public void affect(final Backstab backstab) {
        backstab.setDmg(backstab.getDmg() * Constants.ROGUEONWOODSMODIFIER);
        if (backstab.getStrikeCounter() % Constants.BACKSTABCRITICAL == 0) {
            backstab.setDmg(
                    backstab.getDmg() * Constants.BACKSTABCRITICALMODIF);
        }
    }
    @Override
    public void affect(final Paralysis paralysis) {
        paralysis.setAoTRounds(Constants.PARALYSISDOTROUNDSONWOODS);
        paralysis.setDmg(paralysis.getDmg() * Constants.ROGUEONWOODSMODIFIER);
        paralysis.setAoTDmg(
                paralysis.getAoTDmg() * Constants.ROGUEONWOODSMODIFIER);
    }
    @Override
    public void affect(final Drain drain) {
        drain.setDmg(drain.getDmg() * Constants.WIZARDONWOODSMODIFIER);
    }
    @Override
    public void affect(final Deflect deflect) {
        deflect.setDmg(deflect.getDmg() * Constants.WIZARDONWOODSMODIFIER);
    }
}
