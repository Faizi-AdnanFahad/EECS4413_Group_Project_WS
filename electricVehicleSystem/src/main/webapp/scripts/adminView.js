function showProfile() 
{
	document.getElementById("profileSection").style.display = "block";
	document.getElementById("appUsageSection").style.display = "none";
	document.getElementById("vehicleSalesSection").style.display = "none";
}


function showVehicleSales() 
{
	document.getElementById("profileSection").style.display = "none";
	document.getElementById("appUsageSection").style.display = "none";
	document.getElementById("vehicleSalesSection").style.display = "block";
        }

function signOut() 
{
 	alert("Signing out...");
}