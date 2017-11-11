import org.junit.Test;
import static org.junit.Assert.*;
import chat.dao.ConnectionFactory;
import chat.dao.model.Usuario;
import chat.dao.UsuarioDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UsuarioDaoTest {
     
    
    @Test
    public void testarBuscarAlunoPorId()  {	
        Usuario usuario = new Usuario();
        usuario.id=10;

        Usuario usuarioEncontrado = new Usuario();
        UsuarioDao dao = new UsuarioDao();
        usuarioEncontrado = dao.buscar(usuario);

        System.out.println("testarBuscarAlunoPorId:"+usuarioEncontrado.nome);
        assertEquals(usuarioEncontrado.isAluno, true);
        assertEquals(usuarioEncontrado.nome, "Aluno Padrao para Teste - nao deletar");
        
    }   
    
    @Test
    public void testarBuscarAlunoPorLogin()  {	
        Usuario usuario = new Usuario();
        usuario.login="alunopadrao";

        Usuario usuarioEncontrado = new Usuario();
        UsuarioDao dao = new UsuarioDao();
        usuarioEncontrado = dao.buscar(usuario);

        assertEquals(usuarioEncontrado.isAluno, true);
        assertEquals(usuarioEncontrado.nome, "Aluno Padrao para Teste - nao deletar");
    }   
    
    @Test
    public void testarBuscarTutor()  {	
        Usuario usuario = new Usuario();
        usuario.login="tutorpadrao";

        Usuario usuarioEncontrado = new Usuario();
        UsuarioDao dao = new UsuarioDao();
        usuarioEncontrado = dao.buscar(usuario);

        assertEquals(usuarioEncontrado.isTutor, true);
        assertEquals(usuarioEncontrado.nome, "Tutor Padrao para Teste - nao deletar");
    }        
}

