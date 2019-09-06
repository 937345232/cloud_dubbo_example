package item.api;

import item.pojoEs.Listing;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author jzx
 * @email:
 * @Date: 2019-09-02 14:23
 */
public interface ItemService {

    Page<Listing> queryItemByDesc(String desc);

    List<Listing> queryAll();
}
