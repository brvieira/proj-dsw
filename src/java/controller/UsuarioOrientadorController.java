package controller;
        
import infra.dao.UsuarioOrientadorDAO;
import model.Usuario;
import model.UsuarioOrientador;
import java.util.*;

public class UsuarioOrientadorController {

    private final UsuarioOrientadorDAO dao = new UsuarioOrientadorDAO();

    public UsuarioOrientadorController() {}
    
    public ArrayList<Usuario> obterAlunosSemOrientacao() throws Exception  {
        return dao.obterAlunosSemOrientacao();
    }
    
    public ArrayList<UsuarioOrientador> obterAlunosOrientados() throws Exception  {
        return dao.obterAlunosOrientados();
    }
}