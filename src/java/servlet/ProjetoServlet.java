package servlet;

import model.Projeto;
import controller.ProjetoController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;

@WebServlet(name = "Projeto", urlPatterns = {"/Projeto"})
public class ProjetoServlet extends HttpServlet {
    private final ProjetoController controller = new ProjetoController();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String action = request.getParameter("action");
            switch (action) {
                case "criarProjeto":
                    this.criarProjeto(request, response);
                    break;
                case "enviarProjeto":
                    this.enviarProjeto(request, response);
                    break;
                case "cancelarEnvio":
                    this.cancelarEnvio(request, response);
                    break;
                case "aprovarEnvio":
                    this.aprovarEnvio(request, response);
                    break;
                case "confirmarRecebimento":
                    this.confirmarRecebimento(request, response);
                    break;
                case "informarParecer":
                    this.informarParecer(request, response);
                    break;
                default:
                    break;
            }
        } finally {
            out.close();
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

    private void criarProjeto(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher rd;
        try {
            Projeto prj = new Projeto();
            
            prj.setNome(request.getParameter("titulo"));
            prj.setAluno((Usuario) request.getSession().getAttribute("usuarioLogado"));
            
            this.controller.criarProjeto(prj);
            
            rd = request.getRequestDispatcher("/dashboardAluno.jsp");
            rd.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Orientacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void enviarProjeto(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher rd;
        try {
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            
            this.controller.enviarProjeto(codigo);
            
            rd = request.getRequestDispatcher("/dashboardAluno.jsp");
            rd.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Orientacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void informarParecer(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher rd;
        try {
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            String textoParecer = request.getParameter("textoParecer");
            
            this.controller.informarParecer(codigo, textoParecer);
            
            rd = request.getRequestDispatcher("/dashboardCoordenador.jsp");
            rd.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Orientacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void aprovarEnvio(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher rd;
        try {
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            
            this.controller.aprovarEnvio(codigo);
            
            rd = request.getRequestDispatcher("/dashboardProfessor.jsp");
            rd.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Orientacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void confirmarRecebimento(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher rd;
        try {
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            
            this.controller.confirmarRecebimento(codigo);
            
            rd = request.getRequestDispatcher("/dashboardCoordenador.jsp");
            rd.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Orientacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void cancelarEnvio(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher rd;
        try {
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            
            this.controller.cancelarEnvio(codigo);
            
            rd = request.getRequestDispatcher("/dashboardProfessor.jsp");
            rd.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Orientacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
