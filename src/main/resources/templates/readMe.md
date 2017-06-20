# Thymeleaf 教程
>[请关注Thymeleaf官网教程](http://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#what-is-thymeleaf)


### 一、 标准表达式语法

1、 消息表达式(可以获取配置文件的数据)：`#{...}`

    <p th:text="#{name}">Welcome to our <b>fantastic</b> grocery store!</p>
<br>
    
    <p th:utext="#{${welcomeMsgKey}(${session.user.name})}">
      Welcome to our grocery store, Sebastian Pepper!
    </p>

2、 变量表达式(获取后台model传入的参数)：`${...}`

    <p th:text="${hello}">Welcome to our store!</p>

**底层就是采用的ONGL表达式实现的：**

`#ctx`：上下文对象。<br>
`#vars`: 上下文变量。<br>
`#locale`：上下文区域设置。<br>
`#request`：（仅在Web上下文中）HttpServletRequest对象。<br>
`#response`：（仅在Web上下文中）HttpServletResponse对象。<br>
`#session`：（仅在Web上下文中）HttpSession对象。<br>
`#servletContext`：（仅在Web上下文中）ServletContext对象。<br>
等等

**eg**：

    stablished locale country: <span th:text="${#locale.country}">US</span>.

日期格式化：

    后台：
    public String ToAdmin(Model model) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
            Calendar cal = Calendar.getInstance();
            model.addAttribute("today", dateFormat.format(cal.getTime()));
    }
<br>
    
    前台：
    <p>
        Today is: <span th:text="${#calendars.format(today,'dd MMMM yyyy')}">13 May 2011</span>
    </p>
    


3、 选择性/星号表达式：`*{...}`
只要不存在变量的对象(用`th:object`属性时，表示为对象)时，和`${...}`是一样的效果<br>
**eg:**

      <div th:object="${session.user}">
        <p>Name: <span th:text="*{firstName}">Sebastian</span>.</p>
        <p>Surname: <span th:text="*{lastName}">Pepper</span>.</p>
        <p>Nationality: <span th:text="*{nationality}">Saturn</span>.</p>
      </div>
      
相同于下面这种方法：

    <div>
      <p>Name: <span th:text="${session.user.firstName}">Sebastian</span>.</p>
      <p>Surname: <span th:text="${session.user.lastName}">Pepper</span>.</p>
      <p>Nationality: <span th:text="${session.user.nationality}">Saturn</span>.</p>
    </div>


4、 链接表达式：`@{...}`

    <!-- Will produce 'http://localhost:8080/gtvg/order/details?orderId=3' (plus rewriting) -->
    <a href="details.html" 
       th:href="@{http://localhost:8080/gtvg/order/details(orderId=${o.id})}">view</a>
    
    <!-- Will produce '/gtvg/order/details?orderId=3' (plus rewriting) -->
    <a href="details.html" th:href="@{/order/details(orderId=${o.id})}">view</a>
    
    <!-- Will produce '/gtvg/order/3/details' (plus rewriting) -->
    <a href="details.html" th:href="@{/order/{orderId}/details(orderId=${o.id})}">view</a>

注意：

- th:href是一个修饰符属性：一旦处理，它将计算要使用的链接URL，并将该值设置href为<a>标签的属性。
- 我们被允许使用表达式的URL参数（如您所见orderId=${o.id}）。所需的URL参数编码操作也将自动执行。
- 如果需要几个参数，这些参数将以逗号分隔： @{/order/process(execId=${execId},execType='FAST')}
- URL路径中也允许使用变量模板： @{/order/{orderId}/details(orderId=${orderId})}
- 以/（eg /order/details：）开头的相对URL 将以应用程序上下文名称自动为前缀。
- 如果未启用Cookie，或者尚未知道Cookie，则";jsessionid=..."可能会将相应的URL添加到后缀，以便会话被保留。<br>
    这被称为URL重写，Thymeleaf允许您使用response.encodeURL(...)Servlet API中针对每个URL 的机制来插入自己的重写过滤器。
- 该th:href属性允许我们（可选地）href在我们的模板中有一个工作的静态属性，以便我们的模板链接可以直接打开直接用于原型开发时被浏览器导航。
  
5、 片段表达式 th:insert或th:replace（包含其他内容，不推荐使用th:include）

    被包含的内容
    <!DOCTYPE html>
    <html xmlns:th="http://www.thymeleaf.org">
      <body>
        <div th:fragment="copy">
          &copy; 2011 The Good Thymes Virtual Grocery
        </div>
      </body>
    </html>

footer表示要引入的路径及文件名；copy相当于被引入的文件id或者th:fragment的值
<br>

    <body>
      ...
      <div th:insert="~{footer :: copy}"></div>
    </body>

**注意如果`copy`是id，则引入时为#copy**

th:insert和th:replace有什么区别？

