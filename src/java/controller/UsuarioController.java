package controller;
        
import infra.dao.UsuarioDAO;
import model.Usuario;
import java.util.*;

public class UsuarioController {

    private final UsuarioDAO dao = new UsuarioDAO();

    public UsuarioController() {}

    public void cadastrar(Usuario u) throws Exception { 
        dao.inserir(u);
    }

    public void alterar(Usuario u) throws Exception { 
        dao.alterar(u);
    }
    
    public boolean alterarSenha(int codigo, String senhaAnterior, String senhaNova) throws Exception  { 
        if (dao.obterUsuario(codigo).getSenha().equals(senhaAnterior)){
            dao.alterarSenha(codigo, senhaNova);
            return true;
        }else
            return false;
    }
    
    public Usuario autenticar(String prontuario, String senha) throws Exception  { 
        return dao.obterUsuarioByProntuario(prontuario, senha);
    }
    
    public ArrayList<Usuario> obterUsuarios() throws Exception  {
        return dao.obterTodos();
    }

    public Usuario obterUsuario(int codigo) throws Exception  {
        return dao.obterUsuario(codigo);
    }
    
    public void removerProduto(int codigo) throws Exception  {
        dao.remover(codigo);
    }
    
    public void alterarCoordenador(int oldCodigo, int newCodigo) throws Exception {
        dao.alterarCoordenador(oldCodigo, newCodigo);
    }
    
    public ArrayList<Usuario> obterProfessores() throws Exception  {
        return dao.obterProfessores();
    }
}