<?php

$send_to = 'youremail@gmail.com';

$errors         = array();  	// array to hold validation errors
$data 			= array(); 		// array to pass back data

// validate the variables ======================================================
	// if any of these variables don't exist, add an error to our $errors array

	if (empty($_POST['contact-name']))
		$errors['name'] = 'Name is required.';

	if (empty($_POST['contact-email']))
		$errors['email'] = 'Email is required.';

	if (empty($_POST['contact-subject']))
		$errors['subject'] = 'Subject is required.';

	if (empty($_POST['contact-message']))
		$errors['message'] = 'Message is required.';

// return a response ===========================================================

	// if there are any errors in our errors array, return a success boolean of false
	if ( ! empty($errors)) {

		// if there are items in our errors array, return those errors
		$data['success'] = false;
		$data['errors']  = $errors;
	} else {

		// if there are no errors process our form, then return a message

    	//If there is no errors, send the email
    	if( empty($errors) ) {

			$subject = 'Contact Form';
			$headers = 'From: ' . $send_to . "\r\n" .
			    'Reply-To: ' . $send_to . "\r\n" .
			    'X-Mailer: PHP/' . phpversion();

        	$message = 'Name: ' . $_POST['contact-name'] . '

Email: ' . $_POST['contact-email'] . '

Subject: ' . $_POST['contact-subject'] . '

Message: ' . $_POST['contact-message'];

        	$headers = 'From: Contact Form' . '<' . $send_to . '>' . "\r\n" . 'Reply-To: ' . $_POST['contact-email'];

        	mail($send_to, $subject, $message, $headers);

    	}

		// show a message of success and provide a true success variable
		$data['success'] = true;
		$data['message'] = 'Thank you!';
	}

	// return all our data to an AJAX call
	echo json_encode($data);