- th:insert 是最简单的：它将简单地插入指定的片段作为它的主机标签的主体。
- th:replace实际上用指定的片段替换了它的主机标签。
- th:include是类似的th:insert，而不是插入片段，它只插入这个片段的内容。


6、字符拼接

    <span th:text="'The name of the user is ' + ${user.name}">
    
7、字符替换（被替换的信息由 `| |`包裹）

    <span th:text="|Welcome to our application, ${user.name}!|">

相当于：

    <span th:text="'Welcome to our application, ' + ${user.name} + '!'">

### 二、 循环迭代

1、使用th：each

    <table>
      <tr>
        <th>NAME</th>
        <th>PRICE</th>
        <th>IN STOCK</th>
      </tr>
      <tr th:each="prod : ${prods}">
        <td th:text="${prod.name}">Onions</td>
        <td th:text="${prod.price}">2.41</td>
        <td th:text="${prod.inStock}? #{true} : #{false}">yes</td>
      </tr>
    </table>
   
使用th:each时，Thymeleaf提供了一种有助于跟踪您的迭代状态的机制：状态变量。

    当前的迭代索引，从0开始。这是index属性。
    当前的迭代索引，从1开始。这是count属性。
    迭代变量中元素的总量。这是size酒店。
    的ITER变量对于每次迭代。这是current酒店。
    当前的迭代是偶数还是奇数。这些是even/odd布尔属性。
    当前的迭代是否是第一个迭代。这是first布尔属性。
    当前的迭代是否是最后一个迭代。这是last布尔属性
  
**eg:**

    <table>
      <tr>
        <th>NAME</th>
        <th>PRICE</th>
        <th>IN STOCK</th>
      </tr>
      <tr th:each="prod,iterStat : ${prods}" th:class="${iterStat.odd}? 'odd'">
        <td th:text="${prod.name}">Onions</td>
        <td th:text="${prod.price}">2.41</td>
        <td th:text="${prod.inStock}? #{true} : #{false}">yes</td>
      </tr>
    </table>
    
2、 使用th:if

      <tr th:each="prod : ${prods}" th:class="${prodStat.odd}? 'odd'">
        <td th:text="${prod.name}">Onions</td>
        <td th:text="${prod.price}">2.41</td>
        <td th:text="${prod.inStock}? #{true} : #{false}">yes</td>
        <td>
          <span th:text="${#lists.size(prod.comments)}">2</span> comment/s
          <a href="comments.html" 
             th:href="@{/product/comments(prodId=${prod.id})}" 
             th:if="${not #lists.isEmpty(prod.comments)}">view</a>
        </td>
      </tr>
 
3、使用th:switch/ th:case（case默认为*）

    <div th:switch="${user.role}">
      <p th:case="'admin'">User is an administrator</p>
      <p th:case="#{roles.manager}">User is a manager</p>
      <p th:case="*">User is some other thing</p>
    </div>
    
### 三、 注释

1、`<!--......-->`

    <!-- User info follows -->
    <div th:text="${...}">
      ...
    </div>
    
2、Thymeleaf解析器级注释 `<!--/*  ...   */-->`

Thymeleaf将删除一切与<!--/*和*/-->，所以这些注释块也可以用于显示当模板是静态开放代码，
<br>当Thymeleaf处理它，它都将被删除：

    <!--/*--> 
      <div>
         you can see me only before Thymeleaf processes me!
      </div>
    <!--*/-->

3、Thymeleaf评论块注释 `<!--/*/  ...   /*/-->`

    <span>hello!</span>
    <!--/*/
      <div th:text="${...}">
        ...
      </div>
    /*/-->
    <span>goodbye!</span>

Thymeleaf的解析系统将简单地删除<!--/*/和/*/-->标记，而不是其内容，因此将被遗弃。
<br>所以当执行模板时，Thymeleaf实际上会看到这样的：

    <span>hello!</span>
      <div th:text="${...}">
        ...
      </div>
    <span>goodbye!</span>
    
### 四、表达式内嵌（在ht:text或th:utext属性中使用）

表达式方言和内嵌的比较

    内嵌：
    <p>Hello, [[${session.user.name}]]!</p>
    
<br>

    方言：
    <p>Hello, <span th:text="${session.user.name}">Sebastian</span>!</p>
    
在th:text和th:utext中使用的不同，如有：`msg = 'This is <b>great!</b>'`

    <p>The message is "[(${msg})]"</p>
    结果显示(b标签不被转义)为：
    <p>The message is "This is <b>great!</b>"</p>

<br>

    <p>The message is "[[${msg}]]"</p>
    结果显示(b标签被HTML转义)为：
    <p>The message is "This is &lt;b&gt;great!&lt;/b&gt;"</p>

**注意：**

默认情况下，文本内联在我们的标记中的每个标签的正文中都是活动的，而不是标签本身

禁用内联：使用 `th:inline="none"`：

    <p th:inline="none">A double array looks like this: [[1, 2, 3], [4, 5]]!</p>
    
