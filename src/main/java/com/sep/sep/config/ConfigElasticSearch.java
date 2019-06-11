package com.sep.sep.config;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

import javax.annotation.PostConstruct;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;

import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import com.sep.sep.elasticsearch.Article;
import com.sep.sep.elasticsearch.ArticleRepository;
import com.sep.sep.elasticsearch.Magazine;
import com.sep.sep.elasticsearch.MagazineRepository;
import com.sep.sep.elasticsearch.ScienceArea;


@Configuration
@EnableElasticsearchRepositories(basePackages = "com.sep.sep.elasticsearch")
@ComponentScan(basePackages = { "com.sep.sep.elasticsearch;" })
public class ConfigElasticSearch {

	
	
	
	
	 @Value("${elasticsearch.home:/usr/local/Cellar/elasticsearch/5.6.0}")
	    private String elasticsearchHome;

	    @Value("${elasticsearch.cluster.name:elasticsearch}")
	    private String clusterName;

	    @Bean
	    public Client client() {
	        TransportClient client = null;
	        try {
	            final Settings elasticsearchSettings = Settings.builder()
	              .put("client.transport.sniff", true)
	              .put("path.home", elasticsearchHome)
	              .put("cluster.name","elasticsearch").build();
	            client = new PreBuiltTransportClient(elasticsearchSettings);
	            client.addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
	        } catch (UnknownHostException e) {
	            e.printStackTrace();
	        }
	        return client;
	    }

	    @PostConstruct
	    @Bean
	    public ElasticsearchOperations elasticsearchTemplate() {
	    	
	    	
	    	
	        return new ElasticsearchTemplate(client());
	    }
}
