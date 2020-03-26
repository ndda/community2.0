function deleteCookie(){
document.cookie = "token=; expires=Thu, 01 Jan 1970 00:00:00 GMT";
/*var date= new Date();
date.setTime(date.getTime() - 1);
var cookieName = getCookie(name);
if(cookieName != null)
document.cookie=name+"=;expires="+date.toGMTString();*/
}

function getCookie(cname)
{
  var name = cname + "=";
  var ca = document.cookie.split(';');
  for(var i=0; i<ca.length; i++)
  {
    var c = ca[i].trim();
    if (c.indexOf(name)==0) return c.substring(name.length,c.length);
  }
  return "";
}