package infra.dao;

import infra.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Defesa;

public class DefesaDAO {
    
    public DefesaDAO() {}
    
    Connection con = ConnectionFactory.obterConexao();
    
    public void agendarDefesa(Defesa def) throws Exception {
        try {
            PreparedStatement stm = con.prepareStatement("INSERT INTO agendamentoDefesa(dataMarcada, primeiroMembroID, segundoMembroID, projetoID) VALUES(?,?,?,?)");
            
            stm.setDate(1,(Date) def.getDataMarcada());
            stm.setInt(2, def.getPrimeiroMembro().getCodigo());
            stm.setInt(3, def.getSegundoMembro().getCodigo());
            stm.setInt(4, def.getProjeto().getCodigo());
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
    
    public void confirmarAgendamento(int codigo, boolean isCoordenador) throws Exception {
        try {
            String fieldToBeUpdated = isCoordenador ? "statusAgendamentoCoordenador" : "statusAgendamentoOrientando";
            
            PreparedStatement stm = con.prepareStatement("UPDATE agendamentoDefesa SET "+fieldToBeUpdated+" = true WHERE codigo = ?");
            
            stm.setInt(1, codigo);
            
            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DefesaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
    
    public void lancarResultado(int codigo, String resultadoDefesa, String parecerBanca, String consideracoesBanca) throws Exception {
        try {
            PreparedStatement stm = con.prepareStatement("UPDATE agendamentoDefesa SET resultadoDefesa = ?, parecerBanca = ?, consideracoesBanca = ? WHERE codigo = ?");
            
            stm.setString(1, resultadoDefesa);
            stm.setString(2, parecerBanca);
            stm.setString(3, consideracoesBanca);
            stm.setInt(4, codigo);
            
            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DefesaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
    
    public ArrayList obterAgendamentosConfirmados() throws Exception {
        try {
            ArrayList<Defesa> defesas = new ArrayList<>();
            
            PreparedStatement stm = con.prepareStatement("SELECT * FROM agendamentoDefesa");            
            ResultSet rs = stm.executeQuery();
            
            while(rs.next())
            {
                Defesa def = new Defesa();
                ProjetoDAO prjDAO = new ProjetoDAO();
                UsuarioDAO usrDAO = new UsuarioDAO();
                
                def.setCodigo(rs.getInt("codigo"));
                def.setDataMarcada(rs.getDate("dataMarcada"));
                def.setPrimeiroMembro(usrDAO.obterUsuario(rs.getInt("primeiroMembroID")));
                def.setSegundoMembro(usrDAO.obterUsuario(rs.getInt("segundoMembroID")));
                def.setConsideracoesBanca(rs.getString("consideracoesBanca"));
                def.setParecerBanca(rs.getString("parecerBanca"));
                def.setResultadoDefesa(rs.getString("resultadoDefesa"));
                def.setStatusAgendamentoCoordenador(rs.getBoolean("statusAgendamentoCoordenador"));
                def.setStatusAgendamentoOrientando(rs.getBoolean("statusAgendamentoOrientando"));
                def.setProjeto(prjDAO.obterProjeto(rs.getInt("projetoID")));
                
                defesas.add(def);
            }
            
            return defesas;
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
}
