package item.service;

import item.api.ItemService;

import item.pojoEs.Listing;
import item.reposity.ListingRepository;
import org.apache.dubbo.config.annotation.Service;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.SearchQuery;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author jzx
 * @email:
 * @Date: 2019-09-02 20:50
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ListingRepository listingRepository;

    @Override
    public Page<Listing> queryItemByDesc(String desc) {
        PageRequest pageRequest = PageRequest.of(1, 200, Sort.by(Sort.Direction.DESC, "listingId"));
        Page<Listing> listingDesc = listingRepository.search(QueryBuilders.multiMatchQuery(desc,"listingDesc","author" ), pageRequest);
        return listingDesc;
    }

    @Override
    public List<Listing> queryAll() {
        Iterable<Listing> listings = listingRepository.findAll();
       return copyIterator(listings.iterator());
    }


    public static <T> List<T> copyIterator(Iterator<T> iter) {
        List<T> copy = new ArrayList<T>();
        while (iter.hasNext()) {
            copy.add(iter.next());
        }
        return copy;
    }

}
