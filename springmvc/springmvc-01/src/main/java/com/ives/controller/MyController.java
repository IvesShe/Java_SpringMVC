package com.ives.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Controller：創建處理器對象，對象放在springmvc容器中。
 * 位置：在類的上面
 * 和sping中的@Service、 @Component相同，都是創建對象的
 *
 * 能處理請求的都是控制器(處理器)：
 * MyController能處理請求，叫作後端控制器(back controller)
 */
@Controller
public class MyController {
    /*
        處理用戶提交的請求，springmvc中是使用方法來處理。
        方法是自定義的，可以有多種返回值，多種參數，方法名稱自定義
     */

    /**
     * 准備使用doSome方法處理some.do請求
     * @RequestMapping：請求映射，作用是把一個請求地址和一個方法綁在一起。
     *                  一個請求指定一個方法處理。
     *         屬性： 1. value是一個String，表示請求的uri地址(some.do)。
     *                  value的值必須是唯一的，不能重複。
     *                  在使用時，推薦地址以"/"
     *         位置： 1. 在方法的上面，常用的。
     *               2. 在類的上面
     * 說明： 使用RequestMapping修飾的方法叫作處理器方法或者控制器方法。
     * 使用@RequestMapping修飾的方法可以處理請求，類似Servlet中的doGet,doPost
     *
     * 返回值： ModelAndView表示本次請求的處理結果
     * Model： 數據，請求處理完成後，要顯示給用戶的數據
     * View： 視圖，比如jsp等。
     */
    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(){   // doGet() -- service請求處理
        // 處理some.do請求。相當於service調用處理完成了。
        ModelAndView mv = new ModelAndView();
        // 添加數據，框架在請求的最後把數據放入到request作用域
        // request.setAttribute("msg","歡迎使用SpringMVC");
        mv.addObject("msg","歡迎使用SpringMVC");
        mv.addObject("fun","執行的是doSome方法");

        // 指定視圖的完整路徑
        // 框架對視圖執行的forward操作，request.getRequestDispatcher("/show.jsp).forward(...)
        mv.setViewName("show.jsp");

        // 返回mv
        return mv;
    }
}
