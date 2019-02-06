package com.sep.sep.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/download")
public class FileDownloadController {
	
	private static final String fp = System.getProperty("user.dir");
	
	@GetMapping("/file/{fileName:.+}")
	public ResponseEntity<byte[]> downloadPDFResource(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("fileName") String fileName) throws IOException {
		
		
		
		System.out.println(fp + " ovo je trenutnoo");
		
		
		
		String fpp=new String(fp+"\\MagazineBase\\");
		System.out.println(fpp);
		
		 Path path = Paths.get(fpp+fileName);
		    byte[] pdfContents = null;
		    try {
		        pdfContents = Files.readAllBytes(path);
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		    HttpHeaders headers = new HttpHeaders();
		    headers.setContentType(MediaType.parseMediaType("application/pdf"));
		    String filename = fileName;
		   
		    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		  
		    headers.add("content-disposition", "inline;filename=" + fileName);
		   
		    
		    ResponseEntity<byte[]> resp = new ResponseEntity<byte[]>(
		                pdfContents, headers, HttpStatus.OK);
		    
		    
		    
		return resp;
			
		

		
	}

}
