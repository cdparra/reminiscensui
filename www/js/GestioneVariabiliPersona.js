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
	return storage.get('deacadeBirthDate');	
}

function SetPersonDeacadeBirthDate(decade)
{
	storage.set('deacadeBirthDate',decade);
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