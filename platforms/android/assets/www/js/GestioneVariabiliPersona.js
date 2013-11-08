// JavaScript Document
var storage = $.localStorage;
function SetBaseUrl(baseUrl) {
    storage.set('baseUrl', baseUrl);
}

function GetBaseUrl() {
    return storage.get('baseUrl');
}

function SetSessionKey(Key)
{
	storage.set('sessionKey',Key);
}

function GetSessionKey()
{
	return storage.get('sessionKey');
}

function SetPersonId(Id)
{
	storage.set('personId',Id);
}

function GetPersonId()
{
	return storage.get('personId');
}

function SetUserList(userList)
{
	storage.set('userList',userList);
}

function GetUserList()
{
	return storage.get('userList');
}

function SetPersonBirthDate(BirthDate)
{
	storage.set('personBirthDate',BirthDate);
}

function GetPersonBirthDate()
{
	return storage.get('personBirthDate');
}

function SetUserId(Id)
{
	storage.set('userId',Id);
}

function GetUserId()
{
	return storage.get('userId');
}

function GetPersonDeacadeBirthDate()
{
	return storage.get('decadeBirthDate');	
}

function SetPersonDeacadeBirthDate(decade)
{
	storage.set('decadeBirthDate',decade);
}

function GetPersonYearBirthDate()
{
	return storage.get('yearBirthDate');	
}

function SetPersonYearBirthDate(year)
{
	storage.set('yearBirthDate',year);
}

function GetAppVersion() {
    return storage.get('AppVersion');
}

function SetAppVersion(version) {
    storage.set('AppVersion', version);
}

function GetFirstDecade(decadeBirth)
{
    var firstDec = 1900;
    while(firstDec < decadeBirth)
    {
        decade = firstDec;
        var vett = RecuperaMieStorieDecade();
        if(vett.length > 0)
        {
            return firstDec;
        }
        else
        {
            firstDec += 10;
        }
    }
    return decadeBirth;
}

function GetImage(id, isPublic)
{
    if (isPublic) {
        var immaginiPubbliche = storage.get("immaginiPubbliche");
        if (immaginiPubbliche[id]) {
            console.log("immagine recuperata dallo storage");
            return immaginiPubbliche[id];
        }
    }
    else {
        var immaginiPrivate = storage.get("immaginiPrivate");
        if (immaginiPrivate[id]) {
            console.log("immagine recuperata dallo storage");
            return immaginiPrivate[id];
        }
    }
    return null;
}

function GetSetImage(id, fileHashcode, url, ImgId, isPublic)
{
    // Create XHR, Blob and FileReader objects
    var xhr = new XMLHttpRequest(),
        blob,
        fileReader = new FileReader(),
        id,
        ImgId,
        isPublic;

    if (url == null) {
        xhr.open("GET", GetBaseUrl() + "/lifeapi/file/" + fileHashcode + "/SMALL", true);
    }
    else
    {
        xhr.open("GET", url, true);
    }
    // Set the responseType to arraybuffer. "blob" is an option too, rendering manual Blob creation unnecessary, but the support for "blob" is not widespread enough yet
    xhr.responseType = "arraybuffer";


    xhr.addEventListener("load", function () {
        if (xhr.status === 200) {
            // Create a blob from the response
            blob = new Blob([xhr.response], { type: "image/png" });

            // onload needed since Google Chrome doesn't support addEventListener for FileReader
            fileReader.onload = function (evt) {
                // Read out file contents as a Data URL
                var result = evt.target.result;
                // Set image src to Data URL
                var img = document.getElementById(ImgId + id);
                img.setAttribute("src", result);
                // Store Data URL in localStorage
                try {
                    //localStorage.set(id, result);
                    if (isPublic) {
                        var immaginiPubbliche = storage.get("immaginiPubbliche");
                        immaginiPubbliche[id] = result;
                        storage.set("immaginiPubbliche", immaginiPubbliche);
                    }
                    else {
                        var immaginiPrivate = storage.get("immaginiPrivate");
                        immaginiPrivate[id] = result;
                        storage.set("immaginiPrivate", immaginiPrivate);
                    }
                }
                catch (e) {
                    console.log("Storage failed: " + e);
                }

                //return result;
            };
            // Load blob as Data URL
            fileReader.readAsDataURL(blob);
        }
    }, false);
    // Send XHR
    xhr.send();
}


function GetUserFullname()
{
	return storage.get('userFullname');
}

function SetUserFullname(fullname)
{
	storage.set('userFullname',fullname);
}

function GetPersonName()
{
	return storage.get('personName');
}

function SetPersonName(fullname)
{
	storage.set('personName',fullname);
}