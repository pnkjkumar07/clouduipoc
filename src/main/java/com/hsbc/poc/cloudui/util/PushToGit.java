package com.hsbc.poc.cloudui.util;

import org.eclipse.jgit.api.*;
import org.eclipse.jgit.transport.URIish;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

/*
* To push the code in git repo first checkout the repo in local system and then get access to that repo for git push/commit
* after that try to submit.
* */
public class PushToGit {

    @Autowired
    private static ConfigUtility configUtil;

    public static void pushToRepo() {
        try {

            //String localPath = "C:\\develpment\\hsbc\\git\\HiteshUIRepo"; //working pankaj
            //String localPath = "D:\\CloudUI_HiteshRepo"; //working prarthana

            String gitlocalPath = null;

            if(null == configUtil){
                gitlocalPath = "/home/hitesh_cloudwork/decoder/servicelayer/repo/platformui";
            } else{
                gitlocalPath = configUtil.getProperty("git_local_path");//"D:\\platformui";  //hitesh
            }

            Git git = Git.open(new File(gitlocalPath));

            // Stage all files in the repo including new files
            git.add().addFilepattern(".").call();

            // and then commit the changes.
            git.commit()
                    .setMessage("Commit all changes including additions")
                    .call();

            // add remote repo:
            RemoteAddCommand remoteAddCommand = git.remoteAdd();
            remoteAddCommand.setName("origin");
            //remoteAddCommand.setUri(new URIish("https://github.com/pnkjkumar07/uicloudtf.git")); //working
            //remoteAddCommand.setUri(new URIish("https://github.com/hiteshcloudwork/platformui.git")); //checking
            String git_remote_url = null;
            if(null == configUtil){
                git_remote_url = "https://github.com/hiteshcloudwork/platformui.git";
            } else{
                git_remote_url = configUtil.getProperty("git_remote_url");
            }
            remoteAddCommand.setUri(new URIish(git_remote_url)); //checking
            remoteAddCommand.call();

            // push to remote:
            PushCommand pushCommand = git.push();
           // pushCommand.setCredentialsProvider(new UsernamePasswordCredentialsProvider("pnkjkumar07", "A$tomate1")); //working
            String git_username = null;
            String git_password = null;
            if(configUtil == null){
                git_username = "hiteshcloudwork";
                git_password = "hiteshjaincloud";
            } else {
                git_username = configUtil.getProperty("git_username");
                git_password = configUtil.getProperty("git_password");
            }
            System.out.println("git_remote_url="+git_remote_url + "\r\n git_username = "+git_username +"\r\n git_password = "+git_password);
            pushCommand.setCredentialsProvider(new UsernamePasswordCredentialsProvider(git_username, git_password)); //checking
            pushCommand.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        pushToRepo();
    }
}
