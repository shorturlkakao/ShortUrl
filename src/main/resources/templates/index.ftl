<!DOCTYPE html>
<html lang="ko">
	<head>
		<title>ShortUrl Creator</title>
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
                <h1>Short URL Creator</h1>
                <p>This Page is Short Url Creator.</p>
            </div>
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Input Your Url" id="fullurl">
                <div class="input-group-btn">
                    <button class="btn btn-default" type="submit" id="createBtn">단축 URL 생성</i></button>
                    <button class="btn btn-default" type="button" id="resetBtn">초기화</i></button>
                </div>
            </div>
			<div id="pnl_success" style="padding-top: 30px;display: none;">
                <div class="alert alert-success" style="padding-top: 20px;">
                    <strong>생성완료!</strong>
					<input type="text" class="form-control" id="result" style="margin-top: 5px">
                </div>

			</div>
			<div id="pnl_fail" style="padding-top: 30px;display: none;">
                <div class="alert alert-danger">
                    <strong>URL생성 실패!</strong> <p id="errormsg">단축 URL생성에 실패하였습니다.</p>
                </div>
			</div>

        </div>
        <!-- jQuery -->
		<script src="//code.jquery.com/jquery.js"></script>
		<!-- Bootstrap JavaScript -->
		<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
		<script src="/static/js/index.js"></script>
        <script type="application/javascript">

        </script>
	</body>
</html>