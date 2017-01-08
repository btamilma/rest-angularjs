package com.balatamilmani.batch.sample;

import java.io.File;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class ZipCreatorTasklet implements Tasklet{

	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		String dirPath = chunkContext.getStepContext().getJobParameters().get("dirPath").toString();
		System.out.println(dirPath);
		System.out.println("java.io.tmpdir->"+System.getProperty("java.io.tmpdir"));
		System.out.println("File.separator->"+File.separator);
		Files.write(Paths.get(System.getProperty("java.io.tmpdir")+File.separator+"test.txt"), "sample content test".getBytes());
		
		Map<String, String> env = new HashMap<>(); 
        env.put("create", "true");
        // locate file system by using the syntax 
        // defined in java.net.JarURLConnection
        URI uri = URI.create("jar:file:"+dirPath+"/zipfstest.zip");
        
       try (FileSystem zipfs = FileSystems.newFileSystem(uri, env)) {
            Path externalTxtFile = Paths.get(dirPath+"/employee.csv");
            Path pathInZipfile = zipfs.getPath("/employee.csv");          
            // copy a file into the zip file
            Files.copy( externalTxtFile,pathInZipfile, 
                    StandardCopyOption.REPLACE_EXISTING ); 
        } 
		return RepeatStatus.FINISHED;
	}

}
