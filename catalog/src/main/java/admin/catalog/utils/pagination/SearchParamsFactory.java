package admin.catalog.utils.pagination;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class SearchParamsFactory {

    public static PageRequest createPageRequest(SearchParams params) {
        if (params.getSort() == null || params.getSort().isEmpty()) {
            return PageRequest.of(params.getPage() - 1, params.getPerPage());
        } else {
            Sort sort = Sort.by(Sort.Direction.fromString(params.getSortDir()), params.getSort());
            return PageRequest.of(params.getPage() - 1, params.getPerPage(), sort);
        }
    }

}
