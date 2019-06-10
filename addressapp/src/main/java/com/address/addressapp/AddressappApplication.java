package com.address.addressapp;

import java.io.InputStream;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509ExtendedTrustManager;

import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AddressappApplication {
	
	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext ctx = SpringApplication.run(AddressappApplication.class, args);
		
		
		AddressAccessAPI addressAPI = ctx.getBean(AddressAccessAPI.class);
		//ctx.close();
		
		// interface responsible for managing the trust material/validate the SSL Layer
		// Gives access cert to the getAddress.io api
		TrustManager[] trustAllCerts = new TrustManager[] {
				// extensions of the X509TrustManager interface supports SSL/TLS connection sensitive trust management
				new X509ExtendedTrustManager() {
					@Override
		            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
					
					@Override
					public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
					}
					
					@Override
					public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
					}
					
					@Override
					public void checkServerTrusted(X509Certificate[] arg0, String arg1, SSLEngine arg2) throws CertificateException {

					}
					
					@Override
					public void checkServerTrusted(X509Certificate[] arg0, String arg1, Socket arg2) throws CertificateException {

					}
					
					@Override
					public void checkClientTrusted(X509Certificate[] arg0, String arg1, SSLEngine arg2) throws CertificateException {

					}
					
					@Override
					public void checkClientTrusted(X509Certificate[] arg0, String arg1, Socket arg2) throws CertificateException {
					}
				}
			};
		
		// secures socket protocol implementation
		SSLContext sc = SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, new java.security.SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		
		// creating all-trusting host name verifier
		HostnameVerifier allHostValid = new HostnameVerifier() {
			@Override
			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		};
		
		// install the all-trusting host verifier
		HttpsURLConnection.setDefaultHostnameVerifier(allHostValid);
		// end of SSL trust fix
			
	}
	
	

}


