package be.intecbrussel.MyShoppingList.service.implementation;

import be.intecbrussel.MyShoppingList.data.Item;
import be.intecbrussel.MyShoppingList.repository.ItemRepository;
import be.intecbrussel.MyShoppingList.service.interfaces.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImplementation implements ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public ItemServiceImplementation(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> findAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(Long id) {

        return itemRepository.findById(id).get();
    }

    @Override
    public String deleteItemById(Long id) {
        itemRepository.deleteById(id);
        return "item is deleted successfully";
    }

    @Override
    public String createItem(Item newItem) {
        Optional<Item> item1=itemRepository.findByItemName(newItem.getItemName());

        if(item1.isPresent()){
            throw new IllegalStateException("Item has already existed");
        }

        if (newItem.getItemName() == null) {
            throw new IllegalStateException("");
        }
        if (newItem.getAmount() == null) {
            throw new IllegalStateException("");
        }
        if (newItem.getPrice() == null) {
            throw new IllegalStateException("");
        }

    itemRepository.save(newItem);
        return "Item has been created";

    }

    @Override
    public Double calculateAllItemTotalPrice() {
        List<Item> items= itemRepository.findAll();
        Double total = 0.0;
        for (Item item : items) {
            total+=item.getTotalPrice();
        }

        return total;

    }

    @Override
    public Integer calculateAllItemAmount() {
        List<Item> items= itemRepository.findAll();
        Integer total = 0;
        for (Item item : items) {
            total+=item.getAmount();
        }

        return total;

    }
}
