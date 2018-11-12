package infra.dao;

import infra.ConnectionFactory;
import model.UsuarioOrientador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuario;

public class UsuarioOrientadorDAO {

    public UsuarioOrientadorDAO(){}
    
    public void enviarSolicitacao(int usuarioID, int orientadorID) throws Exception {
        try {
            Connection con = ConnectionFactory.obterConexao();
            PreparedStatement stm = con.prepareStatement("INSERT INTO usuarioorientador(usuarioID, orientadorID) VALUES(?,?)");
            
            stm.setInt(1, usuarioID);
            stm.setInt(2, orientadorID);
            
            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
    
    public void aceitarOrientacao(int usuarioID, int orientadorID) throws Exception {
        try {
            Connection con = ConnectionFactory.obterConexao();
            PreparedStatement stm = con.prepareStatement("UPDATE usuarioorientador SET orientacaoAceita = 1 WHERE usuarioID = ? AND orientadorID = ?");
            
            stm.setInt(1, usuarioID);
            stm.setInt(1, orientadorID);
            
            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
    
    public ArrayList obterAlunosOrientados() throws Exception {
        try {
            ArrayList<UsuarioOrientador> usuarioOrientador = new ArrayList<>();

            Connection con = ConnectionFactory.obterConexao();
            PreparedStatement stm = con.prepareStatement("SELECT u.nome AS 'aluno', u2.nome AS 'orientador' FROM usuarioorientador uo INNER JOIN usuario u ON u.codigo = uo.usuarioID "
                    + "INNER JOIN usuario u2 ON u2.codigo = uo.orientadorID WHERE uo.orientacaoAceita = true");            
            ResultSet rs = stm.executeQuery();
            
            while(rs.next())
            {
                UsuarioOrientador uc = new UsuarioOrientador();
                
                uc.setAluno(rs.getString("aluno"));
                uc.setOrientador(rs.getString("orientador"));
                
                usuarioOrientador.add(uc);
            }
            
            return usuarioOrientador;
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
    
    public ArrayList obterAlunosSemOrientacao() throws Exception {
        try {
            ArrayList<Usuario> usuarios = new ArrayList<>();

            Connection con = ConnectionFactory.obterConexao();
            PreparedStatement stm = con.prepareStatement("SELECT * FROM usuario WHERE isProfessor = false AND isCoordenador = false");            
            ResultSet rs = stm.executeQuery();
            
            while(rs.next())
            {
                Usuario user = new Usuario();
                
                user.setCodigo(rs.getInt("codigo"));
                user.setNome(rs.getString("nome"));
                user.setCpf(rs.getString("cpf"));
                user.setProntuario(rs.getString("prontuario"));
                user.setSenha(rs.getString("senha"));
                user.setEmail(rs.getString("email"));
                user.setIsProfessor(rs.getBoolean("isProfessor"));
                user.setIsCoordenador(rs.getBoolean("isCoordenador"));
                
                usuarios.add(user);
            }
            
            return usuarios;
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

}