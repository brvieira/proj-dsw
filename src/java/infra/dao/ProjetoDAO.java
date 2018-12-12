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
    
    Connection con = ConnectionFactory.obterConexao();
    
    public void inserir(Projeto prj) throws Exception {
        try {
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
    
    public void enviarProjeto(int codigo) throws Exception {
        try {
            PreparedStatement stm = con.prepareStatement("UPDATE projeto SET projetoEnviadoColegiado = true WHERE codigo = ?");
            
            stm.setInt(1, codigo);
            
            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
    
    public void informarParecer(int codigo, String textoParecer) throws Exception {
        try {
            PreparedStatement stm = con.prepareStatement("UPDATE projeto SET parecerProjeto = ? WHERE codigo = ?");
            
            stm.setString(1, textoParecer);
            stm.setInt(2, codigo);
            
            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
    
    public String obterParecer(int codigo) throws Exception {
        try {
            Connection con = ConnectionFactory.obterConexao();
            PreparedStatement stm = con.prepareStatement("SELECT * FROM projeto WHERE codigo = ?");            
            stm.setInt(1, codigo);
            ResultSet rs = stm.executeQuery();
            
            if (rs.next())
            {
                String parecer = rs.getString("parecerProjeto");
                return parecer;
            }
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return null;        
    }
    
    public void cancelarEnvio(int codigo) throws Exception {
        try {
            PreparedStatement stm = con.prepareStatement("UPDATE projeto SET projetoEnviadoColegiado = false WHERE codigo = ?");
            
            stm.setInt(1, codigo);
            
            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
    
    public void aprovarEnvio(int codigo) throws Exception {
        try {
            PreparedStatement stm = con.prepareStatement("UPDATE projeto SET projetoEnviadoColegiadoConcordado = true WHERE codigo = ?");
            
            stm.setInt(1, codigo);
            
            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
    
    public void confirmarRecebimento(int codigo) throws Exception {
        try {
            PreparedStatement stm = con.prepareStatement("UPDATE projeto SET projetoRecebidoAnalise = true WHERE codigo = ?");
            
            stm.setInt(1, codigo);
            
            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    public void confirmarVersaoFinal(int codigo) throws Exception {
        try {
            PreparedStatement stm = con.prepareStatement("UPDATE projeto SET versaoFinalConfirmadaOrientador = true WHERE codigo = ?");
            
            stm.setInt(1, codigo);
            
            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
    
    public void enviarVersaoFinal(int codigo) throws Exception {
        try {
            PreparedStatement stm = con.prepareStatement("UPDATE projeto SET versaoFinalEnviada = true WHERE codigo = ?");
            
            stm.setInt(1, codigo);
            
            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
    
    public Projeto obterProjeto(int codigo) throws Exception {
        try {
            PreparedStatement stm = con.prepareStatement("SELECT * FROM projeto WHERE codigo = ?");            
            stm.setInt(1, codigo);
            ResultSet rs = stm.executeQuery();
            
            if (rs.next())
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
                prj.setVersaoFinalEnviada(rs.getBoolean("versaoFinalEnviada"));
                prj.setVersaoFinalConfirmadaOrientador(rs.getBoolean("versaoFinalConfirmadaOrientador"));
                prj.setAluno(userDAO.obterUsuario(rs.getInt("usuarioID")));
                
                return prj;
            }
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return null;
    }

    public ArrayList obterProjetos() throws Exception {
        try {
            ArrayList<Projeto> projetos = new ArrayList<>();
            
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
                prj.setVersaoFinalEnviada(rs.getBoolean("versaoFinalEnviada"));
                prj.setVersaoFinalConfirmadaOrientador(rs.getBoolean("versaoFinalConfirmadaOrientador"));
                prj.setAluno(userDAO.obterUsuario(rs.getInt("usuarioID")));
                projetos.add(prj);
            }
            
            return projetos;
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    public ArrayList obterProjetosFinalizados() throws Exception {
        try {
            ArrayList<Projeto> projetos = new ArrayList<>();
            
            PreparedStatement stm = con.prepareStatement("SELECT * FROM projeto where versaoFinalConfirmadaOrientador = TRUE");            
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
                prj.setVersaoFinalEnviada(rs.getBoolean("versaoFinalEnviada"));
                prj.setVersaoFinalConfirmadaOrientador(rs.getBoolean("versaoFinalConfirmadaOrientador"));
                prj.setAluno(userDAO.obterUsuario(rs.getInt("usuarioID")));
                projetos.add(prj);
            }
            
            return projetos;
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
    
    public ArrayList obterProjetosPendentesColegiado() throws Exception {
        try {
            ArrayList<Projeto> projetos = new ArrayList<>();
            
            PreparedStatement stm = con.prepareStatement("SELECT * FROM projeto WHERE projetoEnviadoColegiadoConcordado = true");            
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
                prj.setVersaoFinalEnviada(rs.getBoolean("versaoFinalEnviada"));
                prj.setVersaoFinalConfirmadaOrientador(rs.getBoolean("versaoFinalConfirmadaOrientador"));
                prj.setAluno(userDAO.obterUsuario(rs.getInt("usuarioID")));
                projetos.add(prj);
            }
            
            return projetos;
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
    
    public ArrayList obterProjetosbyUsuarioID(int codigo) throws Exception {
        try {
            ArrayList<Projeto> projetos = new ArrayList<>();
            
            PreparedStatement stm = con.prepareStatement("SELECT * FROM projeto WHERE usuarioID = ?");  
            stm.setInt(1, codigo);
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
                prj.setVersaoFinalEnviada(rs.getBoolean("versaoFinalEnviada"));
                prj.setVersaoFinalConfirmadaOrientador(rs.getBoolean("versaoFinalConfirmadaOrientador"));
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
