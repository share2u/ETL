<%@ page language="Java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>??</title>        
 <style type="text/css">
#box{ width:1200px; height: 100px; margin:0 auto;border:1px solid #ddd; text-align: center;}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body> 
<hr />
<div id="box">
<input type="text" id="testInput" placeholder="截屏后粘贴到输入框中" size="30" />
<input type="button" id="picturePath" value="复制路径" onclick="copyUrl();"></div>
<img id ="img" src="">
<div>
<input type="text" id="CopyLink"  readonly="readonly" size="30" />
<script type="text/javascript">

(function(){
    var imgReader = function( item ){
        var blob = item.getAsFile(),
            reader = new FileReader();

        reader.readAsDataURL( blob );

        reader.onload = function( e ){
            var img = new Image();

            img.src = e.target.result;
           // document.getElementById("img").src=img.src;//显示上传的图片
          
                 /* $.ajax({
                    type: 'POST',
                    url:"http://localhost:8000/upload//uploadpicture/base64",
                    data:{base64Data: img.src},
                    dataType: 'jsonp',
                    jsonp: "jsonpCallback",//服务端用于接收callback调用的function名的参数
                    jsonpCallback:"success_jsonp",   
                   success:function(json,textStatus){
                       if (json.completeCode ==1) {
                            $("#CopyLink").val(json.reasonMessage);
                       } else {
                            alert("上传失败")
                       }   
                   },    
                   error:function(XMLHttpRequest,textStatus,errorThrown){    
                       console.log("jsonp.error:"+textStatus);    
                   } 
                    });  */
            $.ajax({
                type: 'POST',
                url:"upload/uploadpicture/base64",
                data:{base64Data: img.src},
                dataType: 'json',  
	               success:function(json,textStatus){
	                   if (json.completeCode ==1) {
	                        $("#CopyLink").val(json.reasonMessage);
	                   } else {
	                        alert("上传失败")
	                   }   
	               },    
	               error:function(XMLHttpRequest,textStatus,errorThrown){    
	                   console.log("error:"+textStatus);    
	               } 
                }); 
            
           
        };

        
    };
    document.getElementById( 'testInput' ).addEventListener( 'paste', function( e ){
    var clipboardData = e.clipboardData,
        i = 0,
        items, item, types;

    if( clipboardData ){
        items = clipboardData.items;

        if( !items ){
            return;
        }

        item = items[0];
        types = clipboardData.types || [];

        for( ; i < types.length; i++ ){
            if( types[i] === 'Files' ){
                item = items[i];
                break;
            }
        }

        if( item && item.kind === 'file' && item.type.match(/^image\//i) ){
            imgReader( item );
        }
    }
    });
})(); 


</script>
<script type="text/javascript">
function copyUrl()
{
var Url2=document.getElementById("CopyLink");
Url2.select(); // 选择对象
document.execCommand("Copy"); // 执行浏览器复制命令
}

</script>
</body>
</html>