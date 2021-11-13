<h1 align="center">Mini Networks Protocols</h1>

<hr>

<h3 align="left">Little Networks Protocols made with Java Sockets during my second year at the university 🎓</h3>

- <h5 align="left">3 protocols : UDP / TCP / HTTP</h5>
- <h5 align="left">Instructions are in French <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/Flag_of_France.svg/langfr-225px-Flag_of_France.svg.png" width="40" height="25" /> </h5>

<hr>

<h3 align="left">Screenshots :</h3>

![image](https://user-images.githubusercontent.com/55751991/141655124-c4db86e0-20b8-4162-8e52-e90b3a8ded95.png)
![image](https://user-images.githubusercontent.com/55751991/141655152-63da6628-5dec-4aad-9f51-ccb0d31c33c1.png)


<hr>

<h3 align="left">How to use it :</h3>

- <h4 align="left">You need 2 terminals : the server and the client</h4>
- <h4 align="left">Run the server of the protocol you want (here TCP) with a non-used port (here : 8888) with the command :</h4>
```java
java TCPServer 8888
```
- <h4 align="left">For the client use the port indicated before and the ip address of the server (here it's on the same machine) :</h4>
```java
java TCPClient localhost 8888
```
- <h4 align="left">For UDP it's the same thing for the server but you can only send one message, so you need to specify the message at the client :</h4>
```java
java UDPClient localhost 8888 message
```
- <h4 align="left">HTTPServer will start a server at the specified port but you can't send it anything right now</h4>

<hr>

<h3 align="left">Prerequies :</h3> 

- <h4 align="left">Java 11 or better <a href="https://www.java.com" target="_blank"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="30" height="30"/> </a> <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript" target="_blank"> </a></h4>
