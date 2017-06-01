/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_hibernate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Izidio Carvalho
 */
public class ManagerXML {

    public static void main(String[] args) {
        List<String> listaNomes = new ArrayList();
        List<String> listaFields = new ArrayList();

        int index = 3;

        listaNomes.add("Campo1");
        listaNomes.add("Campo2");
        listaNomes.add("Campo3");

        listaFields.add("field1");
        listaFields.add("field2");
        listaFields.add("field3");

        configureXML(listaNomes, listaFields, index);
    }

    static void configureXML(List listaNomes, List listaFields, int index) {
        System.out.println("Configurando JRXML");
        
        //Array usado para configurar a posicao de cada elemento
        List<Integer> listaPosicao = new ArrayList();
        int LarguraTotal = 555;
        int LarguraIndivudual=0;
        int L = 0;
        String XML;

        if (index == 0) {
            System.out.println("Erro! managerXML");
            LarguraIndivudual = 0;
            System.exit(0);
        } else {
            if (index == 1) {
                L=255;
            } else {
                LarguraIndivudual = LarguraTotal / (index + 1);
            }
        }

        for (int i = 0; i < index; i++) {
            L += LarguraIndivudual - (10 * (index - 1));
              listaPosicao.add(L);
         }

       String parte1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                + "<jasperReport xmlns=\"http://jasperreports.sourceforge.net/jasperreports\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://jasperreports.sourceforge.net/jasperreports http://jasperreports.sourceforge.net/xsd/jasperreport.xsd\" name=\"RelatorioClientes\" language=\"groovy\" pageWidth=\"595\" pageHeight=\"842\" columnWidth=\"535\" leftMargin=\"20\" rightMargin=\"20\" topMargin=\"20\" bottomMargin=\"20\" uuid=\"39515629-5484-4bb7-b11f-dcb8a2cdac20\">\n"
                + "	<property name=\"ireport.zoom\" value=\"1.0\"/>\n"
                + "	<property name=\"ireport.x\" value=\"0\"/>\n"
                + "	<property name=\"ireport.y\" value=\"0\"/>\n";
        String parte2 = "";
        for (int i = 0; i < listaFields.size(); i++) {
            parte2 += "	<field name=\"" + listaFields.get(i) + "\" class=\"java.lang.String\"/>\n";

        }

        String parte3 = "	<group name=\"Group1\">\n"
                + "		<groupFooter>\n"
                + "			<band/>\n"
                + "		</groupFooter>\n"
                + "	</group>\n"
                + "	<group name=\"Group2\">\n"
                + "		<groupFooter>\n"
                + "			<band/>\n"
                + "		</groupFooter>\n"
                + "	</group>\n"
                + "	<group name=\"Group3\">\n"
                + "		<groupFooter>\n"
                + "			<band/>\n"
                + "		</groupFooter>\n"
                + "	</group>\n"
                + "	<group name=\"Group4\">\n"
                + "		<groupFooter>\n"
                + "			<band/>\n"
                + "		</groupFooter>\n"
                + "	</group>\n"
                + "	<background>\n"
                + "		<band/>\n"
                + "	</background>\n"
                + "	<title>\n"
                + "		<band height=\"72\">\n"
                + "			<frame>\n"
                + "				<reportElement mode=\"Opaque\" x=\"-20\" y=\"-20\" width=\"595\" height=\"92\" backcolor=\"#99cc60\" uuid=\"97ef0665-73ad-41f5-a269-44fd18292f46\"/>\n"
                + "				<staticText>\n"
                + "					<reportElement x=\"20\" y=\"20\" width=\"234\" height=\"43\" forecolor=\"#FFFFFF\" uuid=\"1cb183af-1d20-4def-b085-c890b645ae3f\"/>\n"
                + "					<textElement>\n"
                + "						<font size=\"34\" isBold=\"true\"/>\n"
                + "					</textElement>\n"
                + "					<text><![CDATA[Relatório]]></text>\n"
                + "				</staticText>\n"
                + "				<staticText>\n"
                + "					<reportElement x=\"435\" y=\"38\" width=\"140\" height=\"25\" forecolor=\"#FFFFFF\" uuid=\"29954f46-3583-4b7a-9844-9af0900b81fd\"/>\n"
                + "					<textElement textAlignment=\"Right\">\n"
                + "						<font size=\"14\" isBold=\"false\"/>\n"
                + "					</textElement>\n"
                + "					<text><![CDATA[Ireport +JasperReprt]]></text>\n"
                + "				</staticText>\n"
                + "			</frame>\n"
                + "		</band>\n"
                + "	</title>\n"
                + "	<pageHeader>\n"
                + "		<band height=\"13\"/>\n"
                + "	</pageHeader>\n"
                + "	<columnHeader>\n"
                + "		<band height=\"21\">\n"
                + "			<line>\n"
                + "				<reportElement x=\"-20\" y=\"20\" width=\"595\" height=\"1\" forecolor=\"#666666\" uuid=\"5a6eb449-0660-433a-ba3f-2a0aa835a37f\"/>\n"
                + "			</line>\n";

        String parte4 = "";

        for (int i = 0; i < listaNomes.size(); i++) {
            parte4 += "			<staticText>\n"
                    + "				<reportElement x=\"" + listaPosicao.get(i) + "\" y=\"0\" width=\"100\" height=\"20\" forecolor=\"#006699\" uuid=\"693e38cc-24ca-491a-b36d-7d75b675a477\"/>\n"
                    + "				<textElement textAlignment=\"Left\" verticalAlignment=\"Middle\">\n"
                    + "					<font size=\"14\" isBold=\"true\" isItalic=\"false\"/>\n"
                    + "				</textElement>\n"
                    + "				<text><![CDATA[" + listaNomes.get(i) + "]]></text>\n"
                    + "			</staticText>\n";
        }
        String parte5 = "</band>\n"
                + "	</columnHeader>\n"
                + "	<detail>\n"
                + "		<band height=\"20\">\n"
                + "			<line>\n"
                + "				<reportElement positionType=\"FixRelativeToBottom\" x=\"0\" y=\"19\" width=\"555\" height=\"1\" uuid=\"35691373-560d-42db-bd2a-b9ec49f75bb0\"/>\n"
                + "			</line>\n";

        String parte6 = "";

        for (int i = 0; i < listaFields.size(); i++) {
            parte6 += "			<textField>\n"
                    + "				<reportElement x=\"" + listaPosicao.get(i) + "\" y=\"0\" width=\"100\" height=\"20\" uuid=\"ae37440e-740b-4852-8a59-6434fdec4288\"/>\n"
                    + "				<textElement textAlignment=\"Left\"/>\n"
                    + "				<textFieldExpression><![CDATA[$F{" + listaFields.get(i) + "}]]></textFieldExpression>\n"
                    + "			</textField>\n";
        }
        String parte7 = "</band>\n"
                + "	</detail>\n"
                + "	<columnFooter>\n"
                + "		<band/>\n"
                + "	</columnFooter>\n"
                + "	<pageFooter>\n"
                + "		<band height=\"17\">\n"
                + "			<textField>\n"
                + "				<reportElement mode=\"Opaque\" x=\"0\" y=\"4\" width=\"515\" height=\"13\" backcolor=\"#E6E6E6\" uuid=\"72d38ae0-8549-4699-b9db-3620cfb148fb\"/>\n"
                + "				<textElement textAlignment=\"Right\"/>\n"
                + "				<textFieldExpression><![CDATA[\"Page \"+$V{PAGE_NUMBER}+\" of\"]]></textFieldExpression>\n"
                + "			</textField>\n"
                + "			<textField evaluationTime=\"Report\">\n"
                + "				<reportElement mode=\"Opaque\" x=\"515\" y=\"4\" width=\"40\" height=\"13\" backcolor=\"#E6E6E6\" uuid=\"d079e3e9-6ec6-430b-be22-e080b5816ac3\"/>\n"
                + "				<textFieldExpression><![CDATA[\" \" + $V{PAGE_NUMBER}]]></textFieldExpression>\n"
                + "			</textField>\n"
                + "			<textField pattern=\"EEEEE dd MMMMM yyyy\">\n"
                + "				<reportElement x=\"0\" y=\"4\" width=\"100\" height=\"13\" uuid=\"df33c217-3de9-48cc-9d68-5f1982f553e6\"/>\n"
                + "				<textFieldExpression><![CDATA[new java.util.Date()]]></textFieldExpression>\n"
                + "			</textField>\n"
                + "		</band>\n"
                + "	</pageFooter>\n"
                + "</jasperReport>\n";
        XML = parte1 + parte2 + parte3 + parte4 + parte5 + parte6 + parte7;

        System.out.println("JRXML criado");
        escrever(XML);

    }

