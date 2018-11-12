package infra.dao;

import infra.ConnectionFactory;
import model.Usuario;
import model.UsuarioOrientador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {

    public UsuarioDAO() {}

    public void inserir(Usuario user) throws Exception {
        try {
            Connection con = ConnectionFactory.obterConexao();
            PreparedStatement stm = con.prepareStatement("INSERT INTO usuario(nome, cpf, prontuario, senha, email, isProfessor) VALUES(?,?,?,?,?,?)");
            
            stm.setString(1, user.getNome());
            stm.setString(2, user.getCpf());
            stm.setString(3, user.getProntuario());
            stm.setString(4, user.getSenha());
            stm.setString(5, user.getEmail());
            stm.setBoolean(6, user.getIsProfessor());
            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }        
    }

    public void alterar(Usuario user) throws Exception {
            try {
            Connection con = ConnectionFactory.obterConexao();
            PreparedStatement stm = con.prepareStatement("UPDATE usuario SET nome = ?, cpf = ?, prontuario = ?, email = ? WHERE codigo = ?");
            
            stm.setString(1, user.getNome());
            stm.setString(2, user.getCpf());
            stm.setString(3, user.getProntuario());
            stm.setString(4, user.getEmail());
            stm.setInt(5, user.getCodigo());
            
            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }        
    }
    
    public void alterarSenha(int codigo, String senha) throws Exception {
            try {
            Connection con = ConnectionFactory.obterConexao();
            PreparedStatement stm = con.prepareStatement("UPDATE usuario SET senha = ? WHERE codigo = ?");
            
            stm.setString(1, senha);
            stm.setInt(2, codigo);
            
            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }        
    }

    public void remover(int codigo) throws Exception {
        try {
            Connection con = ConnectionFactory.obterConexao();
            PreparedStatement stm = con.prepareStatement("DELETE FROM usuario WHERE codigo = ?");
            stm.setInt(1, codigo);
            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }        
    }
        
    public Usuario obterUsuario(int codigo) throws Exception {
        try {
            Connection con = ConnectionFactory.obterConexao();
            PreparedStatement stm = con.prepareStatement("SELECT * FROM usuario WHERE codigo = ?");            
            stm.setInt(1, codigo);
            ResultSet rs = stm.executeQuery();
            
            if (rs.next())
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
                
                return user;
            }
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return null;        
    }
    
    public Usuario obterUsuarioByProntuario(String prontuario, String senha) throws Exception {
        try {
            Connection con = ConnectionFactory.obterConexao();
            PreparedStatement stm = con.prepareStatement("SELECT * FROM usuario WHERE prontuario = ? AND senha = ?");            
            stm.setString(1, prontuario);
            stm.setString(2, senha);
            ResultSet rs = stm.executeQuery();
            
            if (rs.next())
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
                
                return user;
            }
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return null;        
    }

    public void alterarCoordenador(int oldCodigo, int newCodigo) throws Exception {
            try {
            Connection con = ConnectionFactory.obterConexao(); 
            
            PreparedStatement stm1 = con.prepareStatement("UPDATE usuario SET isCoordenador = false WHERE codigo = ?");
            stm1.setInt(1, oldCodigo);
            int cod = stm1.executeUpdate();
            
            if(cod == 1) {
                PreparedStatement stm2 = con.prepareStatement("UPDATE usuario SET isCoordenador = true WHERE codigo = ?");
                stm2.setInt(1, newCodigo);
                stm2.executeUpdate();
            }
            
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }        
    }
    
    public ArrayList obterProfessores() throws Exception {
        try {
            ArrayList<Usuario> usuarios = new ArrayList<>();

            Connection con = ConnectionFactory.obterConexao();
            PreparedStatement stm = con.prepareStatement("SELECT * FROM usuario WHERE isProfessor = true");            
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
    
    public ArrayList obterAlunos() throws Exception {
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