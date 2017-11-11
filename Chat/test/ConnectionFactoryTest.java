import org.junit.Test;
import static org.junit.Assert.*;
import chat.dao.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectionFactoryTest {
    
    @Test
    public void testarConexao()  {
	
        boolean conexaoValida;
        try {
            Connection con = new ConnectionFactory().getConnection();
            conexaoValida = con.isValid(0);
        } catch (SQLException ex) {
            conexaoValida=false;
        }

        assertEquals(conexaoValida, true);
    }    
    
}
