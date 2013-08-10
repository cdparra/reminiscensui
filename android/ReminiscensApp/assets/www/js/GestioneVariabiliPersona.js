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
