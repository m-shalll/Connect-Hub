
package Backend;

public class ContentFactory {
    public ContentCreation createContent(String c){
        if(c.equals("post")){
            return new Post();
        } else if(c.equals("story")){
            return new Story();
        }
        return null;
    }
}
