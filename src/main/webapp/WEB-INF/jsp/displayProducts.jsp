<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONException"%>
<%@page import="java.util.Map"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="com.att.onlinestore.util.ProductUtil"%>
<%@page import="com.att.onlinestore.bean.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Inventory</title>
 <script src="http://code.jquery.com/jquery-1.4.min.js" type="text/javascript"></script>
     


</script>
</head>

<style type="text/css">
	table {
		border-collapse: collapse;
		border-spacing: 0;
		width: 100%;
		border: 1px solid #ddd;
	}

	th, td {
		text-align: left;
		padding: 16px;
	}

	tr:nth-child(even) {
		background-color: #f2f2f2
	}
	.button:hover {
  background-color: #403866;
}

.button {
    background-color: #827ffe;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}
</style>
<body>
<h2 align="center">Product Directory</h2><br>

  <div id="demo">
  <form action="/home">
<div align="right"><input type="submit"  value="Add Product" class="button" ></div> 
 </form> 
	<table border="1">
		<tr>
			<th>Product ID</th>
			<th>Product Name</th>
			<th>Product Description</th>
			<th>Product Image</th>
			<th>&nbsp;</th>
			<th>&nbsp;</th>
		</tr>

		<%
			System.out.print("IN DISPLAY JSP");
			String jsonResponse = request.getAttribute("prodlist").toString();
		    System.out.println("Json Response: "+jsonResponse);
			try {
				JSONArray jsonArray = new JSONArray(jsonResponse);

				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject jsonObject1 = jsonArray.getJSONObject(i);
					String value1 = jsonObject1.optString("id");
					System.out.print("*value1: "+value1);
					String value2 = jsonObject1.optString("name");
					String value3 = jsonObject1.optString("description");
					String value4 = jsonObject1.optString("url");
					if(value1.equals("")&&value2.equals("")&value3.equals("")

&value4.equals(""))
					{
						
					}
					else
					{
					
		%>
		<tr>
			<td><%=value1%></td>
			<td><%=value2%></td>
			<td><%=value3%></td>
			<td><%=value4%></td>
			<td><a href="/editProduct/<%=value1%>">Edit</a></td>
			 <td><a href="/deleteProduct/<%=value1%>">Delete</a></td></tr>

			<%
				}
				}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			%>
	</table>
  </div>

</body>
</html>