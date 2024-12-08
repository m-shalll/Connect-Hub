
package Backend;

public class Content{
    private String imageFilePath;
    private String caption;
    
    public Content(){
        
    }
    public Content(String image, String caption){
        this.imageFilePath = image;
        this.caption = caption;
    }
    public Content(String caption){
        this.caption = caption;
    }
    public String getImageFilePath() {
        return imageFilePath;
    }

    public void setImageFilePath(String imageFilePath) {
        this.imageFilePath = imageFilePath;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
