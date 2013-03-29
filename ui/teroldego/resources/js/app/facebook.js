/**
 * CODE COPIED FROM SOURCE CODE OF ANOTHER PROJECT, NOT YET READY
 * This file contains the scripts required for the interaction with facebook.
 */

/* Facebook's initialization parameters */
var fbInitParams = {
	/*
	 * The ID of the application registered in facebook. Facebook needs this in
	 * order to authenticate our application.
	 */
	appId : '177901662342635', // whatsup display temp
	/* Check login status. */
	status : true,
	/* Enables cookies to allow the server to access the session. */
	cookie : true,
	/* Enable XFBML parsing. */
	xfbml : true,
	/* Enables the authentication dialogue. */
	oauth : true

};

/* The Facebook's login function. */
var fbLogin = function(response) {
	if (response.authResponse) {
		FB.api('/me', function(response) {
			consoleLog('Good to see you, ' + response.name + '.');
		});
	} else {
		consoleLog('User cancelled login or did not fully authorize.');
	}
};

/* The scopes for the Facebook's login. */
var fbLoginScopes = {
	scope : 'email'
};

/*
 * Checks the response of facebook (the user status on facebook). Runned by the
 * FB.getLoginStatus in the initFB()
 */
var checkFbStatus = function(response) {
	consoleLog("Facebook status ready.");

	/* Checks the facebook's status. */
	if (response.status == "connected") {
		/*
		 * The user is logged in and has authenticated your app, and
		 * response.authResponse supplies the user's ID, a valid access token, a
		 * signed request, and the time the access token and signed request each
		 * expire
		 */
		consoleLog("The user status is: " + response.status);
		/*
		 * Gets the accessToken needed by our application to interact with
		 * facebook's user's profile.
		 */
		var accessToken = response.authResponse.accessToken;
		/* Log the user in our application. */
		displayLogin(accessToken);
	} else if (response.status == 'not_authorized') {
		/*
		 * The user is logged in to Facebook, but has not authenticated your app
		 */
		consoleLog("The user status is: " + response.status);
		FB.login(fbLogin,fbLoginScopes);
	} else {
		/* The user isn't logged in to Facebook. */
		consoleLog("The user status is: " + response.status);
		FB.login(fbLogin,fbLoginScopes);
	}
};

/*
 * The starting point of the application. Facebook interaction is required by
 * application.
 */
function initFb() {
    
	/* Facebook initialization. Validation of the application. */
	FB.init(fbInitParams);
	/* Facebook status check. Runs the checkFbStatus(response). */
	FB.getLoginStatus(function(response) {
		checkFbStatus(response);
		/*
		 * Fired when the user status changes. Check the response for the
		 * result. Fired even by the FB.init() if status : true
		 */
                FB.Event.subscribe('auth.authResponseChange', checkFbStatus);
                
	});
}