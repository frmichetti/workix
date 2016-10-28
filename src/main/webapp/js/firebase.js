//Initialize Firebase
var config = {
		apiKey: "AIzaSyDtccrM2X2IqflZ9BZYCSDQ46DpvYHk1i8",
		authDomain: "akijob-2a6bc.firebaseapp.com",
		databaseURL: "https://akijob-2a6bc.firebaseio.com",
		storageBucket: "akijob-2a6bc.appspot.com",
		messagingSenderId: "289835208718"
};

firebase.initializeApp(config);


/**
 * Function called when clicking the Login/Logout button.
 */
//[START buttoncallback]
function toggleSignIn() {

	if (!firebase.auth().currentUser) {
		// [START createprovider]
		var provider = new firebase.auth.GoogleAuthProvider();
		// [END createprovider]

		// [START addscopes]
		provider.addScope('https://www.googleapis.com/auth/plus.login');
		// [END addscopes]
		
		// [START signin]
		firebase.auth().signInWithPopup(provider).then(function(result) {
			// This gives you a Google Access Token. You can use it to access the Google API.
			var token = result.credential.accessToken;
			// The signed-in user info.
			var user = result.user;

			loggedUser = user;
			// [START_EXCLUDE]
			$('#quickstart-oauthtoken').text(token);			
			// [END_EXCLUDE]
		}).catch(function(error) {
			// Handle Errors here.
			var errorCode = error.code;
			var errorMessage = error.message;
			// The email of the user's account used.
			var email = error.email;
			// The firebase.auth.AuthCredential type that was used.
			var credential = error.credential;
			// [START_EXCLUDE]
			if (errorCode === 'auth/account-exists-with-different-credential') {
				alert('You have already signed up with a different auth provider for that email.');
				// If you are using multiple auth providers on your app you should handle linking
				// the user's accounts here.
			} else {
				console.error(error);
			}
			// [END_EXCLUDE]
		});
		// [END signin]
	} else {
		// [START signout]
		firebase.auth().signOut();
		// [END signout]
	}
	// [START_EXCLUDE]	
	$('#quickstart-sign-in').attr("disabled", true);

	// [END_EXCLUDE]	
}



//[END buttoncallback]

/**
 * initApp handles setting up UI event listeners and registering Firebase auth listeners:
 *  - firebase.auth().onAuthStateChanged: This listener is called when the user is signed in or
 *    out, and that is where we update the UI.
 */
function initApp() {

	// Listening for auth state changes.
	// [START authstatelistener]
	firebase.auth().onAuthStateChanged(function(user) {

		if (user) {
			// User is signed in.
			var displayName = user.displayName;

			var email = user.email;

			var emailVerified = user.emailVerified;

			var photoURL = user.photoURL;

			var isAnonymous = user.isAnonymous;

			var uid = user.uid;

			var providerData = user.providerData;
			
			console.warn("[Logged UserName] " + displayName);			

			console.warn("[Logged Email] " + email);			

			console.warn("[Logged UID] " + uid);			

			console.warn("[Photo Url] " + photoURL);
			
			console.warn("[Provider Data] " + providerData)
			
			if (user != null) {			
				
				providerData.forEach(function (profile) {
				    
					console.log("Sign-in provider: " + profile.providerId);
				    
				    console.log("  Provider-specific UID: " + profile.uid);
				    
				    console.log("  Name: " + profile.displayName);
				    
				    (displayName == null) ? displayName = profile.displayName : displayName;
				    
				    console.log("  Email: " + profile.email);
				    
				    console.log("  Photo URL: " + profile.photoURL);
				    
				    (photoURL == null) ? photoURL = profile.photoURL : photoURL;
				  });
				}	

		

			// [START_EXCLUDE]
			$('#quickstart-sign-in-status').text('Signed in');			

			$('#quickstart-sign-in').html("<i class='fa fa-google-plus'></i>" + email + '\n Sign out ' +"");		
			
			$('#fbtoken').text(displayName);			

			/****BootsTrap Notify**/
			
			$.notify({
				icon: photoURL,
				title: 'Bem Vindo ! ' + ((displayName == null) ? "Visitante" : displayName),
				message: 'Seu Email - ' + ((email == null) ? "Ainda não logado" : email)
			},{
				type: 'minimalist',
				
				animate: {
					enter: 'animated zoomInDown',
					exit: 'animated zoomOutUp'
				},
				
				allow_dismiss: true,
				
				position: null,placement: {
					from: "bottom",
					align: "center"
				},
				
				
				delay: 5000,
				
				icon_type: 'image',
				template: 
					'<div data-notify="container" class="col-xs-11 col-sm-3 alert alert-{0}" role="alert">' +
					'<button type="button" aria-hidden="true" class="close" data-notify="dismiss">×</button>' +
					'<img data-notify="icon" class="img-circle pull-left" />' +
					'<span data-notify="title">{1}</span>' +
					'<span data-notify="message">{2}</span>' +
				'</div>'
			});

			 


			// [END_EXCLUDE]
		} else {
			// User is signed out.
			// [START_EXCLUDE]
			$('#quickstart-sign-in-status').text('Signed out');

			$('#quickstart-sign-in').html("<i class='fa fa-google-plus'></i>" + 'Sign in with Google');			
			
			$.notify({
				icon: photoURL,
				title: 'Logout ',
				message: ((email == null) ? "Logout Realizado com sucesso" : email)
			},
			
			
			{
				type: 'minimalist',
				delay: 5000,
				
				animate: {
					enter: 'animated zoomInDown',
					exit: 'animated zoomOutUp'
				},
				
				allow_dismiss: true,
				
				position: null,placement: {
					from: "bottom",
					align: "center"
				},
				
				icon_type: 'image',
				template: 
					'<div data-notify="container" class="col-xs-11 col-sm-3 alert alert-{0}" role="alert">' +
					'<img data-notify="icon" class="img-circle pull-left" />' +
					'<span data-notify="title">{1}</span>' +
					'<span data-notify="message">{2}</span>' +
				'</div>'
			});

			// [END_EXCLUDE]
		}
		// [START_EXCLUDE]		
		$('#quickstart-sign-in').attr("disabled", false);
		// [END_EXCLUDE]	
		

		
		
	});
	// [END authstatelistener]	
	//$('#quickstart-sign-in').click(toggleSignIn);
	document.getElementById('quickstart-sign-in').addEventListener('click', toggleSignIn, false);
}

window.onload = function() {
	initApp();
};
