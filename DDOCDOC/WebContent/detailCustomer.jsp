<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src = "/DDOCDOC/js/jquery.min.js"></script>
<script type="text/javascript" src = "/DDOCDOC/js/qrcode.js"></script>
</head>
<body>
	
	
	
	<div class = "led-group" align = "center">
	ȸ�� ���̵� : <h1 id = "let-text">${customer.cus_id }</h1><br>
	ȸ�� �̸� : ${customer.cus_name }<br>
	ȸ�� �ּ� : ${customer.cus_addr }<br>
	ȸ��  �̸��� : ${customer.cus_email }<br>
	ȸ�� ������� : ${customer.cus_birth }<br>
	
	
		<h1>�� ������ QR�ڵ�</h1> 
		<textarea cols="18" rows="20" class = "autosize" onkeydown="resize(this)" onkeyup = "resize(this)" id = "led-text" charset = "UTF-8">�� ���̵� : ${customer.cus_id }     �� �̸� : ${customer.cus_name }       �� �ּ� : ${customer.cus_addr }       �� �̸��� : ${customer.cus_email }     �� ������� : ${customer.cus_birth }</textarea>
		<button type = button id = "led-button1" onclick="button1_click()">QR�ڵ� �߱�</button>
		<div id = "qrcode" style = "width:100px; height:100px; margin-top:15px;"></div> 
	
	</div>
	
	<script>
		var qrcode = new QRCode(document.getElementById("qrcode"),{height : 100, width : 100});
	
		function makeCode(){
			var elText = document.getElementById("led-text");
			if(!elText.value){
				alert("Input a text");
				elText.focus();
				return;
			}
			alert(elText.value);
			
			qrcode.makeCode(elText.value);
		}
		function button1_click(){
			makeCode();
		}
		function resize(obj){
			obj.style.height = "1px";
			obj.style.height = (12 + obj.scrollHeight) + "px";
		}
	
	</script>
	

</body>
</html>