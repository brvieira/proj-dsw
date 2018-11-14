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

    Connection con = ConnectionFactory.obterConexao();
    
    public UsuarioOrientadorDAO(){}
    
    public void enviarSolicitacao(int usuarioID, int convidadoID, boolean conviteProfessor) throws Exception {
        try {
            PreparedStatement stm = con.prepareStatement("INSERT INTO usuarioOrientador(usuarioID, orientadorID, conviteProfessor) VALUES(?,?,?)");
            
            stm.setInt(1, usuarioID);
            stm.setInt(2, convidadoID);
            stm.setBoolean(3, conviteProfessor);
            
            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
    
    public void aceitarOrientacao(int usuarioID, int orientadorID) throws Exception {
        try {
            PreparedStatement stm = con.prepareStatement("UPDATE usuarioOrientador SET orientacaoAceita = 1 WHERE usuarioID = ? AND orientadorID = ?");
            
            stm.setInt(1, usuarioID);
            stm.setInt(2, orientadorID);
            
            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
    
    public ArrayList obterAlunosOrientados() throws Exception {
        try {
            ArrayList<UsuarioOrientador> usuarioOrientador = new ArrayList<>();
            Usuario aluno = new Usuario();
            Usuario professor = new Usuario();
            PreparedStatement stm = con.prepareStatement("SELECT u.nome AS 'aluno', u.codigo AS 'alunoCodigo', u.email AS 'alunoEmail', u.prontuario AS 'alunoProntuario', u2.nome AS 'professor', u2.codigo AS 'professorCodigo', u2.email AS 'professorEmail', u2.prontuario AS 'professorProntuario' FROM usuarioOrientador uo INNER JOIN usuario u ON u.codigo = uo.usuarioID "
                    + "INNER JOIN usuario u2 ON u2.codigo = uo.orientadorID WHERE uo.orientacaoAceita = true");            
            ResultSet rs = stm.executeQuery();
            
            while(rs.next())
            {
                UsuarioOrientador uc = new UsuarioOrientador();
                
                aluno.setCodigo(rs.getInt("alunoCodigo"));
                aluno.setNome(rs.getString("aluno"));
                aluno.setProntuario(rs.getString("alunoProntuario"));
                aluno.setEmail(rs.getString("alunoEmail"));
                
                professor.setCodigo(rs.getInt("professorCodigo"));
                professor.setNome(rs.getString("professor"));
                professor.setProntuario(rs.getString("professorProntuario"));
                professor.setEmail(rs.getString("professorEmail"));
                
                uc.setAluno(aluno);
                uc.setOrientador(professor);
                uc.setOrientacaoAceita(true);
                
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

            PreparedStatement stm = con.prepareStatement("select * from usuario left join usuarioOrientador as user ON user.usuarioID = usuario.codigo WHERE user.usuarioID is NULL AND usuario.isProfessor = false");            
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
    
      public Usuario obterOrientador(int alunoId) throws Exception {
        try {
            Usuario orientador = new Usuario();

            PreparedStatement stm = con.prepareStatement("SELECT * FROM usuario INNER JOIN usuarioOrientador AS user WHERE user.orientadorID = usuario.codigo AND user.usuarioID = ? AND user.orientacaoAceita = true");            
            
            stm.setInt(1, alunoId);
            
            ResultSet rs = stm.executeQuery();
            
            if (rs.next())
            {
                orientador.setCodigo(rs.getInt("codigo"));
                orientador.setNome(rs.getString("nome"));
                orientador.setCpf(rs.getString("cpf"));
                orientador.setProntuario(rs.getString("prontuario"));
                orientador.setSenha(rs.getString("senha"));
                orientador.setEmail(rs.getString("email"));
                orientador.setIsProfessor(rs.getBoolean("isProfessor"));
                orientador.setIsCoordenador(rs.getBoolean("isCoordenador"));
                
                return orientador;
            }
            
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return null;
    }
    
    public ArrayList convitesEnviadosByAluno(int alunoID) throws Exception {
        try {
            ArrayList<UsuarioOrientador> usuarioOrientador = new ArrayList<>();
            PreparedStatement stm = con.prepareStatement("SELECT u.nome AS 'aluno', u.codigo AS 'alunoCodigo', u.email AS 'alunoEmail', u.prontuario AS 'alunoProntuario', u2.nome AS 'professor', u2.codigo AS 'professorCodigo', u2.email AS 'professorEmail', u2.prontuario AS 'professorProntuario' FROM usuarioOrientador uo INNER JOIN usuario u ON u.codigo = uo.usuarioID "
                    + "INNER JOIN usuario u2 ON u2.codigo = uo.orientadorID WHERE uo.orientacaoAceita = false AND uo.usuarioID = ? AND uo.conviteProfessor = false");            
            
            stm.setInt(1, alunoID);
            
            ResultSet rs = stm.executeQuery();
            
            while(rs.next())
            {
                UsuarioOrientador uc = new UsuarioOrientador();
                Usuario aluno = new Usuario();
                Usuario professor = new Usuario();
                
                aluno.setCodigo(rs.getInt("alunoCodigo"));
                aluno.setNome(rs.getString("aluno"));
                aluno.setProntuario(rs.getString("alunoProntuario"));
                aluno.setEmail(rs.getString("alunoEmail"));
                
                professor.setCodigo(rs.getInt("professorCodigo"));
                professor.setNome(rs.getString("professor"));
                professor.setProntuario(rs.getString("professorProntuario"));
                professor.setEmail(rs.getString("professorEmail"));
                
                uc.setAluno(aluno);
                uc.setOrientador(professor);
                uc.setOrientacaoAceita(true);
                
                usuarioOrientador.add(uc);
            }
            
            return usuarioOrientador;
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
    
    public ArrayList convitesRecebidosByAluno(int alunoID) throws Exception {
        try {
            ArrayList<UsuarioOrientador> usuarioOrientador = new ArrayList<>();
            PreparedStatement stm = con.prepareStatement("SELECT u.nome AS 'aluno', u.codigo AS 'alunoCodigo', u.email AS 'alunoEmail', u.prontuario AS 'alunoProntuario', u2.nome AS 'professor', u2.codigo AS 'professorCodigo', u2.email AS 'professorEmail', u2.prontuario AS 'professorProntuario' FROM usuarioOrientador uo INNER JOIN usuario u ON u.codigo = uo.usuarioID "
                    + "INNER JOIN usuario u2 ON u2.codigo = uo.orientadorID WHERE uo.orientacaoAceita = false AND uo.usuarioID = ? AND uo.conviteProfessor = true");            
            
            stm.setInt(1, alunoID);
            
            ResultSet rs = stm.executeQuery();
            
            while(rs.next())
            {
                UsuarioOrientador uc = new UsuarioOrientador();
                Usuario aluno = new Usuario();
                Usuario professor = new Usuario();
                
                aluno.setCodigo(rs.getInt("alunoCodigo"));
                aluno.setNome(rs.getString("aluno"));
                aluno.setProntuario(rs.getString("alunoProntuario"));
                aluno.setEmail(rs.getString("alunoEmail"));
                
                professor.setCodigo(rs.getInt("professorCodigo"));
                professor.setNome(rs.getString("professor"));
                professor.setProntuario(rs.getString("professorProntuario"));
                professor.setEmail(rs.getString("professorEmail"));
                
                uc.setAluno(aluno);
                uc.setOrientador(professor);
                uc.setOrientacaoAceita(true);
                
                usuarioOrientador.add(uc);
            }
            
            return usuarioOrientador;
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
    
    public ArrayList convitesEnviadosByProfessor(int professorID) throws Exception {
        try {
            ArrayList<UsuarioOrientador> usuarioOrientador = new ArrayList<>();
            PreparedStatement stm = con.prepareStatement("SELECT u.nome AS 'aluno', u.codigo AS 'alunoCodigo', u.email AS 'alunoEmail', u.prontuario AS 'alunoProntuario', u2.nome AS 'professor', u2.codigo AS 'professorCodigo', u2.email AS 'professorEmail', u2.prontuario AS 'professorProntuario' FROM usuarioOrientador uo INNER JOIN usuario u ON u.codigo = uo.usuarioID "
                    + "INNER JOIN usuario u2 ON u2.codigo = uo.orientadorID WHERE uo.orientacaoAceita = false AND uo.orientadorID = ? AND uo.conviteProfessor = true");            
            
            stm.setInt(1, professorID);
            
            ResultSet rs = stm.executeQuery();
            
            while(rs.next())
            {
                UsuarioOrientador uc = new UsuarioOrientador();
                Usuario aluno = new Usuario();
                Usuario professor = new Usuario();
                
                aluno.setCodigo(rs.getInt("alunoCodigo"));
                aluno.setNome(rs.getString("aluno"));
                aluno.setProntuario(rs.getString("alunoProntuario"));
                aluno.setEmail(rs.getString("alunoEmail"));
                
                professor.setCodigo(rs.getInt("professorCodigo"));
                professor.setNome(rs.getString("professor"));
                professor.setProntuario(rs.getString("professorProntuario"));
                professor.setEmail(rs.getString("professorEmail"));
                
                uc.setAluno(aluno);
                uc.setOrientador(professor);
                uc.setOrientacaoAceita(true);
                
                usuarioOrientador.add(uc);
            }
            
            return usuarioOrientador;
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
    
    public ArrayList convitesRecebidosByProfessor(int professorID) throws Exception {
        try {
            ArrayList<UsuarioOrientador> usuarioOrientador = new ArrayList<>();
            PreparedStatement stm = con.prepareStatement("SELECT u.nome AS 'aluno', u.codigo AS 'alunoCodigo', u.email AS 'alunoEmail', u.prontuario AS 'alunoProntuario', u2.nome AS 'professor', u2.codigo AS 'professorCodigo', u2.email AS 'professorEmail', u2.prontuario AS 'professorProntuario' FROM usuarioOrientador uo INNER JOIN usuario u ON u.codigo = uo.usuarioID "
                    + "INNER JOIN usuario u2 ON u2.codigo = uo.orientadorID WHERE uo.orientacaoAceita = false AND uo.orientadorID = ? AND uo.conviteProfessor = false");            
            
            stm.setInt(1, professorID);
            
            ResultSet rs = stm.executeQuery();
            
            while(rs.next())
            {
                UsuarioOrientador uc = new UsuarioOrientador();
                Usuario aluno = new Usuario();
                Usuario professor = new Usuario();
                
                aluno.setCodigo(rs.getInt("alunoCodigo"));
                aluno.setNome(rs.getString("aluno"));
                aluno.setProntuario(rs.getString("alunoProntuario"));
                aluno.setEmail(rs.getString("alunoEmail"));
                
                professor.setCodigo(rs.getInt("professorCodigo"));
                professor.setNome(rs.getString("professor"));
                professor.setProntuario(rs.getString("professorProntuario"));
                professor.setEmail(rs.getString("professorEmail"));
                
                uc.setAluno(aluno);
                uc.setOrientador(professor);
                uc.setOrientacaoAceita(true);
                
                usuarioOrientador.add(uc);
            }
            
            return usuarioOrientador;
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    public ArrayList obterOrientandosByProfessor(int professorID) throws Exception {
        try {
            ArrayList<UsuarioOrientador> usuarioOrientador = new ArrayList<>();
            PreparedStatement stm = con.prepareStatement("SELECT u.nome AS 'aluno', u.codigo AS 'alunoCodigo', u.email AS 'alunoEmail', u.prontuario AS 'alunoProntuario', u2.nome AS 'professor', u2.codigo AS 'professorCodigo', u2.email AS 'professorEmail', u2.prontuario AS 'professorProntuario' FROM usuarioOrientador uo INNER JOIN usuario u ON u.codigo = uo.usuarioID "
                    + "INNER JOIN usuario u2 ON u2.codigo = uo.orientadorID WHERE uo.orientacaoAceita = true AND uo.orientadorID = ?");            
            
            stm.setInt(1, professorID);
            
            ResultSet rs = stm.executeQuery();
            
            while(rs.next())
            {
                UsuarioOrientador uc = new UsuarioOrientador();
                Usuario aluno = new Usuario();
                Usuario professor = new Usuario();
                
                aluno.setCodigo(rs.getInt("alunoCodigo"));
                aluno.setNome(rs.getString("aluno"));
                aluno.setProntuario(rs.getString("alunoProntuario"));
                aluno.setEmail(rs.getString("alunoEmail"));
                
                professor.setCodigo(rs.getInt("professorCodigo"));
                professor.setNome(rs.getString("professor"));
                professor.setProntuario(rs.getString("professorProntuario"));
                professor.setEmail(rs.getString("professorEmail"));
                
                uc.setAluno(aluno);
                uc.setOrientador(professor);
                uc.setOrientacaoAceita(true);
                
                usuarioOrientador.add(uc);
            }
            
            return usuarioOrientador;
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
    
    public void cancelarConvite(int usuarioID, int orientadorID, boolean conviteProfessor) throws Exception {
        try {
            
            PreparedStatement stm = con.prepareStatement("DELETE FROM usuarioOrientador WHERE usuarioID = ? AND orientadorID = ? AND conviteProfessor = ?");
            
            stm.setInt(1, usuarioID);
            stm.setInt(2, orientadorID);
            stm.setBoolean(3, conviteProfessor);
            
            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
    
}