   var totalrate=new Array()
   
        refleshMainTable();
   
       
        function refleshMainTable() {
       	 $.ajax({
                type: "get",//数据发送的方式（post 或者 get）
                url: "/getMainJson",//要发送的后台地址
                //data: {page:page},//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
                async:false,
                dataType: "json",//后台处理后返回的数据格式
                success: function (data) {//ajax请求成功后触发的方法
               	 console.log(data)
               	 totalrate=data;
               	 //alert([totalrate])
                    }
            });       	 
       }                      //ajax获取数据库数据

var randomScalingFactor = function(){ return Math.round(Math.random()*100)};
        
        var barChartData = {
            labels : ["服务器","网络设备","网络存储设备"],
        datasets : [
            {
                label:"正常设备",
                fillColor : "rgba(0,205,0,1)",
                strokeColor : "rgba(0,205,0,0.8)",
                highlightFill: "rgba(0,205,0,0.75)",
                highlightStroke: "rgba(0,205,0,0.5)",
                labelsColor:"rgba(0,205,0,0.5)",
                data : [totalrate[0][10],totalrate[0][12],totalrate[0][11]]
            },
            {
                label:"预警设备",
                fillColor : "rgba(255,0,0,1)",
                strokeColor : "rgba(255,0,0,0.8)",
                highlightFill : "rgba(255,0,0,0.75)",
                highlightStroke : "rgba(255,0,0,0.5)",
                labelsColor:"rgba(255,0,0,0.5)",
                data : [totalrate[0][13],totalrate[0][15],totalrate[0][14]]
            }
        ]


    }   //柱状图

       
       	

        
      
        


var pieData = [
    {
        value:totalrate[0][7],
        color:"#FFB90F",
        highlight: "#FFC125",
        label: "网络存储设备"
    },
    {
        value: totalrate[0][7],
        color: "#6495ED",
        highlight: "#6495ED",
        label: "网络设备"
    },
    {
        value:totalrate[0][5],
        color: "#32CD32",
        highlight: "#00CD00",
        label: "服务器"
    }

];
var pieData1 = [
    {
        value: totalrate[0][8],
        color:"#32CD32",
        highlight: "#00CD00",
        label: "正常设备"
    },
    {
        value: totalrate[0][9],
        color: "red",
        highlight: "#EE3B3B",
        label: "预警设备"
    }

]; //饼图

        
window.onload = function() {
        var ctx = document.getElementById("canvas").getContext("2d");
        window.myBar = new Chart(ctx).Bar(barChartData, {responsive: true});
        legend(document.getElementById("barLegend"), barChartData, myBar);
       var ctx = document.getElementById("chart-area").getContext("2d");
        window.myPie = new Chart(ctx).Pie(pieData);
        legend(document.getElementById("pieLegend1"), pieData, myPie);
        var ctx = document.getElementById("chart-area1").getContext("2d");
        window.myPie = new Chart(ctx).Pie(pieData1);
        legend(document.getElementById("pieLegend2"), pieData1, myPie);
    }                //生成图以及图例


      
$(function() {
    
    setTimeout(function() {
        $('#chart1').data('easyPieChart').update(totalrate[0][0]);
        $('#chart2').data('easyPieChart').update(totalrate[0][1]);
        $('#chart3').data('easyPieChart').update(totalrate[0][2]);
        if (totalrate[0][3]/1024>=1){
        	totalrate[0][3]=changeTwoDecimal_f(totalrate[0][3]/10240);
        	$(".percent1").addClass("percent2").removeClass("percent1");
        	//alert($(".percent1").hasClass("percent1"));
      
        }
        	
        else
        	totalrate[0][3]=totalrate[0][3]/10;
        // alert(totalrate[0][3]);
        $('#chart4').data('easyPieChart').update(totalrate[0][3]);
        if (totalrate[0][4]/1024>=1){
        	totalrate[0][4]=changeTwoDecimal_f(totalrate[0][4]/10240);
        	$(".percent3").addClass("percent2").removeClass("percent3");
        	}
        else
        	totalrate[0][4]=totalrate[0][4]/10;
        $('#chart5').data('easyPieChart').update(totalrate[0][4]);
        }, 100); //0.1s
});      //更新百分比图的数据
function winclose() { 
	//此处填写要处理的逻辑代码
	window.opener.location.reload();//刷新 
	} 

function changeTwoDecimal_f(x)
{
var f_x = parseFloat(x);
if (isNaN(f_x))
{
alert('function:changeTwoDecimal->parameter error');
return false;
}
f_x = Math.round(f_x*100)/100;
var s_x = f_x.toString();
var pos_decimal = s_x.indexOf('.');
if (pos_decimal < 0)
{
pos_decimal = s_x.length;
s_x += '.';
}
while (s_x.length <= pos_decimal + 2)
{
s_x += '0';
}
return s_x;
}
    
