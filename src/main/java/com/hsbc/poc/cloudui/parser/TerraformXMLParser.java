package com.hsbc.poc.cloudui.parser;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import com.hsbc.poc.cloudui.model.*;
import com.hsbc.poc.cloudui.util.GenerateFinalTerraForm;
import com.hsbc.poc.cloudui.vo.PreviewVO;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class TerraformXMLParser {

    private static ComputeVM computeVM = null;
    private static PersistentDisk persistentDisk = null;
    private static BootDisk bootDisk = null;
    private static Firewall firewall = null;
    private static ServiceAccount serviceAccount = null;
    private static SubNetwork subNetwork = null;
    private static NetworkInterface networkInterface = null;

    public static void main(String[] args) throws Exception {

        String xmlfilename = "C:\\develpment\\hsbc\\poc\\cloudui\\src\\main\\resources\\xml\\TerraformComponent.xml";

        parseGenerateTF(xmlfilename);
    }

    public static String parseGenerateTF(String xmlfilename) throws Exception {

        System.out.println("Parsing xml file:- "+ xmlfilename);

        File inputFile = new File(xmlfilename);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;

        dBuilder = dbFactory.newDocumentBuilder();

        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();

        XPath xPath =  XPathFactory.newInstance().newXPath();

        String expression = "/mxfile/diagram/mxGraphModel/root/object";

        NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(
                doc, XPathConstants.NODESET);

        for (int i = 0; i < nodeList.getLength(); i++) {

            Node nNode = nodeList.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                String elementName = eElement.getAttribute("label");

                if(elementName.equalsIgnoreCase("Compute\n" +
                        "Engine")){
                    String computeEngineName = eElement.getAttribute("Name");
                    String computeEngineZone = eElement.getAttribute("Zone");
                    String computeEngineMachine_Type = eElement.getAttribute("Machine_Type");
                    String computeEngineAllow_Update = eElement.getAttribute("Allow_Update");
                    String computeEngineSource = eElement.getAttribute("Source");
                    String computeEngineTags = eElement.getAttribute("Tags");
                    String computeEngineSubnetwork = eElement.getAttribute("Subnetwork");

                    computeVM = new ComputeVM(computeEngineName, computeEngineZone, computeEngineMachine_Type,
                            computeEngineAllow_Update, computeEngineSource, computeEngineTags, subNetwork);
                    bootDisk = new BootDisk(computeEngineSource);

                    /*System.out.println("\nName = "+computeEngineName + ",\t Zone = " +computeEngineZone + ",\t Machine_Type = "+ computeEngineMachine_Type +
                    ",\t Allow_Update = "+computeEngineAllow_Update + ",\t Source = " + computeEngineSource + ",\t Tags = " +computeEngineTags + ",\t Subnetwork = " + computeEngineSubnetwork) ;*/

                }
                if(elementName.equalsIgnoreCase("Persistent\n" +
                        "Disk")){
                    String family = eElement.getAttribute("Family");
                    String project = eElement.getAttribute("Project");
                    String name = eElement.getAttribute("Name");
                    String size = eElement.getAttribute("Size");
                    String disktype = eElement.getAttribute("Disk_Type");
                    String image = eElement.getAttribute("Image");
                    String zone = eElement.getAttribute("Zone");
                    persistentDisk = new PersistentDisk(family, project, name, size, disktype, image, zone);

                    /*System.out.println("\nFamily = "+ family +",\t project = "+ project +",\t name = "+name+",\t size = "+size+
                    ",\t disktype = "+disktype+",\t image = "+image+",\t zone = "+zone);*/
                }
                if(elementName.equalsIgnoreCase("Cloud IAM")){
                    String accountid = eElement.getAttribute("Account_Id");
                    String displayname = eElement.getAttribute("Display_Name");
                    serviceAccount = new ServiceAccount(accountid, displayname);
                }
                if(elementName.equalsIgnoreCase("Cloud\n" +
                        "Firewall Rules")){
                    String name = eElement.getAttribute("Name");
                    String network = eElement.getAttribute("Network");
                    String sourcetags = eElement.getAttribute("Source_Tag");
                    String protocol  = eElement.getAttribute("Protocol");
                    String ports = eElement.getAttribute("Ports");
                    firewall = new Firewall(name, network, sourcetags, protocol, ports);
                }
                if(elementName.equalsIgnoreCase("Cloud\n" +
                        "Network")){
                    String name = eElement.getAttribute("Name");
                    String range = eElement.getAttribute("IP_CIDR_Range");
                    String region = eElement.getAttribute("Region");
                    subNetwork = new SubNetwork(name, range, region);
                }
                if(elementName.equalsIgnoreCase("Virtual\n" +
                        "Private Cloud")){
                    networkInterface = new NetworkInterface(eElement.getAttribute("Name"));
                }
            }
        }

        return  GenerateFinalTerraForm.createMainTF1(computeVM, bootDisk, persistentDisk, serviceAccount, firewall,
                networkInterface, subNetwork);
    }
}
