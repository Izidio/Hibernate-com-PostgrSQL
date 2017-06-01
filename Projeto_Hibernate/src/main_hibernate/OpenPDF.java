/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_hibernate;

import java.io.File;
import java.io.IOException;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Izidio Carvalho
 */
public class OpenPDF {

    public static void main(String[] args) throws JRException, IOException, InterruptedException {
        show();
    }

    static void show() throws JRException, IOException, InterruptedException {
        String path = new File("relatorios/Relatorio.pdf").getCanonicalPath();
        System.out.println("Caminho absoluto: " + path);
        Process pro = Runtime.getRuntime().exec("cmd.exe /c " + path);
        pro.waitFor();
    }
}
