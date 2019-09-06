package item;

//import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import item.pojoEs.Listing;
import item.reposity.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jzx
 * @email:
 * @Date: 2019-09-02 14:27
 */
//@NacosPropertySource(dataId = "itemServiceApp", autoRefreshed = true)
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@RestController
public class ItemServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ItemServiceApplication.class, args);
    }
    @Autowired
    ListingRepository listingRepository;

    @RequestMapping("/initData")
    public void initData(){
        Listing listing = new Listing();
        listing.setAmount(100.00);
        listing.setListingDesc("小马哥的编程思想");
        listing.setListingId(1L);
        listing.setListingName("spring boot 编程思想");
        listing.setAuthor("小马哥");
        listingRepository.save(listing);
    }

}
