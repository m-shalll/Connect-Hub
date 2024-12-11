package Backend.Roles;

public interface Role {
    public boolean canPerform(String action);
    void execute(String action, String data);
    void execute(String action, String data1, Object data2);
    public Role unWrap();
}
