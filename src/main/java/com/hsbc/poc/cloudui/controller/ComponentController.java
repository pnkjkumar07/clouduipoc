package com.hsbc.poc.cloudui.controller;

import com.hsbc.poc.cloudui.util.PushToGit;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.io.File;
import java.nio.file.Files;

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
        PushToGit.pushToRepo();
        System.out.println("Pushed to git");
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping(path="/sa", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getServiceAccount(){
        fileName = "file:C:\\develpment\\hsbc\\git\\gcp\\basic\\service_account.json";
        return new ResponseEntity<>(loadJson(fileName), HttpStatus.OK);
    }

    @GetMapping(path="/vm", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getcomputeVM(){
        fileName = "file:C:\\develpment\\hsbc\\git\\gcp\\basic\\instance.json";
        return new ResponseEntity<>(loadJson(fileName), HttpStatus.OK);
    }

    @GetMapping(path="/network", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getNetwork(){
        fileName = "file:C:\\develpment\\hsbc\\git\\gcp\\basic\\network.json";
        return new ResponseEntity<>(loadJson(fileName), HttpStatus.OK);
    }

    @GetMapping(path="/firewall", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getFirewall(){
        fileName = "file:C:\\develpment\\hsbc\\git\\gcp\\basic\\firewall.json";
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
