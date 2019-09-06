package item;

import item.api.ItemService;
import item.pojoEs.Listing;
import item.reposity.ListingRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author jzx
 * @email:
 * @Date: 2019-09-02 14:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ItemServiceApplication.class)
public class ItemServiceApplicationTest {

    @Autowired
    ListingRepository listingRepository;


    @Test
    public  void testData(){
        Listing listing = new Listing();
        listing.setAmount(100.00);
        listing.setListingDesc("小马哥的编程思想");
        listing.setListingId(1L);
        listing.setListingName("spring boot 编程思想");
        listing.setAuthor("小马哥");
        listingRepository.save(listing);
    }


    @Autowired
    ItemService itemService;

    @Test
    public void testSearch(){
        Page<Listing> listings = itemService.queryItemByDesc("小马哥");
        System.out.println("listings = " + listings.getContent());
    }

}
