package com.joye.basedata.filter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 * Created by joye on 2017/4/21.
 * 替换的对象站信息
 */

public class ReplaceDomainEntity {
    private String domain;
    private String keystr;
    private String charsert;
    private String[]keys;

    private String otherOldDomains;
    private String otherOldTitle;
    private String elseOldDomains;
    private String elseOldTitle;



    private String e1Title;
    private String e1Domains;
    private String e2Title;
    private String e2Domains;
    private String e3Title;
    private String e3Domains;
    private String e4Title;
    private String e4Domains;
    private String e5Title;
    private String e5Domains;
    private String e6Title;
    private String e6Domains;

    public String getOtherOldDomains() {
        return otherOldDomains;
    }

    public void setOtherOldDomains(String otherOldDomains) {
        this.otherOldDomains = otherOldDomains;
    }

    public String getOtherOldTitle() {
        return otherOldTitle;
    }

    public void setOtherOldTitle(String otherOldTitle) {
        this.otherOldTitle = otherOldTitle;
    }

    public String getElseOldDomains() {
        return elseOldDomains;
    }

    public void setElseOldDomains(String elseOldDomains) {
        this.elseOldDomains = elseOldDomains;
    }

    public String getElseOldTitle() {
        return elseOldTitle;
    }

    public void setElseOldTitle(String elseOldTitle) {
        this.elseOldTitle = elseOldTitle;
    }

    public String getE1Title() {
        return e1Title;
    }

    public void setE1Title(String e1Title) {
        this.e1Title = e1Title;
    }

    public String getE1Domains() {
        return e1Domains;
    }

    public void setE1Domains(String e1Domains) {
        this.e1Domains = e1Domains;
    }

    public String getE2Title() {
        return e2Title;
    }

    public void setE2Title(String e2Title) {
        this.e2Title = e2Title;
    }

    public String getE2Domains() {
        return e2Domains;
    }

    public void setE2Domains(String e2Domains) {
        this.e2Domains = e2Domains;
    }

    public String getE3Title() {
        return e3Title;
    }

    public void setE3Title(String e3Title) {
        this.e3Title = e3Title;
    }

    public String getE3Domains() {
        return e3Domains;
    }

    public void setE3Domains(String e3Domains) {
        this.e3Domains = e3Domains;
    }

    public String getE4Title() {
        return e4Title;
    }

    public void setE4Title(String e4Title) {
        this.e4Title = e4Title;
    }

    public String getE4Domains() {
        return e4Domains;
    }

    public void setE4Domains(String e4Domains) {
        this.e4Domains = e4Domains;
    }

    public String getE5Title() {
        return e5Title;
    }

    public void setE5Title(String e5Title) {
        this.e5Title = e5Title;
    }

    public String getE5Domains() {
        return e5Domains;
    }

    public void setE5Domains(String e5Domains) {
        this.e5Domains = e5Domains;
    }

    public String getE6Title() {
        return e6Title;
    }

    public void setE6Title(String e6Title) {
        this.e6Title = e6Title;
    }

    public String getE6Domains() {
        return e6Domains;
    }

    public void setE6Domains(String e6Domains) {
        this.e6Domains = e6Domains;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getKeystr() {
        return keystr;
    }

    public void setKeystr(String keys) {
        this.keystr = keys;
    }

    public String getCharsert() {
        return charsert;
    }

    public void setCharsert(String charsert) {
        this.charsert = charsert;
    }

    public String[]getkeys(){
        if(keys==null||keys.length<3){
            keys=keystr.split("，");
        }
        return keys;
    }

    public void setRow(Row r) {
        String cellValue = "";
        for (Cell cell : r) {
            cellValue = cell.getStringCellValue();
            if (cell.getColumnIndex() == 0) {
                setDomain(cellValue);
            }else if (cell.getColumnIndex() == 1) {
                setKeystr(cellValue);
            }else if(cell.getColumnIndex()==2){
               setCharsert(cellValue);
            }else if(cell.getColumnIndex()==3){
                setOtherOldDomains(cellValue);
            }else if(cell.getColumnIndex()==4){
                setOtherOldTitle(cellValue);
            }
            else if(cell.getColumnIndex()==5){
                setElseOldDomains(cellValue);
            }else if(cell.getColumnIndex()==6){
                setElseOldTitle(cellValue);
            }
            else if(cell.getColumnIndex()==7){
                setE1Domains(cellValue);
            }else if(cell.getColumnIndex()==8){
                setE1Title(cellValue);
            }
            else if(cell.getColumnIndex()==9){
                setE2Domains(cellValue);
            }else if(cell.getColumnIndex()==10){
                setE2Title(cellValue);
            }
            else if(cell.getColumnIndex()==11){
                setE3Domains(cellValue);
            }else if(cell.getColumnIndex()==12){
                setE3Title(cellValue);
            }
            else if(cell.getColumnIndex()==13){
                setE4Domains(cellValue);
            }else if(cell.getColumnIndex()==14){
                setE4Title(cellValue);
            }
            else if(cell.getColumnIndex()==15){
                setE5Domains(cellValue);
            }else if(cell.getColumnIndex()==16){
                setE5Title(cellValue);
            }
            else if(cell.getColumnIndex()==17){
                setE6Domains(cellValue);
            }else if(cell.getColumnIndex()==18){
                setE6Title(cellValue);
            }
        }
    }
}
