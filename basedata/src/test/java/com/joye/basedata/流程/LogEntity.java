package com.joye.basedata.流程;

// FIXME generate failure  field _$Fields221

import com.google.gson.annotations.SerializedName;

/**
 * Created by joye on 2017/8/30.
 */

public class LogEntity {


    /**
     * timestamp : 2017-08-29T16:51:40-04:00
     * fields : {"remote_addr":"176.74.192.36","body_bytes_sent":"45060","request_time":"2.554","request_method":"GET","host":"herhandset.com","request":"/news/detail_503085.html","status":"200","protocol":"HTTP/1.1","http_referrer":"-","x-forwarded-for":"-","http_user_agent":"DomainCrawler/3.0 (info@domaincrawler.com; http://www.domaincrawler.com/herhandset.com)"}
     */

    private String timestamp;
    private FieldsBean fields;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public FieldsBean getFields() {
        return fields;
    }

    public void setFields(FieldsBean fields) {
        this.fields = fields;
    }

    public static class FieldsBean {
        /**
         * remote_addr : 176.74.192.36
         * body_bytes_sent : 45060
         * request_time : 2.554
         * request_method : GET
         * host : herhandset.com
         * request : /news/detail_503085.html
         * status : 200
         * protocol : HTTP/1.1
         * http_referrer : -
         * x-forwarded-for : -
         * http_user_agent : DomainCrawler/3.0 (info@domaincrawler.com; http://www.domaincrawler.com/herhandset.com)
         */

        private String remote_addr;
        private String body_bytes_sent;
        private String request_time;
        private String request_method;
        private String host;
        private String request;
        private String status;
        private String protocol;
        private String http_referrer;
        @SerializedName("x-forwarded-for")
        private String xforwardedfor;
        private String http_user_agent;

        public String getRemote_addr() {
            return remote_addr;
        }

        public void setRemote_addr(String remote_addr) {
            this.remote_addr = remote_addr;
        }

        public String getBody_bytes_sent() {
            return body_bytes_sent;
        }

        public void setBody_bytes_sent(String body_bytes_sent) {
            this.body_bytes_sent = body_bytes_sent;
        }

        public String getRequest_time() {
            return request_time;
        }

        public void setRequest_time(String request_time) {
            this.request_time = request_time;
        }

        public String getRequest_method() {
            return request_method;
        }

        public void setRequest_method(String request_method) {
            this.request_method = request_method;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String getRequest() {
            return request;
        }

        public void setRequest(String request) {
            this.request = request;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getProtocol() {
            return protocol;
        }

        public void setProtocol(String protocol) {
            this.protocol = protocol;
        }

        public String getHttp_referrer() {
            return http_referrer;
        }

        public void setHttp_referrer(String http_referrer) {
            this.http_referrer = http_referrer;
        }

        public String getXforwardedfor() {
            return xforwardedfor;
        }

        public void setXforwardedfor(String xforwardedfor) {
            this.xforwardedfor = xforwardedfor;
        }

        public String getHttp_user_agent() {
            return http_user_agent;
        }

        public void setHttp_user_agent(String http_user_agent) {
            this.http_user_agent = http_user_agent;
        }

        @Override
        public String toString() {
            return "FieldsBean{" +
                    "remote_addr='" + remote_addr + '\'' +
                    ", body_bytes_sent='" + body_bytes_sent + '\'' +
                    ", request_time='" + request_time + '\'' +
                    ", request_method='" + request_method + '\'' +
                    ", host='" + host + '\'' +
                    ", request='" + request + '\'' +
                    ", status='" + status + '\'' +
                    ", protocol='" + protocol + '\'' +
                    ", http_referrer='" + http_referrer + '\'' +
                    ", xforwardedfor='" + xforwardedfor + '\'' +
                    ", http_user_agent='" + http_user_agent + '\'' +
                    '}';
        }
    }
}
