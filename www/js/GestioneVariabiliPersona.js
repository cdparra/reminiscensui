// JavaScript Document
var storage = $.localStorage;
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