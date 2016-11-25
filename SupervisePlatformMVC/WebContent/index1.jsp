<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head lang="en">
	<meta charset="UTF-8">
  
<link rel="stylesheet" type="text/css" href="/static/css/ingrid.css">
<link rel="stylesheet" type="text/css" href="/static/css/bootstrap.css">


        

</head>

<body>

<div id="example" tabindex="9999" class="modal hide fade in">
<div class="modal-header">
<a class="close" data-dismiss="modal">Ã</a>
<h3>This is a Modal Heading</h3>
</div>
<div class="modal-body">
<h4>Text in a modal</h4>
<p>You can add some text here.</p>		        
</div>
<div class="modal-footer">
<a href="#" class="btn btn-success">Call to action</a>
<a href="#" class="btn" data-dismiss="modal">Close</a>
</div>
</div>

    
    
<table id="table1" style="margin-top:200px">

<thead>

    <tr>
		<th>åºå·</th>
      <th>æ¥æ</th>

      <th>å°å</th>

      <th>å§å</th>

      <th>Artist</th>
		<th>æä½</th>
    </tr>

</thead>

<tbody>

<tr><td>static col 1</td><td>static col 1</td><td>static col 2</td><td>static col 3</td><td>static col 4</td><td><a  id='u_alter' href='javascript:void(0)' >ä¿®æ¹</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a id='u_delete' href='javascript:void(0)'>å é¤</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a id='u_resetpwd' href='javascript:void(0)'>å¯ç éç½®</a><a data-toggle="modal" href="#example" class="btn btn-primary btn-large">Launch demo modal</a></td></tr>

<tr><td>static col 1</td><td>static col 1</td><td>static col 2</td><td>static col 3</td><td>static col 4</td><td><a  id='u_alter' href='javascript:void(0)' >ä¿®æ¹</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a id='u_delete' href='javascript:void(0)'>å é¤</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a id='u_resetpwd' href='javascript:void(0)'>å¯ç éç½®</a></tr>

<tr><td>static col 1</td><td>static col 1</td><td>static col 2</td><td>static col 3</td><td>static col 4</td><td><a  id='u_alter' href='javascript:void(0)' >ä¿®æ¹</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a id='u_delete' href='javascript:void(0)'>å é¤</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a id='u_resetpwd' href='javascript:void(0)'>å¯ç éç½®</a></tr>

<tr><td>static col 1</td><td>static col 1</td><td>static col 2</td><td>static col 3</td><td>static col 4</td><td><a  id='u_alter' href='javascript:void(0)' >ä¿®æ¹</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a id='u_delete' href='javascript:void(0)'>å é¤</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a id='u_resetpwd' href='javascript:void(0)'>å¯ç éç½®</a></tr>

<tr><td>static col 1</td><td>static col 1</td><td>static col 2</td><td>static col 3</td><td>static col 4</td><td><a  id='u_alter' href='javascript:void(0)' >ä¿®æ¹</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a id='u_delete' href='javascript:void(0)'>å é¤</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a id='u_resetpwd' href='javascript:void(0)'>å¯ç éç½®</a></tr>

</tbody>

</table>

<script type="text/javascript" src="/static/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/static/js/bootstrap.min.js"></script>
<!-- <script type="text/javascript" src="static/js/jquery.ingrid.account.js"></script>
<script type="text/javascript" src="static/js/jquery.similar.msgbox.account.js" ></script>
 <script type="text/javascript">

$(document).ready(

         function() {
							var num = 100;
                   $("#table1").ingridaccount({

                           url: 'useralter.php',
									height: 300,
									initialLoad: false,
									savedStateLoad: true,
									rowClasses: ['grid-row-style1','grid-row-style1','grid-row-style2','grid-row-style1','grid-row-style1','grid-row-style3'],
            					sorting:false,
            					paging:true,
									totalRecords: num,
									extraParams: {sessid : 'some_session_token_here'},
									onRowSelect: function(tr, selected,id){
												var tr_html	= $(tr).html();					
												var num =$(tr).find("td[data-ingrid-colid  = '0']").text();	
												var u_date = $(tr).find("td[data-ingrid-colid  = '1']").text();	
												var u_address =$(tr).find("td[data-ingrid-colid  = '2']").text();	
												var u_name = $(tr).find("td[data-ingrid-colid  = '3']").text();	
												var u_artist = $(tr).find("td[data-ingrid-colid  = '4']").text();	
												if(id == 1)	{
													var tip = "å½åä¿®æ¹ç¨æ·ï¼"+num; 
													$.MsgBox_alter.Confirm("ç¨æ·ä¿¡æ¯ä¿®æ¹",tip,num,u_date,u_address,u_name,u_artist,function(u_date,u_address,u_name,u_artist){
													$.ajax({
																url: path+'/bll/account/get_alteruser.php?userid='+userid+'&name='+u_name+'&type='+u_type+'&balance='+u_balance,
																type:'get',
																dataType:"json",
																success:function(data) {

																if(data == true){
																		//update_table_account();
																		alert('ä¿¡æ¯ä¿®æ¹æåï¼');
																	}
																else{
																	 alert('ä¿¡æ¯ä¿®æ¹å¤±è´¥ï¼è¯·ç¨åéæ°ä¿®æ¹ï¼');
																	 return false;
																	}
																}	
														});
													});
												}
											if(id == 2){
									    			var tip = "æ§è¡å é¤åå°æ æ³æ¢å¤ï¼ç¡®å®å é¤ç¨æ·ï¼ "+num; 
													$.MsgBox.Confirm("æ¸©é¦¨æç¤º",tip,
													function(){                        
												 	$.ajax({
														url: path+"/bll/account/get_deleteuser.php?userid="+userid,
														type:'get',
														dataType:"json",
														success:function(data) {

														if(data == true){
															//update_table_account();
															alert('å é¤æåï¼');
														}
														else{
														 alert('å é¤å¤±è´¥ï¼');
														 return false;
														}
													}	
												});																					
											});
										}
										if(id == 3){
				    						var tip = "å½åéç½®å¯ç ç¨æ·ï¼ "+num; 
											$.MsgBox_reset.Confirm("ç¨æ·å¯ç éç½®",tip,num,
											function(re_pwd){                        
							 				$.ajax({
													url: path+"/bll/account/get_resetpwd.php?userid="+userid+"&pwd="+re_pwd,
													type:'get',
													dataType:"json",
													success:function(data) {

													if(data == true){
														update_table_account();
														alert('éç½®å¯ç æåï¼');
													}
													else{
									 						alert('éç½®å¯ç å¤±è´¥ï¼');
									 						return false;
													}
												}	
											});																					
										});
									}							

							}	                        

                   });

         }

);

</script>-->

 
</body>

</html>

