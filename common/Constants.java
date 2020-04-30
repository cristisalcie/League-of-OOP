package common;

public final class Constants {

    private Constants() {

    }

    public static final float FLOATERROR = 0.0001f;


    public static final int MAPDIMENSION = 2;
    public static final int DATAENTITY = MAPDIMENSION + 1;
    public static final int INDEXPOSX = 1;
    public static final int INDEXPOSY = 2;

    /* For xp and lvl up formula. */
    public static final int XPCONST1 = 250;
    public static final int XPCONST2 = 200;
    public static final int XPCONST3 = 50;
    public static final int XPCONST4 = 40;


    public static final float KNIGHTONLANDMODIFIER = 1.15f;
    public static final float KNIGHTONVOLCANICMODIFIER = 1.0f;
    public static final float KNIGHTONDESERTMODIFIER = 1.0f;
    public static final float KNIGHTONWOODSMODIFIER = 1.0f;

    public static final float PYROONLANDMODIFIER = 1.0f;
    public static final float PYROONVOLCANICMODIFIER = 1.25f;
    public static final float PYROONDESERTMODIFIER = 1.0f;
    public static final float PYROONWOODSMODIFIER = 1.0f;

    public static final float ROGUEONLANDMODIFIER = 1.0f;
    public static final float ROGUEONVOLCANICMODIFIER = 1.0f;
    public static final float ROGUEONDESERTMODIFIER = 1.0f;
    public static final float ROGUEONWOODSMODIFIER = 1.15f;

    public static final float WIZARDONLANDMODIFIER = 1.0f;
    public static final float WIZARDONVOLCANICMODIFIER = 1.0f;
    public static final float WIZARDONDESERTMODIFIER = 1.1f;
    public static final float WIZARDONWOODSMODIFIER = 1.0f;

    public static final int KNIGHTHP = 900;
    public static final int EXTRAKNIGHTHPLVL = 80;

    public static final int EXECUTEDMG = 200;
    public static final int EXTRAEXECUTEDMGLVL = 30;
    public static final float EXECUTELIMIT = 0.2f;
    public static final float EXTRAEXECUTELIMITLVL = 0.01f;
    public static final float MAXEXECUTELIMIT = 0.4f;

    public static final float EXECUTEVSKNIGHTMODIF = 1.0f;
    public static final float EXECUTEVSPYROMANCERMODIF = 1.1f;
    public static final float EXECUTEVSROGUEMODIF = 1.15f;
    public static final float EXECUTEVSWIZARDMODIF = 0.8f;

    public static final int SLAMDMG = 100;
    public static final int EXTRASLAMDMGLVL = 40;
    public static final int SLAMAOTROUNDS = 1;

    public static final float SLAMVSKNIGHTMODIF = 1.2f;
    public static final float SLAMVSPYROMANCERMODIF = 0.9f;
    public static final float SLAMVSROGUEMODIF = 0.8f;
    public static final float SLAMVSWIZARDMODIF = 1.05f;


    public static final int PYROMANCERHP = 500;
    public static final int EXTRAPYROMANCERHPLVL = 50;

    public static final int FIREBLASTDMG = 350;
    public static final int EXTRAFIREBLASTDMGLVL = 50;

    public static final float FIREBLASTVSKNIGHTMODIF = 1.2f;
    public static final float FIREBLASTVSPYROMANCERMODIF = 0.9f;
    public static final float FIREBLASTVSROGUEMODIF = 0.8f;
    public static final float FIREBLASTVSWIZARDMODIF = 1.05f;

    public static final int IGNITEDMG = 150;
    public static final int EXTRAIGNITEDMGLVL = 20;
    public static final int IGNITEDOT = 50;
    public static final int EXTRAIGNITEDOTLVL = 30;
    public static final int IGNITEDOTROUNDS = 2;

    public static final float IGNITEVSKNIGHTMODIF = 1.2f;
    public static final float IGNITEVSPYROMANCERMODIF = 0.9f;
    public static final float IGNITEVSROGUEMODIF = 0.8f;
    public static final float IGNITEVSWIZARDMODIF = 1.05f;


    public static final int ROGUEHP = 600;
    public static final int EXTRAROGUEHPLVL = 40;

    public static final int BACKSTABDMG = 200;
    public static final int EXTRABACKSTABDMGLVL = 20;
    /**
     * BACKSTABCRITICAL - from when to when he critics (from 3 to 3 strikes).
     */
    public static final int BACKSTABCRITICAL = 3;
    public static final float BACKSTABCRITICALMODIF = 1.5f;

