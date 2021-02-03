package com.hsbc.poc.cloudui.util;

import org.eclipse.jgit.api.*;
import org.eclipse.jgit.transport.URIish;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import java.io.File;

/*
* To push the code in git repo first checkout the repo in local system and then try to submit.
* */
public class PushToGit {

    public static void pushToRepo() {
        try {

            String localPath = "C:\\develpment\\hsbc\\git\\uicloudtf"; //working
            Git git = Git.open(new File(localPath));

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
            remoteAddCommand.setUri(new URIish("https://github.com/hiteshcloudwork/platformui.git")); //checking
            remoteAddCommand.call();

            // push to remote:
            PushCommand pushCommand = git.push();
           // pushCommand.setCredentialsProvider(new UsernamePasswordCredentialsProvider("pnkjkumar07", "A$tomate1")); //working
            pushCommand.setCredentialsProvider(new UsernamePasswordCredentialsProvider("hiteshcloudwork", "hiteshjaincloud")); //checking
            pushCommand.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        pushToRepo();
    }
}
