/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crowdMemories;

/**
 *
 * @author franz
 */
public class Album implements java.io.Serializable {

    private String album_id;
    private String album_description;
    private String album_title;

    public Album() {
    }

    public String getAlbum_title() {
        return album_title;
    }

    public void setAlbum_title(String album_title) {
        this.album_title = album_title;
    }

    public String getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(String album_id) {
        this.album_id = album_id;
    }

    public String getAlbum_description() {
        return album_description;
    }

    public void setAlbum_description(String album_description) {
        this.album_description = album_description;
    }
}
