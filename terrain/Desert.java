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

public final class Desert extends AbstractTerrain {
    @Override
    public void affect(final Execute execute) {
        execute.setDmg(execute.getDmg() * Constants.KNIGHTONDESERTMODIFIER);
    }
    @Override
    public void affect(final Slam slam) {
        slam.setAoTRounds(Constants.SLAMAOTROUNDS);
        slam.setDmg(slam.getDmg() * Constants.KNIGHTONDESERTMODIFIER);
    }
    @Override
    public void affect(final Fireblast fireblast) {
        fireblast.setDmg(fireblast.getDmg() * Constants.PYROONDESERTMODIFIER);
    }
    @Override
    public void affect(final Ignite ignite) {
        ignite.setAoTRounds(Constants.IGNITEDOTROUNDS);
        ignite.setDmg(ignite.getDmg() * Constants.PYROONDESERTMODIFIER);
        ignite.setAoTDmg(ignite.getAoTDmg() * Constants.PYROONDESERTMODIFIER);
    }
    @Override
    public void affect(final Backstab backstab) {
        backstab.setStrikeCounter(0); // Reset it to 0 if he is not on woods.
        backstab.setDmg(backstab.getDmg() * Constants.ROGUEONDESERTMODIFIER);
    }
    @Override
    public void affect(final Paralysis paralysis) {
        paralysis.setAoTRounds(Constants.PARALYSISDOTROUNDS);
        paralysis.setDmg(paralysis.getDmg() * Constants.ROGUEONDESERTMODIFIER);
        paralysis.setAoTDmg(
                paralysis.getAoTDmg() * Constants.ROGUEONDESERTMODIFIER);
    }
    @Override
    public void affect(final Drain drain) {
        drain.setDmg(drain.getDmg() * Constants.WIZARDONDESERTMODIFIER);
    }
    @Override
    public void affect(final Deflect deflect) {
        deflect.setDmg(deflect.getDmg() * Constants.WIZARDONDESERTMODIFIER);
    }
}
