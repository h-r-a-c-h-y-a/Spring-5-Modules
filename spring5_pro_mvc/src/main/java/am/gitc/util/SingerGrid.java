package am.gitc.util;

import am.gitc.entities.Singer;

import java.util.List;

public class SingerGrid {
    private int totalPages;
    private int currentPage;
    private long totalRecords;
    private List<Singer> singerData;

    public SingerGrid() {
    }

    public SingerGrid(int totalPages, int currentPage, long totalRecords, List<Singer> singerData) {
        this.totalPages = totalPages;
        this.currentPage = currentPage;
        this.totalRecords = totalRecords;
        this.singerData = singerData;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<Singer> getSingerData() {
        return singerData;
    }

    public void setSingerData(List<Singer> singerData) {
        this.singerData = singerData;
    }
}
