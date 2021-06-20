package fooddelivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuViewHandler {

    @Autowired
    private MenuRepository menuRepository;

}