    public static final float BACKSTABVSKNIGHTMODIF = 0.9f;
    public static final float BACKSTABVSPYROMANCERMODIF = 1.25f;
    public static final float BACKSTABVSROGUEMODIF = 1.2f;
    public static final float BACKSTABVSWIZARDMODIF = 1.25f;

    public static final int PARALYSISDMG = 40;
    public static final int EXTRAPARALYSISDMGLVL = 10;
    public static final int PARALYSISDOT = 40;
    public static final int EXTRAPARALYSISDOTLVL = 10;
    public static final int PARALYSISDOTROUNDS = 3;
    public static final int PARALYSISDOTROUNDSONWOODS = 6;

    public static final float PARALYSISVSKNIGHTMODIF = 0.8f;
    public static final float PARALYSISVSPYROMANCERMODIF = 1.2f;
    public static final float PARALYSISVSROGUEMODIF = 0.9f;
    public static final float PARALYSISVSWIZARDMODIF = 1.25f;


    public static final int WIZARDHP = 400;
    public static final int EXTRAWIZARDHPLVL = 30;

    public static final float DRAINPERCENTAGE = 0.2f;
    public static final float EXTRADRAINPERCENTAGELVL = 0.05f;
    public static final float DRAINVSKNIGHTMODIF = 1.2f;

    public static final float DRAINVSPYROMANCERMODIF = 0.9f;
    public static final float DRAINVSROGUEMODIF = 0.8f;
    public static final float DRAINVSWIZARDMODIF = 1.05f;
    public static final float DRAINBASEHPFORMULAMODIF = 0.3f;

    public static final float DEFLECTPERCENTAGE = 0.35f;
    public static final float EXTRADEFLECTPERCENTAGELVL = 0.02f;
    public static final float MAXDEFLECTPERCENTAGE = 0.7f;

    public static final float DEFLECTVSKNIGHTMODIF = 1.4f;
    public static final float DEFLECTVSPYROMANCERMODIF = 1.3f;
    public static final float DEFLECTVSROGUEMODIF = 1.2f;
    public static final float DEFLECTVSWIZARDMODIF = 0f;


    public static final float DAMAGEANGELONKNIGHTDMGMODIF = 0.15f;
    public static final float DAMAGEANGELONPYROMANCERDMGMODIF = 0.2f;
    public static final float DAMAGEANGELONROGUEDMGMODIF = 0.3f;
    public static final float DAMAGEANGELONWIZARDDMGMODIF = 0.4f;


    public static final int DARKANGELONKNIGHTHP = 40;
    public static final int DARKANGELONPYROMANCERHP = 30;
    public static final int DARKANGELONROGUEHP = 10;
    public static final int DARKANGELONWIZARDHP = 20;


    public static final float DRACULAONKNIGHTDMGMODIF = 0.2f;
    public static final float DRACULAONPYROMANCERDMGMODIF = 0.3f;
    public static final float DRACULAONROGUEDMGMODIF = 0.1f;
    public static final float DRACULAONWIZARDDMGMODIF = 0.4f;

    public static final int DRACULAONKNIGHTHP = 60;
    public static final int DRACULAONPYROMANCERHP = 40;
    public static final int DRACULAONROGUEHP = 35;
    public static final int DRACULAONWIZARDHP = 20;


    public static final float GOODBOYONKNIGHTDMGMODIF = 0.4f;
    public static final float GOODBOYONPYROMANCERDMGMODIF = 0.5f;
    public static final float GOODBOYONROGUEDMGMODIF = 0.4f;
    public static final float GOODBOYONWIZARDDMGMODIF = 0.3f;

    public static final int GOODBOYONKNIGHTHP = 20;
    public static final int GOODBOYONPYROMANCERHP = 30;
    public static final int GOODBOYONROGUEHP = 40;
    public static final int GOODBOYONWIZARDHP = 50;


    public static final float LEVELUPANGELONKNIGHTDMGMODIF = 0.1f;
    public static final float LEVELUPANGELONPYROMANCERDMGMODIF = 0.2f;
    public static final float LEVELUPANGELONROGUEDMGMODIF = 0.15f;
    public static final float LEVELUPANGELONWIZARDDMGMODIF = 0.25f;


    public static final int LIFEGIVERONKNIGHTHP = 100;
    public static final int LIFEGIVERONPYROMANCERHP = 80;
    public static final int LIFEGIVERONROGUEHP = 90;
    public static final int LIFEGIVERONWIZARDHP = 120;


    public static final float SMALLANGELONKNIGHTDMGMODIF = 0.1f;
    public static final float SMALLANGELONPYROMANCERDMGMODIF = 0.15f;
    public static final float SMALLANGELONROGUEDMGMODIF = 0.05f;
    public static final float SMALLANGELONWIZARDDMGMODIF = 0.1f;

