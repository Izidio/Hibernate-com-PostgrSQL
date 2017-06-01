/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Izidio
 */
public class HibernateUtility {
    private static SessionFactory sessionFactory;
    private static final ThreadLocal<Session> sessionThread;
    
    //metodo static
    //sempre chamado quando algum metodo da classe for chamado
    //instancia os dois objetos
    static{
        //tread associada para a criacao da sessao
        //getSession()
        sessionThread =  new ThreadLocal<Session>();
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    
    //metodo static que retorna a sessao
    public static Session getSession(){
        //armazena a sessao
        //get() para saber se ja esta sendo ultilizada
        Session session = sessionThread.get();
        
        //se a sessao for nula
        //abre a sessao e associa a sessao criada
        if(session==null){
            session = sessionFactory.openSession();
            sessionThread.set(session);
        }
        return session;
    }
//    metodo que fecha a sessao
    public static void closeSession(){
        Session session = sessionThread.get();
        sessionThread.set(null);
        if(session != null && session.isOpen()){
            //atualiza antes de fechar a sessao
            session.flush();
            session.close();
        }
    }
}
