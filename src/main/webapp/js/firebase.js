// Initialize Firebase
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
// [START buttoncallback]
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
// [END buttoncallback]

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
			
			console.info("Logged UserName")
			console.info(displayName);
			
			console.info("Logged Email")
			console.info(email);
			
			console.info("Logged UID")
			console.info(uid);
			
			console.info("Photo Url")
			console.info(photoURL);
			
			
			// [START_EXCLUDE]
			$('#quickstart-sign-in-status').text('Signed in');			
			
			$('#quickstart-sign-in').html("<i class='fa fa-google-plus'></i>" + email + '\n Sign out ' +"");		
			
			// [END_EXCLUDE]
		} else {
			// User is signed out.
			// [START_EXCLUDE]
			$('#quickstart-sign-in-status').text('Signed out');
			
			$('#quickstart-sign-in').html("<i class='fa fa-google-plus'></i>" + 'Sign in with Google');
	
			// [END_EXCLUDE]
		}
		// [START_EXCLUDE]		
		$('#quickstart-sign-in').attr("disabled", false);
		// [END_EXCLUDE]
	});
	// [END authstatelistener]	
	$('#quickstart-sign-in').click(toggleSignIn);
}

window.onload = function() {
	initApp();
};
