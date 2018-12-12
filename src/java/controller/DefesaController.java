package controller;

import infra.dao.DefesaDAO;
import java.util.ArrayList;
import model.Defesa;

public class DefesaController {
    private final DefesaDAO dao = new DefesaDAO();

    public DefesaController() {}
    
    public void agendarDefesa(Defesa def) throws Exception {
        dao.agendarDefesa(def);
    }
    
    public void confirmarAgendamento(int codigo, boolean isCoordenador) throws Exception { 
        dao.confirmarAgendamento(codigo, isCoordenador);
    }
    
    public void definirMembrosBanca(int codigo, int primeiroMembroID, int segundoMembroID) throws Exception {
        //dao.definirMembrosBanca(codigo, primeiroMembroID, segundoMembroID);
    }
    
    public void lancarResultado(int codigo, String resultadoDefesa, String parecerBanca, String consideracoesBanca) throws Exception {
        dao.lancarResultado(codigo, resultadoDefesa, parecerBanca, consideracoesBanca);
    }
    
    public ArrayList<Defesa> obterAgendamentosConfirmados() throws Exception {
        return dao.obterAgendamentosConfirmados();
    }
}