    private static void escrever(String texto) {
        System.out.println("Salvando Relatorio.jrxml");
        File dir = new File("relatorios/");
        File arq = new File(dir, "Relatorio.jrxml");

        try {

            //neste ponto criamos o arquivo fisicamente
            arq.createNewFile();

            //Devemos passar no construtor do FileWriter qual arquivo
            // vamos manipular.
            // Esse construtor aceita dois tipos de parâmetros,
            // File ou String.
            //O parâmetro true indica que reescrevemos no arquivo
            // sem apagar o que já existe.
            // O false apagaria o conteúdo do arquivo e escreveria
            // o novo conteúdo.
            // Se não usar o 2° parâmetro, ele por padrão será false.
            //O mais importante, essa linha abre o fluxo do arquivo
            FileWriter fileWriter = new FileWriter(arq, false);

            //Agora vamos usar a classe PrintWriter para escrever
            //fisicamente no arquivo.
            //Precisamos passar o objeto FileReader em seu construtor
            PrintWriter printWriter = new PrintWriter(fileWriter);

            //Agora vamos escrever no arquivo com o método  println(),
            // que nos permite escrever linha a linha no arquivo
            printWriter.println(texto);

            //o método flush libera a escrita no arquivo
            printWriter.flush();

            //No final precisamos fechar o arquivo
            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Arqivo Relatorio.jrxml salvo com sucesso em: " + dir);
    }
}
