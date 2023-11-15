package com.wang.controller;

import com.wang.entity.User;
import com.wang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findAllUsers")
    @ResponseBody
    public List<User> findAllUsers(){
        System.out.println("findAllUsers");
        return userService.selectAllUser();
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody User user){
        System.out.println("addUser");
        userService.saveOneUser(user);
        return "保存成功";
    }
}


//    1.接收简单类型(根据匹配形参名和请求参数的key)：8种基本类型及其包装器+String
//    但是Date日期类型等特殊类型，默认不支持，需要自定义类型转换器，1和2的匹配人规律就不适用了
//    2.接收pojo(entity)对象类型(查找对应形参类型的`属性名`与请求参数的key) Plain Ordinary Java Object
//    pojo: set get 无参构造  (serializable)  不实现容器或框架所规定的接口
//    3.接收一组简单变量的情况  例如：批量删除的 ids
//    这种不可以  错误：No primary or default constructor found for interface java.util.List
//    因为List是个接口，不存在构造方法
//    public String test11(List<Integer> ids) {
//        for (Integer id : ids) {
//            System.out.println(id);
//        }
//        return "";
//    }
//    这种也不行，虽然ArrayList
//    由2的规则：查找对应形参类型的`属性名`与请求参数的key
//    因为ArrayList类中，没有ids这个属性，所以不对
//    public String test12(ArrayList<Integer> ids) {
//        for (Integer id : ids) {
//            System.out.println(id);
//        }
//        return "";
//    }
//    4.接收一组pojo类型的请求参数  例如：批量注册
//    前端：users[0].username   users[0].pwd
//         users[1].username   users[1].pwd
//         users[2].username   users[2].pwd
//    (Liat<User> users)不行
//    (ArrayList<User> users)不行
//    办法：提供一个类
//public class UsersDTO {
//    private List<User> users = new ArrayList<>();
//
//    public List<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(List<User> users) {
//        this.users = users;
//    }
//}
//
//    public String test13(mvc.UsersDTO usersDTO) {
//        List<User> users = usersDTO.getUsers();
//        for (User user : users) {
//            System.out.println(user);
//        }
//        return "";
//    }



    //    使用了@RequestParam注解的形参，客户端必须传递数据，不能省略，否则报错;后面课程会解决这个问题
//    pojo类型的形参，不能与@RequestParam注解联用，否则报400错误：(@RequestParam User user)
//    public String test14(@RequestParam("u") String username, @RequestParam(value = "p") String pwd, @RequestParam String status) {
//        return "";
//    }

//    典型应用：?id<=10
//            (@RequestParam("id<") Integer id)    而(Integer id<)是错的

    //    @RequestParam的required属性，解决了：使用了@RequestParam注解的形参，客户端必须传递数据，不能省略，否则报错
//    public String test15(@RequestParam(required = false) String username) {
//        return "";
//    }

    //    @RequestParam的defaultValue属性
//    public String test16(@RequestParam(defaultValue = "张三") String username) {
//        return "";
//    }

    //    推荐使用包装类型，int类型不能存储null数据
//    public String test17(@RequestParam(defaultValue = "0") int id) {
//        return "";
//    }
//    defaultValue的典型应用：默认分页显示为第一页 (@RequestParam(defaultValue="1") Integer pageNum)


//    springmvc内置的类型转换器
//    public interface Converter(S, T) {
//    }
//    其实现类：
//          private static final class StringToNumberConverter
//          private static final class StringToBooleanConverter
//    下面的这个bean放到工厂里，里面存储了上面的Converter的接口实现类，存储了所有的内置类型转换器
//    public class FormattingConversionServiceFactoryBean{
//          private Set<?> converts;
//    }
//    <mvc:annotation-driven/>这个标签是引入springmvc的核心功能，其中，就创建了FormattingConversionServiceFactoryBean
//    需要配置自定义类型转换器 DateConverter
//public String test18(Date dirthday) {
//    return "";
//}


    //    单值动态参数的收集(1个key对应1个value)    注意必须加@RequestParam
//    key是动态的
//    public String test19(@RequestParam Map<String, String> params) {
//        Set<String> keys = params.keySet();
//        for (String key : keys) {
//            System.out.println("key is" + key + ",value id" + params.get(key));
//        }
//        return "";
//    }

    //    多值动态参数收集(1个key对应d多个value)   ?id=1&id=2&id=3
    //    多值解决办法1：public String test20(int[] id)
    //    多值解决办法2：
//    @RequestMapping("/abc")
//    public String test20(@RequestParam MultiValueMap<String, String> params) {
////        key id value List<> 1,2,3
//        Set<String> keys = params.keySet();
//        for (String key : keys) {
//            List<String> values = params.get(key);
//            System.out.println("key is " + key);
//            for (String value : values) {
//                System.out.println("value = " + value);
//            }
//        }
////        结果：key is id
////             value = 1
////             value = 2
////             value = 3
//        return "";
//    }


    //    动态参数的典型应用：    排序：综合(desc/asc) 销量(desc/asc) 价格(desc/asc) 时间(desc/asc)
    //    order by column order
