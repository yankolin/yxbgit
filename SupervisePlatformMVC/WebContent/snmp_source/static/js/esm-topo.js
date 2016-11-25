	for(var i = 1; i < 8; i++) {
			document.getElementById('imgTopoSA_'+i).src="static/img/switch.gif"; 
			document.getElementById('imgTopoSB_'+i).src="static/img/switch.gif";
			document.getElementById('imgTopoSC_'+i).src="static/img/switch.gif"; 
		}
		for(var i = 1; i < 13; i++) {
			document.getElementById('imgTopoA_'+i).src="static/img/green-1.gif";
		}
		for(var i = 1; i < 17; i++) {

			document.getElementById('imgTopoB_'+i).src="static/img/red-1.gif"; 
			document.getElementById('imgTopoC_'+i).src="static/img/green-3.gif"; 
			document.getElementById('imgTopoD_'+i).src="static/img/red-1.gif"; 
			document.getElementById('imgTopoE_'+i).src="static/img/green-1.gif"; 
			document.getElementById('imgTopoF_'+i).src="static/img/red-1.gif"; 
			document.getElementById('imgTopoG_'+i).src="static/img/red-1.gif"; 
			document.getElementById('imgTopoH_'+i).src="static/img/yellow-1.gif"; 
		}

function imgShowInfo(e) {

	var imgID = e.id;
	/*document.getElementById("lblToNum").innerHTML = imgID;
	document.getElementById("lblToCPU").innerHTML = 89;
	document.getElementById("lblToMem").innerHTML=8978877678;
	document.getElementById("lblToStor").innerHTML="340.56GB";*/
	$('#show_modal').modal('show')
	//alert(e.id);
  	console.log(e);
}