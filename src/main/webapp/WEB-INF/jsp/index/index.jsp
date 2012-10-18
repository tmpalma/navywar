<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Navy War</title>
</head>
<body>
	<h1>Navy War</h1>
	
	<form action="post">
		<table>
			<%
				for(int i = 0; i < 6; i++) {
					out.println("<tr>");
			
					for(int j = 0; j < 6; j++) {
				    	out.println("<td><input type='checkbox' name='linha" + i + "["+ j + "].tabuleiro'/></td>");
					}
					
					out.println("</tr>");
				}
			%>
		</table>
		
		<div>
			Linha <input type="text" id="linha">
		
		</div>
		
		<div>
			Coluna <input type="text" id="coluna">
		
		</div>
		
		<div class="available_ships">
			<div class="available_ship airshipcarrier"><input type="radio" id="navio" value="1" /><img src="src/main/webapp/WEB-INF/jsp/index/376.png" /></div>
			<div class="available_ship destroyer"><input type="radio" id="navio" value="2" /><img src="376.png" /></div>
			<div class="available_ship cruiser"><input type="radio" id="navio" value="3" /><img src="376.png" /></div>
			<div class="available_ship submarine"><input type="radio" id="navio" value="4" /><img src="376.png" /></div>
		</div>
		<input type="submit" />
	</form>
</body>
</html>