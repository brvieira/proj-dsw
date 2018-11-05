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
            if (action.equals("cadastrar"))
                this.cadastrarUsuario(request, response); 
            else if (action.equals("atualizar"))
                this.atualizarUsuario(request, response);
            else if (action.equals("mudarsenha"))
                this.atualizarSenhaUsuario(request, response);
            /*else if(action.equals("remover"))
                this.removerProduto(request,response);
            else if(action.equals("visualizar"))
                this.visualizarProdutos(request, response);
            
            else if(action.equals("visualizarProduto"))
                this.visualizarProduto(request, response);*/
        }finally {
            out.close();
        }
    }
    
    private void cadastrarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UsuarioController uc = new UsuarioController();
            Usuario u = new Usuario();
            
            u.setNome(request.getParameter("nome"));
            u.setCpf(Integer.valueOf(request.getParameter("cpf").replace(".", "").replace("-", "")));
            u.setEmail(request.getParameter("email"));
            u.setProntuario(request.getParameter("prontuario"));
            u.setIsProfessor(Boolean.valueOf(request.getParameter("tipoUsuario")));
            u.setSenha(request.getParameter(request.getParameter("senha")));
            
            uc.cadastrar(u);
            
            request.setAttribute("usuario", u);
            request.setAttribute("sucesso", true);
            
            RequestDispatcher rd = request.getRequestDispatcher("/mensagemUsuarioCadastrado.jsp");
            
            rd.forward(request,response);
        } catch(Exception e) {
            request.setAttribute("sucesso", false);
            
            RequestDispatcher rd = request.getRequestDispatcher("/mensagemUsuarioCadastrado.jsp");
            
            rd.forward(request,response);
            
            System.out.println(e);
        }
    }
    
    private void atualizarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UsuarioController uc = new UsuarioController();
            Usuario u = new Usuario();
            
            u.setNome(request.getParameter("nome"));
            u.setCpf(Integer.valueOf(request.getParameter("cpf").replace(".", "").replace("-", "")));
            u.setEmail(request.getParameter("email"));
            u.setProntuario(request.getParameter("prontuario"));
            u.setIsProfessor(Boolean.valueOf(request.getParameter("tipoUsuario")));
            u.setSenha(request.getParameter(request.getParameter("senha")));
            
            uc.alterar(u);
            
            request.setAttribute("usuario", u);
            request.setAttribute("sucesso", true);
            
            RequestDispatcher rd = request.getRequestDispatcher("/mensagemUsuarioAtualizado.jsp");
            
            rd.forward(request,response);
        } catch(Exception e) {
            request.setAttribute("sucesso", false);
            
            RequestDispatcher rd = request.getRequestDispatcher("/mensagemUsuarioAtualizado.jsp");
            
            rd.forward(request,response);
            
            System.out.println(e);
        }
    }
    
    private void atualizarSenhaUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UsuarioController uc = new UsuarioController();
            
            int codigo = Integer.valueOf(request.getParameter("codigo"));
            String senhaAnterior = request.getParameter("senhaAnterior");
            String senhaNova = request.getParameter("senha");
            
            Boolean senhaAlterada = uc.alterarSenha(codigo, senhaAnterior, senhaNova);
            
            request.setAttribute("sucesso", senhaAlterada);
            
            RequestDispatcher rd = request.getRequestDispatcher("/mensagemUsuarioSenhaAtualizada.jsp");
            
            rd.forward(request,response);
        } catch(Exception e) {
            request.setAttribute("sucesso", false);
            
            RequestDispatcher rd = request.getRequestDispatcher("/mensagemUsuarioSenhaAtualizada.jsp");
            
            rd.forward(request,response);
            
            System.out.println(e);
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
