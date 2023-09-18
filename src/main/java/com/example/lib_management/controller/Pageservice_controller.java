package com.example.lib_management.controller;


import com.example.lib_management.AAA.ServiceInterface.PageWebService;
import com.example.lib_management.AAA.commons.exceptions.mException;
import com.example.lib_management.AAA.model.PageinfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("pagecontroller")
public class Pageservice_controller {


    private PageWebService pageWebService;

    @Autowired
    public Pageservice_controller(PageWebService pageWebService){
        this.pageWebService=pageWebService;
    }
    /////////////////////////////////////////////////////////////////// view all role
    @RequestMapping("viewallroles")
    public String pages_info_page(Model model){
        model.addAttribute("page_list_key",pageWebService.return_all_pages());
        return "view_all_pages";
    }

/////////////////////////////////////////////////////////////////// ADD ROLE

    @RequestMapping(value = "addpage", method = RequestMethod.GET)
    public String add_page_page(@ModelAttribute("page_keyy") PageinfoDTO pageinfoDTO){
        return "add_page";
    }


    @RequestMapping(value = "submit_add_page_form",method = RequestMethod.POST)
    public String add_page_submit(PageinfoDTO pageinfoDTO) throws mException {
        pageWebService.add_page(pageinfoDTO);
        return "redirect:/pagecontroller/viewallroles";
    }


/////////////////////////////////////////////////////////////////// DELETE PAGE
    @RequestMapping(value = "deletepage/{code}")
    public String delete_page(@PathVariable int code){
        pageWebService.Remove(code);
        return "redirect:/pagecontroller/viewallroles";
    }

/////////////////////////////////////////////////////////////////// EDIT PAGE

    @RequestMapping(value = "editpage/{code}", method = RequestMethod.GET)
    public String edit_page(@PathVariable int code, Model model){
        model.addAttribute("page_key", pageWebService.return_page_by_id(code));

        return "edit_page";
    }

    @RequestMapping(value = "submit_edit_page", method = RequestMethod.POST)
    public String submit_edit_page_form(PageinfoDTO pageinfoDTO){
        pageWebService.update_page(pageinfoDTO);
        return "redirect:/pagecontroller/viewallroles";
    }


}
