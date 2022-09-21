package be.intecbrussel.MyShoppingList.service.interfaces;

import be.intecbrussel.MyShoppingList.data.Item;
import be.intecbrussel.MyShoppingList.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {

    List<Item> findAllItems();

    Item getItemById(Long id);

    String deleteItemById(Long Id);

    String createItem(Item item);

    Double calculateAllItemTotalPrice();
    Integer calculateAllItemAmount();


}
