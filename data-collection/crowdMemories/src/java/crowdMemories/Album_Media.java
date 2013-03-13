/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crowdMemories;

/**
 *
 * @author franz
 */
public class Album_Media implements java.io.Serializable {

   private String album_id;
   private String media_id;

    public Album_Media() {
    }

    public Album_Media(String album_id, String media_id) {
        this.album_id = album_id;
        this.media_id = media_id;
    }

    public String getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(String album_id) {
        this.album_id = album_id;
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }
}
