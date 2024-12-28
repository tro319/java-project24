<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="bentouSysModel.BentouClass" %>
<%

	BentouClass bentou = (BentouClass) request.getAttribute("selectedBentou");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>弁当詳細 | かまどや弁当情報システム</title>
<link rel="stylesheet" href="assets/css/body.css">

</head>
<body>

<header class="header">

	<h1 "headedr-title">かまどや弁当情報</h1>

</header>


<main>
<div class="container">

	<h2><%= bentou.getBentouName() %></h2>
	
	<div class="bentouImg">
	
		<img src="<%= bentou.getImg() %>" alt="<%= bentou.getBentouName() %>">
	
	</div>
	
	
	
	<dl>
	
		<dt>価格 (税込み)</dt>
		<dd><%= bentou.getPrice() %>円</dd>
		
		
		<dt>入っているもの</dt>
		
		<% for (String material : bentou.getMaterial().split(",")) { %>
		
		<dd><%= material %></dd>
		
		<% } %>
		
		<dt>オプションメニュー</dt>
		
		<% for (String option : bentou.getOptionPlus().split(",")) { %>
		
		<dd><%= option %></dd>
		
		<% } %>
	
	</dl>
	
	<a href="bentouList">一覧に戻る</a>
	
</div>

</main>

</body>
</html>