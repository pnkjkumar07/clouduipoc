package com.hsbc.poc.cloudui.controller;

import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.hsbc.poc.cloudui.parser.TerraformXMLParser;
import com.hsbc.poc.cloudui.util.PushToGit;
import com.hsbc.poc.cloudui.util.xmlobj.Mxfile;
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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonParser;

import static com.google.gson.stream.JsonReader.*;

@Controller
public class ComponentController {

    private String fileName;
    private ClassLoader classLoader;
    private ResourcePatternResolver resolver;
    private File file;
    private Resource resource;
    byte[] content;

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
        String outputFilePath = "C:\\develpment\\hsbc\\poc\\cloudui\\src\\main\\resources\\xml\\xmlfile.xml"; //path of xml file where we are trying to write POST request data from UI

        String tfcontent = null;
        tfcontent = storeXML(xmldata, tfcontent, outputFilePath);

        return ResponseEntity.ok().body(tfcontent);
    }

    public String storeXML(String xmldata, String tfcontent, String outputFilePath) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
            writer.write(xmldata);
            writer.close();

            tfcontent = TerraformXMLParser.parseGenerateTF(outputFilePath);

        } catch (Exception  e) {
            e.printStackTrace();

        }
        return tfcontent;
    }


    // @PostMapping(path = "/preview", consumes = MediaType.ALL_VALUE , produces = MediaType.ALL_VALUE)
   @GetMapping(path="/preview")
    public ResponseEntity<Object> previewXML(@RequestBody Mxfile mxfile){

        return new ResponseEntity<>(mxfile.getDiagram().getMxGraphModel().getRoot().getObject().get(0),HttpStatus.OK);
        /*ResponseEntity<Object> response = null;
        try {
           response = ResponseEntity.status(HttpStatus.OK).body(mxfile.getDiagram().getMxGraphModel().getRoot().getObject());
        } catch (Exception e) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return response;*/
    }
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public List sayHello() {
        return Arrays.asList("A", "B", "C");
    }

    //TODO
    //@GetMapping(path="/preview", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getPreview(){
        try {
            fileName = "file:C:\\develpment\\hsbc\\previewpretty.json";
            JsonParser parser = new JsonParser();
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create(); //new Gson();
            resource = resolver.getResource(fileName);
            file = resource.getFile();
            String content = Files.readAllBytes(file.toPath()).toString();
            String content1 = gson.fromJson(content, String.class);
            System.out.println(content1);
        } catch(Exception exception){
            exception.printStackTrace();
        }
        return new ResponseEntity<>(loadJson(fileName), HttpStatus.OK);
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
