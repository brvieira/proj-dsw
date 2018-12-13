package servlet;

import model.Defesa;
import model.Projeto;
import controller.DefesaController;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;

@WebServlet(name = "Defesa", urlPatterns = {"/Defesa"})
public class DefesaServlet extends HttpServlet {
    private final DefesaController controller = new DefesaController();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String action = request.getParameter("action");
            switch (action) {
                case "agendarDefesa":
                    this.agendarDefesa(request, response);
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

    private void agendarDefesa(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher rd;
        try {
            Defesa defesa = new Defesa();
            
            defesa.setPrimeiroMembro(request.getParameter("nomeavaliador1"));
            defesa.setSegundoMembro(request.getParameter("nomeavaliador2"));
            defesa.setHorario(request.getParameter("horario"));
            
            Projeto p = new Projeto();
            p.setCodigo(Integer.parseInt(request.getParameter("codigo")));
            defesa.setProjeto(p);
            
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            defesa.setDataMarcada(df.parse(request.getParameter("data")));
            
            this.controller.agendarDefesa(defesa);
            
            rd = request.getRequestDispatcher("/dashboardProfessor.jsp");
            rd.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Orientacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
