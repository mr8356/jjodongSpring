package codekat.jjodongSpring.HelloController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController{
    
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data" , "hello!!");
        return "hello";
    }
    
    @GetMapping("hello-jjodong")
    public String helloJjodong(Model model){
        model.addAttribute("name"  , "조동현");
        return "hello-jjodong";
    }
    
    @GetMapping("helloApi")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    
    public class Hello{
        private String name;
        
        public String getName() {
            return name;
        }
        
        public String setName(String name){
            this.name = name;
            return this.name;
        }
        
    }
}