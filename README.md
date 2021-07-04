# Java SpringMVC

SpringMVC 筆記

# SpringMVC

SpringMVC是基於spring的一個框架，實際上就是spring的一個模塊，專門是作WEB開發的，理解成是servlet的一個升級。

web開發底層是servlet，框架是在servlet基礎上面加入一些功能，讓web開發更方便。

SpringMVC就是一個spring。Spring是容器，IOC能夠管理對象，使用

```xml
<bean>
```
```java
@Componet
@Repository
@Service
@Controller
```

SpringMVC能夠創建對象，放入到容器中(SpringMVC容器)，SpringMVC容器中放的是控制器對象。

使用 ```@Controller```創建控制器對象，把對象放入到SpringMVC容器中，把創建的對象作為控制器使用，這個控制器對象能接收用戶的請求，顯示處理的結果，就當作是一個servlet使用。

使用 ```@Controller```註解創建的是一個普通類對象，不是servlet。SpringMVC賦予了控制器對象一些額外的功能。

web開發底層是servlet，SpringMVC中有一個對象是servlet：DispatherServlet

DispatherServlet(中央調度器)：負責接收用戶的所有請求，用戶把請求給了DispatherServlet，之後DispatherServlet把請求轉發給Controller對象，最後Controller對象處理請求。


index.jsp -> DispatherServlet(Servlet) -> 轉發分配給Controll對象(```@Controller```註解創建的對象)

# 創建新專案及新模塊

建立一個空專案，再新增模塊

![image](./images/20210704120312.png)

![image](./images/20210704115947.png)

![image](./images/20210704120137.png)

![image](./images/20210704120340.png)

# springmvc-01：第一個SpringMVC項目

需求：用戶在頁面發起一個請求，請求交給SpringMVC的控制器對象，並顯示請求的處理結果，在結果頁面顯示一個歡迎語句。

實現步驟：

1. 新建web maven工程
2. 加入依賴：
- spring-web mvc依賴，間接把spring的依賴都加入到項目
- jsp、servlet依賴

3. 重點： 在web.xml注冊SpringMVC框架的核心對象DispatherServlet
    - DispatherServlet叫作中央調度器，是一個servlet，它的父類是繼承HttpServlet
    - DispatherServlet也叫作前端控制器(front controller)
    - DispatherServlet負責接收用戶提交的請求，調用其它的控制器對象，並把請求的處理結果顯示給用戶。

4. 創建一個發起請求的頁面 index.jsp

5. 創建控制器類
    - 在類的上面加入 ```@Controller``` 註解，創建對象，並放入到SpringMVC容器中
    - 在類中的方法上面加入```@RequestMapping```註解。

6. 創建一個作為結果的jsp，顯示請求的處理結果。

7. 創建SpringMVC的配置文件(跟spring的配置文件一樣)
    - 聲明組件掃描器，指定 ```@Controller```註解所在的包名
    - 聲明視圖解析器，幫助處理視圖。
