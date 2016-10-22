package br.com.codecode.openjobs.bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.tasks.OnSuccessListener;

@SessionScoped
@Named
@ManagedBean
public class FirebaseMB implements Serializable {

	private String name,email,uid,photo;

	private String idToken;

	private static final long serialVersionUID = -6683482350467577281L;
	
	private URL url;

	public FirebaseMB() {
		System.out.println("[CDI] " + getClass().getSimpleName());
	}

	@PostConstruct
	private void init(){

		System.out.println("Post Construct");

		
		try {
			
			url = new URL("http://localhost:8080/jobs/google-services.json");
			
			System.out.println(url.getProtocol());
			
			
			
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  

		

		
	}

	private void initFirebaseConfig(URI uri) throws FileNotFoundException {

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setServiceAccount(new FileInputStream(new File(uri)))					
				.build();

		FirebaseApp.initializeApp(options);

		FirebaseAuth.getInstance().verifyIdToken(idToken)		
		.addOnSuccessListener(new OnSuccessListener<FirebaseToken>() {

			@Override
			public void onSuccess(FirebaseToken decodedToken) {

				uid = decodedToken.getUid();

				email = decodedToken.getEmail();

				name = decodedToken.getName();

				photo = decodedToken.getPicture();

				// ...
			}



		});



	}

	public String getIdToken() {
		System.out.println(idToken);
		return idToken;
	}

	public void setIdToken(String idToken) {
		this.idToken = idToken;
	}


	public String getEmail() {
		System.out.println("Email = " + email);
		return email;		
	}

	public String getPhoto() {
		return photo;
	}

	public String getName() {
		System.out.println("Name = " + name);
		return name;
	}

	public String getUid() {
		System.out.println("UID = " + uid);
		return uid;		
	}



}
