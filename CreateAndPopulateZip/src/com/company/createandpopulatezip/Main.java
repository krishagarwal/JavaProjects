package com.company.createandpopulatezip;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        String[] lines = {
	            "This is the first line of text...",
                "This is the second line of text...",
                "This is the third line of text...",
                "This is the fourth line of text...",
                "This is the fifth line of text..."
        };

	    try(FileSystem zipFS = openZip(Paths.get("testZip.zip"))){
            copyToZip(zipFS);
            writeToFileInZip1(zipFS, lines);
            writeToFileInZip2(zipFS, lines);
        } catch (Exception e){
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    private static FileSystem openZip(Path zipPath) throws IOException, URISyntaxException {
        Map<String, String> providerProperties = new HashMap<>();
        providerProperties.put("create", "true");

        URI zipURI = new URI("jar:file", zipPath.toUri().getPath(), null);
        FileSystem zipFS = FileSystems.newFileSystem(zipURI, providerProperties);

        return zipFS;
    }

    private static void copyToZip(FileSystem zipFS) throws IOException{
        Path sourceFile = Paths.get("file1.txt");
        Path destFile = zipFS.getPath("/file1Copied.txt");

        Files.copy(sourceFile, destFile, StandardCopyOption.REPLACE_EXISTING);
    }

    private static void writeToFileInZip1(FileSystem zipFS, String[] lines) throws IOException{
        try(BufferedWriter writer = Files.newBufferedWriter(zipFS.getPath("/typedFile1.txt"))){
            for(String l : lines){
                writer.write(l);
                writer.newLine();
            }
        }

    }

    private static void writeToFileInZip2(FileSystem zipFS, String[] lines) throws IOException{

        Files.write(zipFS.getPath("/typedFile2.txt"), Arrays.asList(lines), Charset.defaultCharset(), StandardOpenOption.CREATE);
    }
}
