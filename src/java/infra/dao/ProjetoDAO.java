package infra.dao;

import infra.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Projeto;

public class ProjetoDAO {
    
    public ProjetoDAO() {}
    
    public void inserir(Projeto prj) throws Exception {
        try {
            Connection con = ConnectionFactory.obterConexao();
            PreparedStatement stm = con.prepareStatement("INSERT INTO projeto(nome, parecerProjeto, resultadoQualificacao, projetoEnviadoColegiado, projetoEnviadoColegiadoConcordado, projetoRecebidoAnalise, usuarioID) VALUES(?,?,?,?,?,?,?)");
            
            stm.setString(1, prj.getNome());
            stm.setString(2, prj.getParecerProjeto());
            stm.setString(3, prj.getResultadoQualificacao());
            stm.setBoolean(4, prj.isProjetoEnviadoColegiado());
            stm.setBoolean(5, prj.isProjetoEnviadoColegiadoConcordado());
            stm.setBoolean(6, prj.isProjetoRecebidoAnalise());
            stm.setInt(7, prj.getAluno().getCodigo());
            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
    
    public ArrayList obterProjetos() throws Exception {
        try {
            ArrayList<Projeto> projetos = new ArrayList<>();

            Connection con = ConnectionFactory.obterConexao();
            PreparedStatement stm = con.prepareStatement("SELECT * FROM projeto");            
            ResultSet rs = stm.executeQuery();
            
            while(rs.next())
            {
                Projeto prj = new Projeto();
                UsuarioDAO userDAO = new UsuarioDAO();
                
                prj.setCodigo(rs.getInt("codigo"));
                prj.setNome(rs.getString("nome"));  
                prj.setParecerProjeto(rs.getString("parecerProjeto"));  
                prj.setResultadoQualificacao(rs.getString("resultadoQualificacao"));  
                prj.setProjetoEnviadoColegiado(rs.getBoolean("projetoEnviadoColegiado"));
                prj.setProjetoEnviadoColegiadoConcordado(rs.getBoolean("projetoEnviadoColegiadoConcordado"));
                prj.setProjetoRecebidoAnalise(rs.getBoolean("projetoRecebidoAnalise"));
                prj.setAluno(userDAO.obterUsuario(rs.getInt("usuarioID")));
                projetos.add(prj);
            }
            
            return projetos;
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
}
