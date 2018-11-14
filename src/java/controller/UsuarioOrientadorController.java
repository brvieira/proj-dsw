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
    
    public void enviarSolicitacao(int usuarioID, int convidadoID, boolean conviteProfessor) throws Exception {
        dao.enviarSolicitacao(usuarioID, convidadoID, conviteProfessor);
    }
    
    public Usuario obterOrientador(int alunoId) throws Exception {
        return dao.obterOrientador(alunoId);
    }
    
    public ArrayList convitesEnviadosByAluno(int alunoID) throws Exception {
        if(obterOrientador(alunoID) == null) {
            return dao.convitesEnviadosByAluno(alunoID);
        }
        else {
            return null;
        }
    }
    
    public ArrayList convitesRecebidosByAluno(int alunoID) throws Exception {
        if(obterOrientador(alunoID) == null) {
            return dao.convitesRecebidosByAluno(alunoID);
        }
        else {
            return null;
        }
    }
    
    public ArrayList convitesEnviadosByProfessor(int professorID) throws Exception {
        return dao.convitesEnviadosByProfessor(professorID);
    }
    
    public ArrayList convitesRecebidosByProfessor(int professorID) throws Exception {
        return dao.convitesRecebidosByProfessor(professorID);
    }
    
    public void cancelarConvite(int usuarioID, int orientadorID, boolean conviteProfessor) throws Exception {
        dao.cancelarConvite(usuarioID, orientadorID, conviteProfessor);
    }
    
    public void aceitarConvite(int usuarioID, int orientadorID) throws Exception {
        dao.aceitarOrientacao(usuarioID, orientadorID);
    }
    
    public ArrayList obterOrientandosByProfessor(int professorID) throws Exception {
        return dao.obterOrientandosByProfessor(professorID);
    }
    
}