package controller;
        
import infra.dao.UsuarioDAO;
import model.Usuario;
import java.util.*;

public class UsuarioController {

    private UsuarioDAO dao = new UsuarioDAO();

    public UsuarioController() {
    }

    public void cadastrar(Usuario u) throws Exception { 
        dao.inserir(u);
    }

    public void alterar(Usuario u) throws Exception  { 
        dao.alterar(u);
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
}