    public static final int SMALLANGELONKNIGHTHP = 10;
    public static final int SMALLANGELONPYROMANCERHP = 15;
    public static final int SMALLANGELONROGUEHP = 20;
    public static final int SMALLANGELONWIZARDHP = 25;


    public static final int SPAWNERONKNIGHTHP = 200;
    public static final int SPAWNERONPYROMANCERHP = 150;
    public static final int SPAWNERONROGUEHP = 180;
    public static final int SPAWNERONWIZARDHP = 120;


    public static final int XPANGELONKNIGHTBONUS = 45;
    public static final int XPANGELONPYROMANCERBONUS = 50;
    public static final int XPANGELONROGUEBONUS = 40;
    public static final int XPANGELONWIZARDBONUS = 60;


    public static final int KNIGHTOFFENSIVEMINNUMMODIF = 1;
    public static final int KNIGHTOFFENSIVEMINDENOMMODIF = 3;

    public static final int KNIGHTOFFENSIVEMAXNUMMODIF = 1;
    public static final int KNIGHTOFFENSIVEMAXDENOMMODIF = 2;

    public static final int KNIGHTOFFENSIVEHPNUMMODIF = 1;
    public static final int KNIGHTOFFENSIVEHPDENOMMODIF = 5;

    public static final float KNIGHTOFFENSIVEDMGMODIF = 0.5f;


    public static final int KNIGHTDEFENSIVENUMMODIF = 1;
    public static final int KNIGHTDEFENSIVEDENOMMODIF = 3;

    public static final float KNIGHTDEFENSIVEDMGMODIF = 0.2f;

    public static final int KNIGHTDEFENSIVEHPNUMMODIF = 1;
    public static final int KNIGHTDEFENSIVEHPDENOMMODIF = 4;


    public static final int PYROOFFENSIVEMINNUMMODIF = 1;
    public static final int PYROOFFENSIVEMINDENOMMODIF = 4;

    public static final int PYROOFFENSIVEMAXNUMMODIF = 1;
    public static final int PYROOFFENSIVEMAXDENOMMODIF = 3;

    public static final int PYROOFFENSIVEHPNUMMODIF = 1;
    public static final int PYROOFFENSIVEHPDENOMMODIF = 4;

    public static final float PYROOFFENSIVEDMGMODIF = 0.7f;


    public static final int PYRODEFENSIVENUMMODIF = 1;
    public static final int PYRODEFENSIVEDENOMMODIF = 4;

    public static final float PYRODEFENSIVEDMGMODIF = 0.3f;

    public static final int PYRODEFENSIVEHPNUMMODIF = 1;
    public static final int PYRODEFENSIVEHPDENOMMODIF = 3;


    public static final int ROGUEOFFENSIVEMINNUMMODIF = 1;
    public static final int ROGUEOFFENSIVEMINDENOMMODIF = 7;

    public static final int ROGUEOFFENSIVEMAXNUMMODIF = 1;
    public static final int ROGUEOFFENSIVEMAXDENOMMODIF = 5;

    public static final int ROGUEOFFENSIVEHPNUMMODIF = 1;
    public static final int ROGUEOFFENSIVEHPDENOMMODIF = 7;

    public static final float ROGUEOFFENSIVEDMGMODIF = 0.4f;


    public static final int ROGUEDEFENSIVENUMMODIF = 1;
    public static final int ROGUEDEFENSIVEDENOMMODIF = 7;

    public static final float ROGUEDEFENSIVEDMGMODIF = 0.1f;

    public static final int ROGUEDEFENSIVEHPNUMMODIF = 1;
    public static final int ROGUEDEFENSIVEHPDENOMMODIF = 2;


    public static final int WIZARDOFFENSIVEMINNUMMODIF = 1;
    public static final int WIZARDOFFENSIVEMINDENOMMODIF = 4;

    public static final int WIZARDOFFENSIVEMAXNUMMODIF = 1;
    public static final int WIZARDOFFENSIVEMAXDENOMMODIF = 2;

    public static final int WIZARDOFFENSIVEHPNUMMODIF = 1;
    public static final int WIZARDOFFENSIVEHPDENOMMODIF = 10;

    public static final float WIZARDOFFENSIVEDMGMODIF = 0.6f;


    public static final int WIZARDDEFENSIVENUMMODIF = 1;
    public static final int WIZARDDEFENSIVEDENOMMODIF = 4;

    public static final float WIZARDDEFENSIVEDMGMODIF = 0.2f;

    public static final int WIZARDDEFENSIVEHPNUMMODIF = 1;
    public static final int WIZARDDEFENSIVEHPDENOMMODIF = 5;
}
