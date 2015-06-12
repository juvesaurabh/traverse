package com.project;

import java.io.*;
import java.util.*;


public class FileTraverse {

    public FileTraverse() {
    }

    private ArrayList<String> output1 = new ArrayList<String>();
    private ArrayList<DetailedInfo> output2 = new ArrayList<DetailedInfo>();
    private Queue q = new ArrayDeque();


    public static void main(String[] args) {

        String root = args[0];
        String method = args[1];
        FileTraverse m = new FileTraverse();

        try {
            m.walkthroughFS(root, method);

            m.printOutput(method);


        } catch (FileNotFoundException ex)
        {
            System.out.println("FileNotFound: "+ex);
        }
    }

    private void walkthroughFS(String path, String method) throws FileNotFoundException{

        File filepath = new File(path);
        if(filepath.isDirectory()){
            //System.out.println("This is our root");

            if(method.toLowerCase().equalsIgnoreCase("bfs")){
                buildOutput(filepath); //visiting root node
                bfs(filepath);
            }

            else
                dfs(filepath);

        }else {
            System.out.println("Root needs to be a dir");

        }

    }

    private void dfs(File ff) {

        buildOutput(ff);
        if(ff.isDirectory()){
            File[] listing = ff.listFiles();
            for(File f: listing){

                if (f.isDirectory()) {
                    dfs(f); //recursively call for encountered sub-folders
                }else
                    buildOutput(f);
            }
            //dfsFileSearch(ff);
        }
    }

    private void bfs(File ff){


        File[] l = ff.listFiles();
        for (File f : l) {
            q.add(f);
            buildOutput(f);

        }
        while(!q.isEmpty()){
            File qf = (File)q.remove();
            if(qf.isDirectory()) {
                bfs(qf); //recursively call for encountered sub-folders
            }

        }
    }

    private void addtoOutput2(File fff){
        DetailedInfo di = new DetailedInfo();
        di.setAbsolutePath(fff.getAbsolutePath());
        di.setModifiedDate(new Date(fff.lastModified()));
        di.setSize(fff.length());

        output2.add(di);

    }

    private void buildOutput(File f){

        output1.add(f.getAbsolutePath());
        addtoOutput2(f);

    }

    private void printOutput(String method) {

        //System.out.println("output1 Size: "+output1.size());
        //System.out.println("output2 Size: "+output2.size());

        System.out.println("============"+method+" Flat Listing Output1=================");
        //printing output1
        for(int i=0;i< output1.size();i++){

            System.out.println(output1.get(i).toString()); //return listing
        }
        System.out.println("============"+method+" Flat Listing Output1=================");
        System.out.println("=================================================");
        System.out.println("============"+method+" Pipe Delimited Output2=================");
        //printing output2
        for (int j=0;j<output2.size();j++){
            String p1=output2.get(j).getAbsolutePath();
            String p2=output2.get(j).getSize().toString();
            String p3=output2.get(j).getModifiedDate().toString();
            System.out.println(p1+"|"+p2+"|"+p3);
        }
        System.out.println("============"+method+" Pipe Delimited Output2=================");


    }
}
