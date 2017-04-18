<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<link rel="stylesheet" href="/static/css/bootstrap.min.css" />
</head>
<body>

	<div class="container">
	<div class="row">
		<div class="col-md-5">
			<form action="/pay" method="post">
			
			<div class="form-group">
				<label>金额</label>
				<input type="text" name="money" value="${money }" class="form-control" />
			</div>
			
			<div>
				<label>验证码</label>
				<a href="javascript:;" id="change">
					<img src="/patchca.png" id="vimg"/>
				</a>
				<input type="text" name="code1" class="form-control" />
			</div>
			
			<div class="form-group">
				<button class="form-control">支付</button>
			</div>
			</form>
		</div>
	</div>
	</div>
	
	<script src="/static/js/jquery-1.11.3.min.js"></script>
	
	<script>
		$(function(){
			$("#change").click(function(){
				$("#vimg").removeAttr("src").attr("src","/patchca.png?="+new Date().getTime());
			});
		});	
	</script>

</body>
</html>