package com.sep.sep.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.camunda.bpm.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonValue;
import com.sep.sep.controller.dto.SWorkDTO;
import com.sep.sep.controller.dto.ScientificWorkDTO;
import com.sep.sep.controller.dto.TransactionDTO;
import com.sep.sep.model.Magazine;
import com.sep.sep.model.Membership;
import com.sep.sep.model.RegUser;
import com.sep.sep.model.ScienceArea;
import com.sep.sep.model.ScientificWork;
import com.sep.sep.model.Transaction;
import com.sep.sep.repository.MagazineRepository;
import com.sep.sep.repository.ScienceAreaRepository;
import com.sep.sep.service.ScientificWorkService;



@RestController
@RequestMapping("/swork")
@CrossOrigin(origins="http://localhost:3000",allowedHeaders="*")
public class ScientificWorkController {
	
	private static final String fp = System.getProperty("user.dir");

	
	@Autowired
	private ScientificWorkService scientificWorkService;
	
	@Autowired
	private MagazineRepository magazineRepository;
	
	@Autowired
	private ScienceAreaRepository saRepository;
	
	@Autowired
	private TaskService taskService;
	
	
	@JsonValue
	@GetMapping("/getSWorks")
	public List<ScientificWork> getWorks() {

		System.out.println("USAOOO");
		List<ScientificWork> listw=scientificWorkService.getAllScientificWorks();
		return listw;

	}
	
	@JsonValue
	@GetMapping("/getWorksByIds")
	public List<ScientificWork> getWorksByIds(@RequestParam("magazineid") String magazineid,@RequestParam("editionid") String editionid) {
		
		System.out.println("POGODIO OVO BRE");

		
		Long m=new Long(Long.parseLong(magazineid));
		Long e=new Long(Long.parseLong(editionid));
		
		System.out.println(m);
		System.out.println(e);
		
		List<ScientificWork> listw=scientificWorkService.getWorksByMagazineAndEdition(m,e);
		
		
		return listw;

	}
	
	
	@SuppressWarnings("resource")
	@PostMapping("/create")
	public String createScientificWork(@RequestParam("file") MultipartFile file) {
		
		System.out.println("pogodak");
		InputStream inputStream = null;
		OutputStream outputStream = null;
		String fpp=new String(fp+"\\MagazineBase\\");
		
		 String fileName = file.getOriginalFilename();
		    File newFile = new File(fpp + fileName);
		    System.out.println(newFile.getAbsolutePath());

		    try {
		        inputStream = file.getInputStream();

		        if (!newFile.exists()) {
		            newFile.createNewFile();
		        }
		        outputStream = new FileOutputStream(newFile);
		        int read = 0;
		        byte[] bytes = new byte[1024];

		        while ((read = inputStream.read(bytes)) != -1) {
		            outputStream.write(bytes, 0, read);
		        }
		        outputStream.close();
		      
		    } catch (IOException e) {
		        e.printStackTrace();
		    }	
        	
	
		return "success";
	}

	
	@PostMapping("/save")
	public String saveScientificWork(@RequestBody SWorkDTO swork) {
		
		
		ScientificWork sw = new ScientificWork();
		sw.setName(swork.getName());
		sw.setAbstractt(swork.getAbstractt());
		String pomk = new String("");
		for(int i=0;i<swork.getKeywords().size();i++){
			pomk=pomk+" "+swork.getKeywords().get(i);
			
		}
		sw.setKeywords(pomk);
		
		String pomc = new String("");
		for(int j=0;j<swork.getKeywords().size();j++){
			pomc=pomc+" "+swork.getCoauthors().get(j);
			
		}
		sw.setCoauthors(pomk);
		sw.setPdf(swork.getPdf());
		Magazine m=magazineRepository.findOneById(swork.getMagid());
		sw.setMagazine(m);
		ScienceArea sa= saRepository.findScienceArea(swork.getArea());
		sw.setArea(sa);
		scientificWorkService.saveScientificWork(sw);
		
        Map<String, Object> variables = new HashMap<>();
		
		variables.put("title",swork.getName());
		variables.put("keywords",swork.getKeywords());
		variables.put("scientificarea",swork.getArea());
		variables.put("abstract", swork.getAbstractt());
		variables.put("coauthors", swork.getCoauthors());
		
		
		taskService.complete(swork.getTaskid(),variables);
		
		return "success";
	}
}
