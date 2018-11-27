package controller;

import infra.dao.ProjetoDAO;
import java.util.ArrayList;
import model.Projeto;

public class ProjetoController {
    private final ProjetoDAO dao = new ProjetoDAO();

    public ProjetoController() {}

    public void cadastrar(Projeto prj) throws Exception { 
        dao.inserir(prj);
    }
    
    public ArrayList<Projeto> obterProjetos() throws Exception  {
        return dao.obterProjetos();
    }
}