package infra.dao;

import infra.ConnectionFactory;
import model.Usuario;

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
            stm.setInt(2, user.getCpf());
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

    public ArrayList obterTodos() throws Exception {
        try {
            ArrayList<Usuario> usuarios = new ArrayList<>();

            Connection con = ConnectionFactory.obterConexao();
            PreparedStatement stm = con.prepareStatement("SELECT * FROM usuario");            
            ResultSet rs = stm.executeQuery();
            
            while(rs.next())
            {
                Usuario user = new Usuario();
                
                user.setNome(rs.getString("nome"));
                user.setCpf(rs.getInt("cpf"));
                user.setProntuario(rs.getString("prontuario"));
                user.setSenha(rs.getString("senha"));
                user.setEmail(rs.getString("email"));
                user.setIsProfessor(rs.getBoolean("isProfessor"));
                
                usuarios.add(user);
            }
            
            return usuarios;
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    public void alterar(Usuario user) throws Exception {
            try {
            Connection con = ConnectionFactory.obterConexao();
            PreparedStatement stm = con.prepareStatement("UPDATE produto SET nome = ?, cpf = ?, senha = ?, email = ?, isProfessor = ? WHERE codigo = ?");
            
            stm.setString(1, user.getNome());
            stm.setInt(2, user.getCpf());
            stm.setString(3, user.getProntuario());
            stm.setString(4, user.getSenha());
            stm.setString(5, user.getEmail());
            stm.setBoolean(6, user.getIsProfessor());
            stm.setInt(7, user.getCodigo());
            
            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }        
    }
    
    public void alterarSenha(int codigo, String senha) throws Exception {
            try {
            Connection con = ConnectionFactory.obterConexao();
            PreparedStatement stm = con.prepareStatement("UPDATE produto SET senha = ? WHERE codigo = ?");
            
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
                
                user.setNome(rs.getString("nome"));
                user.setCpf(rs.getInt("cpf"));
                user.setProntuario(rs.getString("prontuario"));
                user.setSenha(rs.getString("senha"));
                user.setEmail(rs.getString("email"));
                user.setIsProfessor(rs.getBoolean("isProfessor"));
                
                return user;
            }
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return null;        
    }

}