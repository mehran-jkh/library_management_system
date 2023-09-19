package com.example.lib_management.controller;


import com.example.lib_management.AAA.Entity.Aaaccesslist;
import com.example.lib_management.AAA.Entity.Aarole;
import com.example.lib_management.AAA.ServiceInterface.AccesslistWebService;
import com.example.lib_management.AAA.ServiceInterface.PageWebService;
import com.example.lib_management.AAA.ServiceInterface.RoleWebService;
import com.example.lib_management.AAA.commons.exceptions.mException;
import com.example.lib_management.AAA.model.AccesslistDTO;
import com.example.lib_management.AAA.model.PageinfoDTO;
import com.example.lib_management.AAA.model.RoleinfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("accesslistcontroller")
public class Accesslistservice_controller {
    private RoleWebService roleWebService;
    private PageWebService pageWebService;
    private AccesslistWebService accesslistWebService;


    @Autowired
    public Accesslistservice_controller(RoleWebService roleWebService, PageWebService pageWebService,AccesslistWebService accesslistWebService) {
        this.roleWebService = roleWebService;
        this.pageWebService = pageWebService;
        this.accesslistWebService=accesslistWebService;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////// show page
    @RequestMapping(value = "viewallaccesslists", method = RequestMethod.GET)
    public String accesslists_info_page( @ModelAttribute("accesslist_key") AccesslistDTO accesslistDTO,Model model, Integer role_id )
    {



        List<RoleinfoDTO> roleslist=new ArrayList<RoleinfoDTO>();
        roleslist=roleWebService.return_all_roles();
        model.addAttribute("role_list_key",roleslist);

        List<PageinfoDTO> pagesList=new ArrayList<PageinfoDTO>();
        pagesList=pageWebService.return_all_pages();
        model.addAttribute("page_list_key",pagesList);
        if(role_id==null)
        {
            accesslistDTO.setPages_id(load_accesslist(roleslist.get(0).getCode()));
        }
        else
        {
            accesslistDTO.setPages_id(load_accesslist(role_id));
        }
        return "view_all_accesslists";
    }


    @RequestMapping(value = "submit_add_accesslist_form",method = RequestMethod.POST)
    public String submit_add_accesslist_form(AccesslistDTO accesslistDTO) throws mException
    {
        accesslistWebService.Add(accesslistDTO.getRole_id(),accesslistDTO.getPages_id());
        return "redirect:/accesslistcontroller/viewallaccesslists";
    }

    public int[] load_accesslist(int role_id)
    {
        return accesslistWebService.return_all_pages(role_id);
    }





}
