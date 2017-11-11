package chat.controller;

import chat.dao.UsuarioDao;
import chat.dao.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rodrigo
 */
@WebServlet(name = "UsuarioLogarServlet", urlPatterns = {"/UsuarioLogar"})
public class UsuarioLogarServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println( "Character Encoding: " + request.getCharacterEncoding() );
        request.setCharacterEncoding("UTF-8");
        System.out.println( "Character Encoding: " + request.getCharacterEncoding() );
        
        try (PrintWriter out = response.getWriter()) {
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            
            Usuario usuario = new Usuario();
            usuario.login=login;

            UsuarioDao dao = new UsuarioDao();
            Usuario usuarioEncontrado = new Usuario();
            usuarioEncontrado = dao.buscar(usuario);
            
            if (usuarioEncontrado.isTutor && usuarioEncontrado.senha.equals(senha) ){
                out.println("<h1> Redirecionar tutor</h1>");
                RequestDispatcher r = request.getRequestDispatcher( "indexTutor.jsp" );
                r.forward( request, response );
            }else if (usuarioEncontrado.isAluno && usuarioEncontrado.senha.equals(senha)){
              //  out.println("<h1> Redirecionar aluno</h1>");
                
                HttpSession sessao = request.getSession();
		if(sessao.isNew()== false ){
                    sessao.invalidate();
                    sessao = request.getSession(true);
		}
		if(sessao.isNew()){
                    sessao.setAttribute("idUsuario", usuarioEncontrado.id);
		}
		
                RequestDispatcher r = request.getRequestDispatcher( "indexAluno.jsp" );
                r.forward( request, response );               
               // return;
            }else {
                out.println("<h1> Dados inválidos!</h1>");
            }
             

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
