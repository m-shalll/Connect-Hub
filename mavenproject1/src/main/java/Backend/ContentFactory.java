
package Backend;

public class ContentFactory {
    public static ContentCreation createContent(String c) {
        if (c.equals("post")) {
            return new Post();
        } else if (c.equals("story")) {
            return new Story();
        }
        return null;
    }
}
