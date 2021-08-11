package br.vianna.aula.appteatro.controller.commander;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public abstract class GenericCommander {
    
    private boolean executarComLogin;

    public GenericCommander(boolean executarComLogin) {
        this.executarComLogin = executarComLogin;
    }
    
    public abstract void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    public boolean isSoExecuteComLogin() {
        return executarComLogin;
    }

    public void setSoExecuteComLogin(boolean executarComLogin) {
        this.executarComLogin = executarComLogin;
    }

    

    
    
        
}
