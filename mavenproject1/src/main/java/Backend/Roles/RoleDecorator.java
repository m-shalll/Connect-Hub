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
    public void execute(String action, Object data, Object data2) {
        wrappedRole.execute(action, data, data2);
    }
    @Override
    public void execute(String action, String data, Object data1, Object data2){
        wrappedRole.execute(action, data, data1, data2);
    }
    @Override
    public Role unWrap() {
        return wrappedRole;
    }
}

