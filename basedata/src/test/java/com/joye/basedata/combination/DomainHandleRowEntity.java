package com.joye.basedata.combination;

import com.joye.basedata.filter.OtherInfoEntity;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 * Created by joye on 2017/4/10.
 */

public class DomainHandleRowEntity extends OtherInfoEntity{
    private String initObjectDomains;
    private String queryObjectDomains;
    private String combinationDomains;
    private String oldDomains;
    private String charset;
    private String title;
    private String keys;
    private String description;

    public String getInitObjectDomains() {
        return initObjectDomains;
    }

    public void setInitObjectDomains(String initObjectDomains) {
        this.initObjectDomains = initObjectDomains;
    }

    public String getQueryObjectDomains() {
        return queryObjectDomains;
    }

    public void setQueryObjectDomains(String queryObjectDomains) {
        this.queryObjectDomains = queryObjectDomains;
    }

    public String getCombinationDomains() {
        return combinationDomains;
    }

    public void setCombinationDomains(String combinationDomains) {
        this.combinationDomains = combinationDomains;
    }

    public String getOldDomains() {
        return oldDomains;
    }

    public void setOldDomains(String oldDomains) {
        this.oldDomains = oldDomains;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void setRow(Row r) {
        for (Cell cell:r){
           String cellValue=cell.getStringCellValue();
            if(cell.getColumnIndex()==0){
               setInitObjectDomains(cellValue);
            }else if(cell.getColumnIndex()==1){
                setQueryObjectDomains(cellValue);
            }else if(cell.getColumnIndex()==2){
               setCombinationDomains(cellValue);
            }else if(cell.getColumnIndex()==3){
               setOldDomains(cellValue);
            }else if(cell.getColumnIndex()==4){
                setCharset(cellValue);
            }else if(cell.getColumnIndex()==5){
                setTitle(cellValue);
            }else if(cell.getColumnIndex()==6){
                setKeys(cellValue);
            }else if(cell.getColumnIndex()==7){
                setDescription(cellValue);
            }else if(cell.getColumnIndex()==8){
                setOtherOldDomains(cellValue);
            }else if(cell.getColumnIndex()==9){
                setOtherOldTitle(cellValue);
            }else if(cell.getColumnIndex()==10){
                setElseOldDomains(cellValue);
            }else if(cell.getColumnIndex()==11){
                setElseOldTitle(cellValue);
            }else if(cell.getColumnIndex()==12){
                setE1Domains(cellValue);
            }else if(cell.getColumnIndex()==13){
                setE1Title(cellValue);
            }
            else if(cell.getColumnIndex()==14){
                setE2Domains(cellValue);
            }else if(cell.getColumnIndex()==15){
                setE2Title(cellValue);
            }
            else if(cell.getColumnIndex()==16){
                setE3Domains(cellValue);
            }else if(cell.getColumnIndex()==17){
                setE3Title(cellValue);
            }
            else if(cell.getColumnIndex()==18){
                setE4Domains(cellValue);
            }else if(cell.getColumnIndex()==19){
                setE4Title(cellValue);
            }
            else if(cell.getColumnIndex()==20){
                setE5Domains(cellValue);
            }else if(cell.getColumnIndex()==21){
                setE5Title(cellValue);
            }
            else if(cell.getColumnIndex()==22){
                setE6Domains(cellValue);
            }else if(cell.getColumnIndex()==23){
                setE6Title(cellValue);
            }
        }
    }
}
