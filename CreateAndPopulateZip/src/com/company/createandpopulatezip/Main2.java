package com.company.createandpopulatezip;

import java.io.BufferedWriter;
import java.io.File;
import java.nio.file.FileSystem;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {

    public static void main (String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Zip File Explorer!");

        System.out.println("Enter 'e' to exit.");
        System.out.println("Enter 'c' to create a new zip file.");
        System.out.println("Enter any other character to open an existing zip file.");
        String firstInput = scanner.nextLine();

        while(true) {

            if(firstInput.equalsIgnoreCase("e")){
                System.out.println("Thank you for using Zip File Explorer!");
                return;
            }

            System.out.println("What is the location of this zip file? (Excluding the zip file name itself)");
            String zipLocation = scanner.nextLine();

            System.out.println("What is the zip file name?");
            String fileName = scanner.nextLine();

            if (fileName.length() < 4 || !fileName.substring(fileName.length() - 4).equals(".zip")) {
                fileName += ".zip";
            }

            if (fileName.length() > 0 && (fileName.charAt(0) == '\\' || fileName.charAt(0) == '/')) {

                StringBuilder fileNameSB = new StringBuilder(fileName);

                while (fileNameSB.length() > 0) {
                    if (fileNameSB.charAt(0) == '\\' || fileNameSB.charAt(0) == '/') {
                        fileNameSB.deleteCharAt(0);
                    } else {
                        break;
                    }
                }

                fileName = fileNameSB.toString();
            }

            try (FileSystem fs = openZip(Paths.get(zipLocation + "\\" + fileName))) {
                if (firstInput.equals("c")) {
                    System.out.println("File " + fileName + " was successfully created!\n");
                } else {
                    System.out.println("File " + fileName + " was successfully opened!\n");
                }
                break;

            } catch (Exception e) {
                System.out.println("Something went wrong: " + e.getMessage() + ". Please try again.\n");
            }
        }


//        try(FileSystem fileSystem = openZip(Paths.get("testZip2.zip"))){
//
//            copyFileToZip(fileSystem, "copyFile", "it");
//            createAndWriteToFileInZip(fileSystem, "createdFile", "a", "b");
//
//
//        } catch (Exception e){
//            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
//        }
    }

    private static FileSystem openZip(Path zipPath) throws IOException, URISyntaxException{
        Map<String, String> properties = new HashMap<>();

        properties.put("create", "true");

        URI zipURI = new URI("jar:file", zipPath.toUri().getPath(), "");

        return FileSystems.newFileSystem(zipURI, properties);
    }

    private static void copyFileToZip(FileSystem fileSystem, String sourceFileName, String destFileName) throws IOException{

        if(sourceFileName.length() < 4 || !sourceFileName.substring(sourceFileName.length() - 4).equals(".txt")){
            sourceFileName += ".txt";
        }

        if(destFileName.length() < 4 || !destFileName.substring(destFileName.length() - 4).equals(".txt")){
            destFileName += ".txt";
        }

        Path sourceFile = Paths.get(sourceFileName);
        Path destFile = fileSystem.getPath(destFileName);

        Files.copy(sourceFile, destFile, StandardCopyOption.REPLACE_EXISTING);
    }

    private static void createAndWriteToFileInZip(FileSystem fileSystem, String fileName, String... lines) throws IOException{

        if(fileName.length() < 4 || !fileName.substring(fileName.length() - 4).equals(".txt")){
            fileName += ".txt";
        }

        try(BufferedWriter writer = Files.newBufferedWriter(fileSystem.getPath(fileName))){
            for(String l : lines){
                writer.write(l);
                writer.newLine();
            }
        }
    }


//    private static void deleteFileInZip(FileSystem fileSystem, String fileName){
//
//        File file = new File(fileSystem.getPath(fileName).toUri());
//        file.delete();
//
//    }
}
