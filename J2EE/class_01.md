1. 包命名都是小写

   `package a`

2. import

3. 代码

   ```java
   package a;
   
   import java.io.*;
       
   import javax.servlet.*;
   import javax.servlet.http.*;
   
   public class HelloServlet extends HttpServlet{
       //private ServletConfig config;
       
       //public void init(ServletConfig config) throws ServletException{
       //    this.config = config;
       //}
       //有两个init函数：有ServletConfig config 参数和没有的版本
       public void init() throw ServletException{
           //如果想用config
           ServletConfig config = getServletConfig();
       }
       public void service(HttpServletRequest request, HttpServletResponse response) 			throw ServletException, IOException{
           String method = request.getMethod();
       		
           //getMethod()返回值7个必考
           //dispatcher!
           if("GET".equals(method)){
               doGet(request, response)
           }
           
           else if("POST".equals(method)){
               
           }
           
           else if("PUT".equals(method)){
               
           }
       }
       
       //运行异常编译器看不见
       public void doGet(HttpServletRequest request, HttpServletResponse response)
       	throws ServletException, IOException{
           response.setContentType("text/html");
           
           PrintWriter out = response.getWriter();
           
           out.println("<h1> Hello world! </h1>");
       }
       
   }
      
   ```

   

![image-20210909141514429](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210909141514429.png)



header：以 `\r\n`结尾。所有header输出完，再输出一个 `\r\n`

必考：`getHeader()` `getCookie()` 



`getRequestURL()`：返回 `StringBuffer`

`getRequestURI():`  返回`string` 。去掉协议，去掉头部。`http://www.baidu.com/s`    `/s`是`URI`

`getContextPath()`：获取上下文路径。一个web应用程序部署到服务器上，就是服务器路径的一部分。

​			`http://localhost:8080/abc/xyz/a.html` 如果部署在根目录下：URI就是 `/`;如果部署在 `/abc`下，URI就是 `/abc`。



![20210909150137](C:\Users\Administrator\Documents\Tencent Files\1835208956\Image\SharePic\20210909150137.png)