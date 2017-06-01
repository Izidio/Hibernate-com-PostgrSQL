/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_hibernate;

import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author Izidio Carvalho
 */
public class Relatorio {

    public static void main(String[] args) throws JRException {

        Fields f1 = new Fields("3", "Izidio", "Carvalho");
        Fields f2 = new Fields("3", "Izidio", "Carvalho");
        Fields f3 = new Fields("3", "Izidio", "Carvalho");

        List lista = new ArrayList();
        lista.add(f1);
        lista.add(f2);
        lista.add(f3);

        System.out.println("Classe main");
        gerarRelatorio(lista);

    }

    public static void gerarRelatorio(List list) throws JRException {

        System.out.println("Gerando relatório...");

// compilacao do JRXML
        JasperReport report = JasperCompileManager.compileReport("relatorios/Relatorio.jrxml");

// preenchimento do relatorio, note que o metodo recebe 3 parametros:
// 1 - o relatorio
//
// 2 - um Map, com parametros que sao passados ao relatorio
// no momento do preenchimento. No nosso caso é null, pois nao
// estamos usando nenhum parametro
//
// 3 - o data source. Note que nao devemos passar a lista diretamente,
// e sim "transformar" em um data source utilizando a classe
// JRBeanCollectionDataSource
        JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(list));

// exportacao do relatorio para outro formato, no caso PDF
        JasperExportManager.exportReportToPdfFile(print, "relatorios/Relatorio.pdf");

        System.out.println("Relatório gerado.");
    }
}
