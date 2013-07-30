import models.User;

import org.junit.*;
import org.mindrot.jbcrypt.BCrypt;

import play.mvc.*;
import providers.MyLoginUsernamePasswordAuthUser;


import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;


/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class ApplicationTest {

    @Test 
    public void simpleCheck() {
        int a = 1 + 1;
        assertThat(a).isEqualTo(2);
    }
    
    @Test
    public void renderTemplate() {
        Content html = views.html.index.render();
        assertThat(contentType(html)).isEqualTo("text/html");
        assertThat(contentAsString(html)).contains("Your new application is ready.");
    }
    
    
    @Test
    public void testPasswords() {
    	MyLoginUsernamePasswordAuthUser authUser = new MyLoginUsernamePasswordAuthUser("testing-password","cdparra@gmail.com");
    	
    	// Hash a password for the first time
    	String hashed = BCrypt.hashpw(authUser.getPassword(), BCrypt.gensalt());
    	String hashed2 = authUser.getHashedPassword();
    	System.out.println("Bcrypt hash is: " + hashed);
    	System.out.println("authUser hash is: " + hashed);
    	assertThat(hashed == hashed2);
    	
    	// gensalt's log_rounds parameter determines the complexity
    	// the work factor is 2**log_rounds, and the default is 10
    	String hashed3 = BCrypt.hashpw(authUser.getHashedPassword(), BCrypt.gensalt(12));
    	System.out.println("Bcrypt complex hash is: " + hashed);
    	
    	// Check that an unencrypted password matches one that has
    	// previously been hashed
    	assertThat(BCrypt.checkpw("testing-password", hashed));    	
    	
//    	User u = User.findByUsernamePasswordIdentity(authUser);
    	
    	
    	
    }
}
