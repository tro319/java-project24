<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bentouSysModel.BentouClass" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>弁当情報 | かまどや弁当情報システム</title>
<!-- 自作css -->
<link rel="stylesheet" href="assets/css/body.css">
</head>
<body>

<header class="header">

<h1 class="header-title">かまどや弁当情報</h1>

</header>

<main>

<!-- 弁当の種類選択フォーム -->

<form method="get" action="">

<label for="kind">弁当種類選択</label>

<select name="kind" id="kind">

<option value="">選択してください (すべて)</option>
<option value="スペシャルメニュー" <%= "スペシャルメニュー".equals(request.getAttribute("selectedKind")) ? "selected" : "" %>>スペシャルメニュー</option>
<option value="定番メニュー" <%= "定番メニュー".equals(request.getAttribute("selectedKind")) ? "selected" : "" %>>定番メニュー</option>
<option value="丼・カレー" <%= "丼・カレー".equals(request.getAttribute("selectedKind")) ? "selected" : "" %>>丼・カレー</option>
<option value="サイドメニュー" <%= "サイドメニュー".equals(request.getAttribute("selectedKind")) ? "selected" : "" %>>サイドメニュー</option>
<option value="おかずのみ" <%= "おかずのみ".equals(request.getAttribute("selectedKind")) ? "selected" : "" %>>おかずのみ</option>

</select>

<button type="submit">表示</button>

</form>




<!-- 選択された種類名を、サブタイトルとして表示 -->

<div class="container">

<%


if (request.getAttribute("selectedKind") != null && request.getAttribute("selectedKind") != "") {

%>

	<h2 class="sub-title"><%= request.getAttribute("selectedKind") %></h2>
	
<%

} else {

%>	

	<h2 class="sub-title">すべて</h2>

<%

}

%>


<!-- 選択された種類に基ずく、弁当をすべて表示。 -->

<%

List<BentouClass> allRsBentous =	(List<BentouClass>) request.getAttribute("allRsBentous");

if (allRsBentous != null && !allRsBentous.isEmpty()) {

%>

<ul class="catchedBentouList">

	

<!-- 繰り返しで、各要素の情報をそれぞれ表示 -->

<%

for (BentouClass bentou : allRsBentous) {

%>



<li>

<a class="bentouDetailLink" href="bentouDetail?id=<%= bentou.getId() %>">

<div class="bentouImg">

<img src="<%= bentou.getImg() %>" alt="<%= bentou.getBentouName() %>">

</div>


<h3><%= bentou.getBentouName() %></h3>
<p>価格: <%= bentou.getPrice() %>円</p>


</a>

</li>


<%

}

%>

</ul>


<%

} else { 

%>

<p>選択された弁当の種類のものは、見つかりませんでした。</p>


<%

}


%>

</div>

</main>



</body>
</html>