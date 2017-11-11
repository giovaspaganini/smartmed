package chat.dao.model;

import java.util.ArrayList;


public class Usuario {
    public Integer id;
    public String login;
    public String senha;    
    public Boolean isAluno = false;
    public Boolean isTutor = false;
    public String nome;
    public Usuario(){
        id=-1;
        sessoesDisponiveis = new ArrayList<Sessaochat>()    ;
    }
    public ArrayList<Sessaochat> sessoesDisponiveis;
}
