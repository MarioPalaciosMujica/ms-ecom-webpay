package com.ecom.webpay.tools;

import org.springframework.stereotype.Component;

import javax.xml.datatype.XMLGregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

@Component
public class DateFormat {

    private String format = "dd/MM/yyyy HH:mm:ss";
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);

    public String dateToString(Date date){
        if(date != null){
            return simpleDateFormat.format(date);
        }
        else {
            return null;
        }
    }

    public Date stringToDate(String text){
        if(text != null){
            try{
                return simpleDateFormat.parse(text);
            }
            catch (ParseException ex){
                return null;
            }
        }
        else {
            return null;
        }
    }

    public Date datePickerToDate(String datePicker){
        if(datePicker != null){
            String[] dateArray = datePicker.split("-");
            return new Date(Integer.parseInt(dateArray[2]), Integer.parseInt(dateArray[1]), Integer.parseInt(dateArray[0]), 0, 0, 0);
        }
        else {
            return null;
        }
    }

    public Date xmlGregorianToDate(XMLGregorianCalendar xmlCalendar){
        if(xmlCalendar != null){
            GregorianCalendar gregorianCalendar = xmlCalendar.toGregorianCalendar();
            return gregorianCalendar.getTime();
        }
        else {
            return null;
        }
    }

    public String xmlGregorianToString(XMLGregorianCalendar xmlCalendar){
        if(xmlCalendar != null){
            GregorianCalendar gregorianCalendar = xmlCalendar.toGregorianCalendar();
            Date date = gregorianCalendar.getTime();
            return simpleDateFormat.format(date);
        }
        else {
            return null;
        }
    }

}
