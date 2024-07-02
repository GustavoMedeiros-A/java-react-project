package admin.catalog.utils.pagination;

import java.util.List;

public class PaginationResponse<T> {
    private List<T> content;
    private int page;
    private int perPage;
    private long quantityOfItems;

    public PaginationResponse(List<T> content, int page, int perPage, long quantityOfItems) {
        this.content = content;
        this.page = page;
        this.perPage = perPage;
        this.quantityOfItems = quantityOfItems;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public long getQuantityOfItems() {
        return quantityOfItems;
    }

    public void setQuantityOfItems(long quantityOfItems) {
        this.quantityOfItems = quantityOfItems;
    }

}
