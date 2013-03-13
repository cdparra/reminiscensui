/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crowdMemories;

/**
 *
 * @author franz
 */
public class Test {

    public static void main(String[] a) {
        NewHibernateUtil hb = new NewHibernateUtil();

        Media m = new Media();
        m.setSource("crowd");
        m.setSource_url("http://www.catinabib.it/files/TIC511-1940.jpg");
        m.setUrl("http://www.catinabib.it/files/TIC511-1940.jpg");
        m.setTitle("Trento via belenzani");
        m.setType("photo");

        Integer media_id = (Integer) hb.addMedia(m);
        System.out.println("media_id: " + media_id);

        
        Album_Media am;
        am = (Album_Media) hb.addAlbum_Media("1234", media_id.toString());
        System.out.println("album_id: " + am.getAlbum_id() + " media_id: " + am.getMedia_id());

        am = (Album_Media) hb.addAlbum_Media("ciao", media_id.toString());
        System.out.println("album_id: " + am.getAlbum_id() + " media_id: " + am.getMedia_id());
    }
}
