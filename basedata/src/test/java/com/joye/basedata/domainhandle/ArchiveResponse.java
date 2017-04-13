package com.joye.basedata.domainhandle;

import org.apache.poi.ss.usermodel.Row;

/**
 * Created by joye on 2017/4/5.
 */

public class ArchiveResponse {

    /**
     * archived_snapshots : {"closest":{"available":true,"url":"http://web.archive.org/web/20130919044612/http://example.com/","timestamp":"20130919044612","status":"200"}}
     */

    public static String[] TITLES={"老域名","是否可用","状态","快照时间","快速链接地址"};
    private ArchivedSnapshotsBean archived_snapshots;

    private String oldDomainStr;

    public String getOldDomainStr() {
        return oldDomainStr;
    }

    public void setOldDomainStr(String oldDomainStr) {
        this.oldDomainStr = oldDomainStr;
    }

    public ArchivedSnapshotsBean getArchived_snapshots() {
        return archived_snapshots;
    }

    public void setRow(Row row){
        boolean available=false;
        String url="";
        String timestamp="";
        String status="";
        ArchivedSnapshotsBean.ClosestBean bean=archived_snapshots.getClosest();
        if(bean!=null){
            available=bean.available;
            url=bean.getUrl();
            timestamp=bean.getTimestamp();
            status=bean.getStatus();
        }
        row.createCell(0).setCellValue(getOldDomainStr());
        row.createCell(1).setCellValue(available?"可用":"不可");
        row.createCell(2).setCellValue(status);
        row.createCell(3).setCellValue(timestamp);
        row.createCell(4).setCellValue(url);
    }
    @Override
    public String toString() {
        return "ArchiveResponse{" +
                "archived_snapshots=" + archived_snapshots.toString() +
                '}';
    }

    public void setArchived_snapshots(ArchivedSnapshotsBean archived_snapshots) {
        this.archived_snapshots = archived_snapshots;
    }

    public static class ArchivedSnapshotsBean {
        /**
         * closest : {"available":true,"url":"http://web.archive.org/web/20130919044612/http://example.com/","timestamp":"20130919044612","status":"200"}
         */

        private ClosestBean closest;

        @Override
        public String toString() {
            return "ArchivedSnapshotsBean{" +
                    "closest=" + closest!=null?closest.toString():"closet==null" +
                    '}';
        }

        public ClosestBean getClosest() {
            return closest;
        }

        public void setClosest(ClosestBean closest) {
            this.closest = closest;
        }

        public static class ClosestBean {
            @Override
            public String toString() {
                return "ClosestBean{" +
                        "available=" + available +
                        ", url='" + url + '\'' +
                        ", timestamp='" + timestamp + '\'' +
                        ", status='" + status + '\'' +
                        '}';
            }

            /**
             * available : true
             * url : http://web.archive.org/web/20130919044612/http://example.com/
             * timestamp : 20130919044612
             * status : 200
             */

            private boolean available;
            private String url="";
            private String timestamp="";
            private String status="";

            public boolean isAvailable() {
                return available;
            }

            public void setAvailable(boolean available) {
                this.available = available;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getTimestamp() {
                return timestamp;
            }

            public void setTimestamp(String timestamp) {
                this.timestamp = timestamp;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }
        }
    }
}
