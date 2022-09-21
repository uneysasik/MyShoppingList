package be.intecbrussel.MyShoppingList.controller;

import be.intecbrussel.MyShoppingList.data.Item;
import be.intecbrussel.MyShoppingList.service.implementation.ItemServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ItemController {

    private ItemServiceImplementation serviceImplementation;

    @Autowired
    public ItemController(ItemServiceImplementation serviceImplementation) {
        this.serviceImplementation = serviceImplementation;
    }

    @GetMapping(path="")
    public String findAllItem(Model model){
        model.addAttribute("items",serviceImplementation.findAllItems());
        model.addAttribute("total",serviceImplementation.calculateAllItemTotalPrice());
        model.addAttribute("amount",serviceImplementation.calculateAllItemAmount());

        return "index";
    }

    @PostMapping(path = "addItem")
    public String addNewItem(Model model, Item item) {
        model.addAttribute("items",serviceImplementation.findAllItems());


        try{
            if(item.getItemName().equals("")){
                throw new IllegalStateException("Enter proper item name.");
            }
            serviceImplementation.createItem(item);
        }catch (Exception e) {
            return "newPage";
        }
        return "redirect:";
    }

    @GetMapping(path="deleteItem/{id}")
    public String deleteItem(@PathVariable Long id, Model model){

        serviceImplementation.deleteItemById(id);

        return "message";
    }

    @GetMapping(path = "deleteItem/message")
    public String messagePage(){
        return "index";
    }
}
