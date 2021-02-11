package com.hsbc.poc.cloudui.controller;

import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.hsbc.poc.cloudui.parser.TerraformXMLParser;
import com.hsbc.poc.cloudui.util.ConfigUtility;
import com.hsbc.poc.cloudui.util.PushToGit;
import com.hsbc.poc.cloudui.util.jenkinsobj.Build;
import com.hsbc.poc.cloudui.util.jenkinsobj.JenkinsResponse;
import com.hsbc.poc.cloudui.util.xmlobj.Mxfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RestController
public class ComponentController {

    private String fileName;
    private ClassLoader classLoader;
    private ResourcePatternResolver resolver;
    private File file;
    private Resource resource;
    byte[] content;
    private Build build;

    @Autowired
    private ConfigUtility configUtil;

    @PostConstruct
    public void init() {
        classLoader = this.getClass().getClassLoader();
        resolver = new PathMatchingResourcePatternResolver(classLoader);
    }

    @RequestMapping("/")
    public String home() {
        return "Hi";
    }

    @GetMapping(path="/pushtorepo", produces= MediaType.ALL_VALUE)
    public ResponseEntity<Object> PushToGitRepo(){

        System.out.println("Submitting final tf to git...");
        PushToGit.pushToRepo();
        System.out.println("Pushed to git");

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path="/sa", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getServiceAccount(){
        fileName = "file:C:\\develpment\\hsbc\\git\\oldfiles\\gcp\\basic\\service_account.json";
        return new ResponseEntity<>(loadJson(fileName), HttpStatus.OK);
    }

    @GetMapping(path="/vm", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getcomputeVM(){
        fileName = "file:C:\\develpment\\hsbc\\git\\oldfiles\\gcp\\basic\\instance.json";
        return new ResponseEntity<>(loadJson(fileName), HttpStatus.OK);
    }

    @GetMapping(path="/network", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getNetwork(){
        fileName = "file:C:\\develpment\\hsbc\\git\\oldfiles\\gcp\\basic\\network.json";
        return new ResponseEntity<>(loadJson(fileName), HttpStatus.OK);
    }

    @GetMapping(path="/firewall", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getFirewall(){
        fileName = "file:C:\\develpment\\hsbc\\git\\oldfiles\\gcp\\basic\\firewall.json";
        return new ResponseEntity<>(loadJson(fileName), HttpStatus.OK);
    }

    @PostMapping(value = "/readxml",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = "text/plain"
    )
    public ResponseEntity<String> terraformDecoder(@RequestBody String xmldata)
            throws ConfigDataResourceNotFoundException {

        System.out.println("Got xmldata from browser :- "+ xmldata);
        String outputFilePath = configUtil.getProperty("xml_output_file_path");//"D:\\xmldata\\xmlfile.xml"; //hitesh

        String tfcontent = null;
        tfcontent = storeXML(xmldata, tfcontent, outputFilePath, true);

        return new ResponseEntity<>(tfcontent, HttpStatus.OK);
    }

    public String storeXML(String xmldata, String content, String outputFilePath, boolean isParsing) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
            writer.write(xmldata);
            writer.close();
            if(isParsing) {
                content = TerraformXMLParser.parseGenerateTF(outputFilePath);
            }

        } catch (Exception  e) {
            e.printStackTrace();

        }
        return content;
    }


    @PostMapping(value = "/jenkinsrequest",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = "text/plain"
    )
    public ResponseEntity<String> jenkinsResponse(@RequestBody String xmldata)
            throws ConfigDataResourceNotFoundException {

        System.out.println("Got Jenkins xmldata from browser :- "+ xmldata);
        String outputFilePath = configUtil.getProperty("jenkins_response_file_path"); //"D:\\xmldata\\xmlfile.xml"; //hitesh
        String content = null;
        content = storeXML(xmldata, content, outputFilePath, false);
        return new ResponseEntity<>(content, HttpStatus.OK);
    }

    @PostMapping(value = "/jenkins",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Build> jenkins(@RequestBody JenkinsResponse response)
    throws ConfigDataResourceNotFoundException {

        System.out.println("jenkins status = "+response.getBuild().getStatus() +"\r\n Jenkins phase = "
                + response.getBuild().getPhase());
        build = response.getBuild();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\develpment\\hsbc\\poc\\cloudui\\src\\main\\resources\\xml\\jenkinsresponse.json"));
            writer.write(response.getBuild().toString());
            writer.close();
        }catch (Exception ex){

        }

        return new ResponseEntity<>(response.getBuild(), HttpStatus.OK);
    }

    @GetMapping(path="/jenkinsstatus", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getJenkinsStatus(){
        //fileName = "file:C:\\develpment\\hsbc\\poc\\cloudui\\src\\main\\resources\\xml\\jenkinsresponse.json";
        //return new ResponseEntity<>(loadJson(fileName), HttpStatus.OK);
        if(null == build){
            return new ResponseEntity<>("Please check if Jenkins Pipeline is Triggered/Running/Finished.", HttpStatus.OK);
        }
        return new ResponseEntity<>(build, HttpStatus.OK);
    }

    private byte[] loadJson(String fileName) {
        try {
            resource = resolver.getResource(fileName);
            file = resource.getFile();
            content = Files.readAllBytes(file.toPath());
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return content;
    }
}
