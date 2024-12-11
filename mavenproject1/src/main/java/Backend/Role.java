package Backend;

public interface Role {
    public boolean canPerform(String action);
    void execute(String action, String data);
}
