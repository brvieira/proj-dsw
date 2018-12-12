package controller;

import infra.dao.ProjetoDAO;
import java.util.ArrayList;
import model.Projeto;

public class ProjetoController {
    private final ProjetoDAO dao = new ProjetoDAO();

    public ProjetoController() {}

    public void criarProjeto(Projeto prj) throws Exception { 
        dao.inserir(prj);
    }
    
    public void enviarProjeto(int codigo) throws Exception { 
        dao.enviarProjeto(codigo);
    }
    
    public void informarParecer(int codigo, String textoParecer) throws Exception { 
        dao.informarParecer(codigo, textoParecer);
    }
    
    public String obterParecer(int codigo) throws Exception { 
        return dao.obterParecer(codigo);
    }
    
    public void cancelarEnvio(int codigo) throws Exception { 
        dao.cancelarEnvio(codigo);
    }
    
    public void aprovarEnvio(int codigo) throws Exception { 
        dao.aprovarEnvio(codigo);
    }

    public void confirmarVersaoFinal(int codigo) throws Exception { 
        dao.confirmarVersaoFinal(codigo);
    }
    
    public void confirmarRecebimento(int codigo) throws Exception { 
        dao.confirmarRecebimento(codigo);
    }
    
    public void enviarVersaoFinal(int codigo) throws Exception { 
        dao.enviarVersaoFinal(codigo);
    }
    
    public ArrayList<Projeto> obterProjetos() throws Exception  {
        return dao.obterProjetos();
    }
    
    public ArrayList<Projeto> obterProjetosPendentesColegiado() throws Exception  {
        return dao.obterProjetosPendentesColegiado();
    }

    public ArrayList<Projeto> obterProjetosFinalizados() throws Exception  {
        return dao.obterProjetosFinalizados();
    }

    public ArrayList<Projeto> obterProjetosByUsuarioID(int codigo) throws Exception {
        return dao.obterProjetosbyUsuarioID(codigo);
    }
}