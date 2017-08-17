<!DOCTYPE html>
<html lang="ko">
	<head>
		<title>ERROR</title>
		<meta charset="UTF-8">
		<meta name=description content="">
		<meta name=viewport content="width=device-width, initial-scale=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<!-- Bootstrap CSS -->
		<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" media="screen">
	</head>
	<body>
    <div class="container">
        <div class="jumbotron">
            <h1>Oops...</h1>
		<#if exception??>
            <p>오류정보 : ${exception.message!""}</p>
		<#else>
            <p>존재하지 않는 URL입니다.</p>
		</#if>
        </div>
    </div>

		<!-- jQuery -->
		<script src="//code.jquery.com/jquery.js"></script>
		<!-- Bootstrap JavaScript -->
		<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
	</body>
</html>