var userName = "gxThtAAgbQwQxDPNyVea";
var passWord = "IKhskLNIaOUkJvdYECsgIEHBmaQgfpeP";

var token_ ;// variable will store the token

var caspioTokenUrl = "https://api.discogs.com/oauth/request_token"; // Your application token endpoint  
var request = new XMLHttpRequest(); 

function getToken(url, clientID, clientSecret) {
    var key;           
    request.open("POST", url, true); 
    request.setRequestHeader("Content-type", "application/json");
    request.send("grant_type=client_credentials&client_id="+clientID+"&"+"client_secret="+clientSecret); // specify the credentials to receive the token on request
    request.onreadystatechange = function () {
        if (request.readyState == request.DONE) {
            var response = request.responseText;
            var obj = JSON.parse(response); 
            key = obj.access_token; //store the value of the accesstoken
            token_ = key; // store token in your global variable "token_" or you could simply return the value of the access token from the function
        }
    }
}
// Get the token
getToken(caspioTokenUrl, userName, passWord);

function CallWebAPI() {
  var request_ = new XMLHttpRequest();        
  var encodedParams = encodeURIComponent(params);
  request_.open("GET", "https://xxx123.caspio.com/rest/v1/tables/", true);
  request_.setRequestHeader("Authorization", "Bearer "+ token_);
  request_.send();
  request_.onreadystatechange = function () {
      if (request_.readyState == 4 && request_.status == 200) {
          var response = request_.responseText;
          var obj = JSON.parse(response); 
          // handle data as needed... 

      }
  }
} 
// var request = require('request'); // "Request" library

// var client_id = 'gxThtAAgbQwQxDPNyVea'; // Your client id
// var client_secret = 'IKhskLNIaOUkJvdYECsgIEHBmaQgfpeP'; // Your secret

// // your application requests authorization
// var authOptions = {
//   url: 'https://api.discogs.com/oauth/access_token',
//   headers: {
//     'Authorization': 'Basic ' + (Buffer.from(client_id + ':' + client_secret).toString('base64'))
//   },
//   form: {
//     grant_type: 'client_credentials'
//   },
//   json: true
// };

// request.post(authOptions, function(error, response, body) {
//   if (!error && response.statusCode === 200) {

//     // use the access token to access the Spotify Web API
//     var token = body.access_token;
//     var options = {
//       url: 'https://api.discogs.com/users/ferrintaylor',
//       headers: {
//         'Authorization': 'Bearer ' + token
//       },
//       json: true
//     };
//     request.get(options, function(error, response, body) {
//       console.log(body);
//     });
//   }
// });