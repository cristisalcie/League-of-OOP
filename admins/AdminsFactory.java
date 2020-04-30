package admins;

public final class AdminsFactory {

    private static AdminsFactory adminsFactory = null;

    private AdminsFactory() {
        // It's singleton.
    }

    public static AdminsFactory getInstance() {
        if (adminsFactory == null) {
            adminsFactory = new AdminsFactory();
        }
        return adminsFactory;
    }

    public Admin getAdmin(final AdminType type) {
        if (type == null) {
            return null;
        }
        if (type.equals(AdminType.TheGreatMagician)) {
            return TheGreatMagician.getInstance();
        }
        return null;
    }
}
