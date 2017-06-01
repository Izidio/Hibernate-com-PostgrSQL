/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import Entidades.Categoria;
import Entidades.Produto;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Izidio
 */
public class Teste {

    static SessionFactory factory = new Configuration().configure().buildSessionFactory();
    static Session session;

    public static void main(String[] args) {
        Produto produto = new Produto();
        Categoria categoria= new Categoria();
        start_db();
        session.flush();
        
//        session.save(Usuario);
        end_db();
    }

    static void start_db() {
        session = factory.openSession();
        session.beginTransaction();
        System.out.println("Sessão Iniciada");
    }

    static void end_db() {
        session.getTransaction().commit();
        session.close();
        factory.close();
        System.out.println("Sessão Finalizada");
    }
    
//    static void set_db(String nome, int salario) {
//        session.flush();
//        Usuario Usuario = new Usuario();
//        Usuario.setNome(nome);
//        Usuario.setSalario(salario);
//        session.save(Usuario);
//
//    }
//
//    static List get_db(int index) {
//        List lista = new ArrayList();
//        String hql = "from Usuario";
//       
//        Query query = session.createQuery(hql);
//        List<Usuario> listFields = query.list();
//
//        if (index == 0) {
//            System.out.println("erro");
//            System.exit(0);
//        } else {
//            for (Usuario aCategory : listFields) {
//                lista.add(new Fields(aCategory.getId().toString(), aCategory.getNome(), aCategory.getSalario().toString()));
//            }
//
//        }
//        return lista;
//
//    }
}
