package Backend.Roles;

public abstract class RoleDecorator implements Role {
    protected final Role wrappedRole;

    public RoleDecorator(Role wrappedRole) {
        this.wrappedRole = wrappedRole;
    }

    @Override
    public boolean canPerform(String action) {
        return wrappedRole.canPerform(action);
    }

    @Override
    public void execute(String action, String data) {
        wrappedRole.execute(action, data);
    }
}

