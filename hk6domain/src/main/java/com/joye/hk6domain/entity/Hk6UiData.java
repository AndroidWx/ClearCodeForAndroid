package com.joye.hk6domain.entity;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/20.
 * 304622254@qq.com
 * Remeark:
 */

public class Hk6UiData  implements ReportI{
    /**
     * ����
     */
    private String expect;
    /**
     * ƽ��
     */
    private String[]evictors;

    /**
     * �н�����
     */
    private int openCode;

    /**
     * ����ʱ��
     */
    private String opentime;

    /**
     * ����ʱ���
     */
    private long opentimestamp;

    /**
     *
     * @return ��������
     */
    public String getExpect() {
        return expect;
    }


    public void setExpect(String expect) {
        this.expect = expect;
    }

    /**
     *
     * @return ƽ��s
     */
    public String[] getEvictors() {
        return evictors;
    }

    public void setEvictors(String[] evictors) {
        this.evictors = evictors;
    }

    /**
     *
     * @return �н�����
     */
    @Override
    public int getOpenCode() {
        return openCode;
    }

    public void setOpenCode(int openCode) {
        this.openCode = openCode;
    }

    /**
     *
     * @return ����ʱ��
     */
    public String getOpentime() {
        return opentime;
    }

    public void setOpentime(String opentime) {
        this.opentime = opentime;
    }

    /**
     *
     * @return ����ʱ���
     */
    public long getOpentimestamp() {
        return opentimestamp;
    }

    public void setOpentimestamp(long opentimestamp) {
        this.opentimestamp = opentimestamp;
    }

}
