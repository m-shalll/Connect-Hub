package Backend.Roles;

public interface Role {
    public boolean canPerform(String action);
    public void execute(String action, String data, Object data1, Object data2);
    public void execute(String action, Object data, Object data2);
    public Role unWrap();
}