//    public String productOrderBy(@RequestParam Map<String, String> param) {
//        return "";
//    }

    //    ******************************************************************************************
//    Cookie[] cookies =  request.getCookies();   cookie.getName(); cookie.getValue();  不建议：与Servlet api耦合了
//    public String test21(@CookieValue("cookieName") String cookieValue) {
//        System.out.println(cookieValue);
//        return "";
//    }

    //    ******************************************************************************************
//    接收请求头数据   例如：语言信息 浏览器的版本 操作系统类型 是否缓存数据等信息
//    String headerValue = request.getHeader("key");   不建议：与Servlet api耦合了
//    public String test22(@RequestHeader("host") String host) {
//        System.out.println(host);
//        return "";
//    }

    //    ************************************流程跳转功能*********************************************
//    request session application(ServletContext)三个作用域
//    javaWeb:request.getRequestDispatcher("/result.jsp").forward(request,response);
//            response.sendRedirect("/result.jsp");
//    forward: 一次请求 地址栏不变 可以通过request作用域传递数据                如果本次功能需求没有完成时使用
//    redirect:多次请求 地址栏改变 不能通过request作用域传递数据 可以跨域跳转      如果本次功能需求已经完成时使用
//    redirect跳转传递数据的错误认知:
//             1.观点:redirect跳转传递数据,因为他是多次请求,所以不能使用request作用域传递数据.解决方式:使用HttpSession
//             2.原因:HttpSession只能存储与用户息息相关的数据,用户特有的数据,用于会话追踪
//                   非用户相关的数据,不能用session存储
//                   如果非用户相关的数据,用session存储,会大量侵占系统内存资源
//             3.解决方式:通过url拼接?的形式,完成redirect跳转的数据传递
//                      response.sendRedirect("/bServlet?name=zhangsan&pwd=123456");  bServlet:request.getParameter("name");
//                      但是这样的话,如果传递User对象的数据,就需要把user对象的数据取出来  ?name=user.getName()&pwd=user.getPwd()

    //    springmvc的4种跳转形式:控制器与jsp之间 或 控制器与控制器之间的跳转
