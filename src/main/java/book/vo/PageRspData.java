package book.vo;

import lombok.Data;

import java.util.List;

/**
 * @author fanhongtao
 * @date 2022/10/13 21:33
 */
@Data
public class PageRspData<T> {

    private List<T> records;

    private long total;

    private long pages;

    public static <T> PageRspData<T> of(List<T> records, long total, long pages) {
        PageRspData resp = new PageRspData();
        resp.setRecords(records);
        resp.setTotal(total);
        resp.setPages(pages);
        return resp;
    }
}
