package com.joye.basedata.filter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 * Created by joye on 2017/4/21.
 * 替换的对象站信息
 */

public class ReplaceDomainEntity{//}  extends OtherInfoEntity{
    private String domain;
    private String keystr;
    private String charsert;
    private String[]keys;



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
            }
//            else if(cell.getColumnIndex()==3){
//                setOtherOldDomains(cellValue);
//            }else if(cell.getColumnIndex()==4){
//                setOtherOldTitle(cellValue);
//            }
//            else if(cell.getColumnIndex()==5){
//                setElseOldDomains(cellValue);
//            }else if(cell.getColumnIndex()==6){
//                setElseOldTitle(cellValue);
//            }
//            else if(cell.getColumnIndex()==7){
//                setE1Domains(cellValue);
//            }else if(cell.getColumnIndex()==8){
//                setE1Title(cellValue);
//            }
//            else if(cell.getColumnIndex()==9){
//                setE2Domains(cellValue);
//            }else if(cell.getColumnIndex()==10){
//                setE2Title(cellValue);
//            }
//            else if(cell.getColumnIndex()==11){
//                setE3Domains(cellValue);
//            }else if(cell.getColumnIndex()==12){
//                setE3Title(cellValue);
//            }
//            else if(cell.getColumnIndex()==13){
//                setE4Domains(cellValue);
//            }else if(cell.getColumnIndex()==14){
//                setE4Title(cellValue);
//            }
//            else if(cell.getColumnIndex()==15){
//                setE5Domains(cellValue);
//            }else if(cell.getColumnIndex()==16){
//                setE5Title(cellValue);
//            }
//            else if(cell.getColumnIndex()==17){
//                setE6Domains(cellValue);
//            }else if(cell.getColumnIndex()==18){
//                setE6Title(cellValue);
//            }
        }
    }
}
