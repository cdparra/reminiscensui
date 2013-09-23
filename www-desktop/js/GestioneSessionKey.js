// JavaScript Document
var storage = $.localStorage;
function SalvaSessionKey(Key)
{
	storage.set('sessionKey',Key);
}

function SalvaPersonId(Id)
{
	storage.set('personId',Id);
}