//    1.Controller--forward--jsp        默认情况下,springmvc中控制器通过视图解析器跳转到jsp页面,通过的是forward形式
//    2.Controller--redirect--jsp
//    3.Controller--forward--Controller
//    4.Controller--redirect--Controller
//    public String test23() {
////        return "result";
////        使用了forward关键字,视图解析器的拼接会失效,所以必须写完整路径
//        return "forward:/result.jsp";
//    }
//
//    public String test24() {
//        return "redirect:/result.jsp";
//    }
//
//    //    控制器与控制器之间的跳转 forward
//    public String forward1() {
//        return "forward:/forward2";
//    }
//
//    public String forward2() {
//        return "forward";//forward.jsp
//    }
//
//    //    控制器与控制器之间的跳转 redirect
//    public String redirect1() {
//        return "redirect:/redirect2";
//    }
//
//    public String redirect2() {
//        return "redirect";//redirect.jsp
//    }
//
//    //    ********************************************************************************
////    流程跳转作用域的相关东西  HttpServletRequest(简称request作用域)  HttpSession(简称session作用域) ServletContext(简称application作用域)
////      .setAttribute() .getAttribute()
////            HttpServletRequest:用于组件(控制器 视图)间跳转时传递数据
////            HttpSession       :不能用于组件间跳转时传递数据,用于会话追踪,只能存储与用户相关的个人数据   如:登录状态,令牌等
////            ServletContext    :全局唯一,多用于存储全局唯一的对象,底层框架使用   比如spring工厂(容器),Mybatis的SqlSessionFactory,Hibernate(JPA)的SessionFactory等
//    @RequestMapping("/test25")
//    public String test25(HttpServletRequest request, HttpSession session) {
////        这种方式与ServletAPI耦合,同时也与属兔模板技术耦合,在springmvc中不建议使用
//        request.setAttribute("name", "value");
//        session.setAttribute("name2", "value2");
////        这个ServletContext不能直接在参数中获取,springmvc不支持
//        ServletContext servletContext = session.getServletContext();
//        servletContext.setAttribute("name3", "value3");
//        ServletContext servletContext1 = request.getSession().getServletContext();
//        servletContext1.setAttribute("name4", "value4");
//        return "index";
//    }
//
//    //    springmvc中request作用域的处理: 基于Model的方式  基于ModelMap的方式       可以解决视图模板技术耦合的问题
////    虽然Model ModelMap形式上不同,但在运行时,springmvc会动态的提供对应的实现类型,名字是BindingAwareModelMap,本质上相同
////    Model比较好,还支持WebFlux  而 ModelMap只支持SpringMVC
////    为什么不直接使用BindingAwareModelMap?
////          在源码中Springmvc不建议使用BindingAwareModelMap.如果直接使用BindingAwareModelMap的话,会存在耦合.MVC开发时使用BindingAwareModelMap,而WebFlux开发时使用的
////          是ConcurrentModel.如果替换Web的实现方案,直接使用BindingAwareModelMap的话,不利于项目的维护.所以使用Model接口处理.
////    springmvc根据模板技术,自动转换:jsp:request     FreeMaker:root
////    前端取数据:${requestScope.user}
//    public String test26(Model model) {
//        model.addAttribute("user", "张三");
//        return "result";
//    }
//
//    public String test27(ModelMap modelMap) {
//        modelMap.addAttribute("user", "张三");
//        return "result";
//    }
//
//    //    如果是redirect跳转,数据该如何传递
////    SpringMVC会自动的把Model中的数据,通过?的形式在url上进行拼接传递
//    public String test28(Model model) {
//        model.addAttribute("user", "张三");
//        return "redirect:/result.jsp";//springmvc:/result.jsp?user=张三
//    }
//
////    springmvc中session作用域的处理:
////    (HttpSession session)不建议,与ServletAPI耦合
////    @SessionAttribute(value = "user") 这个注解放到class类上   "name"就存到了request作用域中了,"user"存到了session作用域中
////    @SessionAttribute(value = {"user","name"}) 这个注解放到class类上
////    @SessionAttribute(value = "gsahdiufsafdasdf") 并没有错误,只是为空
//
//    //    @SessionAttribute把数据存储到session域的同时,也会存储到request域中    两个域存储的是一个对象的引用,节省内存
//    public String test29(Model model) {
//        model.addAttribute("user", "张三");
//        model.addAttribute("name", "lisi");
//        return "result";
//    }
//
//    //    删除session域中的数据
//    public String test30(SessionStatus status) {
//        if (!status.isComplete()) {
//            status.setComplete();
//        }
//        return "result";
//    }
//
////    为什么SpringMVC没有提供application作用域的处理?
////    因为application作用域是全局唯一的,在开中,多用于存储全局唯一的对象,被框架底层封装.
//
//    public String test31(@RequestParam("name") String name, Model model) {
//        model.addAttribute("name", name);
//        return "result";
//    }//等同于下面:  @ModelAttribute注解:接收请求参数的同时,把对应的数据存储到request作用域当中
//
//    public String test32(@ModelAttribute("name") String name) {
//        return "result";
//    }
////    @ModelAttribute的典型使用: (@ModelAttribute("pageNum") String pageNum)
//
////    @ModelAttribute接收简单类型的数据时,value必须与超链接或表单的key名一致  (@ModelAttribute("name")String name)
////    @ModelAttribute接收pojo类型的数据时,value可随便写  (@ModelAttribute("uuuuu")User user)   "uuuuu"会作为request作用域的名字
//
//    //    @ModelAttribute(存到了request作用域中)中的value值不能与@SessionAttributes中的value值一致,如果一致,产生异常,解决办法:不用@ModelAttribute
////    类上加@SessionAttributes(value = {"name"})
//    public String test33(String name, Model model) {
//        model.addAttribute("name", name);
//        return "result";
//    }
//
//    //    ***********************************************************************************
////    ModelAndView这个类型,追溯到很早期,实际上是一个复合类型,起到了2个方面的作用
////             1.Model 代表作用域的操作,就是前面的Model  ModelMap
////             2.View  代表体哦暗转路径(页面),对应前面的四种跳转
////    不怎么用了
//    public ModelAndView test33() {
//        ModelAndView modelAndView = new ModelAndView();
////        ModelMap modelMap = modelAndView.getModelMap();
////        modelMap.addAttribute("user","张三");
//
//        modelAndView.addObject("user", "张三");
//
////        modelAndView.setViewName("redirect:/result.jsp");
//
//        modelAndView.setViewName("result");
//        return modelAndView;
//    }
//
////    总结目前控制器方法返回值:String
////                        ModelAndView
////    springmvc最终都会封装到ModelAndView中,ModelAndView更加底层一些,String仅仅时简化了开发
//
////    1.什么是视图控制器(也就是视图解析器)?
////          视图控制器可以通过配置的方式,访问受保护的视图模板,简化开发
////    2.什么是视图模板?
////          JSP Thymeleaf FreeMarker Velocity
////    3.为什么需要保护视图模板?
////          目前我们的开发方式,都没有对视图模板进行保护.如果不保护视图模板,程序在用户访问时,有可能会产生非预期效果
////    4.如何保护视图模板?
////          把所有的视图模板放在WEB-INF下面,这样所有的'视图模板'只能通过控制器forward进行访问
//
//
////    空控制器的解决办法  在配置springmvc中配置: <mvc:view-controller path="/index.do" view-name="index">
////    注意:path不能与@RequestMapping中的路径冲突,如果冲突了,以controller的为准,配置的不起作用,实际也不会这么做一个路径对应两个view
////    @RequestMapping("/index.do")
////    public String goToIndexJSP(){
////        return "index";
////    }
//
//    //    视图控制器的redirect跳转
////    这样访问不到index.jsp
//    public String test34(){
//        return "redirect:/WEB-INF/pages/index.jsp";
//    }
//    //    正确处理方式:<mvc:view-controller path="/index" view-name="index">
//    public String test35(){
//        return "redirect:/index";
//    }
//
//
////    静态资源访问的问题

