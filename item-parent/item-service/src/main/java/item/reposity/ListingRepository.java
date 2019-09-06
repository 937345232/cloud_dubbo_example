package item.reposity;

import item.pojoEs.Listing;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author jzx
 * @email:
 * @Date: 2019-09-03 11:45
 */
public interface ListingRepository extends ElasticsearchRepository<Listing,Long> {
}
