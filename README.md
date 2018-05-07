myOnlineStore
This is a simple web application, using J2EE components, that allows the user to see a list of Products which they can add, delete, and update to an online store.

The Product will contain the following properties at a minimum (can add more if needed): •	Product Id •	Product name • Product Description •	Related Products e.g. if the product is a Shoe, display items such as shoe polish, laces etc. •	Product Image (Currently Just show the image name but this can be enhanced to show actual product thubmnails)

The following functions are implemented in the application:

Login : a.	User id and password is stored in a properties file. b.	The user will go to a Home page after successful login. Invalid login takes the user to Error c.	page.
Home page a.	The initial rendering of the Home page will i.	Start with an empty list if the user does not yet added any products to their inventory. ii.	Start with the existing products if the user has added any in the same application server session (not the user session). b.	The home page will provide the following functions : i.	Add Product ii.	Delete Product iii.Update Product iv.	List products



Follow below steps to run onlinestore war file:

1. Use username: ankita & password att123 (login information stored in application.properties file)

2. Run application on port : 8090 (If you want to change port, edit application.propeties file)

3. create folder "tmp" in C drive (C:\tmp folder stored uploaded image)

Technologies used:
1. Spring Boot MVC Framework
2. Restwebservice
3. For UI: HTML,CSS & javascript

