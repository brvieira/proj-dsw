package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import controller.UsuarioController;

@WebServlet(name = "CadastrarUsuario", urlPatterns = {"/CadastrarUsuario"})
public class CadastrarUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String action = request.getParameter("action");
            if (action.equals("cadastrar")) {
                this.cadastrarUsuario(request, response);
            } else if (action.equals("atualizar")) {
                this.atualizarUsuario(request, response);
            } else if (action.equals("mudarsenha")) {
                this.atualizarSenhaUsuario(request, response);
            } else if (action.equals("autenticar")) {
                this.autenticar(request, response);
            }
        } finally {
            out.close();
        }
    }

    private void cadastrarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UsuarioController uc = new UsuarioController();
            Usuario u = new Usuario();

            u.setNome(request.getParameter("nome"));
            u.setCpf(request.getParameter("cpf"));
            u.setEmail(request.getParameter("email"));
            u.setProntuario(request.getParameter("prontuario"));
            u.setIsProfessor(Boolean.parseBoolean(request.getParameter("tipoUsuario")));
            u.setIsCoordenador(Boolean.parseBoolean(request.getParameter("isCoordenador")));
            u.setSenha(request.getParameter("senha"));

            uc.cadastrar(u);

            request.getSession().setAttribute("usuarioLogado", u);

            RequestDispatcher rd;

            if (u.getIsProfessor()) {
                rd = request.getRequestDispatcher("/dashboardProfessor.jsp");
            } else {
                rd = request.getRequestDispatcher("/dashboardAluno.jsp");
            }

            rd.forward(request, response);
        } catch (Exception e) {
            request.setAttribute("Erro", "Exception: " + e);
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }
    }

    private void atualizarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UsuarioController uc = new UsuarioController();
            Usuario u = new Usuario();
            
            u.setCodigo(Integer.parseInt(request.getParameter("codigo")));
            u.setNome(request.getParameter("nome"));
            u.setCpf(request.getParameter("cpf"));
            u.setEmail(request.getParameter("email"));
            u.setProntuario(request.getParameter("prontuario"));

            uc.alterar(u);

            request.getSession().setAttribute("usuarioLogado", u);
            
            RequestDispatcher rd;

            if (u.getIsProfessor()) {
                rd = request.getRequestDispatcher("/dashboardProfessor.jsp");
            } else {
                rd = request.getRequestDispatcher("/dashboardAluno.jsp");
            }

            rd.forward(request, response);
        } catch (Exception e) {
            request.setAttribute("Erro", "Exception: " + e);
            RequestDispatcher rd = request.getRequestDispatcher("/mensagemUsuarioAtualizado.jsp");
            rd.forward(request, response);
        }
    }

    private void atualizarSenhaUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UsuarioController uc = new UsuarioController();

            int codigo = Integer.valueOf(request.getParameter("codigo"));
            String senhaAnterior = request.getParameter("senhaAnterior");
            String senhaNova = request.getParameter("senha");

            Boolean senhaAlterada = uc.alterarSenha(codigo, senhaAnterior, senhaNova);
            
            RequestDispatcher rd;
            String urlDashboard;
               
            Usuario userLogado = (Usuario) request.getSession().getAttribute("usuarioLogado");
            
            if (userLogado.getIsProfessor())
                urlDashboard = "/dashboardProfessor.jsp";
            else
                urlDashboard = "/dashboardAluno.jsp";
            
            if (!senhaAlterada)
                request.setAttribute("Erro", "SenhaAntigaIncorreta");
            
            rd = request.getRequestDispatcher(urlDashboard);   
            rd.forward(request, response);
        } catch (Exception e) {
            request.setAttribute("Erro", "Exception: " + e);
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
            System.out.println(e);
        }
    }

    private void autenticar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UsuarioController uc = new UsuarioController();

            String prontuario = request.getParameter("prontuario");
            String senha = request.getParameter("senha");

            Usuario user = uc.autenticar(prontuario, senha);

            RequestDispatcher rd;
            String urlRedirect;
            
            if (user != null) {
                if (user.getSenha().equalsIgnoreCase(senha)) {
                    request.getSession().setAttribute("usuarioLogado", user);
                    if (user.getIsProfessor())
                        urlRedirect = "/dashboardProfessor.jsp";
                    else
                        urlRedirect = "/dashboardAluno.jsp";
                } else {
                    urlRedirect = "/index.jsp";
                    request.setAttribute("Erro", "SenhaIncorreta");
                }
            } else {
                urlRedirect = "/index.jsp";
                request.setAttribute("Erro", "UsuarioInexistente");
            }
            
            rd = request.getRequestDispatcher(urlRedirect);
            rd.forward(request, response);
        } catch (Exception e) {
            request.setAttribute("Erro", "Exception: " + e);
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
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
